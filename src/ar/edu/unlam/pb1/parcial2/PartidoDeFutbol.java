package ar.edu.unlam.pb1.parcial2;

import java.util.Arrays;

public class PartidoDeFutbol {
	private EquipoDeFutbol local;
	private EquipoDeFutbol visitante;
	private Evento goles[];
	private Evento amonestados[];
	private Evento expulsados[];
	private int contGoles ;
	private int cantidadAmonestados ;
	private int cantidadExpulsados ;
	private int totalGolesLocal ;
    private int totalGolesVisitante ;
    private int minutoDeJuego ;
	
	
	
	public PartidoDeFutbol(EquipoDeFutbol local, EquipoDeFutbol visitante) {
		this.local = local;
		this.visitante = visitante;
		this.goles = new Evento[20];
		this.amonestados = new Evento[20];
		this.expulsados = new Evento[20];
		this.contGoles = 0;
		this.cantidadAmonestados = 0;
		this.cantidadExpulsados = 0;
		this.totalGolesLocal = 0;
		this.totalGolesVisitante = 0 ;
		this.minutoDeJuego = 0;
	}
	
	/*
	 * Se debe marcar un nuevo Gol 
	 * Dependiendo del autor (segun al equipo que pertenezca) y del tipo (si es a favor o en contra) se sabra a quien contabilizarlo
	 */
	public void marcar(Evento gol) {
		System.out.println(gol.toString());
		TipoDeEvento tipo = gol.getTipo();
		Jugador jugador = gol.getAutor();
		int minutoGol = gol.getMinuto();
		if(minutoGol>minutoDeJuego) {
		
		switch(tipo) {
		case GOL_A_FAVOR :
			for(int i = 0;i<local.getJugadoresTitulares().length;i++) {
				if(local.getJugadoresTitulares()[i]!=null && local.getJugadoresTitulares()[i].getNombre().equals(jugador.getNombre())) {
					goles[contGoles] = gol;
					contGoles++;
					
			}
				}
			
			for(int i = 0;i<visitante.getJugadoresTitulares().length;i++) {
				if(visitante.getJugadoresTitulares()[i]!=null && visitante.getJugadoresTitulares()[i].getNombre().equals(jugador.getNombre())) {
					goles[contGoles] = gol;
					contGoles++;
					
					
			}
				}
			break;
		case GOL_EN_CONTRA:
			for(int i = 0;i<local.getJugadoresTitulares().length;i++) {
				if(local.getJugadoresTitulares()[i]!=null && local.getJugadoresTitulares()[i].getNombre().equals(jugador.getNombre())) {
					goles[contGoles] = gol;
					contGoles++;
					
			}
				}
			
			for(int i = 0;i<visitante.getJugadoresTitulares().length;i++) {
				if(visitante.getJugadoresTitulares()[i]!=null && visitante.getJugadoresTitulares()[i].getNombre().equals(jugador.getNombre())) {
					goles[contGoles] = gol;
					contGoles++;
					
			}
				}
			break;
		default:
			break;
		}
		}
	}
	
