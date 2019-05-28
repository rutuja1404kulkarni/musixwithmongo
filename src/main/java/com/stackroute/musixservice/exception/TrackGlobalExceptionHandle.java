package com.stackroute.musixservice.exception;

import com.stackroute.musixservice.responces.ResponseForError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TrackGlobalExceptionHandle extends Exception{


        @ExceptionHandler(value = {TrackAlreadyExistsException.class})
        public ResponseEntity<ResponseForError> globalTrackAlreadyExistsException(TrackAlreadyExistsException ex) throws Exception{
            ResponseForError responseForError = new ResponseForError();
            responseForError.setErrorId(HttpStatus.BAD_REQUEST.value());
            responseForError.setErrorMessage(ex.getMessage());
            return new ResponseEntity<>(responseForError,HttpStatus.BAD_REQUEST);
        }

        @ExceptionHandler(value = {TrackNotFoundException.class})
        public ResponseEntity<ResponseForError> globalTrackNotFoundException(TrackNotFoundException ex) throws Exception{
            ResponseForError responseForError = new ResponseForError();
            responseForError.setErrorId(HttpStatus.BAD_REQUEST.value());
            responseForError.setErrorMessage(ex.getMessage());
            return new ResponseEntity<>(responseForError,HttpStatus.BAD_REQUEST);
        }
    }

