package com.backend.soullive_a.exception.custom;

import com.backend.soullive_a.exception.base.BaseException;
import com.backend.soullive_a.exception.base.ErrorCode;
import lombok.Getter;

@Getter
public class NotFoundUserException extends BaseException {

    public NotFoundUserException() {
        super(ErrorCode.NOT_FOUND_USER);
    }

    public NotFoundUserException(String message) {
        super(ErrorCode.NOT_FOUND_USER, message);
    }
}