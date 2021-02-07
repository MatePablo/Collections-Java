package ar.educacionit.tests;

import java.util.ArrayDeque;
import java.util.Stack;

public class TestStackQueue {
    public static void main(String[] args) {
        
        /* Vease documentacion: pila.png, cola.png, collection-hierarchy.png */
              
        
        /*
            1) CLASE Stack (Pila):
                > Utiliza el modelo LIFO. (Last In, First Out)
                  (El ultimo en entrar es el primero en salir)
        
        METODOS:
            .push(e)    : Añade un elemento a la pila a la ultima posicion.
            .pop()      : Desapila el ultimo elemento.
        */        
        
        System.out.println("\tStack | Pilas:");
        
        Stack <String> pilaPlatos = new Stack();
        
        pilaPlatos.add("Plato 1");
        pilaPlatos.add("Plato 2");
        
        // Utilizando el metodo .push()
        pilaPlatos.push("Plato 3 (push)");
        
        // Lo imprimo para ver:
        System.out.println("\na) Metodo .push()");       
        pilaPlatos.forEach(System.out::println);

        // Longitud de la pila
        System.out.println("Longitud de la pila: "+pilaPlatos.size());
        
        
        // Metodo .pop()    | Desapila un elemento
        System.out.println("\nb) Metodo .pop()");
        while(!pilaPlatos.isEmpty()){
            System.out.println(pilaPlatos.pop());
        }
        
        // Imprimo la longitud de la pila para comprobar que se desapilo
        System.out.println("Longitud de la pila: "+pilaPlatos.size());
       
        
        
        /*
            2) INTERFAZ Queue (Cola):
                > Utiliza el modelo FIFO. (First In, First Out)
                  (El primero en entrar es el primero en salir)

        METODOS:
        .offer()    :   Encola el elemento.
        .poll()     :   Descola un elemento.
        */    
        System.out.println("--------------------");
        System.out.println("\tQueues / Colas: \n");
        
        ArrayDeque<String> colaAutos = new ArrayDeque();
        
        colaAutos.add("Auto 1");
        colaAutos.add("Auto 2");
        
        // Metodo .offer()  :   Encola un nuevo elemento
        colaAutos.offer("Auto 3 .offer()");
        System.out.println("Metodo .offer()");
        colaAutos.forEach(System.out::println);
        System.out.println("Longitud de cola: "+colaAutos.size());
        
        // Metodo .poll()   :   Deseconla un elemento
        System.out.println("\nMetodo .poll()");
        while (!colaAutos.isEmpty()) {
            System.out.println(colaAutos.poll());
        }
        System.out.println("Longitud de cola: "+colaAutos.size());
    }
}
