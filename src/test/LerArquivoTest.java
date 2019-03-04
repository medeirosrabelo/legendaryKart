package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import kart.LerArquivo;
import kart.impl.LerArquivoImpl;
import kart.model.Volta;

class LerArquivoTest {

	@Test
	void testaLerArquivoKart() {
		String pathFile = "../GymKart\\src\\test\\kart.txt";
		LerArquivo lerArquivo = new LerArquivoImpl();
		ArrayList<Volta> corridas = lerArquivo.lerArquivoCorrida(pathFile);
		
		assertEquals("038", corridas.get(0).getCodPiloto());
	}

}
