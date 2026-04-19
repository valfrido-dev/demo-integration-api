package com.personal.training.initializer;

import com.personal.training.security.AppKeyService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AppKeyDefaultInitializer {

    private final AppKeyService appKeyService;
    private final String keyAccessInit;
    private final String ownerAppInit;
    private final long limit;

    public AppKeyDefaultInitializer(AppKeyService appKeyService,
                                    @Value("${default.app.key}") String keyAccessInit,
                                    @Value("${default.app.owner}") String ownerAppInit,
                                    @Value("${default.app.limit}") long limit) {
        this.appKeyService = appKeyService;
        this.keyAccessInit = keyAccessInit;
        this.ownerAppInit = ownerAppInit;
        this.limit = limit;
    }

    @PostConstruct
    public void init() {
        appKeyService.registerKey(keyAccessInit, ownerAppInit, limit);
    }
}
