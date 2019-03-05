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
	void testaPegarUltimaVolta() {
		ArrayList<Volta> ultVolta = new ArrayList<Volta>();
		ArrayList<Volta> ultVoltaResult = new ArrayList<Volta>();
		Volta aux1 = new Volta();
		Volta aux2 = new Volta();
		Volta aux3 = new Volta();
		Volta aux4 = new Volta();
		Volta aux5 = new Volta();
		Volta aux6 = new Volta();
		
		aux1.setHorario(DateTime.parse("2019-03-04T23:52:17.003-03:00"));
		aux1.setCodPiloto("038");
		aux1.setNomePiloto("F.MASS");
		aux1.setQtdVoltasCompl("4");
		aux1.setTempoTotal(DateTime.parse("2019-03-04T00:01:02.787-03:00"));
		ultVolta.add(aux1);
		
		aux2.setHorario(DateTime.parse("2019-03-04T23:52:22.120-03:00"));
		aux2.setCodPiloto("002");
		aux2.setNomePiloto("K.RAIKKONEN");
		aux2.setQtdVoltasCompl("4");
		aux2.setTempoTotal(DateTime.parse("2019-03-04T00:01:03.076-03:00"));
		ultVolta.add(aux2);
		
		aux3.setHorario(DateTime.parse("2019-03-04T23:52:22.586-03:00"));
		aux3.setCodPiloto("033");
		aux3.setNomePiloto("R.BARRICHELLO");
		aux3.setQtdVoltasCompl("4");
		aux3.setTempoTotal(DateTime.parse("2019-03-04T00:01:04.010-03:00"));
		ultVolta.add(aux3);
		
		aux4.setHorario(DateTime.parse("22019-03-04T23:52:25.975-03:00"));
		aux4.setCodPiloto("023");
		aux4.setNomePiloto("M.WEBBER");
		aux4.setQtdVoltasCompl("4");
		aux4.setTempoTotal(DateTime.parse("2019-03-04T00:01:04.216-03:00"));
		ultVolta.add(aux4);
		
		aux5.setHorario(DateTime.parse("2019-03-04T23:53:06.741-03:00"));
		aux5.setCodPiloto("015");
		aux5.setNomePiloto("F.ALONSO");
		aux5.setQtdVoltasCompl("4");
		aux5.setTempoTotal(DateTime.parse("2019-03-04T00:01:20.050-03:00"));
		ultVolta.add(aux5);
		
		aux6.setHorario(DateTime.parse("2019-03-04T23:54:57.757-03:00"));
		aux6.setCodPiloto("011");
		aux6.setNomePiloto("S.VETTEL");
		aux6.setQtdVoltasCompl("3");
		aux6.setTempoTotal(DateTime.parse("2019-03-04T00:01:18.097-03:00"));
		ultVolta.add(aux6);
		
		ultVoltaResult = objCorrida.pegarUltimaVolta(corrida);
		assertEquals(ultVolta.get(0).getCodPiloto(), ultVoltaResult.get(0).getCodPiloto());
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
