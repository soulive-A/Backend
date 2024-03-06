package com.backend.soullive_a.dto.response;

import com.backend.soullive_a.entity.model.Model;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;

@Builder
public record ModelImageKeywordResponse(
//        Long id,
        String keyord
//        Model model //필요한가?
) {
}
