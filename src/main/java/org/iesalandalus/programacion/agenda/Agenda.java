/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.agenda;

/**
 *
 * @author victoriamarin
 */
public class Agenda {
    /**
     * Hemos añadido el atributo numContactos a la clase Agenda.
     */
    private int numContactos;
    
    /**
     * Hemos añadido el atributo MAX_CONTACTO a la clase Agenda.
     */
    private static final int MAX_CONTACTOS = 10;
    
    /**
     * Definimos el array de Contactos
     */
    private Contacto contactos[];
    
    /**
     * Definimos el método get de Contactos llamando al array Contacto.
     * @return 
     */
    public Contacto[] getContactos(){
        return contactos;
    }
    /**
     * Definimos el método get de numContactos.
     * @return 
     */
    public int getNumContactos(){
        return numContactos;
    }
}
