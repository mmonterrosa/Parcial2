/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial2;

import CentroDeMando.CentroDeMando;
import Factories.AbstractFactory;
import Factories.FactoryProducer;
import Razas.Razas;


/**
 *
 * @author MMont
 */
public class Jugador{
    
    public String nombre;
    public CentroDeMando centrodemando;
    public Razas raza;
    
    
    
 public Jugador(){
        
 }

public Jugador(String nombre, int razaInt) {
        this.nombre = nombre;
        this.centrodemando = new CentroDeMando();
        this.raza = raza;
        AddRaza(razaInt);
        
                
        
 }
public void AddRaza(int x){
    AbstractFactory factory;
        factory = FactoryProducer.getFactory("Razas");
        
        switch(x){
            case 1:
                this.raza = factory.getRazas("Elfos");
                break;
                
            case 2: 
                this.raza  = factory.getRazas("Gigantes");
                break;
            case 3: 
               this.raza  = factory.getRazas("Golems");
                break;   
            default :
                System.out.println("Opcion Invalida");
                        
                        
            }
}

 
    
    
}
