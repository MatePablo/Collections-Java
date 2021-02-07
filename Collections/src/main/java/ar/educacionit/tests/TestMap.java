package ar.educacionit.tests;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class TestMap {
    public static void main(String[] args) {
        
        /* Vease documentacion: collections-hierarchy.png
                                map-in-java.png
        */
        
        /*
            INTERFACES Map        
            > Representa un vector asociativo / diccionario.
            > Las llaves no pueden repetirse.
            > Pero si puede haber un elemento repetido.
        
        IMPLEMENTACIONES:
        HashMap
        HashTable   :   OBSOLETA, ES IGUAL A HASHMAP
        LinkedHashMap
        TreeMap        
        */
        
        //Map<llave, valor> identificador;
        Map<String, String> map;
        
        /*
            1) IMPLEMENTACION HashMap:
                > Es la implementacion mas veloz.
                > No garantiza orden de los elementos en la lista.
        */
        
        map = new HashMap();
        
        // Metodo .put()    -   Agrega un elemento con su llave.
        map.put("lu", "Lunes");
        map.put("ma", "Martes");
        map.put("mi", "Miercoles");
        map.put("ju", "Jueves");
        map.put("vi", "Viernes");
        map.put("sa", "Sabado");
        map.put("do", "Domingo");
        
        // Imprimo el map. (No puedo utilizar el forEach implicito / abreviado)
        System.out.println("\tHashMap:");
        map.forEach((llave,valor) -> System.out.println(llave + " - " + valor));
        
        // Utilizando la llave para imprimir el elemento con metodo .get():  
        System.out.println("\nUtilizando llave para imprimir elemento asociado con metodo .get():");
        System.out.println("Llave \"vi\": "+map.get("vi"));
        
        /*
            2) IMPLEMENTACION LinkedHashMap:
                > Almacena elementos en una lista enlazada por orden de ingreso.
        */        
        map = new LinkedHashMap();
        map.put("lu", "Lunes");
        map.put("ma", "Martes");
        map.put("mi", "Miercoles");
        map.put("ju", "Jueves");
        map.put("vi", "Viernes");
        map.put("sa", "Sabado");
        map.put("do", "Domingo");
        
        // Imprimo:
        System.out.println("\t\nImplementacion LinkedHashMap:");        
        map.forEach((k,v) -> {System.out.println("Llave: "+k+" |Valor: "+v);});
        
        
        /*
            3) IMPLEMENTACION TreeMap:
                > Almacena en un arbol por orden natural DE CLAVES.
                > Ordena los elementos por orden natural (alfabeticamente)
                > Al igual que con TreeSet, la clase de la llave debe implementar la interfaz "Comparable".
        */        
        map = new TreeMap();
        map.put("lu", "Lunes");
        map.put("ma", "Martes");
        map.put("mi", "Miercoles");
        map.put("ju", "Jueves");
        map.put("vi", "Viernes");
        map.put("sa", "Sabado");
        map.put("do", "Domingo");
        
                // Imprimo:
        System.out.println("\t\nImplementacion TreeMap:");        
        map.forEach((k,v) -> {System.out.println("Llave: "+k+" |Valor: "+v);});
    }
}
