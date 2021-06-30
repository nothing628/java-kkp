package com.kkp.myapp.enums;

public enum KandidatStatus {
    MENUNGGU("MENUNGGU"),
    DITERIMA("DITERIMA"),
    DITOLAK("DITOLAK");
    
    private final String statusName;
    
    KandidatStatus(String statusName) {
        this.statusName = statusName;
    }
    
    public String getStatus() {
        return this.statusName;
    }
}
