package Entrega2.Entrega2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Entrega2.Entrega2.models.Equipo;
import Entrega2.Entrega2.models.Partido;
import Entrega2.Entrega2.models.Pronostico;
import Entrega2.Entrega2.models.ResultadoEnum;
import Entrega2.Entrega2.models.Ronda;

public class App 
{
	public static void main(String[] args) throws FileNotFoundException {
        // Abrir el archivo CSV
    	String rutaArchivo = "C:\\Users\\Julio Tomas\\Desktop\\Entrega2,resultados-pronosticos\\resultados.csv";
        File archivo = new File(rutaArchivo);
    	
        Scanner scanner = new Scanner(archivo);           //Escanear el contenido

        scanner.nextLine();           //Ignoramos la primera linea
        int Numero = 1; 
        int puntos = 0;
        
        while (scanner.hasNextLine()) {              // el While Se ejecutara hasta que no haya mas lineas.
        	
            String linea = scanner.nextLine();           //Guardamos la linea a analizar en la variable linea
            String[] valores = linea.split(";");         //Dividimos su contenido usando como separador ;

            Equipo equipo1 = new Equipo(valores[1]);           //El primer equipo será la primer variable string
            Equipo equipo2 = new Equipo(valores[2]);           //El segundo equipo será la segunda variable string

            int golesEquipo1 = Integer.parseInt(valores[3]);   //Los goles del equipo 1 es la tercer variable de la linea
            int golesEquipo2 = Integer.parseInt(valores[4]);   //Los goles del equipo 2 es la cuarta variable de la linea
            
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
            		System.out.println(equipo1.getNombre() + " Perdió y " + equipo2.getNombre() + " Ganó "+ partido.getResultado());
            	}else {
            		System.out.println("Hubo empate entre " + equipo1.getNombre() + " y " + equipo2.getNombre() + " " + partido.getResultado());
            	}
        
            System.out.println("");
            Numero += 1;
            
            
            String rutaArchivo2 = "C:\\Users\\Julio Tomas\\Desktop\\Entrega2,resultados-pronosticos\\pronosticos.csv";
            File archivo2 = new File(rutaArchivo2);
            Scanner scanner2 = new Scanner(archivo2);
            scanner2.nextLine();
            
                String linea2 = scanner2.nextLine();
                String[] valores2 = linea2.split(";");
                Equipo equipoPronostico1 = equipo1;
                ResultadoEnum resultado = null;
                
                
                
                                        
            	if(valores2[3].equals("X")) {      //Encontramos la "X" para ver cual es el pronostico
            		
            		resultado = ResultadoEnum.GANADOR;               
            	}
            	if(valores2[4].equals("X")) {
            		
            		resultado = ResultadoEnum.PERDEDOR;
            	}
            	if(valores2[5].equals("X")) {
            		
            		resultado = ResultadoEnum.EMPATE;
            	}
            	Pronostico pronostico = new Pronostico(partido, equipoPronostico1, resultado);
            	
            	System.out.println("El Pronostico de Mariana de este partido es: " + pronostico.puntos() + "\n");
            	puntos += pronostico.puntos();
            	scanner2.close();
    }
        System.out.println("\nMariana acertó su pronostico unas "+ puntos + " veces \n");
        scanner.close();
        
        
        
        
        
     // Abrir el archivo CSV
    	String rutaArchivo3 = "C:\\Users\\Julio Tomas\\Desktop\\Entrega2,resultados-pronosticos\\resultados.csv";
        File archivo3 = new File(rutaArchivo3);
    	
        Scanner scanner3 = new Scanner(archivo3);           //Escanear el contenido

        scanner3.nextLine();
        int Numero2 = 5;
         
        int puntos3 = 0;
        
        while (scanner3.hasNextLine()) {              // el While Se ejecutara hasta que no haya mas lineas.
        	
            String linea = scanner3.nextLine();           //Guardamos la linea a analizar en la variable linea
            String[] valores = linea.split(";");         //Dividimos su contenido usando como separador ;
            Equipo equipo1 = new Equipo(valores[1]);           //El primer equipo será la primer variable string
            Equipo equipo2 = new Equipo(valores[2]);           //El segundo equipo será la segunda variable string

            int golesEquipo1 = Integer.parseInt(valores[3]);   //Los goles del equipo 1 es la tercer variable de la linea
            int golesEquipo2 = Integer.parseInt(valores[4]);   //Los goles del equipo 2 es la cuarta variable de la linea
            
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
            		System.out.println(equipo1.getNombre() + " Perdió y " + equipo2.getNombre() + " Ganó "+ partido.getResultado());
            	}else {
            		System.out.println("Hubo empate entre " + equipo1.getNombre() + " y " + equipo2.getNombre() + " " + partido.getResultado());
            	}
            
            System.out.println("");
            Numero2 += 1;
            
            
            
            String rutaArchivo4 = "C:\\Users\\Julio Tomas\\Desktop\\Entrega2,resultados-pronosticos\\pronosticos.csv";
            File archivo4 = new File(rutaArchivo4);
            Scanner scanner4 = new Scanner(archivo4);
            int numLineasIgnorar = 5;
            for (int i = 0; i < numLineasIgnorar; i++) {
                scanner4.nextLine();
            }
            
                String linea4 = scanner4.nextLine();
                String[] valores4 = linea4.split(";");
                Equipo equipoPronostico1 = equipo1;
                ResultadoEnum resultado = null;
                
                
                
                                        
            	if(valores4[3].equals("X")) {      //Encontramos la "X" para ver cual es el pronostico
            		
            		resultado = ResultadoEnum.GANADOR;               
            	}
            	if(valores4[4].equals("X")) {
            		
            		resultado = ResultadoEnum.PERDEDOR;
            	}
            	if(valores4[5].equals("X")) {
            		
            		resultado = ResultadoEnum.EMPATE;
            	}
            	Pronostico pronostico = new Pronostico(partido, equipoPronostico1, resultado);
            	
            	System.out.println("El Pronostico de Pedro de este partido es: " + pronostico.puntos() + "\n");
            	puntos3 += pronostico.puntos();
            	scanner4.close();
    }
        System.out.println("\nPedro acertó su pronostico unas "+ puntos3 + " veces \n");
        scanner3.close();
        
        
        int PuntosTotal = 0;
        
        System.out.println("Los puntos totales entre ambos son: " + (puntos+puntos3));
        
        
        }
	}
