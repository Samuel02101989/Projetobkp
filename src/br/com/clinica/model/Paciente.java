package br.com.clinica.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Paciente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Idpaciente;

	public Long getIdpaciente() {
		return Idpaciente;
	}

	public void setIdpaciente(Long idpaciente) {
		Idpaciente = idpaciente;
	}

	public String getNomepaciente() {
		return nomepaciente;
	}

	public void setNomepaciente(String nomepaciente) {
		this.nomepaciente = nomepaciente;
	}

	public String getGpsaguineo() {
		return gpsaguineo;
	}

	public void setGpsaguineo(String gpsaguineo) {
		this.gpsaguineo = gpsaguineo;
	}

	public String getDatanascimento() {
		return datanascimento;
	}

	public void setDatanascimento(String datanascimento) {
		this.datanascimento = datanascimento;
	}

	public String getNomemae() {
		return nomemae;
	}

	public void setNomemae(String nomemae) {
		this.nomemae = nomemae;
	}

	public String getNomepai() {
		return nomepai;
	}

	public void setNomepai(String nomepai) {
		this.nomepai = nomepai;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public String getPlanosaude() {
		return planosaude;
	}

	public void setPlanosaude(String planosaude) {
		this.planosaude = planosaude;
	}

	public String getNumeroconvenio() {
		return numeroconvenio;
	}

	public void setNumeroconvenio(String numeroconvenio) {
		this.numeroconvenio = numeroconvenio;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	

	public String getNumeroCasa() {
		return numeroCasa;
	}

	public void setNumeroCasa(String numeroCasa) {
		this.numeroCasa = numeroCasa;
	}
	private String numeroCasa;
	private String nomepaciente;
	private String gpsaguineo;
	private String datanascimento;
	private String nomemae;
	private String nomepai;
	private String cpf;
	private String rua;
	private String cidade;
	private String fone;
	private String planosaude;
	private String numeroconvenio;
	private String observacao;
}
