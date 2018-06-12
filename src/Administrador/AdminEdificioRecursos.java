/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administrador;

import EdificacionRecursos.EdifRecursos;
import java.util.ArrayList;

/**
 *
 * @author MMont
 */
public class AdminEdificioRecursos implements Administrador<EdifRecursos>{
    
    private ArrayList<EdifRecursos> ListaEdificiosRecursos;

    public AdminEdificioRecursos() {
        ListaEdificiosRecursos = new ArrayList<>();
    }

    @Override
    public void add(EdifRecursos p) throws Exception {
        ListaEdificiosRecursos.add(p);

    
    }

    @Override
    public void change(EdifRecursos p) throws Exception {
    }

    @Override
    public void delete(EdifRecursos p) throws Exception {
    ListaEdificiosRecursos.remove(p);
    }

    @Override
    public void show(EdifRecursos p) throws Exception {
    System.out.println(p.toString());
    }

    @Override
    public void showAll() throws Exception {
     
        for(EdifRecursos  p : ListaEdificiosRecursos){
                System.out.println(p.toString());
            }
        }
    

    
    
}
