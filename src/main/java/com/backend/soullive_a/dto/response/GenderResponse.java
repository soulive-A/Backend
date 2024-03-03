package com.backend.soullive_a.dto.response;

import com.backend.soullive_a.constant.GenderType;

public record GenderResponse (
        Long genderId,
        GenderType gender
){
}
