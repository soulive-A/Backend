package com.backend.soullive_a.dto.response;

public record RecentModelResponse(
    Long modelId,
    String imageUrl,
    String modelName,
    Float aiRate
) {

}
