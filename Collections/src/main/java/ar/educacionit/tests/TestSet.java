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
            a) IMPLEMENTACION HashSet
                > Almacena y recupera los elementos de la forma mas rapida posible.
                > No garantiza ningun orden en los elementos.
                > Es la implementacion mas rapida de la interfaz set.
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

            HASHCODES, Y OBJETOS DUPLICADOS EN UNA TABLA HASHSET:
        
            1) Un HashCode es un codigo de 32 bits que Java utiliza para identificar a los objetos. Todos los objetos heredan el metodo .hashCode()
            que permite recuperar el HashCode asignado de la clase java.lang.Object. Los Hash son importantes para las tablas Hash y otras estructuras de datos
            que agrupan objetos en base al calculo de su HashCode.
        
            2) Dos Strings iguales tendran el mismo HashCode, por lo que seran consideradas el mismo objeto segun Java. Sin embargo, en una tabla HashSet, dos instancias
            de una clase con los mismos estados tendran HashCodes diferentes.
        
            Es decir: Dos Personas con el mismo nombre y dni seran consideradas dos objetos distintos. Lo cual es un problema ya que dentro de las HashSet no debe haber
            datos duplicados.
        
            3) Para solucionar esto se deben sobreescribir los metodos .equals() y .toHashCode() dentro de la clase. Para indicarle al programa que si dos objetos tienen
            el mismo estado, deben tener el mismo HashCode, es decir, ser considerados un unico objeto.
        
        */
        
        System.out.println("\nProblema de elementos duplicados en HashSet:");
        
        Set<Persona> setPrueba = new HashSet();
        
        setPrueba.add(new Persona("Pablo", "Altamirano", 18, "39461254"));
        setPrueba.add(new Persona("Pablo", "Altamirano", 18, "39461254"));
        
        // Lo imprimo para ver. Si no sobreescribo el metodo .equals() de la clase, ambos objetos deberian tener distinto HashCode
        setPrueba.forEach(a->System.out.println(a+"\t | HashCode:"+a.hashCode()));
        
        /*
            b) IMPLEMENTACION LinkedHashSet
                > Es una tabla HashSet con una LinkedList corriendo sobre esta.
                > Ordena los elementos en base al orden en el cual fueron insertados.
                > No es tan rapida como una tabla HashSet
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
            c) IMPLEMENTACION TreeSet
                > Es un poco mas lenta que HashSet.
                > Almacena sus elementos en una estructura de arbol rojo-negro.
                > Ordena los elementos en base a sus valores.   (De forma natural / Alfabeticamente)
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
