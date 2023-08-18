package com.mapping.gmail.Refoctored.Bean;

import java.util.List;

public class SupplierContactsExcel extends ParmaExcel implements Comparable<ParmaExcel>{
    private String role;

    SupplierContactsExcel(){
        super();
    }
    public SupplierContactsExcel(Integer parmaID, String parmaname, List<String> emailID, String role) {
        super(parmaID, parmaname, emailID);
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "SupplierContactsExcel{" +
                "role='" + role + '\'' +
                "} " + super.toString();
    }
}
