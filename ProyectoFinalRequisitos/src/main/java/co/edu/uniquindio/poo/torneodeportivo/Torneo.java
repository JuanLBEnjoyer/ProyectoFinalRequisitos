/**
 * Clase que agrupa los datos de un Torneo
 * @author Área de programación UQ
 * @since 2023-08
 * 
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE) 
 */
package co.edu.uniquindio.poo.torneodeportivo;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Optional;
import java.util.function.Predicate;
import static co.edu.uniquindio.poo.util.AssertionUtil.ASSERTION;

public class Torneo {
    private final String nombre;
    private static LocalDate fechaInicio;
    private LocalDate fechaInicioInscripciones;
    private LocalDate fechaCierreInscripciones;
    private final byte numeroParticipantes;
    private final byte limiteEdad;
    private final int valorInscripcion;
    private final TipoTorneo tipoTorneo;
    private final Collection<Equipo> equipos;
    private  Genero generoTorneo;
    private Juez juez;
    private final Collection<Enfrentamiento> enfrentamientos;

    public Torneo(String nombre, LocalDate fechaInicio,
            LocalDate fechaInicioInscripciones,
            LocalDate fechaCierreInscripciones, byte numeroParticipantes,
            byte limiteEdad, int valorInscripcion,TipoTorneo tipoTorneo, Genero generoTorneo, Juez juez) {
        
        ASSERTION.assertion( nombre != null , "El nombre es requerido");
        ASSERTION.assertion(generoTorneo != null, "Debe añadir un genero al torneo");
        ASSERTION.assertion( numeroParticipantes >= 0, "El número de participantes no puede ser negativo");
        ASSERTION.assertion( limiteEdad >= 0,"El limite de edad no puede ser negativo");
        ASSERTION.assertion( valorInscripcion >= 0,"El valor de la inscripción no puede ser negativo");
        ASSERTION.assertion(juez != null, "Debe añadir al menos un juez al torneo");
        
        this.nombre = nombre;
        
        setFechaInicioInscripciones(fechaInicioInscripciones);
        setFechaCierreInscripciones(fechaCierreInscripciones); 
        setFechaInicio(fechaInicio);
        this.numeroParticipantes = numeroParticipantes;
        this.limiteEdad = limiteEdad;
        this.valorInscripcion = valorInscripcion;
        this.tipoTorneo = tipoTorneo;
        this.equipos = new LinkedList<>();
        this.enfrentamientos=new LinkedList<>();
        this.generoTorneo=generoTorneo;
        this.juez=juez;
        this.fechaCierreInscripciones=fechaCierreInscripciones;
        this.fechaInicioInscripciones=fechaInicioInscripciones;
    }



	public String getNombre() {
        return nombre;
    }

    public static LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaInicioInscripciones() {
        return fechaInicioInscripciones;
    }

    public LocalDate getFechaCierreInscripciones() {
        return fechaCierreInscripciones;
    }

    public byte getNumeroParticipantes() {
        return numeroParticipantes;
    }

    public byte getLimiteEdad() {
        return limiteEdad;
    }

    public int getValorInscripcion() {
        return valorInscripcion;
    }

    public TipoTorneo getTipoTorneo() {
        return tipoTorneo;
    }

    public Juez getJuez(){
        return juez;
    }

    public Genero getGeneroTorneo(){
        return generoTorneo;
    }

    public Collection<Enfrentamiento> getEnfrentamientos(){
        return enfrentamientos;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        ASSERTION.assertion( fechaInicio != null , "La fecha de inicio es requerida");
        ASSERTION.assertion( ( fechaInicioInscripciones == null || fechaInicio.isAfter(fechaInicioInscripciones) ) &&
                ( fechaCierreInscripciones == null || fechaInicio.isAfter(fechaCierreInscripciones) ),"La fecha de inicio no es válida" );
         
    }

    public void setFechaInicioInscripciones(LocalDate fechaInicioInscripciones) {
        ASSERTION.assertion( fechaInicioInscripciones != null , "La fecha de inicio de inscripciones es requerida");
        this.fechaInicioInscripciones = fechaInicioInscripciones;
    }


