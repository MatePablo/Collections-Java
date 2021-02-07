package ar.educacionit.tests;

import ar.educacionit.entities.Persona;
import java.util.ArrayList;
import java.util.List;

public class ApiStream {

    public static void main(String[] args) {
        
        List<Persona> personas = new ArrayList();
        
        personas.add(new Persona("Pablo", "Storino", 24, "31313131311"));
        personas.add(new Persona("Jorge", "Borges", 30, "42131231231"));
        personas.add(new Persona("Marito", "Baracus", 30, "1111111111"));
        
        
        //Api Stream
        
        // SELECT * FROM personas
        personas.stream().forEach(System.out::println);
        
        
        //SELECT * FROM personas WHERE edad = 30;        
        // Sin un api stream:
        System.out.println("\nSin api stream:");
        
        for(Persona p:personas){
            if(p.getEdad()==30){
                System.out.println(p);
            }
        }
        
        // Con api stream:
        System.out.println("\nCon api stream:");
                
        // El elemento filter crea una variable por cada elemento de la lista. Y luego evalua una expresion booleana, los elementos que den True seran filtrados a la nueva lista.
        // .filter ( variable -> expresion booleana)
        personas.stream()
                .filter(p -> p.getEdad() == 30)
                .forEach(System.out::println);
        
        
        
    }

}
