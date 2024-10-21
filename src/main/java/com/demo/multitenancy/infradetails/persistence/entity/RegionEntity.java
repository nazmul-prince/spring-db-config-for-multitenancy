package com.demo.multitenancy.infradetails.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

@Entity
@Getter
@Setter
@Table(name = "regions")
public class RegionEntity {

    @Id
    @GenericGenerator(
            name = "sequence_gen",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(
                            name = SequenceStyleGenerator.CONFIG_SEQUENCE_PER_ENTITY_SUFFIX,
                            value = "_id_sequence"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            })

    @GeneratedValue(generator = "sequence_gen")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "region_code", nullable = false)
    private Integer regionCode;

    @Column(name = "geo_code")
    private String geoCode;

    @Column(name = "name_bn", nullable = false)
    private String nameBn;

    @Column(name = "name_en", nullable = false)
    private String nameEn;

    @Column(name = "is_active")
    private Boolean isActive;

}
