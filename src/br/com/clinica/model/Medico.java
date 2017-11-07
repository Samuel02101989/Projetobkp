package br.com.clinica.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Medico {
    
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idMedico;
	
    public Long getIdMedico() {
		return idMedico;
	}
	public void setIdMedico(Long idMedico) {
		this.idMedico = idMedico;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	public String getCrm() {
		return crm;
	}
    public String getCpfMedico() {
		return cpfMedico;
	}
	public void setCpfMedico(String cpfMedico) {
		this.cpfMedico = cpfMedico;
	}
	public String getNomeMaeMedico() {
		return nomeMaeMedico;
	}
	public void setNomeMaeMedico(String nomeMaeMedico) {
		this.nomeMaeMedico = nomeMaeMedico;
	}
	public String getNomeRuaMedico() {
		return nomeRuaMedico;
	}
	public void setNomeRuaMedico(String nomeRuaMedico) {
		this.nomeRuaMedico = nomeRuaMedico;
	}
	public String getNomeCidade() {
		return nomeCidade;
	}
	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public void setCrm(String crm) {
		this.crm = crm;
	}
	private String nome;
    private String especialidade;
    private String crm;
	private String cpfMedico;
    private String nomeMaeMedico;
    private String nomeRuaMedico;
    private String nomeCidade;
    private String telefone;


}

