package app.core.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import app.core.auth.JwtUtilImpl;
import app.core.auth.User;

public class SchoolApiFilter implements Filter {

	private JwtUtilImpl jwt;

	public SchoolApiFilter(JwtUtilImpl jwt) {
		super();
		this.jwt = jwt;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("from SchoolApiFilter");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		String token = req.getHeader(HttpHeaders.AUTHORIZATION);

		if (token == null) {
			res.sendError(HttpStatus.UNAUTHORIZED.value(), "no token");
			return;
		}

		if (!token.startsWith("Bearer ")) {
			res.sendError(HttpStatus.UNAUTHORIZED.value(), "wrong schema");
			return;
		}

		token = token.replace("Bearer ", "");
		try {
			User user = jwt.extractUser(token);
			if (user.getRole() == User.Role.ADMIN) {
				chain.doFilter(request, response); // pass the request
			} else {
				res.sendError(HttpStatus.UNAUTHORIZED.value(), "restricted to Admins only");
				return;
			}
		} catch (Exception e) {
			res.sendError(HttpStatus.UNAUTHORIZED.value(), "invalid token");
			System.out.println(e);
			return;
		}

	}

}
