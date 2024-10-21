package com.demo.multitenancy.infradetails.persistence.utils;

import static com.demo.multitenancy.infradetails.persistence.utils.SpecificationBuilder.createSpecification;
import static org.springframework.data.jpa.domain.Specification.where;

import com.demo.multitenancy.core.domain.model.Filter;

import java.util.List;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SpecificationUtils {

    public static <E> Specification<E> generateSpecificationByFilters(List<Filter> filterList) {
        Specification<E> specification = where(null);

        if (!filterList.isEmpty()) {
            specification = where(createSpecification(filterList.remove(0)));
            for (Filter input : filterList) {
                specification = specification.and(createSpecification(input));
            }
        }

        return specification;
    }

}