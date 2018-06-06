/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial2;

import java.util.Scanner;

/**
 *
 * @author MMont
 */
public class Menu {
    public static int fase=0;
    private static Menu instance;
    
    private Menu(){       
    }
    private Menu(Jugador jugador1, Jugador jugador2){    
        boolean n=true;
        Scanner sc2 = new Scanner(System.in);
        //nombre = sc2.next();
        while(n){
            System.out.println("--------------" );
            System.out.println("Fase: " + fase);
            System.out.println("Turno de Jugador 1");
            System.out.println("Oro: " + jugador1.centrodemando.getCantOroActual());
            System.out.println("Plata: " + jugador1.centrodemando.getCantPlataActual());
            System.out.println("Cobre: " + jugador1.centrodemando.getCantCobreActual());
            System.out.println("---------------");
            System.out.println("Opciones: ");
            //System.out.println("1) Ver Recursos");
            System.out.println("1) Construir Edificacion");
            System.out.println("2) Construir Militia");
            System.out.println("3) Construir Vehiculos");
            System.out.println("4) Construir Vehiculos");
            System.out.print("Ingrese una Opcion: ");
            int opcion = sc2.nextInt();
            
            switch (opcion){
                case 1:

                    
                            
                    
            }
            
            
            
        }
    }
    
    public synchronized static Menu getInstanced(Jugador jugador1, Jugador jugador2){
        if (instance == null){
            instance = new Menu(jugador1, jugador2);
        }
        return instance;
    }
        
    }
    
