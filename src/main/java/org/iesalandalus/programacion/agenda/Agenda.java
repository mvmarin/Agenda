/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.agenda;

import javax.naming.OperationNotSupportedException;

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
    /**
     * Aparcao
     * @param nuevoContacto 
     */
    public void añadir(Contacto nuevoContacto){   
    }
    /**
     * Definimos el método buscarIndiceCliente, introduciendo un array para comparar la posición en la que está el cliente o -1 si no lo encuentra.
     * @param nombreCliente
     * @return 
     */
    private int buscarIndiceCliente(String nombreCliente){
        if(nombreCliente !=null && !nombreCliente.isEmpty()){
            for(int indice= 0; indice < numContactos; indice++){    
                Contacto contactoTmp = contactos[indice];
                if(nombreCliente.equals(contactoTmp.getNombre())){
                    return indice;
                }
            }
        }
        return -1;
    }   
    /**
     * Definimos el método buscar, donde recorremos por el arrays buscando el nombreCliente. En caso de no estar, devolvería la posición -1.
     * @param nombreCliente
     * @return 
     * @throws javax.naming.OperationNotSupportedException 
     */
    public Contacto buscar(String nombreCliente) throws OperationNotSupportedException{
        int posicion = buscarIndiceCliente(nombreCliente);
        if(posicion == -1){
            throw new OperationNotSupportedException("El nombre introducido no se encuentra en la Agenda");
        }else{
            return contactos[posicion];
        }
    }
}
