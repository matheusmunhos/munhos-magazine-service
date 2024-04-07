package com.munhos.magazine.service.infra.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.munhos.magazine.service.domain.administrador.Administrador;

@Service
public class TokenService {
	
	@Value("${api.security.token.secret}")
	private String secret;

	public String gerarToken(Administrador administrador) {

		try {
		    var algoritmo  = Algorithm.HMAC256(secret);
		    return JWT.create()
		        .withIssuer("Munhos")
		        .withSubject(administrador.getLogin())
		      //  .withClaim("id",administrador.getId())
		        .withExpiresAt(dataExpiracao())
		        .sign(algoritmo);
		} catch (JWTCreationException exception){
		    // Invalid Signing configuration / Couldn't convert Claims.
			throw new RuntimeException("Erro ao gerar token", exception);
		}
		
	}
	
	public String getSubject(String tokenJWT) {
		try {
		    Algorithm algoritmo = Algorithm.HMAC256(secret);
		    return JWT.require(algoritmo)
		    	.withIssuer("Munhos")
		        .build()
		        .verify(tokenJWT)
		        .getSubject();
		        
		   
		} catch (JWTVerificationException exception){
		    throw new RuntimeException("Token invalido ou expirado");
		}
	}

	private Instant dataExpiracao() {
		
		return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
	}
}
