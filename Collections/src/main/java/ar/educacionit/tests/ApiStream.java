package ar.educacionit.tests;

import ar.educacionit.entities.Persona;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ApiStream {

    public static void main(String[] args) {
        
        /*
        
            Vease documentacion: Parte 09 - Collections y Generics.pdf
        
        */
        
        
        /*
            Api Stream:
        
            > La interfaz Stream representa una secuencia de elementos generica, es decir, del tipo de elementos que querramos.
        
        
        Tabla de "equivalencias" entre SQL y Stream:
        
            SQL         |           Stream
        --------------------------------------------
        FROM            |   stream()
        SELECT          |   map()
        WHERE           |   filter()
        ORDER BY        |   sorted()
        
        */
        
        
        //SELECT nombre FROM personas;

        //Creo la lista
        List<Persona> listaPersona = List.of(
            new Persona("Pablo", "Storino", 24, "45454545"),
            new Persona("Luis", "Pachionny", 31, "411111111"),
            new Persona("Mariano", "Borges", 19, "8212341543"),
            new Persona("Kevin", "Ramirez", 45, "214132561234")
        );
        
        // La recorro en forma extensa
        System.out.println("Forma extensa:");
        Stream<String> stream = listaPersona.stream().map(p -> p.getNombre());
        stream.forEach( p -> System.out.println(p) );
        
        // Forma verbosa / abreviada
        System.out.println("\nForma abreviada:");
        listaPersona
                .stream()
                .map(p -> p.getNombre())
                .forEach(p -> System.out.println(p));
        
        // Con el metodo .stream() obtenemos una secuencia de elementos del tipo Persona. Este es el "FROM".
        // Con el metodo .map() recuperamos solo el atributo "nombre". Este seria nuestro "SELECT".
        // El punto clave es obtener un Stream mediante el metodo stream() y a partir de ahi ejecutar las acciones como filtrados, agrupaciones etc
        
        
        // FILTRADO:
        
        // SELECT nombre FROM personas WHERE edad < 30
        System.out.println("Lista de nombres de personas con edad menor a 30: ");
        listaPersona
                .stream()
                .filter(p -> p.getEdad() < 30)
                .map(p -> p.getNombre())
                .forEach(p -> System.out.println(p));
                
        
    }

}