	/*
	 * Se registra un nuevo amonestado en el partido. 
	 * Si el mismo ya pose�a una amonestacion previa, se lo debe expulsar. 
	 * El metodo devuelve la cantidad de amonestaciones del jugador. 
	 * Los valores posibles de retorno son:
	 * 1 - Si no ten�a amonestacion previa o 
	 * 2 - Si ya pose�a una amonestacion previa y termina siendo expulsado
	 * 
	 */
	public int amonestar(Evento amonestado) {

		System.out.println(amonestado.toString());
		Jugador jugador = amonestado.getAutor();
		int minutos = amonestado.getMinuto();
		int cantAmonestaciones = 0;
		
		if(minutos>minutoDeJuego) {
			minutoDeJuego = amonestado.getMinuto();
		
		for(int i = 0;i<local.getJugadoresTitulares().length;i++) {
			if(local.getJugadoresTitulares()[i]!=null && local.getJugadoresTitulares()[i].getNombre().equals(jugador.getNombre())) {
				amonestados[cantidadAmonestados] = amonestado;
				cantidadAmonestados++;
				}
			}
		for(int i = 0;i<visitante.getJugadoresTitulares().length;i++) {
			if(visitante.getJugadoresTitulares()[i]!=null && visitante.getJugadoresTitulares()[i].getNombre().equals(jugador.getNombre())) {
				amonestados[cantidadAmonestados] = amonestado;
				cantidadAmonestados++;
				}
			}
			
		for(int j = 0 ; j<amonestados.length;j++) {
			if(amonestados[j]!= null && amonestados[j].getAutor().getNombre().equals(jugador.getNombre())) {
				cantAmonestaciones++;
				}
			}
				
		if(cantAmonestaciones==2) {
			Evento expulsion = new Evento(minutos, jugador, TipoDeEvento.EXPULSION);
			expulsar(expulsion);
			}
		
		}
		return cantAmonestaciones;
	}
	
	/*
	 * Se registra un nuevo expulsado en el partido. 
	 */
	public void expulsar(Evento expulsado) {
		System.out.println(expulsado.toString());
		Jugador jugador = expulsado.getAutor();
		int minutos = expulsado.getMinuto();
		if(minutos>=minutoDeJuego) {
			minutoDeJuego = expulsado.getMinuto();
		for(int i = 0;i<local.getJugadoresTitulares().length;i++) {
			if(local.getJugadoresTitulares()[i]!=null && local.getJugadoresTitulares()[i].getNombre().equals(jugador.getNombre())) {
				expulsados[cantidadExpulsados] = expulsado;
				cantidadExpulsados++;
				local.getJugadoresTitulares()[i] = null;
		}
			}
		for(int i = 0;i<visitante.getJugadoresTitulares().length;i++) {
			if(visitante.getJugadoresTitulares()[i]!=null && visitante.getJugadoresTitulares()[i].getNombre().equals(jugador.getNombre())) {
				expulsados[cantidadExpulsados] = expulsado;
				cantidadExpulsados++;
				visitante.getJugadoresTitulares()[i] = null;
		}
			}
		}
	}
	
