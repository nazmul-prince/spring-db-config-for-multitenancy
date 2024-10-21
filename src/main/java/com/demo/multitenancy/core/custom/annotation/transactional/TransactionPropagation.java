package com.demo.multitenancy.core.custom.annotation.transactional;


public enum TransactionPropagation {

    /**
     * Support a current transaction, create a new one if none exists. Analogous to EJB transaction
     * attribute of the same name.
     * <p>This is the default setting of a transaction annotation.
     */
    REQUIRED,

    /**
     * Support a current transaction, execute non-transactionally if none exists. Analogous to EJB
     * transaction attribute of the same name.
     * <p>Note: For transaction managers with transaction synchronization,
     * {@code SUPPORTS} is slightly different from no transaction at all, as it defines a
     * transaction scope that synchronization will apply for. As a consequence, the same resources
     * (JDBC Connection, Hibernate Session, etc) will be shared for the entire specified scope. Note
     * that this depends on the actual synchronization configuration of the transaction manager.
     */
    SUPPORTS,

    /**
     * Support a current transaction, throw an exception if none exists. Analogous to EJB
     * transaction attribute of the same name.
     */
    MANDATORY,

    /**
     * Create a new transaction, and suspend the current transaction if one exists. Analogous to the
     * EJB transaction attribute of the same name.
     * <p><b>NOTE:</b> Actual transaction suspension will not work out-of-the-box
     * on all transaction managers. This in particular applies to which requires the
     * {@code jakarta.transaction.TransactionManager} to be made available to it (which is
     * server-specific in standard Jakarta EE).
     */
    REQUIRES_NEW,

    /**
     * Execute non-transactionally, suspend the current transaction if one exists. Analogous to EJB
     * transaction attribute of the same name.
     * <p><b>NOTE:</b> Actual transaction suspension will not work out-of-the-box
     * on all transaction managers. This in particular applies to which requires the
     * {@code jakarta.transaction.TransactionManager} to be made available to it (which is
     * server-specific in standard Jakarta EE).
     */
    NOT_SUPPORTED,

    /**
     * Execute non-transactionally, throw an exception if a transaction exists. Analogous to EJB
     * transaction attribute of the same name.
     */
    NEVER,

    /**
     * Execute within a nested transaction if a current transaction exists, behave like
     * {@code REQUIRED} otherwise. There is no analogous feature in EJB.
     * <p>Note: Actual creation of a nested transaction will only work on specific
     * transaction managers. Out of the box, this only applies to the JDBC
     * DataSourceTransactionManager. Some JTA providers might support nested transactions as well.
     */
    NESTED;
}
