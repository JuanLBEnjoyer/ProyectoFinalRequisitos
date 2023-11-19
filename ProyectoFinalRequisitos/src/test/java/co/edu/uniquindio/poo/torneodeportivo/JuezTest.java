package co.edu.uniquindio.poo.torneodeportivo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class JuezTest {
    @Test
    public void datosCompletos(){
        System.out.println("Iniciando prueba datos completos");
        Juez juez = new Juez("1525", "Juan", "Perez", "1234@hotmail.com", "3154759485");
        assertEquals("1525", juez.licencia());
        assertEquals("Juan", juez.nombre());
        assertEquals("Perez", juez.apellido());
        assertEquals("1234@hotmail.com", juez.email());
        assertEquals("3154759485", juez.numero());
        System.out.println("Finalizando prueba datos completos");
    }
    
    @Test 
    public void datosNulos(){
        System.out.println("Iniciando prueba datos nulos");
        assertThrows(Throwable.class, () -> new Juez(null, null, null, null, null));
        System.out.println("Finalizando prueba datos nulos");
    }
}
