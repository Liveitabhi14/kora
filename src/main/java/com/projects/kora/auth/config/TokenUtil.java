package com.projects.kora.auth.config;

import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;
import java.util.function.Function;

public interface TokenUtil {

    String getUsernameFromToken(String token);

    Date getIssuedAtDateFromToken(String token);

    Date getExpirationDateFromToken(String token);

    <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver);

    String generateToken(UserDetails userDetails);

    Boolean canTokenBeRefreshed(String token);

    Boolean validateToken(String token, UserDetails userDetails);
}
