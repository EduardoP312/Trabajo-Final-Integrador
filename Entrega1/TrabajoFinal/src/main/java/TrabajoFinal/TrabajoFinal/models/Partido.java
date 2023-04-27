package TrabajoFinal.TrabajoFinal.models;

public class Partido {
    private Equipo equipo1;
    private Equipo equipo2;                          //Los 2 equipos del partido y sus goles
    private int golesEquipo1;
    private int golesEquipo2;
    

    public Partido(Equipo equipo1, Equipo equipo2) {               //Agregar los 2 equipos al Partido
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
    }

    public Equipo getEquipo1() {
		return equipo1;
	}

	public void setEquipo1(Equipo equipo1) {
		this.equipo1 = equipo1;
	}                                                    //Getters and setters

	public Equipo getEquipo2() {
		return equipo2;
	}

	public void setEquipo2(Equipo equipo2) {
		this.equipo2 = equipo2;
	}

	public void setResultado(int golesEquipo1, int golesEquipo2) {  //El resultado del partido entre los 2 equipos
        this.golesEquipo1 = golesEquipo1;
        this.golesEquipo2 = golesEquipo2;
    }
	
	public String getResultado() {           //  Metodo solo para obtener de forma textual el resultado del Equipo
		return golesEquipo1 + " a " + golesEquipo2;
	}

    public ResultadoEnum resultado(Equipo equipo) {      //Metodo para obtener el resultado del partido
        if (equipo == equipo1) {                        
            if (golesEquipo1 > golesEquipo2) {
                return ResultadoEnum.GANADOR;            //Si en el parametro ponemos "equipo1" y sale ganador
            } else if (golesEquipo1 < golesEquipo2) {    // significa que el "equipo2" perdió.
                return ResultadoEnum.PERDEDOR;
            } else {
                return ResultadoEnum.EMPATE;
            }
        } else if (equipo == equipo2) {
            if (golesEquipo2 > golesEquipo1) {
                return ResultadoEnum.GANADOR;
            } else if (golesEquipo2 < golesEquipo1) {
                return ResultadoEnum.PERDEDOR;
            } else {
                return ResultadoEnum.EMPATE;
            }
        } else {
            return null;
        }
    }
}