    public void setFechaCierreInscripciones(LocalDate fechaCierreInscripciones) {
        ASSERTION.assertion( fechaCierreInscripciones != null , "La fecha de cierre es requerida");
        ASSERTION.assertion( fechaCierreInscripciones.isAfter(fechaInicioInscripciones),"La fecha de cierre de inscripciones debe ser posterior a la fecha de inicio de inscripciones" );
        this.fechaCierreInscripciones = fechaCierreInscripciones;
    }
    
    /**
     * Permite registrar un equipo en el torneo
     * @param equipo Equipo a ser registrado
     * @throws Se genera un error si ya existe un equipo registrado con el mismo nombre, o en caso de que las inscripciones del torneo no esten abiertas.
     */
    public void registrarEquipo(Equipo equipo) {

        validarGeneroEquipo(equipo);

        validarEquipoExiste(equipo); 

        validarInscripciopnesAbiertas(); 

        equipos.add(equipo);
    }

    public void validarGeneroEquipo(Equipo equipo){
        boolean generoEquipo = generoTorneo.esValido(equipo);
        ASSERTION.assertion(!generoEquipo);
    }

  



    /**
     * Valida que las inscripciones del torneo esten abiertas, en caso de no estarlo genera un assertion error.
     */
    private void validarInscripciopnesAbiertas() {
        boolean inscripcionAbierta = fechaInicioInscripciones.isBefore(LocalDate.now()) && fechaCierreInscripciones.isAfter(LocalDate.now());
        ASSERTION.assertion( inscripcionAbierta,"Las inscripciones no están abiertas");
    }

    /**
     * Valida que no exista ya un equipo registrado con el mismo nombre, en caso de haberlo genera un assertion error.
     */
    private void validarEquipoExiste(Equipo equipo) {
        boolean existeEquipo = buscarEquipoPorNombre(equipo.getNombre()).isPresent();
        ASSERTION.assertion( !existeEquipo,"El equipo ya esta registrado");
    }

    /**
     * Permite obtener una copia no modificable de la lista de los equipos registrados.
     * @return Collection<Equipo> no modificable de los equipos registrados en el torneo.
     */
    public Collection<Equipo> getEquipos() {
        return Collections.unmodifiableCollection(equipos);
    }
    
    /**
     * Permite buscar un equipo por su nomnbre entre los equipos registrados en el torneo
     * @param nombre Nombre del equipo que se está buscando
     * @return Un Optional<Equipo> con el equipo cuyo nombre sea igual al nombre buscado, o un Optional vacio en caso de no encontrar un equipo con nombre igual al dado.
     */
    public Optional<Equipo> buscarEquipoPorNombre(String nombre){
        Predicate<Equipo> condicion = equipo->equipo.getNombre().equals(nombre);
        return equipos.stream().filter(condicion).findAny();
    }

    /**
     * Permite registrar un jugador en el equipo siempre y cuando este dentro de las fechas validas de registro, 
     * no exista ya un jugador registrado con el mismo nombre y apellido y el jugador no exceda el limite de edad del torneo.
     *  
     * @param nombre Nombre del equipo en que se desea registrar el jugador
     * @param jugador Jugador que se desea registrar.
     */
    public void registrarJugador(String nombre, Jugador jugador) {
        var equipo = buscarEquipoPorNombre(nombre);
        equipo.ifPresent( (e)->registrarJugador(e, jugador) );
    }

    /**
     * Permite registrar un jugador en el equipo siempre y cuando este dentro de las fechas validas de registro, 
     * no exista ya un jugador registrado con el mismo nombre y apellido y el jugador no exceda el limite de edad del torneo.
     * 
     * @param equipo Equipo en el que se desea registrar el jugador.
     * @param jugador Jugador que se desea registrar.
     */
    public void registrarJugador(Equipo equipo, Jugador jugador) {
        ASSERTION.assertion( !LocalDate.now().isAfter(fechaCierreInscripciones) , "No se pueden registrar jugadores después del a fecha de cierre de inscripciones");
        validarLimiteEdadJugador(jugador); 
        validarJugadorExiste(jugador);
        equipo.registrarJugador(jugador);
    }

    /**
     * Permite buscar un jugador basado en su nombre y apellido en todos los equipos registrados en el torneo.
     * @param jugador Jugador que se desea buscar
     * @return Optional con el jugador encontrado o un optional vacío en caso de no haber encontrado un jugador con el nombre y apellido del jugador buscado.
     */
    public Optional<Jugador> buscarJugador(Jugador jugador){
        return equipos.stream()
            .map(equipo->equipo.buscarJugador(jugador))
            .filter(Optional::isPresent)
            .map(Optional::get)
            .findAny();
    }

