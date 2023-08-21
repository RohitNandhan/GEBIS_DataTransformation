package com.mapping.gmail.Refoctored.ExceptionHandling;

import java.io.IOException;

public class FolderPresentException extends IOException {
    public FolderPresentException(String m){
        super(m);
    }

}
