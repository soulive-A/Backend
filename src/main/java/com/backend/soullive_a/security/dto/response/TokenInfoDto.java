package com.backend.soullive_a.security.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor @NoArgsConstructor
public class TokenInfoDto {

    private String accessToken;

    private String refreshToken;
}
