
package ar.edu.unlam.pb1.parcial2;

import java.util.Scanner;

public class InterfazDeUnPartido {
	
	private static final int  PRECARGAR_EQUIPOS_PRUEBA = 0, AGREGUAR_NUEVOS_JUGADORES = 1, CALCULAR_EL_VALOR_DE_UN_EQUIPO = 2, CALCULAR_LA_EDAD_PROMEDIO = 3, CREAR_UN_PARTIDO = 4, REGISTRAR_UN_GOL = 5, AMONESTAR = 6, EXPULSAR = 7, CAMBIOJUGADOR = 8, VER_EL_RESUMEN = 9, FINALIZAR_PARTIDO = 10;
		
	public static void main(String args[]) {	
		EquipoDeFutbol inscriptosAlTorneo[] = obtenerEquiposDeFutbolDisponibles();
		PartidoDeFutbol actual = null;
		int opcionIngresada;
		Scanner teclado = new Scanner(System.in);
				
		System.out.println("Bienvenido al sistema para la gestion de un partido de futbol desarrollado por la Unlam");
	
		do {
			mostrarMenu();
			opcionIngresada = teclado.nextInt();
			actual = determinarAccionARealizar(inscriptosAlTorneo, actual, opcionIngresada, teclado);
			}while (opcionIngresada!=10);
	}
	
	private static void mostrarMenu() {
		System.out.println("*************************************************");
		System.out.println("Menu de opciones\n*************************************************");
		System.out.println(PRECARGAR_EQUIPOS_PRUEBA + " -  Precargar equipos de prueba");
		System.out.println(AGREGUAR_NUEVOS_JUGADORES + " -  Agregar un nuevo jugador a un equipo");
		System.out.println(CALCULAR_EL_VALOR_DE_UN_EQUIPO + "  - Calcular el valor de un equipo ");
		System.out.println(CALCULAR_LA_EDAD_PROMEDIO + "  - Calcular la edad promedio de un equipo");
		System.out.println(CREAR_UN_PARTIDO + "  - Crear nuevo partido");
		System.out.println(REGISTRAR_UN_GOL + "  - Regitrar nuevo gol");
		System.out.println(AMONESTAR + "  - Amonestar a un jugador");
		System.out.println(EXPULSAR + "  - Expulsar a un jugador");
		System.out.println(CAMBIOJUGADOR + "  - Sustituir a un jugador");
		System.out.println(VER_EL_RESUMEN + "  - Ver resumen del partido");
		System.out.println(FINALIZAR_PARTIDO + " - Finalizar partido y ver resumen final");
		System.out.println("******************************************");
	}

	private static PartidoDeFutbol determinarAccionARealizar(EquipoDeFutbol[] inscriptosAlTorneo,
			PartidoDeFutbol actual, int opcionIngresada, Scanner teclado) {
		
		switch(opcionIngresada) {
			case PRECARGAR_EQUIPOS_PRUEBA:
			    precargarJugadoresDePrueba(teclado, inscriptosAlTorneo);
			break;
			case AGREGUAR_NUEVOS_JUGADORES:
				agregarNuevoJugador(teclado, inscriptosAlTorneo);
				break;
			case CALCULAR_EL_VALOR_DE_UN_EQUIPO:
				calcularElValorDeUnEquipo(teclado, inscriptosAlTorneo);
				break;
			case CALCULAR_LA_EDAD_PROMEDIO:
				calcularLaEdadPromedioDeUnEquipo(teclado, inscriptosAlTorneo);
				break;
			case CREAR_UN_PARTIDO:
				actual = crearUnNuevoPartido(teclado, inscriptosAlTorneo);
				break;
			case REGISTRAR_UN_GOL:
				if(verificaQueElPartidoHayaSidoCreado(actual)) {
					registrarUnGol(teclado, actual);
					System.out.println("Resultado Parcial "+actual.getResultado());
				}
				break;
			case AMONESTAR:
				if(verificaQueElPartidoHayaSidoCreado(actual)) {
					amonestarAUnJugador(teclado, actual);
				}
				break;
			case EXPULSAR:
				if(verificaQueElPartidoHayaSidoCreado(actual)) {
					expulsarAUnJugador(teclado, actual);
				}
				break;
			case CAMBIOJUGADOR:
				if(verificaQueElPartidoHayaSidoCreado(actual)) {
					cambioDeJugador(teclado, actual);
				}
				break;	
			case VER_EL_RESUMEN:
				if(verificaQueElPartidoHayaSidoCreado(actual)) {
					verElResumenDelPartido(teclado, actual);
				}
				break;	
			case FINALIZAR_PARTIDO:
				actual.setMinutoDeJuego(90);
				System.out.println("Resultado Final "+actual.getResultado());
				break;
			}
		return actual;
	}
	
