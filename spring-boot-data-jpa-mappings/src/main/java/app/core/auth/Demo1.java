package app.core.auth;

import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class Demo1 {

	public static void main(String[] args) {

		// get a JWT Builder
		JwtBuilder jwtBuilder = Jwts.builder();

		// GENERATE KEY FOR SIGNING THE TOKEN

		// part 1 - secret - encoded to platform charset
		String secret = "a".repeat(43);
		System.out.println(secret);
		// part 2 - choose the algorithm for encrypting the signature
		String JCAName = SignatureAlgorithm.HS256.getJcaName();
		// part 3 - create the key
		Key key = new SecretKeySpec(Base64.getDecoder().decode(secret), JCAName);

		Instant now = Instant.now();
		Instant exp = now.plus(5, ChronoUnit.MINUTES);

		// when server respond to login - create the token
		String token = jwtBuilder

				.signWith(key)

				.setSubject("eldar@mail")

				.setIssuedAt(Date.from(now))

				.setExpiration(Date.from(exp))

				.claim("first name", "Eldar")

				.claim("last name", "Bakshi")

				.compact();

		System.out.println(token);
		
		// when server respond to api call - parsing the JWS String
		// get a parser
		JwtParser jwtParser = Jwts.parserBuilder().setSigningKey(key).build();
		Jws<Claims> jwt = jwtParser.parseClaimsJws(token);
		System.out.println(jwt);
		System.out.println(jwt.getHeader());
		System.out.println(jwt.getBody());
		System.out.println(jwt.getSignature());
		
	}

}
