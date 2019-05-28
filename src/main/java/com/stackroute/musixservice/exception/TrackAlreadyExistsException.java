package com.stackroute.musixservice.exception;

public class TrackAlreadyExistsException extends Exception
{
    private String message;

    public TrackAlreadyExistsException(){}
    public TrackAlreadyExistsException(String message) {
        this.message = message;
    }


    @Override
    public String getMessage() {
        return message;
    }
}
