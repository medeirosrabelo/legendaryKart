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
	
	public Volta voltaMaiorQueAnterior(ArrayList<Volta> chegada, Volta piloto) {
		for(int i=0; i < chegada.size(); i++) {
			if(Integer.parseInt(chegada.get(i).getQtdVoltasCompl()) < Integer.parseInt(piloto.getQtdVoltasCompl())) {
				return chegada.get(i);
			}
		}
		return null;
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
	
	public String pegarTempoCorrida(Volta voltaLargada, Volta voltaChegada) {
		DateTime largada = voltaLargada.getHorario().minusMinutes(Integer.parseInt(
				voltaLargada.getTempoTotal().toString().substring(14, 16)))
				.minusSeconds(Integer.parseInt(voltaLargada.getTempoTotal().toString().substring(17, 19)))
				.minusMillis(Integer.parseInt(voltaLargada.getTempoTotal().toString().substring(20, 23)));

		String tempoTotal = voltaChegada.getHorario().minusHours(Integer.parseInt(largada.toString().substring(11, 13)))
				.minusMinutes(Integer.parseInt(largada.toString().substring(14, 16)))
				.minusSeconds(Integer.parseInt(largada.toString().substring(17, 19)))
				.minusMillis(Integer.parseInt(largada.toString().substring(20, 23))).toString().substring(11, 23);
		return tempoTotal;
	}
	
}
