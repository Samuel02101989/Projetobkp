package br.com.clinica.dao;

import br.com.clinica.model.Paciente;

public class PacienteController {
	
	private PacienteDao dao;
	
	public Paciente obterPaciente(String cpf){
		Paciente paciente = new Paciente();
		paciente = dao.getByCpf(cpf);
		return paciente;
	}

	public PacienteDao getDao() {
		return dao;
	}

	public void setDao(PacienteDao dao) {
		this.dao = dao;
	}
}
