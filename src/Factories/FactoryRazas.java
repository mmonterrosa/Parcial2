/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factories;

import Administrador.Administrador;
import EdificacionRecursos.EdifRecursos;
import Militia.Militia;
import Razas.Elfos;
import Razas.Gigantes;
import Razas.Golems;
import Razas.Razas;
import Vehiculos.EdifVehiculos;

/**
 *
 * @author MMont
 */
public class FactoryRazas implements AbstractFactory{

    @Override
    public Razas getRazas(String type) {
        switch (type){
            case "Elfos":
                return new Elfos();
            case "Gigantes":
                return new Gigantes();
            case "Golems":
                return new Golems();
                    
                    
        }
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
