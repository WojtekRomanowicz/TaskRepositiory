package com.crud.tasks.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class Mail {
    private final String mailTo;
    private final String subject;
    private final String message;
    private final String toCc;
}