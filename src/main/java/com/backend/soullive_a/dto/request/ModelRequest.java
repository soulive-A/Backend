package com.backend.soullive_a.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ModelRequest(

        String imageUrl,
        String modelName,
        LocalDate birth,
        String age,
        String job,

        String info,
        String agency,


        Float aiRate) {

}
