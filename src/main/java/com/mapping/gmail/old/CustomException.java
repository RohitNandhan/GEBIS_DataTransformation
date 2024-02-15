package com.mapping.gmail.old;

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


