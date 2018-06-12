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
            System.out.println("1) Construir Edificacion de Recursos");
            System.out.println("2) Mostrar Cantidad de Recursos");
            System.out.println(") Construir Militia");
            System.out.println(") Construir Vehiculos");
            System.out.println(") Atacar Enemigo");
            System.out.println(") Aumentar de Nivel");
            System.out.println("6) Terminar Turno");
            System.out.println("7) Mostrar Edificaciones de Recursos Activas");
            System.out.print("Ingrese una Opcion: ");
            int opcion = sc2.nextInt();
            
            switch (opcion){
                case 1:
                    System.out.println("1) Construir Edificacion de Oro     (-150 Cobre, -100 Plata)");
                    System.out.println("2) Construir Edificacion de Plata   (-150 Cobre, -50 Oro)");
                    System.out.println("3) Construir Edificacion de Cobre   (-100 Plata, -50 Oro");
                    opcion = sc2.nextInt();
                    
                    switch (opcion){
                        case 1:
                            if ((j.centrodemando.getCantCobreActual() >= 150) && (j.centrodemando.getCantPlataActual()>=100)){
                            j.centrodemando.setCantCobreActual(j.centrodemando.getCantCobreActual()-150);
                            j.centrodemando.setCantPlataActual(j.centrodemando.getCantPlataActual() -100);
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
                            if((j.centrodemando.getCantCobreActual() >=150) &&(j.centrodemando.getCantOroActual()>=50)){
                                j.centrodemando.setCantCobreActual(j.centrodemando.getCantCobreActual() -150);
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
                            if((j.centrodemando.getCantOroActual()>=50)&& (j.centrodemando.getCantPlataActual()>=100)){
                                j.centrodemando.setCantOroActual(j.centrodemando.getCantOroActual()-50);
                                j.centrodemando.setCantPlataActual(j.centrodemando.getCantPlataActual()-100);
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
                    
                
                case 6:
                    n=false;
                    break;
                case 7:
                    try{
                        j.centrodemando.AdminRecursos.showAll();
                    }
                    catch (Exception e){
                        System.out.println("No se Pudo Mostrar");
                    }
                    System.out.println("----------------------------------------------------------------------------");
                    System.out.println("----------------------------------------------------------------------------");

                    
                            
                    
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
    
