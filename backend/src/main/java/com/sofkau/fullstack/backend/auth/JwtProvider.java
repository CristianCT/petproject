package com.sofkau.fullstack.backend.auth;

import com.sofkau.fullstack.backend.DTOs.UserDTO;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtProvider {

    private static final Logger logger = LoggerFactory.getLogger(JwtProvider.class);

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private long expiration;

    public String generateToken(UserDTO userDTO) {

        return Jwts.builder()
                .setSubject(userDTO.getEmail())
                .setExpiration(new Date(new Date().getTime() + expiration*1000))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public String getEmailFromToken(String token){
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token).getBody()
                .getSubject();
    }

    public boolean validateToken(String token) throws Exception {
        try{
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (MalformedJwtException e){
            logger.error("Error en el token");
        } catch (UnsupportedJwtException e){
            logger.error("Token no soportado");
        } catch (ExpiredJwtException e){
            logger.error("El token ha expirado");
        } catch (IllegalArgumentException e){
            logger.error("Token vacío");
        } catch (SignatureException e){
            logger.error("Error en la firma");
        }
        return false;
    }
}