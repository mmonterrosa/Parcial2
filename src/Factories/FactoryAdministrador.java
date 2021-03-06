/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factories;

import Administrador.AdminEdificioRecursos;
import Administrador.AdminEdificioVehiculos;
import Administrador.AdminMilitia;
import Administrador.Administrador;
import EdificacionRecursos.EdifRecursos;
import Militia.Militia;
import Razas.Razas;
import Vehiculos.EdifVehiculos;

/**
 *
 * @author MMont
 */
public class FactoryAdministrador implements AbstractFactory {

    @Override
    public Razas getRazas(String type) {
    return null;
   }

    @Override
    public Militia getMilitia(String type) {
        return null;
    }

    @Override
    public EdifRecursos getEdifRecursos(int type, int espera) {
    
    return null;
    }


    @Override
    public Administrador getAdministrador(String type) {
    switch(type){
        case "Recursos":
            return new AdminEdificioRecursos();
        case "Vehiculos":
            return new AdminEdificioVehiculos();
        case "Militia":
            return new AdminMilitia();
                
            
        
        }
    return null;
    }

    @Override
    public EdifVehiculos getVehiculo(int type, int espera) {
      return null;
    }

    @Override
    public Militia getMilitia(int type, int espera, int ataquePorFase) {
    return null;
    }
    
}
