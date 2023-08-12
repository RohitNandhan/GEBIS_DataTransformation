package com.mapping.gmail;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ExtractContentTest {
        ExtractContent extractContent=new ExtractContent();
    @org.junit.jupiter.api.Test
    void printOutput() throws IOException {

    }

    @org.junit.jupiter.api.Test
    void mapToJson() throws IOException {
        String input="1112";
        extractContent.mapToJson(input);
    }
}