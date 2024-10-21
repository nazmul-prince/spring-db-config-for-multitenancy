package com.demo.multitenancy.core.service;

import java.util.List;
import java.util.Optional;

public interface TokenClaim {

    Optional<String> getClaimByValue(String claimName);

    Optional<List<String>> getClaimListByValue(String claimName);

    Optional<List<String>> getAuthorities();
}