	private static void precargarJugadoresDePrueba(Scanner teclado, EquipoDeFutbol[] inscriptosAlTorneo) {
		// River titulares
				Jugador nuevo = new Jugador(1, "Franco Armani", 36, 150000);
				inscriptosAlTorneo[22].agregarJugador(nuevo);
				Jugador nuevo1 = new Jugador(3, "Milton Casco", 35, 350000);
				inscriptosAlTorneo[22].agregarJugador(nuevo1);
				Jugador nuevo2 = new Jugador(4, "Emanuel Mammana", 27, 400000);
				inscriptosAlTorneo[22].agregarJugador(nuevo2);
				Jugador nuevo3 = new Jugador(10, "Enzo Perez", 37, 350000);
				inscriptosAlTorneo[22].agregarJugador(nuevo3);
				Jugador nuevo4 = new Jugador(9, "Lucas Beltran", 22, 550000);
				inscriptosAlTorneo[22].agregarJugador(nuevo4);
				//River suplentes
				Jugador nuevoS1 = new Jugador(7, "Gonzalez Pirez", 31, 250000);
				inscriptosAlTorneo[22].agregarJugadorSuplente(nuevoS1);
				Jugador nuevoS2 = new Jugador(8, "Paulo Diaz", 28, 350000);
				inscriptosAlTorneo[22].agregarJugadorSuplente(nuevoS2);
				Jugador nuevoS3 = new Jugador(15, "Suplente3", 40, 150000);
				inscriptosAlTorneo[22].agregarJugadorSuplente(nuevoS3);
				Jugador nuevoS4 = new Jugador(16, "Suplente4", 40, 150000);
				inscriptosAlTorneo[22].agregarJugadorSuplente(nuevoS4);
				Jugador nuevoS5 = new Jugador(17, "Suplente5", 40, 150000);
				inscriptosAlTorneo[22].agregarJugadorSuplente(nuevoS5);
				// boca titulares
				Jugador nuevo5 = new Jugador(1, "Sergio Romero", 36, 300000);
				inscriptosAlTorneo[1].agregarJugador(nuevo5);
				Jugador nuevo6 = new Jugador(3, "Jorge Figal", 29, 550000);
				inscriptosAlTorneo[1].agregarJugador(nuevo6);
				Jugador nuevo7 = new Jugador(4, "Marcelo Weigandt", 23, 500000);
				inscriptosAlTorneo[1].agregarJugador(nuevo7);
				Jugador nuevo8 = new Jugador(5, "Valentin Barco", 19, 650000);
				inscriptosAlTorneo[1].agregarJugador(nuevo8);
				Jugador nuevo9 = new Jugador(9, "Luca Langoni", 21, 650000);
				inscriptosAlTorneo[1].agregarJugador(nuevo9);
				//Boca suplentes
				Jugador nuevoS6 = new Jugador(7, "Suplente1", 40, 150000);
				inscriptosAlTorneo[1].agregarJugadorSuplente(nuevoS6);
				Jugador nuevoS7 = new Jugador(8, "Suplente2", 40, 150000);
				inscriptosAlTorneo[1].agregarJugadorSuplente(nuevoS7);
				Jugador nuevoS8 = new Jugador(15, "Suplente3", 40, 150000);
				inscriptosAlTorneo[1].agregarJugadorSuplente(nuevoS8);
				Jugador nuevoS9 = new Jugador(16, "Suplente4", 40, 150000);
				inscriptosAlTorneo[1].agregarJugadorSuplente(nuevoS9);
				Jugador nuevoS10 = new Jugador(17, "Suplente5", 40, 150000);
				inscriptosAlTorneo[1].agregarJugadorSuplente(nuevoS10);
				// sanlobe titulares
				Jugador nuevo10 = new Jugador(1, "Augusto Batalla", 27, 400000);
				inscriptosAlTorneo[9].agregarJugador(nuevo10);
				Jugador nuevo11 = new Jugador(3, "Federico Gattoni", 24, 450000);
				inscriptosAlTorneo[9].agregarJugador(nuevo11);
				Jugador nuevo12 = new Jugador(4, "Gaston Hernandez", 25, 450000);
				inscriptosAlTorneo[9].agregarJugador(nuevo12);
				Jugador nuevo13 = new Jugador(5, "Malcom Braida", 26, 450000);
				inscriptosAlTorneo[9].agregarJugador(nuevo13);
				Jugador nuevo14 = new Jugador(10, "Andrés Vombergar", 28, 650000);
				inscriptosAlTorneo[9].agregarJugador(nuevo14);
				// sanlobe suplentes
				Jugador nuevo16 = new Jugador(7, "Suplente1", 40, 150000);
				inscriptosAlTorneo[9].agregarJugadorSuplente(nuevo16);
				Jugador nuevoS12 = new Jugador(8, "Suplente2", 40, 150000);
				inscriptosAlTorneo[9].agregarJugadorSuplente(nuevoS12);
				Jugador nuevoS13= new Jugador(15, "Suplente3", 40, 150000);
				inscriptosAlTorneo[9].agregarJugadorSuplente(nuevoS13);
				Jugador nuevoS14= new Jugador(16, "Suplente4", 40, 150000);
				inscriptosAlTorneo[9].agregarJugadorSuplente(nuevoS14);
				Jugador nuevoS15 = new Jugador(17, "Suplente5", 40, 150000);
				inscriptosAlTorneo[9].agregarJugadorSuplente(nuevoS15);
				// velez titular
				Jugador nuevo17 = new Jugador(1, "Gaston Gomez", 27, 400000);
				inscriptosAlTorneo[6].agregarJugador(nuevo17);
				Jugador nuevo18 = new Jugador(3, "Valentin Gomez", 19, 450000);
				inscriptosAlTorneo[6].agregarJugador(nuevo18);
				Jugador nuevo19 = new Jugador(4, "Lautraro Gianetti", 29, 350000);
				inscriptosAlTorneo[6].agregarJugador(nuevo19);
				Jugador nuevo20 = new Jugador(9, "Lucas Janson", 28, 450000);
				inscriptosAlTorneo[6].agregarJugador(nuevo20);
				Jugador nuevo21 = new Jugador(10, "Gianluca Prestianni", 18, 550000);
				inscriptosAlTorneo[6].agregarJugador(nuevo21);
				// velez suplentes
				Jugador nuevoS16 = new Jugador(7, "Suplente1", 40, 150000);
				inscriptosAlTorneo[6].agregarJugadorSuplente(nuevoS16);
				Jugador nuevoS17 = new Jugador(8, "Suplente2", 40, 150000);
				inscriptosAlTorneo[6].agregarJugadorSuplente(nuevoS17);
				Jugador nuevoS18 = new Jugador(15, "Suplente3", 40, 150000);
				inscriptosAlTorneo[6].agregarJugadorSuplente(nuevoS18);
				Jugador nuevoS19 = new Jugador(16, "Suplente4", 40, 150000);
				inscriptosAlTorneo[6].agregarJugadorSuplente(nuevoS19);
				Jugador nuevoS20 = new Jugador(17, "Suplente5", 40, 150000);
				inscriptosAlTorneo[6].agregarJugadorSuplente(nuevoS20);
				
				System.out.println(" Precarga "+inscriptosAlTorneo[22].toString());
				System.out.println(" Precarga "+inscriptosAlTorneo[1].toString());
				System.out.println(" Precarga "+inscriptosAlTorneo[6].toString());
				System.out.println(" Precarga "+inscriptosAlTorneo[9].toString());
		
	}

