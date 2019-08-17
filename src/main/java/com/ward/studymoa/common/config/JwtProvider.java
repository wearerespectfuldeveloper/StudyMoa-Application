package com.ward.studymoa.common.config;

import com.ward.studymoa.user.domain.StudyUser;
import com.ward.studymoa.user.domain.StudyUserRoleType;
import com.ward.studymoa.user.service.impl.UserDetailsServiceImpl;
import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.Date;

@Component
@RequiredArgsConstructor
@Slf4j
public class JwtProvider {

    @Value("${studymoa.app.jwtSecret}")
    private String jwtSecret;

    @Value("${studymoa.app.jwtExpiration}")
    private int jwtExpiration;

    private static final Logger logger = LoggerFactory.getLogger(JwtProvider.class);
    private final UserDetailsServiceImpl userDetailsService;

    private static class JwtSpec {
        private static String SUB = "studyUser";
        private static String IDX = "idx";
        private static String USER_ID = "userId";
        private static String EMAIL = "email";
        private static String AUTH = "auth";
    }

    @PostConstruct
    protected void encodingSecretKey() {
        jwtSecret = Base64.getEncoder().encodeToString(jwtSecret.getBytes());
    }

    public String generateJwtToken(UserDetails userDetails) {
        StudyUser studyUser = (StudyUser) userDetails;
        Claims claims = Jwts.claims().setSubject(JwtSpec.SUB);
        claims.put(JwtSpec.IDX, studyUser.getIdx());
        claims.put(JwtSpec.USER_ID, studyUser.getUserId());
        claims.put(JwtSpec.EMAIL, studyUser.getEmail());
        claims.put(JwtSpec.AUTH, studyUser.getStudyUserRoleType());

        Date now = new Date();
        Date validity = new Date(now.getTime() + jwtExpiration);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS256, jwtSecret)
                .compact();
    }

    public Authentication getAuthentication(String token) {
        UserDetails userDetails = StudyUser.builder()
                .idx(getIdxFromJwtToken(token))
                .userId(getUserIdFromJwtToken(token))
                .email(getEmailFromJwtToken(token))
                .studyUserRoleType(StudyUserRoleType.valueOf(getAuthFromJwtToken(token)))
                .build();

        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    public Long getIdxFromJwtToken(String token) {
        return Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody().get(JwtSpec.IDX, Long.class);
    }

    public String getUserIdFromJwtToken(String token) {
        return Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody().get(JwtSpec.USER_ID, String.class);
    }

    public String getEmailFromJwtToken(String token) {
        return Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody().get(JwtSpec.EMAIL, String.class);
    }

    public String getAuthFromJwtToken(String token) {
        return Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody().get(JwtSpec.AUTH, String.class);
    }

    public String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            logger.error("Invalid JWT signature -> Message: {} ", e);
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token -> Message: {}", e);
        } catch (ExpiredJwtException e) {
            logger.error("Expired JWT token -> Message: {}", e);
        } catch (UnsupportedJwtException e) {
            logger.error("Unsupported JWT token -> Message: {}", e);
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty -> Message: {}", e);
        }

        return false;
    }
}