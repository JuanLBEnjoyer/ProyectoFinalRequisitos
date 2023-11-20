package co.edu.uniquindio.poo.torneodeportivo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.LinkedList;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;


public class GeneroTest{
    @Test

    public void generoMasculino (){
        System.out.println("Inciando la prueba ");
        Jugador jugador = new Jugador("Carlitos","Cardenas","cCaardenas@gmail.com","2334445544",LocalDate.of(2000,7,23),GeneroJugador.MASCULINO);
        Jugador jugadora = new Jugador("Maria","Correa","Mcorrea123@gmail.com","1234456",LocalDate.of(1999,2,23),GeneroJugador.FEMENINO);

        assertEquals(GeneroJugador.MASCULINO,jugador.getGenero());
        assertEquals(GeneroJugador.FEMENINO,jugadora.getGenero());
        System.out.println("Finalizando la prueba");        
    }


    @Test
    public void validarGenero(){
        System.out.println("Inciando la prueba ");
        Juez juez = new Juez("12345678","Juan","Ramon","Jrgod@gmail.com","3224445454");
        Torneo torneo = new Torneo("Zucaritas",LocalDate.of(2025,10,19),LocalDate.now().minusDays(5),LocalDate.now().plusDays(5),(byte)15,(byte)20,2000,TipoTorneo.NACIONAL,Genero.MASCULINO,juez);
        Jugador jugador1 = new Jugador("Ramsen","Dust","Rmdust@gmail.com","34445344",LocalDate.of(2003,4,19),GeneroJugador.FEMENINO);
        Persona representante = new Persona("Alejandro","Torres","alejot@gmail.com","2134214214");
        Equipo equipo = new Equipo("Montenegro Sport",representante,new LinkedList<>(),GeneroEquipo.MASCULINO );
        equipo.registrarJugador(jugador1);
        assertThrows(Throwable.class, ()-> torneo.registrarEquipo(equipo));
        System.out.println("Finalizando la prueba");
    }

    @Test
    public void testValidarGenero(){
        System.out.println("Inciando la prueba ");        
        Juez juez = new Juez("12345678","Juan","Ramon","Jrgod@gmail.com","3224445454");        
        Torneo torneo = new Torneo("Zucaritas",LocalDate.of(2025,10,19),LocalDate.now().minusDays(5),LocalDate.now().plusDays(5),(byte)15,(byte)20,2000,TipoTorneo.NACIONAL,Genero.MASCULINO,juez);
        Jugador jugador1 = new Jugador("Ramsen","Dust","Rmdust@gmail.com","34445344",LocalDate.of(2003,4,19),GeneroJugador.FEMENINO);
        Persona representante = new Persona("Alejandro","Torres","alejot@gmail.com","2134214214");
        Equipo equipo = new Equipo("Montenegro Sport",representante,new LinkedList<>(),GeneroEquipo.MASCULINO );
        equipo.registrarJugador(jugador1);
        assertThrows(Throwable.class, () -> torneo.registrarEquipo(equipo));
        System.out.println("Finalizando la prueba");
    }
}
