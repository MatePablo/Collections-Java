package ar.educacionit.tests;

import ar.educacionit.entities.Persona;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class TestSet {
    public static void main(String[] args) {
        
        /* Vease documentacion: collections-hierarchy.png */
        
        /*
            2) Interface "Set"
                a) Representa una lista sin indices.
                b) El mismo objeto almacenado es el indice, lo cual implica que no puede haber objetos duplicados.
                
            
        IMPLEMENTACIONES:
            a) HashSet
            b) LinkedHashSet
            c) SortedSet
            d) TreeSet
        */
        
        Set<String> interfaceSet;
        
        /*
            a) HashSet
                > Almacena y recupera los elementos de la forma mas rapida posible.
                > No garantiza ningun orden en los elementos.
        */
        System.out.println("Implementacion HashSet: ");
        
        interfaceSet = new HashSet();
        
        interfaceSet.add("Lunes");
        interfaceSet.add("Martes");
        interfaceSet.add("Miercoles");
        interfaceSet.add("Jueves");
        interfaceSet.add("Viernes");
        
        //Imprimo para ver
        interfaceSet.forEach(System.out::println);
        
        
        /*
            b) LinkedHashSet
                > Almacena los elementos en una lista enlazada por orden de ingreso.
                > No es tan rapida como HashSet
        */
        System.out.println("\nImplementacion LinkedHashSet: ");
        
        interfaceSet = new LinkedHashSet();
        
        interfaceSet.add("Domingo");
        interfaceSet.add("Lunes");
        interfaceSet.add("Martes");
        interfaceSet.add("Miercoles");
        interfaceSet.add("Jueves");
        interfaceSet.add("Viernes");
        interfaceSet.add("Sabado");
        
        //Imprimo para ver
        interfaceSet.forEach(System.out::println);
        
        
        /*
            c) TreeSet
                > Almacena en un arbol por orden natural. (orden Alfabetico).
        */
        System.out.println("\nImplementacion de TreeSet");
        
        interfaceSet = new TreeSet();
        
        interfaceSet.add("Especial");
        interfaceSet.add("Azapan");
        interfaceSet.add("Cianuro");
        interfaceSet.add("Bife");
        interfaceSet.add("Ded");
        
        //Imprimo para ver
        interfaceSet.forEach(System.out::println);
        
        
        /*
            PROBLEMA CON OBJETOS EN TREESET debido al metodo compareTo():
        
        > La implementacion TreeSet ordena alfabeticamente los elementos mediante el metodo compareTo(), que hereda de la interfaz "Comparable".
        (La cual a su vez hereda de la clase String, ya que el metodo compareTo() es el mismo que se utiliza para ver si dos Strings son iguales)
        
        > El metodo compareTo() analiza dos elementos y devuelve un int, dependiendo de la situacion:
            a) Devuelve -1 si el elemento es menor.
            b) Devuelve 0 si ambos elementos son iguales.
            c) Devuelve 1 si el elemento es mayor.
        
        > El problema reside en que si le pasamos un objeto como argumento, no tiene idea de como hacer la comparacion. Y por ende va a tirar una Exception.
            a) Para resolver dicho problema, implementaremos la interfaz "Comparable" en la clase ( Persona ) y luego sobrescribiremos el metodo compareTo().
            b) En el metodo compareTo(), guardaremos en dos variables String los atributos de ambos objetos y los compararemos. De esa forma el metodo comparara dos
            cadenas String y ahi podra decidir cual es menor o mayor, segun esto retornara un int.
        */
        System.out.println("\nFixeo del problema de TreeSet con objetos:");
        Set personas = new TreeSet();
        
        personas.add(new Persona("Pablo", "Altamirano", 24, "39461254"));
        personas.add(new Persona("Anzio", "Copernico", 32, "132131235"));
        personas.add(new Persona("Beto", "Sofista", 15, "55728i56345"));
                
        // Imprimo el TreeSet para ver que pasa:    (Deberia tirar un exception si no arreglamos el compareTo() )
        personas.forEach(System.out::println);
        
    }
}
