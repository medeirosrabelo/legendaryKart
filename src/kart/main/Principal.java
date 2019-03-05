package kart.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

import org.joda.time.DateTimeComparator;

import kart.impl.CorridaImpl;
import kart.impl.LerArquivoImpl;
import kart.model.Volta;

public class Principal {
	
	static ArrayList<Volta> corrida = new ArrayList<Volta>();
	static ArrayList<Volta> primeiraVolta = new ArrayList<Volta>();
	static ArrayList<Volta> ultimaVolta = new ArrayList<Volta>();
	private static LerArquivoImpl leitura = new LerArquivoImpl();
	private static CorridaImpl objCorrida = new CorridaImpl();
	static Scanner reader = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Digite o caminho para o arquivo: ");
		String input = reader.nextLine();
		
		corrida = leitura.lerArquivoCorrida(input);
		
		ultimaVolta = objCorrida.pegarUltimaVolta(corrida);
		ultimaVolta.sort(new Comparator<Volta>() {
			@Override
		    public int compare(Volta v1, Volta v2) {
		        return DateTimeComparator.getInstance().compare(v1.getHorario(), v2.getHorario());
			}
		});
		
		imprimirClassificação(ultimaVolta);
		
		primeiraVolta = objCorrida.pegarPrimeiraVolta(corrida);
		primeiraVolta.sort(new Comparator<Volta>() {
			@Override
		    public int compare(Volta v1, Volta v2) {
		        return DateTimeComparator.getInstance().compare(v1.getHorario(), v2.getHorario());
			}
		});
		
		String tempoTotal = objCorrida.pegarTempoCorrida(primeiraVolta.get(0), ultimaVolta.get(0));
		System.out.println("Tempo Total da Corrida: " + tempoTotal);
	}
	
	public static void imprimirClassificação(ArrayList<Volta> chegada) {
		for(int i = 0; i < chegada.size(); i++) {
			System.out.println("Colocação: " + (i+1));
			System.out.println("Cod. Piloto: " + chegada.get(i).getCodPiloto() + " ");
			System.out.println("Nome: " + chegada.get(i).getNomePiloto()+ " ");
			System.out.println("Horário da chegada: " + chegada.get(i).getHorario()+ " ");
			System.out.println("Voltas Completas: " + chegada.get(i).getQtdVoltasCompl());
			System.out.println();
			System.out.println("####################################################################################################################");
			System.out.println();
		}
	}
}
