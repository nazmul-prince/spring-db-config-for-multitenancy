package com.demo.multitenancy.core.shared.exceptions;

import com.demo.multitenancy.core.constant.HttpStatusCode;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class InternalServerErrorException extends RuntimeException {

    private final HttpStatusCode httpStatusCode;

    public InternalServerErrorException(final String message, HttpStatusCode httpStatusCode) {
        super(message);
        this.httpStatusCode = httpStatusCode;
    }

}
