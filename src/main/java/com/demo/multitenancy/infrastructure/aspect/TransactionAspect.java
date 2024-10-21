package com.demo.multitenancy.infrastructure.aspect;

import com.demo.multitenancy.core.custom.annotation.transactional.TransactionIsolation;
import com.demo.multitenancy.core.custom.annotation.transactional.TransactionPropagation;
import com.demo.multitenancy.core.custom.annotation.transactional.Transactional;
import java.util.Arrays;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Slf4j
@Aspect
@Component
public class TransactionAspect {

    private final PlatformTransactionManager transactionManager;

    public TransactionAspect(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    @Around("@annotation(transactional) || @within(transactional)")
    public Object manageTransaction(ProceedingJoinPoint joinPoint, Transactional transactional)
            throws Throwable {
        DefaultTransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
        transactionDefinition.setPropagationBehavior(
                getPropagationValue(transactional.propagation()));
        transactionDefinition.setIsolationLevel(getIsolationValue(transactional.isolation()));
        transactionDefinition.setTimeout(transactional.timeout());
        transactionDefinition.setReadOnly(transactional.readOnly());

        TransactionStatus status = transactionManager.getTransaction(transactionDefinition);

        try {
            Object result = joinPoint.proceed();
            transactionManager.commit(status);
            return result;
        } catch (Exception ex) {
            log.info("Error while transactional");
            log.error("Error in transactional.", ex);
            transactionManager.rollback(status);
            throw ex;
        }
    }

    private int getPropagationValue(TransactionPropagation propagation) {
        return Arrays.stream(Propagation.values())
                .filter(p -> Objects.equals(p.name(), propagation.name()))
                .findFirst()
                .orElse(Propagation.REQUIRED)
                .value();
    }

    private int getIsolationValue(TransactionIsolation isolation) {
        return Arrays.stream(Isolation.values())
                .filter(i -> Objects.equals(i.name(), isolation.name()))
                .findFirst()
                .orElse(Isolation.DEFAULT)
                .value();
    }

}