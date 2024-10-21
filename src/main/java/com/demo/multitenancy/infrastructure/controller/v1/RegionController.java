package com.demo.multitenancy.infrastructure.controller.v1;

import com.demo.multitenancy.core.domain.filter.RegionFilter;
import com.demo.multitenancy.core.domain.model.PaginatedDomainModel;
import com.demo.multitenancy.core.domain.model.PaginationModel;
import com.demo.multitenancy.core.domain.model.usecase.Region;
import com.demo.multitenancy.core.domain.usecase.regionusecase.RegionModificationUseCase;
import com.demo.multitenancy.core.domain.usecase.regionusecase.RegionRetrieveUseCase;
import com.demo.multitenancy.infradetails.persistence.mapper.RegionDomainRequestMapper;
import com.demo.multitenancy.infradetails.persistence.mapper.RegionDomainResponseMapper;
import com.demo.multitenancy.infradetails.persistence.mapper.RegionListResponseMapper;
import com.demo.multitenancy.infrastructure.model.requestresponse.RegionListResponse;
import com.demo.multitenancy.infrastructure.model.requestresponse.RegionRequest;
import com.demo.multitenancy.infrastructure.model.requestresponse.RegionResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/private/regions")
@RequiredArgsConstructor
public class RegionController {

    private final RegionRetrieveUseCase regionRetrieveUseCase;
    private final RegionModificationUseCase regionModificationUseCase;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RegionListResponse> getRegions(
            @RequestParam(name = "page", defaultValue = "0")  @Min(0L) @Valid Integer page,
            @RequestParam(name = "size", defaultValue = "10") @Min(10L) @Valid Integer size
    ) {
        PaginationModel paginationModel = new PaginationModel(page, size);
        RegionFilter regionFilter = RegionFilter.builder()
                .build();
        PaginatedDomainModel paginatedDomainModel = regionRetrieveUseCase.getRegions(
                regionFilter, paginationModel);
        return ResponseEntity.ok(
                RegionListResponseMapper.INSTANCE.domainModelToResponseModel(paginatedDomainModel));
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RegionResponse> getRegionById(@PathVariable("id") Integer id) {
        Region region = regionRetrieveUseCase.getRegionById(id);
        return ResponseEntity.ok().body(
                RegionDomainResponseMapper.INSTANCE.domainModelToResponseModel(region));
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RegionResponse> createRegion(
            @Valid @RequestBody RegionRequest regionRequest
    ) {
        Region region = RegionDomainRequestMapper.INSTANCE.requestModelToDomainModel(regionRequest);
        region = regionModificationUseCase.createRegion(region);
        RegionResponse regionResponse =
                RegionDomainResponseMapper.INSTANCE.domainModelToResponseModel(
                        region);

        return ResponseEntity.status(HttpStatus.CREATED).body(regionResponse);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RegionResponse> updateRegion(
            @PathVariable("id") Integer id, @Valid @RequestBody RegionRequest regionRequest
    ) {
        Region region = regionModificationUseCase.updateRegion(
                id, RegionDomainRequestMapper.INSTANCE.requestModelToDomainModel(regionRequest));
        if (region == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(
                RegionDomainResponseMapper.INSTANCE.domainModelToResponseModel(region));
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteRegion(@PathVariable("id") Integer id) {
        regionModificationUseCase.deleteRegion(id);
        return ResponseEntity.noContent().build();
    }

}
