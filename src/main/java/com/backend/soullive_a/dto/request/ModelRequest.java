package com.backend.soullive_a.dto.request;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record ModelRequest(
        @NotNull String modelName,
        @NotNull LocalDateTime birth,
        @NotNull String job,
        String info,
        @NotNull String agency,
        @NotNull Float aiRate) {
}