	public boolean realizarCambio (Jugador jugadorQueSale, Jugador jugadorQueIngresa, EquipoDeFutbol equipoQueHaceCambio, int minutos) {
		Jugador jugadorReserva = jugadorQueSale;
		boolean cambioExitoso = false;
		if (minutos>minutoDeJuego) {
		minutoDeJuego = minutos;
		for (int i = 0; i < equipoQueHaceCambio.getJugadoresTitulares().length; i++) {
			 if (equipoQueHaceCambio.getJugadoresTitulares()[i]!= null && equipoQueHaceCambio.getJugadoresTitulares()[i].equals(jugadorQueSale)) {
				 equipoQueHaceCambio.getJugadoresTitulares()[i] = null;
				 equipoQueHaceCambio.getJugadoresTitulares()[i] = jugadorQueIngresa; 
			 	}
			}
		for (int j = 0; j < equipoQueHaceCambio.getJugadoresSuplentes().length; j++) {
			 	if (equipoQueHaceCambio.getJugadoresTitulares()[j]!= null &&equipoQueHaceCambio.getJugadoresSuplentes()[j].equals(jugadorQueIngresa)) {
			 			equipoQueHaceCambio.getJugadoresSuplentes()[j] = null;
			 			equipoQueHaceCambio.getJugadoresSuplentes()[j] = jugadorReserva;
			 			cambioExitoso = true;
			 			}
			 		} 
			}
		 return cambioExitoso;	
	}
	/*
	 * Se cuentan la cantidad de goles por equipo (Se debe considerar si el gol result� a favor o en contra), y devuelve el equipo ganador (Si hubo un empate retorna null) 
	 */
	public String getResultado() {
		int golesLocal = 0;
		int golesVisitante = 0;
		for(int i = 0;i<goles.length;i++) {
			if(goles[i] != null) {				
				TipoDeEvento tipo = goles[i].getTipo();
				Jugador jugador = goles[i].getAutor();
				int minutoGol = goles[i].getMinuto();
				if(minutoGol>minutoDeJuego) {
				minutoDeJuego = goles[i].getMinuto();
				switch(tipo) {
					case GOL_A_FAVOR:								
						for(int j = 0;j<local.getJugadoresTitulares().length;j++) {
								if(local.getJugadoresTitulares()[j]!=null && local.getJugadoresTitulares()[j].getNombre().equals(jugador.getNombre())) {
									golesLocal++;	
											}
										}	
										
						for(int j = 0;j<visitante.getJugadoresTitulares().length;j++) {
								 if(visitante.getJugadoresTitulares()[j]!=null && visitante.getJugadoresTitulares()[j].getNombre().equals(jugador.getNombre())) {
									golesVisitante++;												  
											  }
										}										
						break;
					case GOL_EN_CONTRA:										
						for(int j = 0;j<local.getJugadoresTitulares().length;j++) {
							 	 if(local.getJugadoresTitulares()[j]!=null && local.getJugadoresTitulares()[j].getNombre().equals(jugador.getNombre())) {
									golesLocal--;											
											  }
										}									
								for(int j = 0;j<visitante.getJugadoresTitulares().length;j++) {
									   if(visitante.getJugadoresTitulares()[j]!=null && visitante.getJugadoresTitulares()[j].getNombre().equals(jugador.getNombre())) {
										   golesVisitante--;										   
									   		  }
										}								
						break;
						default:
						break;							
								}
							}
					}
				}
		
		this.totalGolesLocal += golesLocal;
		this.totalGolesVisitante += golesVisitante;
		System.out.println("************************");
		String resultado = " "+local.getNombre()+"-"+totalGolesLocal+"   "+visitante.getNombre()+"-"+totalGolesVisitante+". Tiempo de Juego :"+minutoDeJuego+" minutos.";
		System.out.println("************************");
		return resultado ;		
//		if(golesLocal>golesVisitante) {
//			return local;
//		}else if(golesVisitante>golesLocal) {
//			return visitante;
//		}else {
//			return null;
//		}
	}
	
	/*
	 * El m�todo toString debe describir el ESTADO del partido (Equipos que se enfrentan, los goles realizados, los amonestado y expulsados).
	 */
//	public String toString() {
//		String resultado = "";
//		return resultado;
//	}

	
	
	public EquipoDeFutbol getLocal() {
		return local;
	}

	public int getTotalGolesLocal() {
		return totalGolesLocal;
	}


	public int getTotalGolesVisitante() {
		return totalGolesVisitante;
	}


	@Override
	public String toString() {
		return "*** PartidoDeFutbol actual ***  \n .Equipo local=" + local + "\n .Equipo visitante=" + visitante + "\n goles=" + Arrays.toString(goles)
				+ "\n amontestados=" + Arrays.toString(amonestados) + "\n expulsados=" + Arrays.toString(expulsados)
				+ "]";
	}
	
	

	public EquipoDeFutbol getVisitante() {
		return visitante;
	}

	public int getMinutoDeJuego() {
		return minutoDeJuego;
	}

	public void setMinutoDeJuego(int minutoDeJuego) {
		this.minutoDeJuego = minutoDeJuego;
	}

