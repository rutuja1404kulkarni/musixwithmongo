package com.stackroute.musixservice.exception;

public class TrackNotFoundException extends Exception
{
    private String message;

    public TrackNotFoundException(){}

    public TrackNotFoundException(String message)
    {
        super(message);
        this.message=message;
    }


    @Override
    public String getMessage() {
        return message;
    }
}
