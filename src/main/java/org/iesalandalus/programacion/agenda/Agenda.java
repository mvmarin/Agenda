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
     * Comprobamos que el número de contactos actual no es igual al máximo para poder introducir uno nuevol se controlan las excepciones tanto de max contactos, repetición de contactp y contacto no válido
     * @param nuevoContacto
     * @return
     * @throws OperationNotSupportedException 
     */
    private int buscarPrimerIndiceComprobandoExistencia(Contacto nuevoContacto) throws OperationNotSupportedException{
        if(nuevoContacto != null){
            if(numContactos == MAX_CONTACTOS){
                throw new OperationNotSupportedException("La Agenda está completa");
            }
            for(int indice = 0; indice < numContactos; indice++){
                
                if(contactos[indice] == null){
                    return indice;
                }
                if(contactos[indice].equals(nuevoContacto)){
                    throw new OperationNotSupportedException("El contacto está repetido");
                }
            }
        }else{
            throw new OperationNotSupportedException("El nuevo contacto no es válido");
        }
        return -1;
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
                if(nombreCliente.equalsIgnoreCase(contactoTmp.getNombre())){
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
    /**
     * Definimos el método desplazarUnaPosicionHaciaLaIzquierda para comprobar que no supera el tamaño
     * @param contactoEliminado 
     */
    private void desplazarUnaPosicionHaciaLaIzquierda(int contactoEliminado) throws OperationNotSupportedException{
        if(!indiceNoSuperaTamano(contactoEliminado)){
            throw new OperationNotSupportedException("El contacto eliminado introducido no es correcto");
        }
        int posicionBorrar = -1;
        for(int indice = contactoEliminado; indice < numContactos; indice++){
            int posicionSiguiente = indice+1;
            if(indiceNoSuperaTamano(posicionSiguiente)){
               if(contactos[posicionSiguiente] != null){
                  contactos[indice] = contactos[posicionSiguiente];
                  posicionBorrar = posicionSiguiente;
               }else{
                   break;
               }
            }else{
                break;
            }
        }
        if(posicionBorrar!=-1) {
            contactos[posicionBorrar] = null;
        }
    }
    /**
     * Declaramos el método indice no supera el tamaño para indicar que si no supera el max_contactos entra por el bucle.
     * @param indice
     * @return 
     */
    private boolean indiceNoSuperaTamano(int indice){
        if((indice < MAX_CONTACTOS) && (indice >= 0)){
            return true;
        }
        return false;
    }
    /**
     * Definimos el método borrar, y llamamos al método deplazarUnaPosicionHaciaLaIzquierda.
     * @param nombreBorrar 
     */
    public void borrar(String nombreBorrar) throws OperationNotSupportedException{
        int posicion = buscarIndiceCliente(nombreBorrar);
        if (posicion == -1){
            throw new OperationNotSupportedException("No hay ningun contacto en la Agenda con ese nombre");
        }
        desplazarUnaPosicionHaciaLaIzquierda(posicion);
        numContactos--;
    }
}
