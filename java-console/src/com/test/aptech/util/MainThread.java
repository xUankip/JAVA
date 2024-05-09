package com.test.aptech.util;

public class MainThread {
    public static void main(String[] args) {
        ConverterHelper converterHelper = new ConverterHelper();
        float f = 80;
        float i = 111;
        System.out.println("Convert F to C");
        float c = converterHelper.convertFtoC(f);
        System.out.println(c);
        float m = converterHelper.convertInchtoM(i);
        System.out.println(m);

    }
}