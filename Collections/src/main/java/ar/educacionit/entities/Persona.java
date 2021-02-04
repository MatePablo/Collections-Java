package ar.educacionit.entities;

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
        a) Lo que estoy haciendo es basicamente guardar todos los atributos del primer objeto en una variable String como cadena de caracteres.
          Y todos los atributos del objeto que viene como parametro en otra variable String.
    
        b) Luego utilizo el propio metodo compareTo() para comparar ambas variables y fijarme cual es mayor o menos. Segun el int que retorne.
    
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
    
}