	private static void cambioDeJugador(Scanner teclado, PartidoDeFutbol actual) {
		int minutos;
		EquipoDeFutbol equipoQueHaceCambio;
		Jugador jugadorQueSale,jugadorQueIngresa;
		System.out.println("*********************");
		System.out.println("**CAMBIO DE JUGADOR**");
		System.out.println("*********************");
		
		equipoQueHaceCambio = seleccionarEquipo(teclado, actual);
		System.out.println("Jugador que sale del campo de juego: ");
		jugadorQueSale = seleccionarJugador(teclado, equipoQueHaceCambio);
		System.out.println("Jugador que ingresa al campo de juego: ");
		jugadorQueIngresa = seleccionarJugador(teclado, equipoQueHaceCambio);
		minutos = ingresarMinutos(teclado, actual);
		System.out.println(jugadorQueSale.toString());
		System.out.println(jugadorQueIngresa.toString());
			if(actual.realizarCambio(jugadorQueSale, jugadorQueIngresa, equipoQueHaceCambio, minutos) == true) {
				System.out.println("******************************");
				System.out.println("**CAMBIO DE JUGADOR EXITOSO***");				
				System.out.println("\n Resultado Parcial "+actual.getResultado());
				System.out.println("******************************");
			} else {
				System.out.println("***********************************");
				System.out.println("**CAMBIO DE JUGADOR NO REALIZADO***");
				System.out.println("\n Resultado Parcial "+actual.getResultado());
				System.out.println("***********************************");
			}	
	}

