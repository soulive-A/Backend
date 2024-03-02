package com.backend.soullive_a.security.filter;


import com.backend.soullive_a.entity.User;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

@NoArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final String AUTHENTICATION_HEADER = "Authorization";
    private final String AUTHENTICATION_SCHEME = "Bearer ";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
        FilterChain filterChain) throws ServletException, IOException {

        SecurityContext context = SecurityContextHolder.createEmptyContext();
        context.setAuthentication(getAuthentication());
        SecurityContextHolder.setContext(context);

        filterChain.doFilter(request, response);
    }

    private String extractToken(HttpServletRequest request) {
        String bearToken = request.getHeader(AUTHENTICATION_HEADER);

        if (StringUtils.hasText(bearToken) && bearToken.startsWith(AUTHENTICATION_SCHEME)) {
            return bearToken.substring(AUTHENTICATION_SCHEME.length());
        }

        return null;

    }

    private Authentication getAuthentication() {

        User user = User.builder()
            .id(1L)
            .phoneNumber("010-3370-2740")
            .password("1234")
            .build();

        return new UsernamePasswordAuthenticationToken(user, null, null);
    }
}

