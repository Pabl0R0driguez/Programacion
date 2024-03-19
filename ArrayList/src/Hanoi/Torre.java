package Hanoi;

import java.util.ArrayList;

public class Torre {
	
	//Variable Palo
	private ArrayList<Disco> Palo;
	
	//Constructor e inicializamos nuestra variable Palo
	public Torre() {
		Palo = new ArrayList <Disco>();
		}
	
	//Metodo agregar disco
	//Si palo esta vacio o el disco que coloque sea menor que la cima, añado disco a palo
	public boolean agregarDisco(Disco a) {	
		if(Palo.isEmpty() || a.getTamaño() < cima().getTamaño()) {
			Palo.add(a);
			return true;
		}
	//Si el disco que añado es mayor que la cima, no te deja
		else {
			System.out.println("Disco no puede ser mayor que cima ");;
			return false;
		}
			
	}
	
	//Metodo que elimina el disco de arriba 
	public Disco removerDisco() {
		if(! Palo.isEmpty()) {
			return Palo.remove(Palo.size()-1);
		}
	
		else {
		//Si el palo esta vacio no se hace nada
		return null;
	}
	}
	//Metodo que nos da el disco situado en la cima
	public Disco cima() {
	return this.Palo.get(Palo.size()-1);
	}
	
	

	
	//toString
	@Override
	public String toString() {
		return "Torre [Palo=" + Palo + "]";
	}
	
	
}
