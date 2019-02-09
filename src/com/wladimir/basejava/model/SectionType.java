package com.wladimir.basejava.model;

public enum SectionType {
    PERSONAL("Persönliche qulificationen"),
    OBJECTIVE("Position"),
    ACHIEVEMENT("Leistungen"),
    QUALIFICATIONS("Qualification"),
    EXPERIENCE("Erfahrung"),
    EDUCATION("Bildung");
    private String title;
    SectionType(String title){
        this.title = title;
    }
    public String getTitle(){
        return title;
    }
}
