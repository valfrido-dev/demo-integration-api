package com.personal.training.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
@Component
public class AppKeyFilter extends OncePerRequestFilter {

    private final AppKeyService appKeyService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        String appKey = request.getHeader("APP-KEY");

        if (appKey == null || !appKeyService.isValid(appKey)) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "App Key inválida ou ausente");
            return;
        }

        if (!appKeyService.hasQuota(appKey)) {
            response.sendError(HttpServletResponse.SC_LENGTH_REQUIRED, "Limite de consumo atingido");
            return;
        }

        appKeyService.incrementUsage(appKey);
        filterChain.doFilter(request, response);
    }
}