    /**
     * Valida que no exista ya un jugador registrado con el mismo nombre y apellido, en caso de haberlo genera un assertion error.
     */
    private void validarJugadorExiste(Jugador jugador) {
        boolean existeJugador = buscarJugador(jugador).isPresent();
        ASSERTION.assertion( !existeJugador,"El jugador ya esta registrado");
    }

    /**
     * Valida que no exista se puedan registrar jugadores que al momento del inicio del torneo excedan el limite de edad.
     */
    private void validarLimiteEdadJugador(Jugador jugador) {
        var edadAlInicioTorneo = jugador.calcularEdad(fechaInicio);
        ASSERTION.assertion( limiteEdad == 0 || limiteEdad >= edadAlInicioTorneo , "No se pueden registrar jugadores que excedan el limite de edad del torneo"); 
    }

    public void registrarEnfrentamiento(Enfrentamiento enfrentamiento){ 
        enfrentamientos.add(enfrentamiento);
    }

    public void EnfrentamientoEstado(Enfrentamiento enfrentamiento, Torneo torneo) {
        if (enfrentamiento.getFechaEnfrentamiento().isAfter(Torneo.getFechaInicio())) {
            enfrentamiento.setEstado(Estado.ENJUEGO);
        } else {
            if (enfrentamiento.getFechaEnfrentamiento().isBefore(Torneo.getFechaInicio())) {
                enfrentamiento.setEstado(Estado.PENDIENTE);    
            }
            else {
                enfrentamiento.setEstado (Estado.APLAZADO);
            }

        }

    }

    public void finalizarEnfrentamiento(byte puntosLocal, byte puntosVisitante, Enfrentamiento enfrentamiento) {
        enfrentamiento.setResultado(puntosLocal, puntosVisitante);
        enfrentamiento.setEstado(Estado.FINALIZADO);
        if(enfrentamiento.getPuntosLocal()>enfrentamiento.getPuntosVisitante()){
            enfrentamiento.getEquipoLocal().setVictorias((byte) +1);
            enfrentamiento.getEquipoVisitante().setPerdidas((byte) +1);}
        else{
            if(enfrentamiento.getPuntosLocal()<enfrentamiento.getPuntosVisitante()){
                enfrentamiento.getEquipoLocal().setPerdidas((byte) +1);
                enfrentamiento.getEquipoVisitante().setVictorias((byte) +1);}
                else{
                    enfrentamiento.getEquipoLocal().setEmpates((byte)+1);
                    enfrentamiento.getEquipoVisitante().setEmpates((byte)+1);}
            }   
    }

    public Optional<Enfrentamiento> buscarEnfrentamientoEquipo(String nombreEquipo){
        Predicate<Enfrentamiento> condicion = enfrentamiento->enfrentamiento.getEquipoLocal().getNombre().equals(nombreEquipo) || enfrentamiento.getEquipoVisitante().getNombre().equals(nombreEquipo);
        return enfrentamientos.stream().filter(condicion).findAny();
    }


    public Collection<Enfrentamiento> listaEquipoEnfrentamiento(String nombre){
        Collection<Enfrentamiento> enfrentamientosEquipo = new LinkedList<>();
        Optional<Enfrentamiento> buscar = buscarEnfrentamientoEquipo(nombre);
        enfrentamientosEquipo.add(buscar.get());
        return enfrentamientosEquipo;
    }
    
    public Collection<Enfrentamiento> listaJuezEnfrentamientos(String licenciaJuez){
        Predicate<Enfrentamiento> condicion = e -> e.getJueces().stream().anyMatch(j->j.licencia().equals(licenciaJuez));
        return enfrentamientos.stream().filter(condicion).toList();
    }

    public Collection<Enfrentamiento> listadoVictoriasPerdidasEmpates(Equipo equipo){
        buscarEnfrentamientoEquipo(equipo.getNombre());
        
        Collection<Enfrentamiento> listado = new LinkedList<>();
        for(Enfrentamiento enfrentamiento: enfrentamientos){
            listado.add(enfrentamiento);
        }
        return listado;
    }
}