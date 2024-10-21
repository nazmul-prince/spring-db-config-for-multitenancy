package com.demo.multitenancy.infrastructure.model.requestresponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RegionListResponse {
    @JsonProperty("page")
    private Integer page;
    @JsonProperty("size")
    private Integer size;
    @JsonProperty("total")
    private Integer total;
    @JsonProperty("regions")
    private @Valid List<RegionResponse> regions = null;

    public RegionListResponse() {
    }

    public RegionListResponse page(Integer page) {
        this.page = page;
        return this;
    }

    public Integer getPage() {
        return this.page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public RegionListResponse size(Integer size) {
        this.size = size;
        return this;
    }

    public Integer getSize() {
        return this.size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public RegionListResponse total(Integer total) {
        this.total = total;
        return this;
    }

    public Integer getTotal() {
        return this.total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public RegionListResponse regions(List<RegionResponse> regions) {
        this.regions = regions;
        return this;
    }

    public RegionListResponse addRegionsItem(RegionResponse regionsItem) {
        if (this.regions == null) {
            this.regions = new ArrayList();
        }

        this.regions.add(regionsItem);
        return this;
    }

    public @Valid List<RegionResponse> getRegions() {
        return this.regions;
    }

    public void setRegions(List<RegionResponse> regions) {
        this.regions = regions;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            RegionListResponse regionListResponse = (RegionListResponse)o;
            return Objects.equals(this.page, regionListResponse.page) && Objects.equals(this.size, regionListResponse.size) && Objects.equals(this.total, regionListResponse.total) && Objects.equals(this.regions, regionListResponse.regions);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.page, this.size, this.total, this.regions});
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RegionListResponse {\n");
        sb.append("    page: ").append(this.toIndentedString(this.page)).append("\n");
        sb.append("    size: ").append(this.toIndentedString(this.size)).append("\n");
        sb.append("    total: ").append(this.toIndentedString(this.total)).append("\n");
        sb.append("    regions: ").append(this.toIndentedString(this.regions)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return o == null ? "null" : o.toString().replace("\n", "\n    ");
    }
}
