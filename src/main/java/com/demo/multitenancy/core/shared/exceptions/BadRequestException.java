package com.demo.multitenancy.core.shared.exceptions;

import com.demo.multitenancy.core.constant.HttpStatusCode;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BadRequestException extends RuntimeException {

    private final HttpStatusCode httpStatusCode;

    public BadRequestException(final String message, HttpStatusCode httpStatusCode) {
        super(message);
        this.httpStatusCode = httpStatusCode;
    }

}