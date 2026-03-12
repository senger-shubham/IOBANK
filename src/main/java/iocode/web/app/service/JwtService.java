package iocode.web.app.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.SignatureAlgorithm;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;

public class JwtService {

    private static final long EXPIRATION_TIME=86400000; //1 day in millisecond
     private static final String TOKEN_PREFIX="Bearer";

     private static final String HEADER_STRING="Authorization";

    @Value("${jwtSecret}")
    private String jwtSecret;

    public SecretKey generatekey(){
        byte[] keyBytes=jwtSecret.getBytes();
        return new SecretKeySpec(keyBytes, SignatureAlgorithm.HS512.getJcaName());

    }

    public String generateToken(String username){
        Date now=new Date();
        Date expiration =new Date(now.getTime()+EXPIRATION_TIME);

        return jwts.builder()
                .Subject(username)
                .IssuedAt(now)
                .Expiration(expiration)
                .signWith(generatekey())
                .compact();

    }

    public Claims extractClaims(String token){
        return Jwts.parser()
                .verifyWith(generatekey())
                .build()
                .parseSignedClaims(token)
                .getPayload();

    }

    public String extractSubject(String token){
        return extractClaims(token).getSubject();

    }
    public Boolean isTokenValid(String token){

    }

    public Date extractExpiration(String token){
       return extractClaims(token).getExpiration();
    }

}
