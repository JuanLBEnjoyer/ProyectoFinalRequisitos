package co.edu.uniquindio.poo.torneodeportivo;

import java.time.LocalDateTime;

public class Enfrentamiento{
    private final String lugar;
    private LocalDateTime fechaHora;
    private byte puntosLocal;
    private byte puntosVisitante;
    private Juez juez;
    private Estado estado;
    private Equipo equipoLocal;
    private Equipo equipoVisitante;

public Enfrentamiento (String lugar, LocalDateTime fechaHora, Juez juez, Equipo equipoLocal, Equipo equipoVisitante){
    this.lugar=lugar;
    this.fechaHora=fechaHora;
    this.juez=juez;
    this.estado= Estado.PENDIENTE;    
    }

public String getLugar() {
    return lugar;
}

public LocalDateTime getFechaHora() {
    return fechaHora;
}


public Juez getJuez() {
    return juez;
}

public Estado getEstado() {
    return estado;
}

public byte getPuntosLocal() {
    return puntosLocal;
}

public byte getPuntosVisitante() {
    return puntosVisitante;
}

public Equipo getEquipoLocal() {
    return equipoLocal;
}

public Equipo getEquipoVisitante() {
    return equipoVisitante;
}

public void Enfrentamiento1() {
    if (LocalDateTime.now().isAfter(fechaHora)) {
        estado = Estado.ENJUEGO;
    } else {
        if (LocalDateTime.now().isBefore(fechaHora)) {
            estado=Estado.PENDIENTE;    
        }
        else {
            estado= Estado.APLAZADO;
        }

    }

}

public void finalizarEnfrentamiento(byte puntosLocal, byte puntosVisitante) {
    this.puntosLocal = puntosLocal;
    this.puntosVisitante = puntosVisitante;
    estado = Estado.FINALIZADO;
    }


}