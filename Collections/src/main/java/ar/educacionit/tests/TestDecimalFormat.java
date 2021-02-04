package ar.educacionit.tests;

import java.text.DecimalFormat;

public class TestDecimalFormat {
    public static void main(String[] args) {
        
        /*
            DecimalFormat sirve para darle formato a numeros.
        */
        
        int edad1 = 9;
        int edad2 = 43;
        float precio = 1000000;
        
        DecimalFormat ed = new DecimalFormat("000");        
        DecimalFormat pre = new DecimalFormat("###,###,###.00"); 
        
        System.out.println("Edad 1: "+ed.format(edad1));
        System.out.println("Edad 2: "+ed.format(edad2));
        System.out.println("Precio: "+pre.format(precio));
    }
}
