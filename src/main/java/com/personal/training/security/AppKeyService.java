package com.personal.training.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class AppKeyService {

    private final Map<String, AppKey> keys = new HashMap<>();
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public void registerKey(String rawKey, String owner, Long limite) {
        AppKey appKey = new AppKey();
        appKey.setKeyHash(encoder.encode(rawKey));
        appKey.setOwner(owner);
        appKey.setLimite(limite);
        appKey.setConsumo(0L);
        keys.put(owner, appKey);
    }

    public boolean isValid(String rawKey) {
        return keys.values().stream()
                .anyMatch(appKey -> encoder.matches(rawKey, appKey.getKeyHash()));
    }

    public boolean hasQuota(String rawKey) {
        return keys.values().stream()
                .filter(appKey -> encoder.matches(rawKey, appKey.getKeyHash()))
                .anyMatch(appKey -> appKey.getConsumo() < appKey.getLimite());
    }

    public void incrementUsage(String rawKey) {
        keys.values().stream()
                .filter(appKey -> encoder.matches(rawKey, appKey.getKeyHash()))
                .findFirst()
                .ifPresent(appKey -> appKey.setConsumo(appKey.getConsumo() + 1));
    }

}
