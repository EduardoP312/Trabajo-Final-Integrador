package TrabajoFinal.TrabajoFinal;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import TrabajoFinal.TrabajoFinal.models.Equipo;
import TrabajoFinal.TrabajoFinal.models.Partido;
import TrabajoFinal.TrabajoFinal.models.Pronostico;
import TrabajoFinal.TrabajoFinal.models.ResultadoEnum;
import TrabajoFinal.TrabajoFinal.models.Ronda;

public class App {
    public static void main(String[] args) throws FileNotFoundException {
        // Abrir el archivo CSV
    	String rutaArchivo = "C:\\Users\\Julio Tomas\\Desktop\\TrabajoIntegrador\\resultado.csv";
        File archivo = new File(rutaArchivo);
    	
        Scanner scanner = new Scanner(archivo);           //Escanear el contenido

        scanner.nextLine();           //Ignoramos la primera linea
        int Numero = 1; 
        int puntos = 0;
        
        while (scanner.hasNextLine()) {              // el While Se ejecutara hasta que no haya mas lineas.
        	
            String linea = scanner.nextLine();           //Guardamos la linea a analizar en la variable linea
            String[] valores = linea.split(";");         //Dividimos su contenido usando como separador ;

            Equipo equipo1 = new Equipo(valores[0]);           //El primer equipo será la primer variable string
            Equipo equipo2 = new Equipo(valores[1]);           //El segundo equipo será la segunda variable string

            int golesEquipo1 = Integer.parseInt(valores[2]);   //Los goles del equipo 1 es la tercer variable de la linea
            int golesEquipo2 = Integer.parseInt(valores[3]);   //Los goles del equipo 2 es la cuarta variable de la linea
            
            Partido partido = new Partido(equipo1, equipo2);   //Creamos el nuevo partido con sus 2 equipos.
            partido.setResultado(golesEquipo1, golesEquipo2);  //Se asigna el resultado del partido

            ResultadoEnum resultadoEquipo1 = partido.resultado(equipo1); //Obtenemos el Ganador, Perdedor, o si es Empate.
            
            Ronda ronda1 = new Ronda("Ronda 1", new Partido[] {partido});         
            System.out.println(" |Partido Numero "+ Numero +" De la " + ronda1.getNumero() + "|:");
            for (Partido partidov1 : ronda1.getPartidos()) {                                          //Codigo solo para mostrar el inicio del partido
                System.out.println(partido.getEquipo1().getNombre() + " vs " + partido.getEquipo2().getNombre());
            }
        
            if(resultadoEquipo1 == ResultadoEnum.GANADOR) {       //A partir de aqui solo decimos el resultado y el puntaje del partido
            	System.out.println(equipo1.getNombre() + " Ganó y " + equipo2.getNombre() + " Perdió " + partido.getResultado());
            }
            	else if(resultadoEquipo1 == ResultadoEnum.PERDEDOR) {
            		System.out.println(equipo1.getNombre() + "Perdió y " + equipo2.getNombre() + " Ganó"+ partido.getResultado());
            	}else {
            		System.out.println("Hubo empate entre " + equipo1.getNombre() + " y " + equipo2.getNombre() + " " + partido.getResultado());
            	}
        
            System.out.println("");
            Numero += 1;
                                                   //A partir de aqui empezamos a leer el archivo pronostico.csv
            String rutaArchivo2 = "C:\\Users\\Julio Tomas\\Desktop\\TrabajoIntegrador\\pronostico.csv";
            File archivo2 = new File(rutaArchivo2);
            Scanner scanner2 = new Scanner(archivo2);
            scanner2.nextLine();
            
                String linea2 = scanner2.nextLine();
                String[] valores2 = linea2.split(";");
                Equipo equipoPronostico1 = equipo1;
                ResultadoEnum resultado = null;
                
                
                
                                        
            	if(valores2[2].equals("X")) {      //Encontramos la "X" para ver cual es el pronostico
            		
            		resultado = ResultadoEnum.GANADOR;               
            	}
            	if(valores2[3].equals("X")) {
            		
            		resultado = ResultadoEnum.PERDEDOR;
            	}
            	if(valores2[4].equals("X")) {
            		
            		resultado = ResultadoEnum.EMPATE;
            	}
            	Pronostico pronostico = new Pronostico(partido, equipoPronostico1, resultado);
            	
            	System.out.println("El Pronostico de este partido es: " + pronostico.puntos() + "\n");
            	puntos += pronostico.puntos();
            	scanner2.close();
    }
        System.out.println("\nEl puntaje total del pronostico es: "+ puntos);
        scanner.close();
        
    }
}


 
