/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.agenda;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


 /**
 *
 * @author victoriamarin
 */

public class Contacto {
    /**
     * Hemos añadido el atributo nombre a la clase contacto.
     */
    private String nombre;
    
    /**
     * Hemos añadido el atributo teléfono a la clase contacto.
     */
    private String telefono;
    
    /**
     * Hemos añadido el atributo correo a la clase contacto.
     */
    private String correo;
    
    /**
     * Expresión regular con la que validamos un teléfono.
     */
    private static final String ER_TELEFONO ="^[96]{1}[0-9]{8}$";
    /**
     * Expresión regular con la que validamos un correo.
     */
    private static final String ER_CORREO ="^[\\\\w-]+(\\\\.[\\\\w-]+)*@[A-Za-z0-9]+(\\\\.[A-Za-z0-9]+)*(\\\\.[A-Za-z]{2,})$";
    
    /**
     * Creamos el constructor Contacto, llamando a los tres métodos set.
     * @param nombreValor
     * @param telefonoValor
     * @param correoValor 
     */
    public Contacto(String nombreValor, String telefonoValor, String correoValor){
        setNombre(nombreValor);
        setTelefono(telefonoValor);
        setCorreo(correoValor);
    }
    /**
     * Definimos el método setNombre, introduciendo las excepciones en caso de estar vacio o modificar.
     * @param nombreValor 
     */
    private void setNombre(String nombreValor){
       if(nombre != null && !nombre.isEmpty()){
          throw new IllegalArgumentException("No se puede modificar el nombre de un contacto existente");
       }else{
           if(nombreValor == null || nombreValor.isEmpty()){
               throw new IllegalArgumentException("El nombre de un contacto no puede ser nulo o vacio"); 
           }else{
               nombre = nombreValor;
           }
       }
    }
    /**
     * Definimos el método getNombre, finalizando con un return para devolvernos el Nombre.
     * @return 
     */
    public String getNombre(){
      if(nombre==null) {
          return "";
      }
      return nombre;  
    }
    /**
     * Definimos el método setTelefono controlando las excepciones en caso de ser nulo.
     * @param telefonoValor 
     */
    public void setTelefono(String telefonoValor){
        if(telefonoValor !=null){
           Pattern patron;
           patron = Pattern.compile(ER_TELEFONO);
           Matcher comparador;
           comparador = patron.matcher(telefonoValor);
           if(comparador.matches()){
               telefono = telefonoValor;
           }else{
               throw new IllegalArgumentException("El teléfono de un contacto no puede ser nulo y debe contener 9 dígitos y empezar por 6 ó 9");
           }
           
        }else{
            throw new IllegalArgumentException("El teléfono de un contacto no puede ser nulo y debe contener 9 dígitos y empezar por 6 ó 9");
        }
    }
    /**
     * Definimos el método getTelefono, finalizando con un return para devolvernos el valor del Telefono.
     * @return 
     */
    public String getTelefono(){
        if(telefono == null){
            return "";
        }
        return telefono;
    }
    /**
     * Definimos el método setCorreo controlando las excepciones de las expresion regular.
     * @param correoValor 
     */
    public void setCorreo(String correoValor){
        if(correoValor !=null){
            Pattern patron;
            patron = Pattern.compile(ER_CORREO);
            Matcher comparador;
            comparador = patron.matcher(correoValor);
            if(comparador.matches()){
                correo = correoValor;
            }else{
                throw new IllegalArgumentException("EL correo de un contacto debe ser válido");
            }
        }else{
            throw new IllegalArgumentException("El correo de un contacto debe ser válido");
        }
    }
    /**
     * Definimos el método getCorreo finalizando con un return para devolver el valor correo.
     * @return 
     */
    public String getCorreo(){
        if(correo == null){
            return "";
        }
        return correo;
    }
    /**
     * Definimos el método get para obtener las iniciales de un nombre.
     * @return 
     */
    private String getIniciales(){
        if(nombre == null || nombre.isEmpty()){
            return "";
        }
        String iniciales = "";
        String palabras[] = nombre.split(" ");
        for (int i = 0; i < palabras.length; i++) {
            String palabra = palabras[i];
            iniciales = iniciales + palabra.charAt(0);
        }
        return iniciales.toUpperCase();
    }
    /**
     * Definimos el método toString para obtener las iniciales, el teléfono y el correo del contacto.
     * @return 
     */
    @Override
    public String toString(){
        return "Las iniciales son : " + getIniciales() + "{"+getTelefono()+ "," +getCorreo()+"}";
    }
    /**
     * Definimos el método equals para comparar dos objetos contacto.
     * @param obj
     * @return 
     */
    @Override
    public boolean equals(Object obj){
        if(obj instanceof Contacto){
            Contacto tmp = (Contacto) obj;
            if(nombre.equalsIgnoreCase(tmp.getNombre())){
                return true;
            }
            
        }
        return false;
    }
    /**
     * Definimos el método hashCode para generar el hashCode de la clase.
     * @return 
     */
    public int hashCode(){
        int prime = 31;
        int result = 1;
        result = prime * result + (((nombre == null) ? 0 : nombre.hashCode())
                +((telefono == null) ? 0 : telefono.hashCode()))
                +((correo == null) ? 0 : correo.hashCode());
        return result;
    }

}


    
