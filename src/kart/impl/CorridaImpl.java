package kart.impl;

import java.util.ArrayList;

import org.joda.time.DateTime;

import kart.Corrida;
import kart.model.Volta;

public class CorridaImpl implements Corrida {
	
	public ArrayList<Volta> pegarPrimeiraVolta(ArrayList<Volta> corrida){
		ArrayList<Volta> firstRound = new ArrayList<Volta>();
		for(int i=0; i < corrida.size(); i++) {
			if(corrida.get(i).getQtdVoltasCompl().equals("1")) {
				firstRound.add(corrida.get(i));
			}
		}
		return firstRound;
	}
	
}
