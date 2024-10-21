package com.demo.multitenancy.infrastructure.configuration.multitenancy;

import com.demo.multitenancy.core.utils.TenantContext;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

@Component("currentTenantIdentifierResolver")
public class CurrentTenantIdentifierResolverImpl implements CurrentTenantIdentifierResolver {

    @Override
    public String resolveCurrentTenantIdentifier() {
        String tenantId = TenantContext.getTenantId();
        if (!ObjectUtils.isEmpty(tenantId)) {
            return tenantId;
        } else {
            // Allow bootstrapping the EntityManagerFactory, in which case no tenant is needed
            return "BOOTSTRAP";
        }
    }

    @Override
    public boolean validateExistingCurrentSessions() {
        return true;
    }
}
