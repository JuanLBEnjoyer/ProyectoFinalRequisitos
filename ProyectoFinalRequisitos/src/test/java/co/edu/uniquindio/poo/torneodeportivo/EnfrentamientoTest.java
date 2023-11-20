package co.edu.uniquindio.poo.torneodeportivo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.LinkedList;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class EnfrentamientoTest {
    @Test
        public void estadoEnfrentamiento(){
            System.out.println("Inciando el test estado del enfrentamiento");
            Juez juez1 = new Juez("12345","Santiago","Guevara","santiagoG@gmail.com","3229882323");
            Torneo torneo = new  Torneo("Olimpiadas", LocalDate.now().plusDays(10), LocalDate.now(), LocalDate.now().plusDays(5), (byte)4, (byte)15, 5000, TipoTorneo.LOCAL, Genero.MIXTO,juez1);
            var representante2 = new Persona("Elkn", "Vidales", "234@gmail.com", "3145264879");
            var representante3 = new Persona("Juan", "Pablo", "345@hotmail.com", "3154895577");
            Equipo equipo3 = new Equipo("Tigres del Este", representante3,new LinkedList<>() ,GeneroEquipo.FEMENINO);
            Equipo equipo4 = new Equipo("Tigres del Oeste", representante2,new LinkedList<>(),GeneroEquipo.MASCULINO);
            var enfrentamiento1 = new Enfrentamiento("Juego Importante" ,"Armenia", LocalDate.now(), LocalDateTime.now(), equipo3, equipo4);
            torneo.registrarEnfrentamiento(enfrentamiento1);
            assertTrue(torneo.getEnfrentamientos().contains(enfrentamiento1));
            assertEquals(Estado.PENDIENTE, enfrentamiento1.getEstado());
            System.out.println("Finalizando el test estado del enfrentamiento");
    }

    @Test
    public void registrarEnfrentamientoTorneo(){
            System.out.println("Inciando el test registrar enfrentamiento");
            Juez juez1 = new Juez("12345","Santiago","Guevara","santiagoG@gmail.com","3229882323");
            Torneo torneo = new  Torneo("Olimpiadas", LocalDate.now().plusDays(10), LocalDate.now(), LocalDate.now().plusDays(5), (byte)4, (byte)15, 5000, TipoTorneo.LOCAL, Genero.MIXTO,juez1);
            var representante2 = new Persona("Elkn", "Vidales", "234@gmail.com", "3145264879");
            var representante3 = new Persona("Juan", "Pablo", "345@hotmail.com", "3154895577");
            Equipo equipo3 = new Equipo("Tigres del Este", representante3,new LinkedList<>() ,GeneroEquipo.FEMENINO);
            Equipo equipo4 = new Equipo("Tigres del Oeste", representante2,new LinkedList<>(),GeneroEquipo.MASCULINO);
            var enfrentamiento1 = new Enfrentamiento("Juego Importante" ,"Armenia", LocalDate.now(), LocalDateTime.now(), equipo3, equipo4);
            torneo.registrarEnfrentamiento(enfrentamiento1);
            assertTrue(torneo.getEnfrentamientos().contains(enfrentamiento1));
            assertEquals(torneo.getEnfrentamientos().size(), 1);
            System.out.println("Finalizando el test registrar enfrentamiento");
        }

    @Test
    public void datosCompletos(){
            System.out.println("Inciando el test datos completos");
            Juez juez1 = new Juez("12345","Santiago","Guevara","santiagoG@gmail.com","3229882323");
            Torneo torneo = new  Torneo("Olimpiadas", LocalDate.now().plusDays(10), LocalDate.now().minusDays(5), LocalDate.now().plusDays(5), (byte)4, (byte)15, 5000, TipoTorneo.LOCAL, Genero.MIXTO,juez1);
            var representante2 = new Persona("Elkn", "Vidales", "234@gmail.com", "3145264879");
            var representante3 = new Persona("Juan", "Pablo", "345@hotmail.com", "3154895577");
            Equipo equipo3 = new Equipo("Tigres del Este", representante3,new LinkedList<>() ,GeneroEquipo.FEMENINO);
            Equipo equipo4 = new Equipo("Tigres del Oeste", representante2,new LinkedList<>(),GeneroEquipo.MASCULINO);
            var enfrentamiento1 = new Enfrentamiento("Juego Importante" ,"Armenia", LocalDate.now().plusDays(11), LocalDateTime.now(), equipo3, equipo4);
            torneo.setFechaInicio(LocalDate.now().plusDays(10));
            torneo.registrarEnfrentamiento(enfrentamiento1);
            torneo.registrarEquipo(equipo4);
            torneo.registrarEquipo(equipo3);
            enfrentamiento1.registrarJuez(juez1);
            assertEquals("Juego Importante", enfrentamiento1.getNombre());
            assertEquals("Armenia", enfrentamiento1.getLugar());
            assertEquals(LocalDate.now().plusDays(11), enfrentamiento1.getFechaEnfrentamiento());
            assertTrue(enfrentamiento1.getJueces().contains(juez1));
            assertEquals(equipo3, enfrentamiento1.getEquipoLocal());
            assertEquals(equipo4, enfrentamiento1.getEquipoVisitante());
            System.out.println("Finalizando el tes datos completos");
    }

    @Test
    public void datosNulos(){
        System.out.println("Iniciando el test datos nulos");        
        assertThrows(Throwable.class, () -> new Enfrentamiento(null, null, null, null, null, null));
        System.out.println("Finalizando el tes datos nulos");
    }



    @Test
    public void buscarEnfrentamientoEquipo(){
            System.out.println("Inciando el test buscar enfrentamiento por equipo");
            Juez juez1 = new Juez("12345","Santiago","Guevara","santiagoG@gmail.com","3229882323");
            Torneo torneo = new  Torneo("Olimpiadas", LocalDate.now().plusDays(10), LocalDate.now().minusDays(5), LocalDate.now().plusDays(5), (byte)4, (byte)15, 5000, TipoTorneo.LOCAL, Genero.MIXTO,juez1);
            var representante2 = new Persona("Elkn", "Vidales", "234@gmail.com", "3145264879");
            var representante3 = new Persona("Juan", "Pablo", "345@hotmail.com", "3154895577");
            Equipo equipo3 = new Equipo("Tigres del Este", representante3,new LinkedList<>() ,GeneroEquipo.FEMENINO);
            Equipo equipo4 = new Equipo("Tigres del Oeste", representante2,new LinkedList<>(),GeneroEquipo.MASCULINO);
            var enfrentamiento1 = new Enfrentamiento("Juego Importante" ,"Armenia", LocalDate.now().plusDays(11), LocalDateTime.now(), equipo3, equipo4);
            torneo.registrarEnfrentamiento(enfrentamiento1);
            torneo.registrarEquipo(equipo4);
            torneo.registrarEquipo(equipo3);
            enfrentamiento1.registrarJuez(juez1);
            Collection<Enfrentamiento> enfrentamientosEquipo = torneo.listaEquipoEnfrentamiento("Tigres del Este");
            assertEquals(1, enfrentamientosEquipo.size());
            System.out.println("Finalizando el test buscar enfrentamiento por equipo");
    }    

    @Test
    public void buscarEnfrentamientoJuez(){
        System.out.println("Iniciando el test buscar enfrentamiento por licencia de juez");
        Juez juez1 = new Juez("12345","Santiago","Guevara","santiagoG@gmail.com","3229882323");
        Torneo torneo = new  Torneo("Olimpiadas", LocalDate.now().plusDays(10), LocalDate.now().minusDays(5), LocalDate.now().plusDays(5), (byte)4, (byte)15, 5000, TipoTorneo.LOCAL, Genero.MIXTO,juez1);
        var representante2 = new Persona("Elkn", "Vidales", "234@gmail.com", "3145264879");
        var representante3 = new Persona("Juan", "Pablo", "345@hotmail.com", "3154895577");
        Equipo equipo3 = new Equipo("Tigres del Este", representante3,new LinkedList<>() ,GeneroEquipo.FEMENINO);
        Equipo equipo4 = new Equipo("Tigres del Oeste", representante2,new LinkedList<>(),GeneroEquipo.MASCULINO);
        var enfrentamiento1 = new Enfrentamiento("Juego Importante" ,"Armenia", LocalDate.now().plusDays(11), LocalDateTime.now(), equipo3, equipo4);
        torneo.setFechaInicio(LocalDate.now().plusDays(10));
        torneo.registrarEnfrentamiento(enfrentamiento1);
        torneo.registrarEquipo(equipo4);
        torneo.registrarEquipo(equipo3);
        enfrentamiento1.registrarJuez(juez1);        
        Collection<Enfrentamiento> enfrentamientosJuez = torneo.listaJuezEnfrentamientos("12345");
        assertEquals(1, enfrentamientosJuez.size());
        System.out.println("Finalizando el test buscar enfrentamiento por licencia de juez");
    }

    @Test 
    public void estadoEnfrentamientoFinalizado(){
        System.out.println("Iniciando prueba enfrentamiento finalizado");
        Juez juez1 = new Juez("12345","Santiago","Guevara","santiagoG@gmail.com","3229882323");
        Torneo torneo = new  Torneo("Olimpiadas", LocalDate.now().plusDays(10), LocalDate.now().minusDays(5), LocalDate.now().plusDays(5), (byte)4, (byte)15, 5000, TipoTorneo.LOCAL, Genero.MIXTO,juez1);
        var representante2 = new Persona("Elkn", "Vidales", "234@gmail.com", "3145264879");
        var representante3 = new Persona("Juan", "Pablo", "345@hotmail.com", "3154895577");
        Equipo equipo3 = new Equipo("Tigres del Este", representante3,new LinkedList<>() ,GeneroEquipo.FEMENINO);
        Equipo equipo4 = new Equipo("Tigres del Oeste", representante2,new LinkedList<>(),GeneroEquipo.MASCULINO);
        var enfrentamiento1 = new Enfrentamiento("Juego Importante" ,"Armenia", LocalDate.now().plusDays(11), LocalDateTime.now(), equipo3, equipo4);
        torneo.registrarEnfrentamiento(enfrentamiento1);
        torneo.registrarEquipo(equipo4);
        torneo.registrarEquipo(equipo3);
        enfrentamiento1.registrarJuez(juez1);        
        torneo.finalizarEnfrentamiento((byte) 5, (byte)10, enfrentamiento1);
        assertTrue(torneo.getEnfrentamientos().contains(enfrentamiento1));
        assertEquals(Estado.FINALIZADO, enfrentamiento1.getEstado());
        assertEquals(1, enfrentamiento1.getEquipoLocal().getPerdidas());
        assertEquals(1, enfrentamiento1.getEquipoVisitante().getVictorias());
        System.out.println("Finalizando prueba enfrentamiento finalizado");
    }


}
