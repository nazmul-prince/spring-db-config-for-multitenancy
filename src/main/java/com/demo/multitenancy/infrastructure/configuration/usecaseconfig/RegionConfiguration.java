package com.demo.multitenancy.infrastructure.configuration.usecaseconfig;

import com.demo.multitenancy.core.domain.persistence.port.RegionPersistencePort;
import com.demo.multitenancy.core.domain.usecase.regionusecase.RegionModificationUseCase;
import com.demo.multitenancy.core.domain.usecase.regionusecase.RegionRetrieveUseCase;
import com.demo.multitenancy.core.domain.usecase.regionusecase.impl.RegionModificationUseCaseImpl;
import com.demo.multitenancy.core.domain.usecase.regionusecase.impl.RegionRetrieveUseCaseImpl;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class RegionConfiguration {

    private final RegionPersistencePort regionPersistencePort;

    @Bean
    public RegionRetrieveUseCase regionRetrieveUseCase() {
        return new RegionRetrieveUseCaseImpl(regionPersistencePort);
    }

    @Bean
    public RegionModificationUseCase regionModificationUseCase() {
        return new RegionModificationUseCaseImpl(regionPersistencePort);
    }

}
