package com.electric.electric_project;

public class convertTegangan {
    public double teganganCvt(double volt){
        double voltage = 0;
        voltage = 10*Math.log10(Math.pow(volt, 2));
        return voltage;
    }
}
