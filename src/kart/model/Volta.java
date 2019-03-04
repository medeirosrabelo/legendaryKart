package kart.model;

import org.joda.time.DateTime;

public class Volta {
	private DateTime horario;
	private String codPiloto;
	private String nomePiloto;
	private String qtdVoltasCompl;
	private DateTime tempoTotal;
	
	public DateTime getHorario() {
		return horario;
	}
	public void setHorario(DateTime horario) {
		this.horario = horario;
	}
	public String getCodPiloto() {
		return codPiloto;
	}
	public void setCodPiloto(String codPiloto) {
		this.codPiloto = codPiloto;
	}
	public String getNomePiloto() {
		return nomePiloto;
	}
	public void setNomePiloto(String nomePiloto) {
		this.nomePiloto = nomePiloto;
	}
	public String getQtdVoltasCompl() {
		return qtdVoltasCompl;
	}
	public void setQtdVoltasCompl(String qtdVoltasCompl) {
		this.qtdVoltasCompl = qtdVoltasCompl;
	}
	public DateTime getTempoTotal() {
		return tempoTotal;
	}
	public void setTempoTotal(DateTime tempoTotal) {
		this.tempoTotal = tempoTotal;
	}
}
