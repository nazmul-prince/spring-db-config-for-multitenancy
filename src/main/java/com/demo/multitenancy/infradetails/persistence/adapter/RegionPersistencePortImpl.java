package com.demo.multitenancy.infradetails.persistence.adapter;

import com.demo.multitenancy.core.domain.model.usecase.Region;
import com.demo.multitenancy.infradetails.persistence.entity.RegionEntity;
import com.demo.multitenancy.infradetails.persistence.utils.NullAwareBeanUtils;
import com.demo.multitenancy.core.domain.filter.RegionFilter;
import com.demo.multitenancy.core.domain.model.Filter;
import com.demo.multitenancy.core.domain.model.PaginatedDomainModel;
import com.demo.multitenancy.core.domain.model.PaginationModel;
import com.demo.multitenancy.core.domain.persistence.port.RegionPersistencePort;
import com.demo.multitenancy.infradetails.persistence.mapper.RegionDomainEntityMapper;
import com.demo.multitenancy.infradetails.persistence.repository.RegionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.demo.multitenancy.core.constant.QueryOperator.IN;
import static com.demo.multitenancy.core.constant.QueryOperator.LIKE;
import static com.demo.multitenancy.core.utils.QueryFilterUtils.generateInFilter;
import static com.demo.multitenancy.core.utils.QueryFilterUtils.generateIndividualFilter;
import static com.demo.multitenancy.infradetails.persistence.utils.SpecificationUtils.generateSpecificationByFilters;

@Slf4j
@Component
@RequiredArgsConstructor
public class RegionPersistencePortImpl implements RegionPersistencePort {

    private final RegionRepository regionRepository;
    private final RegionDomainEntityMapper regionDomainEntityMapper;

    @Override
    public PaginatedDomainModel getRegions(
            RegionFilter regionFilter, PaginationModel paginationModel
    ) {

        List<Filter> filterList = generateQueryFilters(regionFilter);

        Specification<RegionEntity> specification = generateSpecificationByFilters(filterList);

        Pageable pageable = PageRequest.of(paginationModel.getPage(), paginationModel.getSize());

        Page<RegionEntity> regionEntityPage = regionRepository.findAll(specification, pageable);

        List<Region> regions = regionEntityPage.getContent().stream()
                .map(regionDomainEntityMapper::entityToDomainModel)
                .toList();

        return new PaginatedDomainModel(regionEntityPage.getNumber(), regionEntityPage.getSize(),
                                        (int) regionEntityPage.getTotalElements(), regions
        );
    }

    @Override
    public Region getRegionById(Integer id) {
        Optional<RegionEntity> optionalRegionEntity = regionRepository.findById(id);

        return optionalRegionEntity.map(regionDomainEntityMapper::entityToDomainModel).orElse(null);
    }

    @Override
    public Region createRegion(Region region) {
        RegionEntity regionEntity = regionDomainEntityMapper.domainModelToEntity(region);
        regionEntity = regionRepository.save(regionEntity);

        return regionDomainEntityMapper.entityToDomainModel(regionEntity);
    }

    @Override
    public Region updateRegion(Integer id, Region region) {
        RegionEntity regionEntity = regionRepository.findById(id).orElse(null);
        if (regionEntity == null) {return null;}
        NullAwareBeanUtils.copyNonNullProperties(region, regionEntity);
        regionEntity = regionRepository.save(regionEntity);
        return regionDomainEntityMapper.entityToDomainModel(regionEntity);
    }

    @Override
    public void deleteRegionById(Integer id) {
        regionRepository.deleteById(id);
    }

    @Override
    public List<Region> getAllRegions() {
        return regionDomainEntityMapper.entityToDomainModel(regionRepository.findAll());
    }

    public List<Filter> generateQueryFilters(RegionFilter regionFilter) {

        List<Filter> filters = new ArrayList<>();

        if (regionFilter.getRegionCode() != null) {
            filters.add(generateIndividualFilter("regionCode", LIKE, regionFilter.getRegionCode()));
        }

        if (regionFilter.getNameBn() != null && !regionFilter.getNameBn().isEmpty()) {
            filters.add(generateIndividualFilter("nameBn", LIKE, regionFilter.getNameBn()));
        }

        if (regionFilter.getNameEn() != null && !regionFilter.getNameEn().isEmpty()) {
            filters.add(generateIndividualFilter("nameEn", LIKE, regionFilter.getNameEn()));
        }

        if (regionFilter.getRegionIds() != null) {
            filters.add(generateInFilter("id", IN, regionFilter.getRegionIds()));
        }

        return filters;
    }

}
