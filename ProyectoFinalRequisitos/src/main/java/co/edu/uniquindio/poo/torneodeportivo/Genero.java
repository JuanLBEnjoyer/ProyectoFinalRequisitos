package co.edu.uniquindio.poo.torneodeportivo;

public enum Genero{
    FEMENINO{
        public boolean esValido(Equipo equipo){
            return equipo.getGenero().equals(GeneroEquipo.FEMENINO);
        }}
    ,MASCULINO{
        public boolean esValido(Equipo equipo){
            return equipo.getGenero() == GeneroEquipo.MASCULINO;
        }}    
    ,MIXTO{
        public boolean esValido(Equipo equipo){       
            boolean unaMujer = false;
            boolean unHombre = false;
        for(Jugador jugador : equipo.getJugadores()){
            if (jugador.getGenero() == GeneroJugador.FEMENINO){
                unaMujer = true;
            }
            if(jugador.getGenero() == GeneroJugador.MASCULINO){
                unHombre = true;
            }
            if(unHombre && unaMujer){
                return true;
            }

        }
        return false;
        }
    };
    public abstract boolean esValido(Equipo equipo);
}
