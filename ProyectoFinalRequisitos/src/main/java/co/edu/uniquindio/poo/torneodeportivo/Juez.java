package co.edu.uniquindio.poo.torneodeportivo;

public record Juez(String licencia, String nombre, String apellido, String email, String numero){
    public Juez{
        assert licencia != null;
        assert nombre != null;
        assert apellido != null;
        assert email != null;
        assert numero != null;
    }
}