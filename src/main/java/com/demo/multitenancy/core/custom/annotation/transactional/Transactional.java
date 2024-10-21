package com.demo.multitenancy.core.custom.annotation.transactional;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Transactional {

    TransactionPropagation propagation() default TransactionPropagation.REQUIRED;

    TransactionIsolation isolation() default TransactionIsolation.DEFAULT;

    int timeout() default -1;

    boolean readOnly() default false;
}
