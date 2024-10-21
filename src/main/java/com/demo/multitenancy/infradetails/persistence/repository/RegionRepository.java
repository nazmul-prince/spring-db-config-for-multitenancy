package com.demo.multitenancy.infradetails.persistence.repository;

import com.demo.multitenancy.infradetails.persistence.entity.RegionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RegionRepository extends JpaRepository<RegionEntity, Integer>,
        JpaSpecificationExecutor<RegionEntity> {
}
