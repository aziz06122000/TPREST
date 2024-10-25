
package com.example.car.rental;
public class Dates {
    private String begin;
    private String end;

    // Constructeur
    public Dates(String begin, String end) {
        this.begin = begin;
        this.end = end;
    }

    // Getter pour 'begin'
    public String getBegin() {
        return begin;
    }

    // Getter pour 'end'
    public String getEnd() {
        return end;
    }

    // Setters (si besoin)
    public void setBegin(String begin) {
        this.begin = begin;
    }

    public void setEnd(String end) {
        this.end = end;
    }
}
