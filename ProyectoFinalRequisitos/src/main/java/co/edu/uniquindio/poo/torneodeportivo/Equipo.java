/**
 * Registro que agrupa los datos de un Equipo
 * @author Área de programación UQ
 * @since 2023-09
 * 
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE) 
 */
package co.edu.uniquindio.poo.torneodeportivo;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Optional;
import java.util.function.Predicate;

import static co.edu.uniquindio.poo.util.AssertionUtil.ASSERTION;

public class Equipo {
    private final String nombre;
    private Persona representante;
    private Collection<Jugador> jugadores;
    private GeneroEquipo genero;
    private byte victorias;
    private byte perdidas;
    private byte empates;
    
    public Equipo (String nombre,Persona representante,Collection<Jugador> jugadores,GeneroEquipo genero){
        ASSERTION.assertion( nombre != null && !nombre.isBlank() , "El nombre es requerido");
        ASSERTION.assertion( representante != null , "El representante es requerido");
        this.nombre=nombre;
        this.representante=representante;
        this.jugadores=new LinkedList<>();
        this.genero=genero;
        this.victorias=0;
        this.perdidas=0;
        this.empates=0;
    }

    /**
     * Permite registrar un jugador en un equipo siempre y cuando no exista ya un jugador registrado en el equipo con el mismo nombre y apellido
     * @param jugador Jugador que se desea registrar.
     */
    public void registrarJugador(Jugador jugador) {
        validarJugadorExiste(jugador);
        jugadores.add(jugador);
    }

    /**
     * Permimte buscar un jugador en el equipo basado en su nombre y apellido.
     * @param jugador Jugador que se desea buscar
     * @return Optional con el jugador que coincida con el nombre y apellido del jugador buscado, 
     * o Optinal vacío en caso de no encontrar un jugador en el equipo con dicho nombre y apellido.
     */
    public Optional<Jugador> buscarJugador(Jugador jugador){
        Predicate<Jugador> nombreIgual = j->j.getNombre().equals(jugador.getNombre());
        Predicate<Jugador> apellidoIgual = j->j.getApellido().equals(jugador.getApellido());
        return jugadores.stream().filter(nombreIgual.and(apellidoIgual)).findAny();
    }

    /**
     * Valida que no exista ya un jugador registrado con el mismo nombre y apellido, en caso de haberlo genera un assertion error.
     */
    private void validarJugadorExiste(Jugador jugador) {
        boolean existeJugador = buscarJugador(jugador).isPresent();
        ASSERTION.assertion( !existeJugador,"El jugador ya esta registrado");
    }

    public String getNombre() {
        return nombre;
    }

    public Persona getRepresentante() {
        return representante;
    }

    public Collection<Jugador> getJugadores() {
        return jugadores;
    }

    public GeneroEquipo getGenero() {
        return genero;
    }

    public byte getVictorias() {
        return victorias;
    }

    public byte getPerdidas() {
        return perdidas;
    }

    public byte getEmpates() {
        return empates;
    }
    
    public void setVictorias(byte victorias){
        this.victorias=victorias;
    }

    public void setPerdidas(byte perdidas){
        this.perdidas=perdidas;
    }

    public void setEmpates(byte empates){
        this.empates=empates;
    }
}
