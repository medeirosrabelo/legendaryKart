package kart.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import kart.LerArquivo;
import kart.model.Volta;

public class LerArquivoImpl implements LerArquivo {

	private ArrayList<Volta> corrida = new ArrayList<Volta>();
	
	public ArrayList<Volta> lerArquivoCorrida(String arquivo) {
		try {
			BufferedReader buffRead = new BufferedReader(new FileReader(arquivo));
			String linha;
			DateTimeFormatter df = DateTimeFormat.forPattern("HH:mm:ss.SSS");
			linha = buffRead.readLine();
			linha = buffRead.readLine();
			while(linha!= null) {
				Volta piloto = new Volta();
				linha.replace("	", "    ");
				piloto.setHorario(df.parseLocalTime(linha.substring(0, 12)).toDateTimeToday());
				piloto.setCodPiloto(linha.substring(17, 22).trim());
				piloto.setNomePiloto(linha.substring(23, 57).trim());
				piloto.setQtdVoltasCompl(linha.substring(58, 60).trim());
				piloto.setTempoTotal(df.parseLocalTime("00:0" + linha.substring(61, 90).trim()).toDateTimeToday());
				corrida.add(piloto);
				linha = buffRead.readLine();
			}
			buffRead.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return corrida;
	}
	
}
