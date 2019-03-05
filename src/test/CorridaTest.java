package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Comparator;

import org.joda.time.DateTime;
import org.joda.time.DateTimeComparator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import kart.Corrida;
import kart.LerArquivo;
import kart.impl.CorridaImpl;
import kart.impl.LerArquivoImpl;
import kart.model.Volta;

class CorridaTest {

	ArrayList<Volta> corrida = new ArrayList<Volta>();
	Corrida objCorrida = new CorridaImpl();
	@BeforeEach
	public void initialize() {
		String pathFile = "../GymKart\\src\\test\\kart.txt";
		LerArquivo lerArquivo = new LerArquivoImpl();
		corrida = lerArquivo.lerArquivoCorrida(pathFile);
	}

	
	@Test
	void testaPegarPrimeiraVolta() {
		ArrayList<Volta> primVolta = new ArrayList<Volta>();
		ArrayList<Volta> primVoltaResult = new ArrayList<Volta>();
		Volta aux1 = new Volta();
		
		aux1.setHorario(DateTime.parse("2019-03-04T23:52:17.003-03:00"));
		aux1.setCodPiloto("038");
		aux1.setNomePiloto("F.MASS");
		aux1.setQtdVoltasCompl("4");
		aux1.setTempoTotal(DateTime.parse("2019-03-04T00:01:02.787-03:00"));
		primVolta.add(aux1);
		
		primVoltaResult = objCorrida.pegarUltimaVolta(corrida);
		assertEquals(primVolta.get(0).getCodPiloto(), primVoltaResult.get(0).getCodPiloto());
	}
	
}
