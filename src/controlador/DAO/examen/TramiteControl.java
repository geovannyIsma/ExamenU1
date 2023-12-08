/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.DAO.examen;

import controlador.DAO.DaoImplement;
import controlador.TDA.listas.DynamicList;
import modelo.Tramite;

/**
 *
 * @author romer
 */
public class TramiteControl extends DaoImplement<Tramite> {
    
    private Tramite tramite;
    private DynamicList<Tramite> tramiteList = new DynamicList<>();
    
    public TramiteControl() {
        super(Tramite.class);
    }

    public Tramite getTramite() {
        if (tramite == null) {
            tramite = new Tramite();
        }
        return tramite;
    }

    public void setTramite(Tramite tramite) {
        this.tramite = tramite;
    }

    public DynamicList<Tramite> getTramiteList() {
        tramiteList = all();
        return tramiteList;
    }

    public void setTramiteList(DynamicList<Tramite> tramiteList) {
        this.tramiteList = tramiteList;
    }
    
    public Boolean persist(){
        this.tramite.setId(all().getLenght()+1);
        return this.persist(tramite);
    }
    
    /*public static void main(String[] args) {
        TramiteControl tc = new TramiteControl();
        tc.getTramite().setNombre("Cambio de clave");
        tc.getTramite().setDuracion(4);
        tc.persist();
        tc.setTramite(null);
        tc.getTramite().setNombre("Actualizacion de datos");
        tc.getTramite().setDuracion(7);
        tc.persist();
        tc.setTramite(null);
        tc.getTramite().setNombre("Asignacion de afiliados");
        tc.getTramite().setDuracion(15);
        tc.persist();
        tc.setTramite(null);
        tc.getTramite().setNombre("Recuperacion de clave");
        tc.getTramite().setDuracion(3);
        tc.persist();
        tc.setTramite(null);
    }*/
}
