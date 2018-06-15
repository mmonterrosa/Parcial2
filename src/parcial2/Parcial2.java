/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial2;

import Factories.AbstractFactory;
import Factories.FactoryProducer;
import Razas.Razas;
import java.util.Scanner;

/**
 *
 * @author MMont
 */
public class Parcial2 {
    

    public static void main(String[] args) {
       System.out.println("Razas Disponibles: ");
        System.out.println("1) Elfos: ");
        System.out.println("Crean Edficaciones de Recursos Mas Rapido");
        System.out.println("2) Gigantes");
        System.out.println("Crean Vehiculos Mas Rapido");
        System.out.println("3) Golem");
        System.out.println("Crean Militia Mas Rapido");
        System.out.println("\nTodas las Razas Recolectan (200 Oro, 300 Plata,500 Cobre)");
        
       


//\n 1) Elfos \n 2) Gigantes \n 3) Golems");
                
        
        
        
        
        System.out.println("Ingrese Nombre del Jugador 1: ");
        Scanner sc = new Scanner(System.in);
        String nombre = sc.next();       
        //System.out.println("Razas Disponibles: \n 1) Elfos \n 2) Gigantes \n 3) Golems");
        System.out.print("Ingrese Raza: ");
        int x = sc.nextInt();
        while((x!=1)&&(x!=2)&&(x!=3)){
        //System.out.println("Razas Disponibles: \n 1) Elfos \n 2) Gigantes \n 3) Golems");
        System.out.print("Ingrese Raza: ");
        x = sc.nextInt();
        }
        Jugador jugador1 = new Jugador(nombre,x);
        
        System.out.println("Ingrese Nombre del Jugador 2: ");
        Scanner sc2 = new Scanner(System.in);
        nombre = sc2.next();
       // System.out.println("Razas Disponibles: \n 1) Elfos \n 2) Gigantes \n 3) Golems");
        System.out.print("Ingrese Raza: ");
        x = sc2.nextInt();
        while((x!=1)&&(x!=2)&&(x!=3)){
        //System.out.println("Razas Disponibles: \n 1) Elfos \n 2) Gigantes \n 3) Golems");
        System.out.print("Ingrese Raza: ");
        x = sc.nextInt();
        }
        Jugador jugador2 = new Jugador(nombre,x);
        
        Menu.getInstanced(jugador1, jugador2);
        
        
        
        
               
                
               
    }
    
}
