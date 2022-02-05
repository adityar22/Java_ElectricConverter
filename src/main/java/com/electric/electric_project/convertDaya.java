package com.electric.electric_project;

public class convertDaya {
    public double dayaconvert(double daya){
        double converted = 0;
        converted = 10*Math.log10(daya);
        return converted;
    }
}
