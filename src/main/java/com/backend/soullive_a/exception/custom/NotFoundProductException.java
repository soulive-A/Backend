package com.backend.soullive_a.exception.custom;

import com.backend.soullive_a.exception.base.BaseException;
import com.backend.soullive_a.exception.base.ErrorCode;

public class NotFoundProductException extends BaseException {

    public NotFoundProductException() {
        super(ErrorCode.NOT_FOUND_PRODUCT);
    }

    public NotFoundProductException(String message) {
        super(ErrorCode.NOT_FOUND_PRODUCT, message);
    }
}
