package ar.edu.unlam.pb1.parcial2;

import java.util.Arrays;

public class EquipoDeFutbol {
	private String nombre;
	private Jugador jugadoresTitulares[];
	private Jugador jugadoresSuplentes[];
	private final int CAPACIDAD_JUGADORES_MAXIMA_EQUIPO = 5;
	
	
	public EquipoDeFutbol(String nombre) {
		this.nombre = nombre;
		this.jugadoresTitulares = new Jugador[CAPACIDAD_JUGADORES_MAXIMA_EQUIPO];
		this.jugadoresSuplentes = new Jugador[CAPACIDAD_JUGADORES_MAXIMA_EQUIPO];
	}

	/*
	 * La capacidad m�xima de un equipo es 5. No se permiten jugadores repetidos (ya sea el n�mero o nombre del jugador)
	 * Se retorna el resultado de la operaci�n
	 */
	public boolean agregarJugador(Jugador nuevo) {
		boolean resultado = false ;
		String nombreJugador = nuevo.getNombre();
		int numeroJugador = nuevo.getNumero();
		int i = 0;
		for(i = 0;i<jugadoresTitulares.length;i++) {
			if(jugadoresTitulares[i] == null && buscar(nombreJugador)== null && buscar(numeroJugador) == null ) {
				jugadoresTitulares[i] = nuevo;
				resultado = true;
				return resultado;
				}
     	}
	
		return resultado;
	}
	
	public boolean agregarJugadorSuplente(Jugador nuevo) {
		boolean resultado = false ;
		String nombreJugador = nuevo.getNombre();
		int numeroJugador = nuevo.getNumero();
		int i = 0;
		for(i = 0;i<jugadoresSuplentes.length;i++) {
			if(jugadoresSuplentes[i] == null && buscar(nombreJugador)== null && buscar(numeroJugador) == null ) {
				jugadoresSuplentes[i] = nuevo;
				resultado = true;
				return resultado;
				}
     	}
	
		return resultado;
	}
	
	/*
	 * Permite buscar un jugador por su numero. 
	 * 
	 */
	public Jugador buscar(int numero) {
		Jugador resultado = null;
		for(int i = 0;i<jugadoresTitulares.length;i++) {
			if(jugadoresTitulares[i]!=null && jugadoresTitulares[i].getNumero()==numero) {
				resultado = jugadoresTitulares[i];
				return resultado;
			}
		}
		
		for(int i = 0;i<jugadoresSuplentes.length;i++) {
			if(jugadoresSuplentes[i]!=null && jugadoresSuplentes[i].getNumero()==numero) {
				resultado = jugadoresSuplentes[i];
				return resultado;
			}
		}
		
		return resultado;
	}
	
	/*
	 * Permite buscar un jugador por su nombre. 
	 * 
	 */
	public Jugador buscar(String nombre) {
		Jugador resultado = null;
		for(int i = 0;i<jugadoresTitulares.length;i++) {
			if(jugadoresTitulares[i]!=null && jugadoresTitulares[i].getNombre().equals(nombre)) {
				resultado = jugadoresTitulares[i];
				return resultado;
			}
		}
		
		for(int i = 0;i<jugadoresSuplentes.length;i++) {
			if(jugadoresSuplentes[i]!=null && jugadoresSuplentes[i].getNombre().equals(nombre)) {
				resultado = jugadoresSuplentes[i];
				return resultado;
			}
		}
		return resultado;
	}
	
	/*
	 * Calcula el valor del equipo. 
	 * 
	 */
	public double calcularLaEdadPromedioDelEquipo() {
		double edadPromedio = 0;
		int cantidadDeJugadores = 0;
		double sumaDeEdades = 0;
		int i = 0;
		for(i = 0;i<jugadoresTitulares.length;i++) {
			if(jugadoresTitulares[i]!= null) {
				cantidadDeJugadores++;
			}
		}
		i = 0;
		for(i = 0;i<jugadoresTitulares.length;i++) {
			if(jugadoresTitulares[i]!=null) {
			sumaDeEdades+= jugadoresTitulares[i].getEdad();
			}
		}
		edadPromedio = sumaDeEdades / cantidadDeJugadores;
		return edadPromedio;

	}
	
	/*
	 * Calcula el valor del equipo
	 * 
	 */
	public double calcularElValorDelEquipo() {
		double valorTotalDelEquipo = 0;
		for(int i = 0;i<jugadoresTitulares.length;i++) {
			if(jugadoresTitulares[i]!=null) {
			valorTotalDelEquipo+= jugadoresTitulares[i].getPrecio();
			}
		}
		for(int i = 0;i<jugadoresSuplentes.length;i++) {
			if(jugadoresSuplentes[i]!=null) {
			valorTotalDelEquipo+= jugadoresSuplentes[i].getPrecio();
			}
		}
		return valorTotalDelEquipo;
	}


//	public String toString() {
//		return this.nombre;
//	}
	

	@Override
	public String toString() {
		return "Equipo : " + nombre + "\n Jugadores Titulares=" + Arrays.toString(jugadoresTitulares)
				+ "\n Jugadores Suplentes=" + Arrays.toString(jugadoresSuplentes) + "]";
	}

	public Jugador[] getJugadoresTitulares() {
		return jugadoresTitulares;
	}
	
	public Jugador[] getJugadoresSuplentes() {
		return jugadoresSuplentes;
	}
	
	public String getNombre() {
		return nombre;
	}
	

	
}
