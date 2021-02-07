package ar.educacionit.tests;

import ar.educacionit.entities.Persona;
import java.util.ArrayList;
import java.util.List;

public class TestLists {

    public static void main(String[] args) {
        
        /* Vease documentacion: collections-hierarchy.png */               
        
        // +++++++ FRAMEWORK "COLLECTIONS" +++++++        
        /*
            1) Interface "List"
        
                > Representa una lista tipo vector con indices.
                > La longitud de List es dinamica. (Se reserva espacio en memoria segun se vayan añadiendo elementos).
                > A diferencia de los Set, permite elementos duplicados.
                > Permite el acceso posicional a elementos, y la busqueda de elementos.
        
                >> El metodo .add() añade un elemento a la Lista
                >> El metodo .remove() remueve un elemento de la Lista
                >> El metodo .get() devuelve un elemento de la lista
                >> etc
        
        IMPLEMENTACIONES:
            ArrayList
            LinkedList
            Vector
            Stack
        */
        
        
        /*        
            a) IMPLEMENTACION ArrayList
        
                > En condiciones normales es la implementacion mas performante de List.
        */
        
        List lista1;        
        lista1 = new ArrayList();
        
        lista1.add(new Persona("Pablo", "Storino", 24, "4141414141"));      // Indice 1
        lista1.add(new Persona("Luis", "Borges", 31, "333333333"));         // Indice 2
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
                a) Esta funcionalidad especifica el tipo de datos que iran dentro de la coleccion.
                ( Lo que vaya dentro de <> es el tipo de dato a utilizar )
                b) No se permitiran elementos que no sean de ese tipo.
        */
        
        // Ejemplo de una lista que solo contenga objetos de la clase Persona
        
        List<Persona> lista2 = new ArrayList();
        
        lista2.add(new Persona("Pablo", "Storino", 24, "4141414141"));
        lista2.add(new Persona("Jorge", "Borges", 55, "1010101010"));
        
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
        
        /*        
            a) IMPLEMENTACION LinkedList:
        
                > Generalmente es un poco mas lenta que ArrayList, pero puede funcionar mejor en ciertos casos.
                > Permite realizar inserciones y eliminaciones de elementos de forma mas performante.
                > Sin embargo el acceso a los elementos es siempre secuencial (de atras hacia adelante o viceversa), por lo que acceder a elementos que esten
                en el medio de la Lista conlleva un tiempo proporcional al tamaño de la lista.
                (Cuanto mas grande sea, mas lento el acceso sera).
                
        */
    }
}
