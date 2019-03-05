package kart;

import java.util.ArrayList;

import kart.model.Volta;

public interface Corrida {
	public boolean pilotoCorrendo(ArrayList<Volta> chegada, Volta piloto);
	
	public ArrayList<Volta> pegarUltimaVolta(ArrayList<Volta> corrida);
	
	public ArrayList<Volta> pegarPrimeiraVolta(ArrayList<Volta> corrida);
}