	private static void agregarNuevoJugador(Scanner teclado, EquipoDeFutbol inscriptos[]) {
		int equipoSeleccionado = 0;
		int tipoDeJugador = 0;
		int numero;
		String nombre;
		int edad;
		double precio;
		boolean cargaFinalizada = false;
		listarLosEquiposInscriptos();
		equipoSeleccionado = seleccionarEquipoDeseado(teclado); 
		do {
		System.out.println("***Tipo de jugador que desea agregar****");
		System.out.println("***1. Ingresar jugador titular *********");
		System.out.println("***2. Ingresar jugador suplente ********");
		System.out.println("***3. Finalizar ingreso de jugador******");
		tipoDeJugador = teclado.nextInt(); 
				if (tipoDeJugador == 1) {
					System.out.println("Ingrese el nombre del jugador");                      
					nombre = teclado.next();
					System.out.println("Ingrese el numero del jugador");
					numero = teclado.nextInt();
					System.out.println("Ingrese la edad del jugador");
					edad = teclado.nextInt();
					System.out.println("Ingrese el precio del jugador");
					precio = teclado.nextDouble();
					Jugador nuevo = new Jugador(numero, nombre, edad, precio);
					inscriptos[equipoSeleccionado].agregarJugador(nuevo);
					cargaFinalizada = true;
				} else if (tipoDeJugador == 2)  {
					System.out.println("Ingrese el nombre del jugador");                      
					nombre = teclado.next();
					System.out.println("Ingrese el numero del jugador");
					numero = teclado.nextInt();
					System.out.println("Ingrese la edad del jugador");
					edad = teclado.nextInt();
					System.out.println("Ingrese el precio del jugador");
					precio = teclado.nextDouble();
					Jugador nuevo = new Jugador(numero, nombre, edad, precio);
					inscriptos[equipoSeleccionado].agregarJugadorSuplente(nuevo);
					cargaFinalizada = true; 
					} else {
					cargaFinalizada = false;
					}
				} while (cargaFinalizada != true && tipoDeJugador != 3);
		
		
	}
	

	private static void calcularElValorDeUnEquipo(Scanner teclado, EquipoDeFutbol[] inscriptosAlTorneo) {
		int equipoSeleccionado = 0;	
		
		System.out.println("***************");
		System.out.println("Calculo del valor de un equipo");
		System.out.println("***************");
		
		listarLosEquiposInscriptos();
		equipoSeleccionado = seleccionarEquipoDeseado(teclado); 
		
		System.out.println("El valor del equipo es: " + inscriptosAlTorneo[equipoSeleccionado].calcularElValorDelEquipo());
	}
	
	private static boolean verificaQueElPartidoHayaSidoCreado(PartidoDeFutbol actual) {
		boolean resultado = false;
		if(actual==null) {
			System.out.println("El partido no ha sido creado a�n");
		}
		else {
			resultado = true;
		}
		return resultado;
	}
	
	private static void calcularLaEdadPromedioDeUnEquipo(Scanner teclado, EquipoDeFutbol[] inscriptosAlTorneo) {
		int equipoSeleccionado = 0;	
		
		System.out.println("***************");
		System.out.println("Calculo de la edad promedio");
		System.out.println("***************");
		
		listarLosEquiposInscriptos();
		equipoSeleccionado = seleccionarEquipoDeseado(teclado); 
		
		System.out.println("El valor del equipo es: " + inscriptosAlTorneo[equipoSeleccionado].calcularLaEdadPromedioDelEquipo());	
	}

