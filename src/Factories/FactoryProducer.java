/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factories;

/**
 *
 * @author MMont
 */
public class FactoryProducer {
    public static AbstractFactory getFactory(String type){
        switch (type){
            case "Recursos":
                return  new FactoryRecursos();
            case "Razas":
                return new FactoryRazas();
            case "Administrador":
                return new FactoryAdministrador();
            case "Vehiculo":
                return new FactoryVehiculo();
        }
        return null;
    }
    
    
}
