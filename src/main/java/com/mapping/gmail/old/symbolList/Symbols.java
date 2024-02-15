package com.mapping.gmail.old.symbolList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Symbols {

    private String symbol;
    private String name;

    public Symbols(String symbol, String name) {
        this.symbol = symbol;
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Symbols{" +
                "symbol='" + symbol + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