    private static PartidoDeFutbol crearUnNuevoPartido(Scanner teclado, EquipoDeFutbol[] inscriptosAlTorneo) {
		
		int equipoSeleccionado = 0;	
		EquipoDeFutbol local, visitante;
		PartidoDeFutbol nuevo;
		
		System.out.println("***************");
		System.out.println("Nuevo partido");
		System.out.println("***************");
		
		System.out.println("Seleccione al local");
		listarLosEquiposInscriptos();
		equipoSeleccionado = seleccionarEquipoDeseado(teclado); 
		local = inscriptosAlTorneo[equipoSeleccionado];
		
		System.out.println("Seleccione al visitante");
		listarLosEquiposInscriptos();
		equipoSeleccionado = seleccionarEquipoDeseado(teclado); 
		visitante = inscriptosAlTorneo[equipoSeleccionado];
		
		nuevo = new PartidoDeFutbol(local, visitante);
		
		System.out.println("El partido fue creado correctamente");
		System.out.println("El partido ah comenzado "+nuevo.getResultado());
		if(nuevo.alineacionEstaCompleta(local,visitante)) {
		nuevo.mostrarAlineacion(local,visitante);
		}else {
		System.out.println(local.toString());
		System.out.println(visitante.toString());
		}
		return nuevo;
	}

	private static void registrarUnGol(Scanner teclado, PartidoDeFutbol actual) {
		int minutos, tipoDeGol;
		EquipoDeFutbol equipoQueMarcoElGol;
		Jugador jugadorQueMarcoElGol;
		Evento gol;
		
		System.out.println("***************");
		System.out.println("Nuevo gol!");
		System.out.println("***************");
		
		equipoQueMarcoElGol = seleccionarEquipo(teclado, actual);
		jugadorQueMarcoElGol = seleccionarJugador(teclado, equipoQueMarcoElGol);
		minutos = ingresarMinutos(teclado, actual);
		System.out.println(" Tipo de Gol (1 - A Favor | 2 - En contra");
		tipoDeGol = teclado.nextInt();
		
		if(tipoDeGol == 1) {
			gol = new Evento(minutos, jugadorQueMarcoElGol, TipoDeEvento.GOL_A_FAVOR);
		}
		else {
			gol = new Evento(minutos, jugadorQueMarcoElGol, TipoDeEvento.GOL_EN_CONTRA);
		}
		
		
		actual.marcar(gol);
	}
	
	private static void amonestarAUnJugador(Scanner teclado, PartidoDeFutbol actual) {
		int minutos, cantidadDeAmonestaciones;
		EquipoDeFutbol equipoQueRecibeLaAmonestacion;
		Jugador jugadorQueSeAmonesta;
		Evento amonestacion;
		
		System.out.println("***************");
		System.out.println("Nueva amonestacion");
		System.out.println("***************");
		
		equipoQueRecibeLaAmonestacion = seleccionarEquipo(teclado, actual);
		jugadorQueSeAmonesta = seleccionarJugador(teclado, equipoQueRecibeLaAmonestacion);
		minutos = ingresarMinutos(teclado, actual);
		
		amonestacion = new Evento(minutos, jugadorQueSeAmonesta, TipoDeEvento.AMONESTACION);
		
		cantidadDeAmonestaciones = actual.amonestar(amonestacion);
		
		if(cantidadDeAmonestaciones == 1) {
			System.out.println("Se amonesto al jugador " + jugadorQueSeAmonesta.getNombre());
		}
		else {
			System.out.println("Se expulso al jugador " + jugadorQueSeAmonesta.getNombre());
		}
	}
	
	private static void expulsarAUnJugador(Scanner teclado, PartidoDeFutbol actual) {
		int minutos;
		EquipoDeFutbol equipoQueRecibeLaExpulsion;
		Jugador jugadorQueSeExpulsa;
		Evento expulsion;
		
		System.out.println("***************");
		System.out.println("Nueva expulsi�n");
		System.out.println("***************");
		
		equipoQueRecibeLaExpulsion = seleccionarEquipo(teclado, actual);
		jugadorQueSeExpulsa = seleccionarJugador(teclado, equipoQueRecibeLaExpulsion);
		minutos = ingresarMinutos(teclado, actual);
		
		expulsion = new Evento(minutos, jugadorQueSeExpulsa, TipoDeEvento.EXPULSION);
		actual.expulsar(expulsion);
		
		System.out.println("El jugador fue expulsado");		
	}

