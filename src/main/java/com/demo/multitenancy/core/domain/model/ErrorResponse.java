package com.demo.multitenancy.core.domain.model;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ErrorResponse {

    String httpStatusCode;
    String message;
    List<String> errorStackTrace;
    LocalDateTime timestamp;

}
