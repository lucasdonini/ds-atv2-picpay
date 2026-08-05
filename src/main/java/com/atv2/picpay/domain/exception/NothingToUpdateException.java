package com.atv2.picpay.domain.exception;

public class NothingToUpdateException extends RuntimeException {
    public NothingToUpdateException() {
        super("Nothing to update");
    }
}
