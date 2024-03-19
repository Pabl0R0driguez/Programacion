package Parking;

import java.util.ArrayList;

public class Parking  {
	//Creamos el arrayList
	private ArrayList <Plaza> Parking;
	
	//Inicializamos el arrayList vacio
	public Parking() {
	this.Parking = new ArrayList<>();
	}
	
	//Inicializamos el arrayList vacio con el numero de plazas, aqui solo reservamos las plazas, no añadimos ninguna
	public Parking(int NPlazas) {
	this.Parking = new ArrayList<>();
	for(int i=0; i<NPlazas;i++)
	{
		Parking.add(new Plaza(i));
	}
	}


	public void agregarPlazas(int NPlazas) {
	//Recorremos el Parking para poder añadir una nueva plaza	
	//Creamos la variable ultima 
		int ultima = Parking.size() - 1;
		for(int i=0; i<NPlazas;i++)
		{
			Parking.add(new Plaza(ultima + 1 + i));
		}
	}
	
	public boolean estacionarVehiculo(Vehiculos Nuevovehiculo) {
	//Usamos la estructura for-each para recorrer el Parking
	//Si la plaza no esta ocupada guardaremos el nuevo vehiculo en la plaza 
 	for(Plaza P : Parking)  {
 		if(P.isOcupada() == false)
 		{
		P.ocuparPlaza(Nuevovehiculo);
		return true;//Coche estacionado
 		}		
	}
	return false;//Parking lleno
 	}
 		

	public boolean retirarVehiculo(String matricula) {
		for(int i=0;i<Parking.size();i++) {
			if(Parking.contains(matricula)) {
				Parking.get(i).liberarPlaza();			
				 System.out.println("Salida de Parking");	 
			}
		}			
		return false;
	}
	
	
	
	public void imprimirEstado() {
		System.out.println(Parking);
	}

	@Override
	public String toString() {
		return "Parking [Parking=" + Parking + "]";
	}

	
	
}
