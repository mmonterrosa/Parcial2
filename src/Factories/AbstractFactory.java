/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factories;

import EdificacionRecursos.EdifRecursos;
import EntrenamientoMilitia.Entrenamiento;
import Militia.Militia;
import Razas.Razas;

/**
 *
 * @author MMont
 */
public interface AbstractFactory {
    public Razas getRazas(String type);
    public Militia getMilitia(String type);
    public EdifRecursos getEdifRecursos (int type);
    public Entrenamiento getEntrenamiento (String type);
    
            
}