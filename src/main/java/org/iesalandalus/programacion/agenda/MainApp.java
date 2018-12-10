package org.iesalandalus.programacion.agenda;

import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.utilidades.Entrada;

public class MainApp {
    private static Agenda agendaPrueba;

    private static void buscarContacto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void borrarContacto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void listarContacto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *Hemos declarado las funciones del menú y lo mostramos en pantalla.
     */
    private static void mostrarMenu(){
        System.out.println("1- Añadir un contacto");
        System.out.println("2- Buscar un contacto");
        System.out.println("3- Borrar un contacto");
        System.out.println("4- Listar todos los contactos nulos");
        System.out.println("5- Salir");
    }
        
    /**
     * Imprimimos por pantalla que se elija la opción deseada, y cuando cumpla la condición devuelve el valor de opcion
     * @return devuelve la opción
     */
    private static int elegirOpcion(){
        int opcion;
        do{
            System.out.println("Elija la opción deseada mostrada en pantalla: ");
            opcion=Entrada.entero();   
        }while (opcion<1 || opcion>5);
        return opcion;
        
    }
    /**
     * Definimos las opciones posible para ejecutar
     * @param opcion 
     */
    private static void ejecutarOpcion(int opcion){
        switch (opcion){
            case 1: añadirContacto();
                break;
            case 2: buscarContacto();
                break;
            case 3: borrarContacto();
                break;
            case 4: listarContacto();
                break;    
        }
        if(agendaPrueba!=null){
           System.out.println("Estado actual de la Agenda: "+ agendaPrueba.toString()); 
        } 
    }
    /**
     * Con este método creamos la Agenda por defecto
     */
    private static void añadirContacto(){
        agendaPrueba = new Agenda();
 

    }
    public static void main(String[] args) {
        System.out.println("Programa para buscar contacto en una Agenda");
        int opcion;
        do{   
            mostrarMenu();
            opcion = elegirOpcion();
            ejecutarOpcion(opcion);
	}while(opcion!=5);
        
        System.out.println("Fin de la ejecución y Gracias por participar");
                
    }
    public static void main(String[] args) {
        System.out.println("Programa para gestionar una agenda de contactos");
        int opcion;
        do{   
            mostrarMenu();
            opcion = elegirOpcion();
            ejecutarOpcion(opcion);
	}while(opcion!=5);
        
        System.out.println("Fin de la ejecución y Gracias por participar");
                
    }
}