package ar.educacionit.tests;

import ar.educacionit.entities.Persona;
import java.util.ArrayList;
import java.util.List;

public class TestLists {

    public static void main(String[] args) {
        
        /* Vease documentacion: collections-hierarchy.png */        
        
        /*
        1) Vectores:
            La longitud de los vectores / arrays es estatica, es decir, no puede variar. Tengo que primero indicar el espacio en memoria a utilizar y es estatico.
        
        2) Listas:
            Las listas, de la clase List, del framework Collection, son dinamicas. A medida que se agregan elementos se va reservando espacio en memoria.
        */
        
        // 1) Ejemplo de vector:
        
        Persona[] pv = new Persona[4];
        
        pv[0] = new Persona("Pablo", "Altamirano", 24, "39461254");
        pv[1] = new Persona("Claudio", "Altamirano", 61, "111111111");
        pv[2] = new Persona("Silvia", "Storino", 55, "2222222222");
        pv[3] = new Persona("Violeta", "Altamirano", 30, "3333333333");
        
        //  a)  Recorriendo el vector por medio de indices  
        System.out.println("Recorriendo mi vector con indices");
        for(int i=0; i<pv.length; i++){
            System.out.println(pv[i]);
        }
        
        //  b)   Recorriendo el vector con la estructura forEach (no es una palabra reservada del lenguaje)
        System.out.println("");
        System.out.println("Recorriendo mi vector con la estructura forEach");
        for(Persona i:pv){
            System.out.println(i);
        }
        
        
        // +++++++ FRAMEWORK "COLLECTIONS" +++++++        
        /*
            a) Interface "List"
        
                > Representa una lista tipo vector con indices.
                > La longitud de List es dinamica. (Se reserva espacio en memoria segun se vayan añadiendo elementos).
        
                >> El metodo .add() añade un elemento a la Lista
                >> El metodo .remove() remueve un elemento de la Lista
                >> El metodo .get() devuelve un elemento de la lista
        
        IMPLEMENTACIONES:
            ArrayList
            LinkedList
            Vector
            Stack
        */
        
        List lista1;        
        lista1 = new ArrayList();
        
        lista1.add(new Persona("Pablo", "Altamirano", 24, "39461254"));     // Indice 1
        lista1.add(new Persona("Violeta", "Altamirano", 31, "333333333"));  // Indice 2
        lista1.add("Glaciar Pepito Moreno");                                // Indice 3
        lista1.add(34);                                                     // Indice 4
        
        // Metodo .add( indice{opcional}, elemento )
        lista1.add(0,"Pepe Argento");
        lista1.add("La Pampa");
        
        // Metodo .remove( elemento/indice )
        lista1.remove("La Pampa");
                
        /*
            Recorriendo una List:
        
                1) No recomendado:
                    a) Con un for de indices.
                    > for(int i=0; i<lista.length; i++) sout
        
                    b) Con un forEach
                    > for(Persona i:pv) sout
        
                2) Recomendado:
                    a) Con el metodo default .forEach()
                    > lista.forEach( objeto -> { acciones } )
        */
        
        // Ejemplo de recorrido de una List con el metodo default .forEach()
        System.out.println("");
        System.out.println("Recorriendo mi lista con un .forEach()");
        
        lista1.forEach(o -> {
            System.out.println(o); 
        });
        
        // Tambien se puede usar el metodo de forma IMPLICITA:
        System.out.println("");
        System.out.println("Recorriendo mi lista con un .forEach() implicito");
        
        lista1.forEach(System.out::println);
        
        /*
            Uso de Generics <>:
                a) Lo que va dentro del <> es el tipo de dato.
                b) No se permitiran elementos que no sean de ese tipo.
                c) Pueden ser tipos primitivos, objetos de una clase, etc.
        */
        
        // Ejemplo de una lista que solo contenga objetos de la clase Persona
        
        List<Persona> lista2 = new ArrayList();
        
        lista2.add(new Persona("Pablo", "Altamirano", 24, "39461254"));
        lista2.add(new Persona("Silvia", "Storino", 55, "1010101010"));
        
        // Metodo .get( indice )
        
        Persona pablo = ( Persona ) lista1.get(1); // Tengo que castearlo ya que lista1 es de tipo Object
        Persona silvia = lista2.get(1); // No hace falta castearlo, ya que lista2 es de tipo Persona
    
        
        /*
            Copiando de una lista a otra:
        
        a) Metodo 1:        (Mejor que b)        
            lista1.forEach( o -> {
                    lista2.add(o)
            })
        
        b) Metodo 2:        
            for( Object o:lista1 ){
                lista2.add(o);
            }
        
        c) Metodo 3:        (El mas facil)        
            lista2.getAll(lista1);
        
        d) Metodo 4:        
            lista1.forEach(lista2::add);
        */
        
        // Ejemplo de copiando de una lista a otra.
        // > Utilizo un if para preguntar si el objeto de list1 es de tipo persona, y si lo es, lo casteo para añadirlo a list 2
        
        lista1.forEach( o -> {
            if( o instanceof Persona) lista2.add( ( Persona ) o);
        });
        
        System.out.println("");
        System.out.println("Recorriendo la lista 2 luego de copiar:");
        
        lista2.forEach(System.out::println);
    }
}
