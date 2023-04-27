package Entrega2.Entrega2.models;

public class Pronostico {
    private Partido partido;
    private Equipo equipo;
    private ResultadoEnum resultado;
    private int puntos;

    public Pronostico(Partido partido, Equipo equipo, ResultadoEnum resultado) { 
        this.partido = partido;               //Metodo para ingresar un pronostico
        this.equipo = equipo;                 
        this.resultado = resultado;          
    }                                     
    
    public boolean acertado() {
        return partido.resultado(equipo) == resultado;
    }
                                            // si el resultado de equipo es igual a resultado, se gana 1 punto.
    public int puntos() {
        if (acertado()) {
            puntos = 1;
        } else {
        	puntos = 0;
        }
        return puntos;
   }
}
