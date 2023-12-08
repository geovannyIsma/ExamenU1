/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.DAO.examen;

import controlador.DAO.DaoImplement;
import controlador.TDA.colas.QueueUltimate;
import controlador.TDA.listas.DynamicList;
import controlador.TDA.listas.Exception.EmptyException;
import controlador.TDA.pilas.FulStackException;
import controlador.Utiles.Utiles;
import modelo.Simulacion;
import modelo.Tramite;

/**
 *
 * @author romer
 */
public class SimulacionControl extends DaoImplement<Simulacion>{
   private Simulacion simulacion = new Simulacion();
   private TramiteControl tramiteControl = new TramiteControl();
   private DynamicList<Simulacion> simulacionList = new DynamicList<>();

    public SimulacionControl() {
        super(Simulacion.class);
    }

    private Tramite generarTramiteAleatorio() throws EmptyException{
        DynamicList<Tramite> tramites = tramiteControl.getTramiteList();
        int aleatorio = Utiles.generarNumero(0, tramites.getLenght() - 1);
        return tramites.getInfo(aleatorio);
    }

    public void generarVentanillas(Integer numPersonas) throws EmptyException, FulStackException{
        for (int i = 0; i < 3; i++){
            QueueUltimate<Tramite> ventanilla = new QueueUltimate<>(numPersonas);
            
            for (int j = 0; j < numPersonas; j++){
                Tramite tramite = generarTramiteAleatorio();
                ventanilla.queue(tramite);
            }
            simulacion.getVentanillas().add(ventanilla);
        }
    }

    public Integer getNumPersonasVentanilla(Integer numVentanilla) throws EmptyException{
        return simulacion.getVentanillas().getInfo(numVentanilla).lenght();
    }

    public Integer getTiempoVentanilla(Integer numVentanilla) throws EmptyException{
        QueueUltimate<Tramite> ventanilla = simulacion.getVentanillas().getInfo(numVentanilla);
        Integer tiempo = 0;
        
        for (int i = 0; i < ventanilla.lenght(); i++){
            Tramite tramite = ventanilla.getData(i);
            tiempo += tramite.getDuracion();
        }
        
        return tiempo;
    }

    public int getNumPersonasTotal() throws EmptyException {
        int totalPersonas = 0;
        for (int i = 0; i < simulacion.getVentanillas().getLenght(); i++) {
            QueueUltimate<Tramite> ventanilla = simulacion.getVentanillas().getInfo(i);
            totalPersonas += ventanilla.lenght();
        }
        return totalPersonas;
    }

    public int getTiempoTotal() throws EmptyException {
        int totalTiempo = 0;
        for (int i = 0; i < simulacion.getVentanillas().getLenght(); i++) {
            QueueUltimate<Tramite> ventanilla = simulacion.getVentanillas().getInfo(i);
            for (int j = 0; j < ventanilla.lenght(); j++) {
                try {
                    Tramite tramite = ventanilla.getData(j);
                    totalTiempo += tramite.getDuracion();
                } catch (EmptyException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return totalTiempo;
    }

    public Boolean persist(){
        simulacion.setId(all().getLenght() + 1);
        return persist(simulacion);
    }

    public Simulacion getSimulacion() {
        if (simulacion == null) {
            simulacion = new Simulacion();
        }
        return simulacion;
    }

    public void setSimulacion(Simulacion simulacion) {
        this.simulacion = simulacion;
    }

    public DynamicList<Simulacion> getSimulacionList() {
        simulacionList = all();
        return simulacionList;
    }

    public void setSimulacionList(DynamicList<Simulacion> simulacionList) {
        this.simulacionList = simulacionList;
    }
}
