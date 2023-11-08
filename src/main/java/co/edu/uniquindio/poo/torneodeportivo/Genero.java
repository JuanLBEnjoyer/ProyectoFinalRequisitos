package co.edu.uniquindio.poo.torneodeportivo;

public enum Genero{
    FEMENINO{
        public boolean esValido(Jugador jugador){
            return jugador.getGenero().equals(FEMENINO);
        }}
    ,MASCULINO{
        public boolean esValido(Jugador jugador){
            return jugador.getGenero().equals(MASCULINO);
        }}    
    ,MIXTO{
        public boolean esValido(Jugador jugador){
            return jugador.getGenero().equals(FEMENINO)||jugador.getGenero().equals(MASCULINO);
        }
    };
    public abstract boolean esValido(Jugador jugador);
}
