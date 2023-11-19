package co.edu.uniquindio.poo.torneodeportivo;

public enum GeneroEquipo {
    FEMENINO{
        public boolean esValido(Jugador jugador){
            return jugador.getGenero() == GeneroJugador.FEMENINO;
        }
    },
    MASCULINO{
        public boolean esValido(Jugador jugador){
            return jugador.getGenero() == GeneroJugador.MASCULINO;
        }
    };

    public abstract boolean esValido(Jugador jugador);
}
