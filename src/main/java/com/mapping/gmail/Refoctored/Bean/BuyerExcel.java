package com.mapping.gmail.Refoctored.Bean;

import java.util.List;

//Bean Class for BuyerExcel Sheet
public class BuyerExcel extends ParmaExcel implements Comparable<ParmaExcel>{
    String buyerEmailID;

    public BuyerExcel(String buyerEmailID) {
        this.buyerEmailID = buyerEmailID;
    }

    public BuyerExcel(Integer parmaID, String parmaname, List<String> emailID, String buyerEmailID) {
        super(parmaID, parmaname, emailID);
        this.buyerEmailID = buyerEmailID;
    }

    public String getBuyerEmailID() {
        return buyerEmailID;
    }

    public void setBuyerEmailID(String buyerEmailID) {
        this.buyerEmailID = buyerEmailID;
    }

    @Override
    public String toString() {
        return "BuyerExcel{" +
                "buyerEmailID='" + buyerEmailID + '\'' +
                '}';
    }
}
