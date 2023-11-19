package co.edu.uniquindio.poo.torneodeportivo;

import static co.edu.uniquindio.poo.util.AssertionUtil.ASSERTION;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.LinkedList;

public class Enfrentamiento{
    private final String nombre;
    private final String lugar;
    private LocalDate fechaEnfrentamiento;
    private LocalDateTime fechaHora;
    private Collection<Juez> jueces;
    private Estado estado;
    private Equipo equipoLocal;
    private Equipo equipoVisitante;
    private byte puntosEquipoLocal;
    private byte puntosEquipoVisitante;
    private Juez juez;

    public Enfrentamiento (String nombre, String lugar, LocalDate fechaEnfrentamiento, LocalDateTime fechaHora, Equipo equipoLocal, Equipo equipoVisitante){
        ASSERTION.assertion(nombre != null);
        ASSERTION.assertion(lugar != null);
        ASSERTION.assertion(fechaEnfrentamiento != null);
        ASSERTION.assertion(fechaHora != null);
        ASSERTION.assertion(equipoLocal != null);
        ASSERTION.assertion(equipoVisitante != null);
        this.lugar=lugar;
        this.fechaHora=fechaHora;
        this.estado= Estado.PENDIENTE; 
        this.nombre=nombre;
        this.fechaEnfrentamiento=fechaEnfrentamiento;   
        this.equipoLocal=equipoLocal;
        this.equipoVisitante=equipoVisitante;
        this.jueces = new LinkedList<>();
    }

    public Enfrentamiento (String nombre, String lugar, LocalDate fechaEnfrentamiento, LocalDateTime fechaHora, Equipo equipoLocal, Equipo equipoVisitante, Juez juez){
        this.lugar=lugar;
        this.fechaHora=fechaHora;
        this.estado= Estado.PENDIENTE; 
        this.nombre=nombre;
        this.fechaEnfrentamiento=fechaEnfrentamiento;   
        this.equipoLocal=equipoLocal;
        this.equipoVisitante=equipoVisitante;
        this.juez = juez;
    }    

    public String getLugar() {
        return lugar;
    }

    public String getNombre(){
        return nombre;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public Collection<Juez> getJueces(){
        return jueces;
    }
    
    public Juez getJuez(){
        return juez;
    }

    public Estado getEstado() {
        return estado;
    }

    public byte getPuntosLocal() {
        return puntosEquipoLocal;
    }

    public byte getPuntosVisitante() {
        return puntosEquipoVisitante;
    }

    public Equipo getEquipoLocal() {
        return equipoLocal;
    }

    public Equipo getEquipoVisitante() {
        return equipoVisitante;
    }

    public LocalDate getFechaEnfrentamiento(){
        return fechaEnfrentamiento;
    }


    public void setEstado(Estado estado){
        assert estado != null;
        this.estado = estado;
    }

    public void EnfrentamientoEstado() {
        if (LocalDateTime.now().isAfter(fechaHora)) {
            setEstado (Estado.ENJUEGO);
        } else {
            if (LocalDateTime.now().isBefore(fechaHora)) {
            setEstado(Estado.PENDIENTE);    
            }
            else {
                setEstado (Estado.APLAZADO);
            }

        }

    }


    public void registrarJuez(Juez juez){
        assert juez != null;
        jueces.add(juez);
    }

    public void setResultado(byte puntosEquipoLocal, byte puntosEquipoVisitante){
        this.puntosEquipoVisitante=puntosEquipoVisitante;
        this.puntosEquipoLocal=puntosEquipoLocal;
        
    } 

    public void finalizarEnfrentamiento(byte puntosLocal, byte puntosVisitante) {
        setResultado(puntosLocal, puntosVisitante);
        estado = Estado.FINALIZADO;
        if(getPuntosLocal()>getPuntosVisitante()){
            equipoLocal.setVictorias((byte) +1);
            equipoVisitante.setPerdidas((byte) +1);}
        else{
            if(getPuntosLocal()<getPuntosVisitante()){
                equipoLocal.setPerdidas((byte) +1);
                equipoVisitante.setVictorias((byte) +1);}
                else{
                    equipoLocal.setEmpates((byte)+1);
                    equipoVisitante.setEmpates((byte)+1);}
            }   
    }
    

}
