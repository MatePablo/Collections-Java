package ar.educacionit.entities;

import java.util.Objects;

/*
    Implemento la interfaz Comparable, vease TestSet, en la parte de TreeSet.

    Luego sobreescribo el metodo compareTo()
*/

public class Persona implements Comparable<Persona>{
    
    private String nombre;
    private String apellido;
    private int edad;
    private String dni;

    public Persona(String nombre, String apellido, int edad, String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", dni=" + dni + '}';
    }
    
    
    /*
        a) Lo que hago es basicamente guardar como cadena de caracteres los estados de los objetos en dos variables String.
    
        b) Luego comparo ambas cadenas utilizando el metodo compareToIgnoreCase(), y segun el retorno, se si la cadena a comparar es menor, igual o mayor.
        (
        -1: Menor
        0: Igual
        1: Mayor
        )
    
        > En este caso estoy priorizando el nombre, pero si quisiera ordenar por apellido, solo tendria que cambiar el orden de los atributos y ya.
    */
    
    @Override
    public int compareTo(Persona per) {
        
        String persona1 = this.nombre + "," + this.apellido + "," + this.edad + "," + this.dni;
        String persona2 = per.getNombre() + "," + per.getApellido() + "," + per.getEdad() + "," + per.getDni();
        
        return persona1.compareToIgnoreCase(persona2);
        
        /*
        Si quisiera ordenarla en orden inverso, solo tendria que multiplicar el retorno *-1
            ej: return persona1.compareToIgnoreCase(persona2)*-1
        */
    }

    
    /*
        Al implementar el metodo hashCode() y equals() soluciono el problema de elementos duplicados en una tabla HashSet.
        Sin embargo, el codigo insertado es bastante grande. Si bien sirve y soluciona el problema, podemos escribir nuestro propio codigo mas compacto
        y facil de leer.
    
    */
    
    /*
        1) Sobreescribiendo hashCode():
    
            a) El metodo hashCode() por default produce un numero al azar mediante una cuenta arbitraria segun el estado del objeto. SIRVE. Pero es dificil de leer.
    
            b) Dos objetos con el mismo estado producen el mismo toString(). Por lo que ambos toString() tendran el mismo HashCode.
                
            c) En el metodo hashCode() sencillamente retorna un HashCode del toString() del objeto. Dos objetos con los mismos estados tienen el mismo toString(), por lo que
            tendran el mismo HashCode y seran considerados el mismo objeto.
    
            (Dos Strings con estados iguales son consideradas el mismo objeto, tienen el mismo hashcode, sensillamente paso el estado del objeto a un String. Si dos objetos
            tienen el mismo estado tendran el mismo String)
    */
    @Override
    public int hashCode() {
        return toString().hashCode();
    }
    
    
    /*
        2) Sobreescribiendo metodo equals:
    
            a) Aqui sensillamente comparo el hashcode del primer objeto, con el hashcode del segundo para ver si son iguales o distintos.
            (True = Iguales, False = Distintos)
    
            b) Agrego un IF que filtra los datos. Si el objeto recibido no es de tipo Persona, retorna Falso siempre.
    */

    @Override
    public boolean equals(Object obj) {
        
        if( !(obj instanceof Persona) ) return false;
        
        return toString().hashCode() == obj.hashCode();
    }

    
  
    
}
