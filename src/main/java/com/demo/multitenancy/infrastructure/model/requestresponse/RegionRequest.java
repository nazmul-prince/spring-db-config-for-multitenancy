package com.demo.multitenancy.infrastructure.model.requestresponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Objects;

public class RegionRequest {
    @JsonProperty("regionCode")
    private Integer regionCode;
    @JsonProperty("nameBn")
    private String nameBn;
    @JsonProperty("nameEn")
    private String nameEn;

    public RegionRequest() {
    }

    public RegionRequest regionCode(Integer regionCode) {
        this.regionCode = regionCode;
        return this;
    }

    public @NotNull Integer getRegionCode() {
        return this.regionCode;
    }

    public void setRegionCode(Integer regionCode) {
        this.regionCode = regionCode;
    }

    public RegionRequest nameBn(String nameBn) {
        this.nameBn = nameBn;
        return this;
    }

    public @NotNull @Size(
    max = 255
) String getNameBn() {
        return this.nameBn;
    }

    public void setNameBn(String nameBn) {
        this.nameBn = nameBn;
    }

    public RegionRequest nameEn(String nameEn) {
        this.nameEn = nameEn;
        return this;
    }

    public @NotNull @Size(
    max = 255
) String getNameEn() {
        return this.nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            RegionRequest regionRequest = (RegionRequest)o;
            return Objects.equals(this.regionCode, regionRequest.regionCode) && Objects.equals(this.nameBn, regionRequest.nameBn) && Objects.equals(this.nameEn, regionRequest.nameEn);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.regionCode, this.nameBn, this.nameEn});
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RegionRequest {\n");
        sb.append("    regionCode: ").append(this.toIndentedString(this.regionCode)).append("\n");
        sb.append("    nameBn: ").append(this.toIndentedString(this.nameBn)).append("\n");
        sb.append("    nameEn: ").append(this.toIndentedString(this.nameEn)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return o == null ? "null" : o.toString().replace("\n", "\n    ");
    }
}
