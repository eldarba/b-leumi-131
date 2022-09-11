package app.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.core.auth.AuthException;
import app.core.auth.JwtUtilImpl;
import app.core.auth.User;
import app.core.auth.UserCredentials;
import app.core.auth.UserRepository;

@Service
public class AuthService {

	@Autowired
	private JwtUtilImpl jwtUtil;
	@Autowired
	private UserRepository userRepository;

	public String register(User user) {
		if (user.getUsername() == null || user.getUsername().length() < 3) {
			throw new AuthException("username must be at leat 3 characters");
		}
		if (user.getEmail() == null || !user.getEmail().contains("@")) {
			throw new AuthException("email must contain @");
		}
		if (user.getPassword() == null || user.getPassword().length() < 3) {
			throw new AuthException("password must be at leat 3 characters");
		}
		userRepository.save(user);
		return jwtUtil.generateToken(user); // return token
	}

	public String login(UserCredentials credentials) {
		User user = userRepository.findByEmail(credentials.getEmail())
				.orElseThrow(() -> new AuthException("no such user: " + credentials.getEmail()));
		
		if(credentials.getPassword().equals(user.getPassword())) {
			return jwtUtil.generateToken(user); // return token
		}
		
		throw new AuthException("login failed - bad credentials");
	}

}