	private static void verElResumenDelPartido(Scanner teclado, PartidoDeFutbol actual) {
		System.out.println("***************");
		System.out.println("El resumen del partido llega a usted gracias a Iveco");
		System.out.println("***************");
		
		System.out.println(actual);
		
		System.out.println("\n Resultado Parcial "+actual.getResultado());
		
		
	}

	private static int ingresarMinutos(Scanner teclado , PartidoDeFutbol actual) {
		int minutos;
		do {
			System.out.println("*** Tiempo actual de Juego : "+actual.getMinutoDeJuego()+" minutos.");
			System.out.println("Ingrese los minutos: ");
			minutos = teclado.nextInt();
		} while (!(minutos > 0 && minutos < 90 && minutos>actual.getMinutoDeJuego()));
		return minutos;
	}

	private static Jugador seleccionarJugador(Scanner teclado, EquipoDeFutbol equipoBuscado) {
		int jugador;
		Jugador buscado;
		do {
			System.out.println("Ingrese el n�mero de jugador");
			jugador = teclado.nextInt();
			buscado = equipoBuscado.buscar(jugador);
		} while(buscado == null);
		
		return buscado;
	}

	private static EquipoDeFutbol seleccionarEquipo(Scanner teclado, PartidoDeFutbol actual) {
		int equipo;
		EquipoDeFutbol equipoBuscado;
		do {
			System.out.println("Ingrese el equipo");
			System.out.println("1 - Local (" + actual.getLocal() + ")");
			System.out.println("2 - Visitante (" + actual.getVisitante() + ")");
			equipo = teclado.nextInt();
		} while(equipo!=1 && equipo!= 2);
		if(equipo==1) {
			equipoBuscado = actual.getLocal();
		}
		else {
			equipoBuscado = actual.getVisitante();
		}
		return equipoBuscado;
	}

	private static int seleccionarEquipoDeseado(Scanner teclado) {
		int equipoSeleccionado;
		do {
			System.out.println("Ingrese el equipo deseado: ");
			equipoSeleccionado = teclado.nextInt();
		}while(equipoSeleccionado < 0 && equipoSeleccionado >= obtenerEquiposDeFutbolDisponibles().length);
		return equipoSeleccionado;
	}

	public static EquipoDeFutbol[] obtenerEquiposDeFutbolDisponibles() {
		
		EquipoDeFutbol inscriptos [] = {new EquipoDeFutbol("Union"),
				new EquipoDeFutbol("Boca"),
				new EquipoDeFutbol("Aldosivi"),
				new EquipoDeFutbol("Patronato"),
				new EquipoDeFutbol("Newells"),
				new EquipoDeFutbol("Talleres"),
				new EquipoDeFutbol("Velez"),
				new EquipoDeFutbol("Racing"),
				new EquipoDeFutbol("Arsenal"),
				new EquipoDeFutbol("San Lorenzo"),
				new EquipoDeFutbol("Independiente"),
				new EquipoDeFutbol("Argentinos"),
				new EquipoDeFutbol("Godoy Cruz"),
				new EquipoDeFutbol("Rosario Central"),
				new EquipoDeFutbol("Sarmiento"),
				new EquipoDeFutbol("Estudiantes"),
				new EquipoDeFutbol("Lanus"),
				new EquipoDeFutbol("Atletico Tucuman"),
				new EquipoDeFutbol("Gimnasia"),
				new EquipoDeFutbol("Platense"),
				new EquipoDeFutbol("Huracan"),
				new EquipoDeFutbol("Defensa"),
				new EquipoDeFutbol("River"),
				new EquipoDeFutbol("Colon"),
				new EquipoDeFutbol("Central Cordoba"),
				new EquipoDeFutbol("Banfield")
				};
		
		return inscriptos;
	}
	
	private static void listarLosEquiposInscriptos() {
		EquipoDeFutbol[] inscriptos = obtenerEquiposDeFutbolDisponibles();
		
		for(int i=0; i<inscriptos.length; i++) {
			System.out.println("" + (i) + " - " + inscriptos[i].getNombre());
		}
	}
}
