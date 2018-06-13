/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial2;

import CentroDeMando.CentroDeMando;
import EdificacionRecursos.EdifRecursos;
import Factories.AbstractFactory;
import Factories.FactoryProducer;
import Militia.Escuadrones;
import Militia.Militia;
import Vehiculos.EdifVehiculos;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author MMont
 */
public class Menu {
    public static int fase=0;
    private static Menu instance; //Singleton
    
    private Menu(){       
    }
    private Menu(Jugador jugador1, Jugador jugador2){    
        //boolean n=true;
        Scanner sc2 = new Scanner(System.in);
        
        Jugador arr[]={jugador1, jugador2};
        
        while(true){
            //Se añaden los edificios pendientes 
            jugador1.centrodemando.addPendingEdif();
            //Se Recolecta el "loot" de cada fase
            jugador1.centrodemando.Recolectar();
            
            
            //Se añaden los edificios pendientes 
            jugador2.centrodemando.addPendingEdif();
            //Se Recolecta el "loot" de cada fase
            jugador2.centrodemando.Recolectar();
            
            

            for( Jugador j : arr){
                
                boolean n=true;
                while (n){
            System.out.println("--------------" );
            System.out.println("Turno de: " + j.nombre);
            System.out.println("Fase: " + fase);
            System.out.println("Nivel: " + j.centrodemando.getNivel());
            System.out.println("---------------");
            System.out.println("Opciones: ");
            //System.out.println("1) Ver Recursos");
                    System.out.println("\nRecursos");
            System.out.println("1) Construir Edificacion de Recursos");
            System.out.println("2) Mostrar Cantidad de Recursos Disponibles");
            System.out.println("3) Mostrar Edificaciones de Recursos Disponibles");
            System.out.println("4) Mostar Edificaciones de Recursos Pendientes");
                    System.out.println("\nVehiculos");
            System.out.println("5) Construir Vehiculo");
            System.out.println("6) Mostrar Edificaciones De Vehiculos Disponibles ");
            System.out.println("7) Mostrar Edificaciones De Vehiculos Pendientes ");
                    System.out.println("\nMilitia");
            System.out.println("8) Construir Militia ");
            System.out.println("9) Mostrar Militia Pendiente");
            System.out.println("10) Mostrar Militia Disponible");
            
            System.out.println(") Atacar Enemigo");
            System.out.println(") Aumentar de Nivel");
            System.out.println("15) Terminar Turno");
            System.out.print("Ingrese una Opcion: ");
            int opcion = sc2.nextInt();
            
            switch (opcion){
                case 1:
                    System.out.println("1) Construir Edificacion de Oro     (-100 Cobre, -50 Plata)");
                    System.out.println("2) Construir Edificacion de Plata   (-50 Oro, -100 Cobre)");
                    System.out.println("3) Construir Edificacion de Cobre   (-50 Oro, -75 Plata)");
                    opcion = sc2.nextInt();
                    
                    switch (opcion){
                        case 1:
                            if ((j.centrodemando.getCantCobreActual() >= 100) && (j.centrodemando.getCantPlataActual()>=50)){
                            j.centrodemando.setCantCobreActual(j.centrodemando.getCantCobreActual()-100);
                            j.centrodemando.setCantPlataActual(j.centrodemando.getCantPlataActual()-50);
                            AbstractFactory factory = FactoryProducer.getFactory("Recursos");
                            try{
                                if(j.raza.getNombreRaza() == "Elfos")
                                j.centrodemando.pendingEdifRecursos.add(factory.getEdifRecursos(1,1));
                                else
                                j.centrodemando.pendingEdifRecursos.add(factory.getEdifRecursos(1,2));
                             //j.centrodemando.AdminRecursos.add(factory.getEdifRecursos(1)); // Se añade recurso de oro
                            }
                            catch (Exception e){
                                System.out.println("Could not add this building to the list");
                                }
                            }
                            else{
                                System.err.println("No Tiene Los Recursos Suficientes!");
                                    
                                    }
                            break;
                        case 2:
                            if((j.centrodemando.getCantCobreActual() >=100) &&(j.centrodemando.getCantOroActual()>=50)){
                                j.centrodemando.setCantCobreActual(j.centrodemando.getCantCobreActual() -100);
                                j.centrodemando.setCantOroActual(j.centrodemando.getCantOroActual()-50);
                                
                                AbstractFactory factory = FactoryProducer.getFactory("Recursos");
                                
                            try{
                                if(j.raza.getNombreRaza() == "Elfos")
                                j.centrodemando.pendingEdifRecursos.add(factory.getEdifRecursos(2,1));
                                else
                                j.centrodemando.pendingEdifRecursos.add(factory.getEdifRecursos(2,2));
                             //j.centrodemando.AdminRecursos.add(factory.getEdifRecursos(2)); // Se añade recurso de plata
                            }
                            catch (Exception e){
                                System.out.println("Could not add this building to the list");
                                }
                            
                            }
                            else{
                                System.err.println("No Tiene Los Recursos Suficientes!");
                                    
                                    }
                            break;
                        case 3:
                            if((j.centrodemando.getCantOroActual()>=50)&& (j.centrodemando.getCantPlataActual()>=75)){
                                j.centrodemando.setCantOroActual(j.centrodemando.getCantOroActual()-50);
                                j.centrodemando.setCantPlataActual(j.centrodemando.getCantPlataActual()-75);
                                AbstractFactory factory = FactoryProducer.getFactory("Recursos");
                             
                            try{
                                if(j.raza.getNombreRaza() == "Elfos")
                                j.centrodemando.pendingEdifRecursos.add(factory.getEdifRecursos(3,1));
                                else
                                j.centrodemando.pendingEdifRecursos.add(factory.getEdifRecursos(3,2));
                             //j.centrodemando.AdminRecursos.add(factory.getEdifRecursos(2)); // Se añade recurso de plata
                            }
                            catch (Exception e){
                                System.out.println("Could not add this building to the list");
                                }
                            }
                            else{
                                System.err.println("No Tiene Los Recursos Suficientes!");
                                    
                                    }
                            
                                
                          }
                                       
                    break;
                    
                case 2:
                    System.out.println("--------------------------------------------");
                    System.out.println("\n Cantidad de Recursos: ");
                    System.out.println("Oro: " + j.centrodemando.getCantOroActual());
                    System.out.println("Plata: " + j.centrodemando.getCantPlataActual());
                    System.out.println("Cobre: " + j.centrodemando.getCantCobreActual());
                    System.out.println("-------------------------------------------- \n");

                    break;
                case 3:
                    try{
                        j.centrodemando.AdminRecursos.showAll();
                    }
                    catch (Exception e){
                        System.out.println("No se Pudo Mostrar");
                    }
                    System.out.println("----------------------------------------------------------------------------");
                    System.out.println("----------------------------------------------------------------------------");
                    
                    break;
                    
                case 4:
                    System.out.println("Edificaciones De Recursos Pendientes(En Construccion)");
                    if (j.centrodemando.getPendingEdifRecursos().isEmpty()){
                        System.err.println("No hay Ninguna Edificacion de Recursos en construccion");
                    }else{
                    for (EdifRecursos er: j.centrodemando.getPendingEdifRecursos()){
                        System.out.println(er.toString() + " Fase implementacion: " + er.getFaseImplementacion());
                    }
                    }
                    
                    
                    break;
                    
                case 5:
                    System.out.println("1) Construir Convoy    (-100 Oro, -75 Plata)");
                    System.out.println("2) Construir Hummer   (-50 Oro, -250 Cobre)");
                    opcion = sc2.nextInt();
                    
                    switch(opcion){
                        case 1:
                             if ((j.centrodemando.getCantOroActual()>= 100) && (j.centrodemando.getCantPlataActual()>=75)){
                            j.centrodemando.setCantOroActual(j.centrodemando.getCantCobreActual()-100);
                            j.centrodemando.setCantPlataActual(j.centrodemando.getCantPlataActual()-75);
                            AbstractFactory factory = FactoryProducer.getFactory("Vehiculo");
                            try{
                                if(j.raza.getNombreRaza() == "Gigantes")
                                j.centrodemando.pendingEdifVehiculos.add(factory.getVehiculo(1,2));
                                else
                                j.centrodemando.pendingEdifVehiculos.add(factory.getVehiculo(1,3));
                             //j.centrodemando.AdminRecursos.add(factory.getEdifRecursos(1)); // Se añade recurso de oro
                            }
                            catch (Exception e){
                                System.out.println("Could not add this building to the list");
                                }
                            }
                            else{
                                System.err.println("No Tiene Los Recursos Suficientes!");
                                    
                                    }
                            break;
                            
                        case 2:
                               if ((j.centrodemando.getCantOroActual()>= 50) && (j.centrodemando.getCantCobreActual()>=250)){
                            j.centrodemando.setCantOroActual(j.centrodemando.getCantCobreActual()-50);
                            j.centrodemando.setCantCobreActual(j.centrodemando.getCantCobreActual()-250);
                            AbstractFactory factory = FactoryProducer.getFactory("Vehiculo");
                            try{
                                if(j.raza.getNombreRaza() == "Gigantes")
                                j.centrodemando.pendingEdifVehiculos.add(factory.getVehiculo(2,2));
                                else
                                j.centrodemando.pendingEdifVehiculos.add(factory.getVehiculo(2,3));
                             //j.centrodemando.AdminRecursos.add(factory.getEdifRecursos(1)); // Se añade recurso de oro
                            }
                            catch (Exception e){
                                System.out.println("Could not add this building to the list");
                                }
                            }
                            else{
                                System.err.println("No Tiene Los Recursos Suficientes!");
                                    
                                    }
                               
                            break;
                            
                    }
                    
                    break;
                    
                case 6:
                    try{
                        j.centrodemando.AdminVehiculos.showAll();
                    }
                    catch (Exception e){
                        System.out.println("No se Pudo Mostrar");
                    }
                    System.out.println("----------------------------------------------------------------------------");
                    System.out.println("----------------------------------------------------------------------------");
                    
                    break;
                case 7:
                    for (EdifVehiculos ev: j.centrodemando.getPendingEdifVehiculos()){
                        System.out.println(ev.toString() + " Fase implementacion: " + ev.getFaseImplementacion());
                    }
                    
                    
                    break;
                case 8:
                    System.out.println("1) Construir Escuadron     (-150 Cobre, -100 Plata)");
                    System.out.println("2) Construir Especialista [Solo 1 A La Vez] (-100 Oro, -100 Cobre)");
                    opcion = sc2.nextInt();
                    
                    switch(opcion){
                        case 1: 
                            if((j.centrodemando.getCantCobreActual() >=150) &&(j.centrodemando.getCantPlataActual()>=100)){
                                j.centrodemando.setCantCobreActual(j.centrodemando.getCantCobreActual()-150);
                                j.centrodemando.setCantPlataActual(j.centrodemando.getCantPlataActual()-100);
                                AbstractFactory factory = FactoryProducer.getFactory("Militia");
                                try{
                                    if(j.raza.getNombreRaza() == "Golems"){
                                        j.centrodemando.pendingMilitia.add(factory.getMilitia(1, 2, 75));
                                    }
                                    else
                                        j.centrodemando.pendingMilitia.add(factory.getMilitia(1, 2, 50));
                                    
                                      }catch(Exception e){
                                            System.out.println(e.toString());
                                        }
                            }
                            break;
                            
                        case 2:
                            AbstractFactory factory = FactoryProducer.getFactory("Militia");
                            Militia especialista = factory.getMilitia(2,2,50);
                            if((j.centrodemando.Especialista!=null)&&(j.centrodemando.Especialista == especialista)){
                                System.out.println("Ya Se Encuentra Un Especialista");
                            }
                            else
                                j.centrodemando.pendingEspecialista=especialista;
                            
                    }
                    
                    
                    
                    
                    
                    
                    break;
                    
                    //Mostrar los pending
                case 9:
                   System.out.println("Edificaciones De Militia Pendientes(En Construccion)");
                    System.out.println("hay algun Pending Especialista: ");// + j.centrodemando.pendingEspecialista!=null);
                    if ( (j.centrodemando.pendingMilitia.isEmpty()) && (j.centrodemando.pendingEspecialista==null)){
                        System.err.println("No hay Ninguna Edificacion de Militia en construccion");
                    }else{
                    for (Militia m: j.centrodemando.pendingMilitia){
                        System.out.println(m.toString());
                    }
                    
                    if(j.centrodemando.pendingEspecialista!=null)
                        System.out.println(j.centrodemando.pendingEspecialista.toString());
                    
                    }
                   break;
                   
                   //Mostrar todos los disponibles
                case 10:

                    try{
                        j.centrodemando.AdminMilitia.showAll();
                        
                    
                    if(j.centrodemando.Especialista!=null)
                            System.out.println(j.centrodemando.Especialista.toString());
                   
                    } catch(Exception e){
                        System.err.println(e);
                    }
                    
                    break;

                
                case 15:
                    n=false;
                    break;
                    

                    
                            
                    
            }
            
            
            
        }
            
            
      }
            fase+=1;
        
        
     }
  }
    
    public synchronized static Menu getInstanced(Jugador jugador1, Jugador jugador2){
        if (instance == null){
            instance = new Menu(jugador1, jugador2);
        }
        return instance;
    }
    
 
    
   
    
        
    }
    
