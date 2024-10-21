package com.demo.multitenancy.infrastructure.model.requestresponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

public class RegionResponse {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("regionCode")
    private Integer regionCode;
    @JsonProperty("nameBn")
    private String nameBn;
    @JsonProperty("nameEn")
    private String nameEn;
    @JsonProperty("createdBy")
    private String createdBy;
    @JsonProperty("updatedBy")
    private String updatedBy;
    @JsonProperty("createdAt")
    private String createdAt;
    @JsonProperty("updatedAt")
    private String updatedAt;

    public RegionResponse() {
    }

    public RegionResponse id(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public RegionResponse regionCode(Integer regionCode) {
        this.regionCode = regionCode;
        return this;
    }

    public Integer getRegionCode() {
        return this.regionCode;
    }

    public void setRegionCode(Integer regionCode) {
        this.regionCode = regionCode;
    }

    public RegionResponse nameBn(String nameBn) {
        this.nameBn = nameBn;
        return this;
    }

    public String getNameBn() {
        return this.nameBn;
    }

    public void setNameBn(String nameBn) {
        this.nameBn = nameBn;
    }

    public RegionResponse nameEn(String nameEn) {
        this.nameEn = nameEn;
        return this;
    }

    public String getNameEn() {
        return this.nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public RegionResponse createdBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public RegionResponse updatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
        return this;
    }

    public String getUpdatedBy() {
        return this.updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public RegionResponse createdAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public String getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public RegionResponse updatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public String getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            RegionResponse regionResponse = (RegionResponse)o;
            return Objects.equals(this.id, regionResponse.id) && Objects.equals(this.regionCode, regionResponse.regionCode) && Objects.equals(this.nameBn, regionResponse.nameBn) && Objects.equals(this.nameEn, regionResponse.nameEn) && Objects.equals(this.createdBy, regionResponse.createdBy) && Objects.equals(this.updatedBy, regionResponse.updatedBy) && Objects.equals(this.createdAt, regionResponse.createdAt) && Objects.equals(this.updatedAt, regionResponse.updatedAt);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.id, this.regionCode, this.nameBn, this.nameEn, this.createdBy, this.updatedBy, this.createdAt, this.updatedAt});
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RegionResponse {\n");
        sb.append("    id: ").append(this.toIndentedString(this.id)).append("\n");
        sb.append("    regionCode: ").append(this.toIndentedString(this.regionCode)).append("\n");
        sb.append("    nameBn: ").append(this.toIndentedString(this.nameBn)).append("\n");
        sb.append("    nameEn: ").append(this.toIndentedString(this.nameEn)).append("\n");
        sb.append("    createdBy: ").append(this.toIndentedString(this.createdBy)).append("\n");
        sb.append("    updatedBy: ").append(this.toIndentedString(this.updatedBy)).append("\n");
        sb.append("    createdAt: ").append(this.toIndentedString(this.createdAt)).append("\n");
        sb.append("    updatedAt: ").append(this.toIndentedString(this.updatedAt)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return o == null ? "null" : o.toString().replace("\n", "\n    ");
    }
}
