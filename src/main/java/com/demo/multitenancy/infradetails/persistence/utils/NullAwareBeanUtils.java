package com.demo.multitenancy.infradetails.persistence.utils;

import java.beans.PropertyDescriptor;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class NullAwareBeanUtils {

    /**
     * Copies non-null properties from one object to another.
     */
    public static void copyNonNullProperties(
            Object source, Object destination, String... ignoreProperties
    ) {
        final Set<String> ignoreAllProperties = new HashSet<>();
        ignoreAllProperties.addAll(getPropertyNamesWithNullValue(source));
        ignoreAllProperties.addAll(Arrays.asList(ignoreProperties));

        BeanUtils.copyProperties(source, destination, ignoreAllProperties.toArray(new String[]{}));
    }

    @NonNull
    private static Set<String> getPropertyNamesWithNullValue(Object source) {
        final BeanWrapper sourceBeanWrapper = new BeanWrapperImpl(source);
        final java.beans.PropertyDescriptor[] propertyDescriptors =
                sourceBeanWrapper.getPropertyDescriptors();
        final Set<String> emptyNames = new HashSet<>();

        for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
            // Check if value of this property is null then add it to the collection
            Object propertyValue = sourceBeanWrapper.getPropertyValue(propertyDescriptor.getName());
            if (propertyValue != null) {continue;}

            emptyNames.add(propertyDescriptor.getName());
        }

        return emptyNames;
    }

}