package kart.impl;

import java.util.ArrayList;

import org.joda.time.DateTime;

import kart.Corrida;
import kart.model.Volta;

public class CorridaImpl implements Corrida {
	
	public boolean pilotoCorrendo(ArrayList<Volta> chegada, Volta piloto) {
		for(int i=0; i < chegada.size(); i++) {
			if(chegada.get(i).getCodPiloto().equals(piloto.getCodPiloto())) {
				return true;
			}
		}
		return false;
	}
	
	public ArrayList<Volta> pegarUltimaVolta(ArrayList<Volta> corrida){
		ArrayList<Volta> ultimasVolta = new ArrayList<Volta>();
		for(int i=0; i<corrida.size(); i++) {
			Volta voltaAtual = voltaMaiorQueAnterior(ultimasVolta, corrida.get(i));
			if(ultimasVolta.isEmpty()) {
				ultimasVolta.add(corrida.get(i));
			}
			else if(pilotoCorrendo(ultimasVolta, corrida.get(i))) {
				if(!voltaAtual.getCodPiloto().isEmpty()) {
					ultimasVolta.remove(voltaAtual);
					ultimasVolta.add(corrida.get(i));
				}
			} else {
				ultimasVolta.add(corrida.get(i));
			}
		}
		return ultimasVolta;
	}
	
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
