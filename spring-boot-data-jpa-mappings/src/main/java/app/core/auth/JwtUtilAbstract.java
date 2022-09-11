package app.core.auth;

import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Date;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public abstract class JwtUtilAbstract<T, ID> {

	private String alg = SignatureAlgorithm.HS256.getJcaName();
	@Value("${jwt.util.secret.key}")
	private String secret;
	private Key key;
	@Value("${jwt.util.chrono.unit}")
	private String chronoUnit;
	@Value("${jwt.util.chrono.unit.number}")
	private int unitsNumber;

	@PostConstruct
	public void init() {
		this.key = new SecretKeySpec(Base64.getDecoder().decode(secret), alg);
	}

	// methods for creating token
	public abstract String generateToken(T user);

	protected String createToken(Map<String, Object> claims, ID id) {
		Instant now = Instant.now();
		Instant exp = now.plus(unitsNumber, ChronoUnit.valueOf(this.chronoUnit));

		JwtBuilder jwtBuilder = Jwts.builder();
		String token = jwtBuilder

				.setClaims(claims) // must be first

				.signWith(key)

				.setSubject(id.toString())

				.setIssuedAt(Date.from(now))

				.setExpiration(Date.from(exp))

				.compact();

		return token;
	}

	// methods for parsing token
	public abstract T extractUser(String token) throws JwtException;

	protected Claims extractAllClaims(String token) throws JwtException {
		JwtParser jwtParser = Jwts.parserBuilder().setSigningKey(key).build();
		Jws<Claims> jwt = jwtParser.parseClaimsJws(token);
		return jwt.getBody();
	}
}
