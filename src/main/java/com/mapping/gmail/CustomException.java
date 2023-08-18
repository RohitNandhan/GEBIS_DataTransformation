package com.mapping.gmail;

public class CustomException extends Exception{

    CustomException(String message){
        super(message);
    }
     public class ParmaNotFoundException extends CustomException{
        ParmaNotFoundException(String message){
            super(message);
        }
      //  super(message);
    }


}


