package com.demo.multitenancy.infrastructure.configuration.multitenancy;

//import com.github.benmanes.caffeine.cache.Caffeine;
//import com.github.benmanes.caffeine.cache.LoadingCache;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider;
import org.hibernate.service.UnknownUnwrapTypeException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SchemaBasedMultiTenantConnectionProvider implements MultiTenantConnectionProvider {

    private final DataSource datasource;
//    private final TenantRepository tenantRepository;

    @Value("${multitenancy.meta.schema:#{null}}")
    private String metaSchema;

    public SchemaBasedMultiTenantConnectionProvider(@Qualifier("dataSource") DataSource datasource) {
        this.datasource = datasource;
    }

//    private LoadingCache<String, String> tenantSchemas;

//    @PostConstruct
//    private void createCache() {
//        Caffeine<Object, Object> tenantsCacheBuilder = Caffeine.newBuilder();
//        if (maximumSize != null) {
//            tenantsCacheBuilder.maximumSize(maximumSize);
//        }
//        if (expireAfterAccess != null) {
//            tenantsCacheBuilder.expireAfterAccess(expireAfterAccess, TimeUnit.MINUTES);
//        }
//        tenantSchemas = tenantsCacheBuilder.build(
//            tenantId -> {
//                Tenant tenant = tenantRepository.findByTenantId(tenantId)
//                    .orElseThrow(() -> new RuntimeException("No such tenant: " + tenantId));
//                return tenant.getSchema();
//            });
//    }

    @Override
    public Connection getAnyConnection() throws SQLException {
        return datasource.getConnection();
    }

    @Override
    public void releaseAnyConnection(Connection connection) throws SQLException {
        connection.close();
    }

    @Override
    public Connection getConnection(String tenantIdentifier) throws SQLException {
        log.info("Get connection for tenant {}", tenantIdentifier);
//        String tenantSchema = tenantSchemas.get(tenantIdentifier);
        final Connection connection = getAnyConnection();
        connection.setSchema(tenantIdentifier);
        return connection;
    }

    @Override
    public void releaseConnection(String tenantIdentifier, Connection connection) throws SQLException {
        log.info("Release connection for tenant {}", tenantIdentifier);
        connection.setSchema(metaSchema);
        releaseAnyConnection(connection);
    }

    @Override
    public boolean supportsAggressiveRelease() {
        return false;
    }

    @Override
    public boolean isUnwrappableAs(Class unwrapType) {
        return MultiTenantConnectionProvider.class.isAssignableFrom(unwrapType);
    }

    @Override
    public <T> T unwrap(Class<T> unwrapType) {
        if ( MultiTenantConnectionProvider.class.isAssignableFrom(unwrapType) ) {
            return (T) this;
        } else {
            throw new UnknownUnwrapTypeException( unwrapType );
        }
    }
}
