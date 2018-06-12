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
        
        
        
        
        System.out.println("Ingrese Nombre del Jugador 1: ");
        Scanner sc = new Scanner(System.in);
        String nombre = sc.next();       
        System.out.println("Razas Disponibles: \n 1) Elfos \n 2) Gigantes \n 3) Golems");
        System.out.print("Ingrese Raza: ");
        int x = sc.nextInt();
        Jugador jugador1 = new Jugador(nombre,x);
        
        System.out.println("Ingrese Nombre del Jugador 2: ");
        Scanner sc2 = new Scanner(System.in);
        nombre = sc2.next();
        System.out.println("Razas Disponibles: \n 1) Elfos \n 2) Gigantes \n 3) Golems");
        System.out.print("Ingrese Raza: ");
        x = sc2.nextInt();
        Jugador jugador2 = new Jugador(nombre,x);
        
        Menu.getInstanced(jugador1, jugador2);
        
        
        
        
               
                
               
    }
    
}
