package Hanoi;

public class Disco {

private int tamaño;
	
public Disco(int valor) {
	this.tamaño=valor;
}

public int getTamaño() {
	return tamaño;
}

@Override
public String toString() {
	return "Disco [tamaño=" + tamaño + "]";
}


}
