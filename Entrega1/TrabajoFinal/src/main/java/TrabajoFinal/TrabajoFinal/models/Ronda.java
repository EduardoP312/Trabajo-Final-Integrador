package TrabajoFinal.TrabajoFinal.models;

import java.util.ArrayList;

public class Ronda {
	private String numero;
    private ArrayList<Partido> partidos;

    public Ronda(String numero, Partido[] partidos) {  //Metodo para guardar los partidos en la ronda.
        this.numero = numero;
        this.partidos = new ArrayList<Partido>();
        for (Partido partido : partidos) {
            this.partidos.add(partido);
        }
    }
    
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public ArrayList<Partido> getPartidos() {
	    return partidos;
	}

	public void setPartidos(ArrayList<Partido> partidos) {
	    this.partidos = partidos;
	}
}