	public void mostrarAlineacion(EquipoDeFutbol local, EquipoDeFutbol visitante) {
        Jugador equipoLocal[] = local.getJugadoresTitulares();
        Jugador equipoVisitante[] = visitante.getJugadoresTitulares();
        Jugador suplentesLocal[] = local.getJugadoresSuplentes();
        Jugador suplentesVisitante[] = visitante.getJugadoresSuplentes();
		
        System.out.println("***********************************************");
        System.out.println("***** ALINEACION INICIAL DEL PARTIDO  *********");
        System.out.println("***********************************************");
        
		System.out.println(" ___________________________________________ ");
		System.out.println("|          |  "+equipoLocal[0].getNumero()+"-"+equipoLocal[0].getNombre()+"    |          |");
		System.out.println("|          |                     |          |");
		System.out.println("|          |_____________________|          |");
		System.out.println("|                                           |");
		System.out.println("|  "+equipoLocal[1].getNumero()+"-"+equipoLocal[1].getNombre()+"       "+equipoLocal[2].getNumero()+"-"+equipoLocal[2].getNombre()+"   |");
		System.out.println("|                                           |");
		System.out.println("|                                           |");
		System.out.println("|                                           |");
		System.out.println("| "+equipoLocal[4].getNumero()+"-"+equipoLocal[4].getNombre()+" _________  "+equipoLocal[3].getNumero()+"-"+equipoLocal[3].getNombre()+"  |");
		System.out.println("|                |         |                |");
		System.out.println("|________________|____.____|________________|");
		System.out.println("|                |         |                |");
		System.out.println("|                |_________|                |");
		System.out.println("|"+equipoVisitante[4].getNumero()+"-"+equipoVisitante[4].getNombre()+"            "+equipoVisitante[3].getNumero()+"-"+equipoVisitante[3].getNombre()+" |");
		System.out.println("|                                           |");
		System.out.println("|                                           |");
		System.out.println("|                                           |");
		System.out.println("| "+equipoVisitante[1].getNumero()+"-"+equipoVisitante[1].getNombre()+"          "+equipoVisitante[2].getNumero()+"-"+equipoVisitante[2].getNombre()+" |");
		System.out.println("|           ______________________          |");
		System.out.println("|          |                      |         |");
		System.out.println("|          |   "+equipoVisitante[0].getNumero()+"-"+equipoVisitante[0].getNombre()+"    |         |");
		System.out.println("|__________|______________________|_________|");
		
		System.out.println("*********************************************************************");
		System.out.println("BANCO DE SUPLENTES DE "+local.getNombre());
		for(int i=0;i<suplentesLocal.length;i++) {
			System.out.print(" "+suplentesLocal[i].getNumero()+"-"+suplentesLocal[i].getNombre()+" ");
		}
		System.out.println();
		System.out.println("*********************************************************************");
		System.out.println();
		System.out.println("*********************************************************************");
		System.out.println("BANCO DE SUPLENTES DE "+visitante.getNombre());
		for(int i=0;i<suplentesLocal.length;i++) {
			System.out.print(" "+suplentesVisitante[i].getNumero()+"-"+suplentesVisitante[i].getNombre()+" ");
		}
		System.out.println();
		System.out.println("*********************************************************************");
	
	}

	public boolean alineacionEstaCompleta(EquipoDeFutbol local, EquipoDeFutbol visitante) {
		int listaTitularLocal = 0 , listaTitularVisitante = 0 , listaSuplenteLocal = 0, listaSuplenteVisitante = 0;
		int i = 0;
		boolean resultado = false;
		for(;i<local.getJugadoresTitulares().length;i++) {
			if(local.getJugadoresTitulares()[i]!=null) {
				listaTitularLocal++;
			}
		}
		i = 0;
		for(;i<local.getJugadoresSuplentes().length;i++) {
			if(local.getJugadoresSuplentes()[i]!=null) {
				listaSuplenteLocal++;
			}
		}
		i = 0;
		for(;i<visitante.getJugadoresTitulares().length;i++) {
			if(visitante.getJugadoresTitulares()[i]!=null) {
				listaTitularVisitante++;
			}
		}
		i = 0;
		for(;i<visitante.getJugadoresSuplentes().length;i++) {
			if(visitante.getJugadoresSuplentes()[i]!=null) {
				listaSuplenteVisitante++;
			}
		}
		
		if(listaTitularLocal == 5 && listaSuplenteLocal== 5 && listaTitularVisitante == 5 && listaSuplenteVisitante == 5 ) {
			resultado = true;
		}
		
		return resultado;
		
	}

	

	
}
