package com.demo.multitenancy.infrastructure.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ExceptionUtils {

    private static final int MAX_STACK_TRACE_ELEMENTS = 10;

    public static List<String> extractStacktrace(StackTraceElement[] stackTrace) {
        return Arrays.stream(stackTrace)
                .map(StackTraceElement::toString)
                .limit(MAX_STACK_TRACE_ELEMENTS)
                .collect(Collectors.toList());
    }

}
