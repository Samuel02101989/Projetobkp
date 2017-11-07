package br.com.clinica.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Agenda {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long idAgenda;
	public Long getIdAgenda() {
		return idAgenda;
	}
	public void setIdAgenda(Long idAgenda) {
		this.idAgenda = idAgenda;
	}
	public String getTratamentomedico() {
		return tratamentomedico;
	}
	public void setTratamentomedico(String tratamentomedico) {
		this.tratamentomedico = tratamentomedico;
	}
	public String getMedicamentouso() {
		return medicamentouso;
	}
	public void setMedicamentouso(String medicamentouso) {
		this.medicamentouso = medicamentouso;
	}
	public String getAlteracaocardio() {
		return alteracaocardio;
	}
	public void setAlteracaocardio(String alteracaocardio) {
		this.alteracaocardio = alteracaocardio;
	}
	public String getHiparterial() {
		return hiparterial;
	}
	public void setHiparterial(String hiparterial) {
		this.hiparterial = hiparterial;
	}
	public String getAlgumdisturbio() {
		return algumdisturbio;
	}
	public void setAlgumdisturbio(String algumdisturbio) {
		this.algumdisturbio = algumdisturbio;
	}
	public String getEpilepsia() {
		return epilepsia;
	}
	public void setEpilepsia(String epilepsia) {
		this.epilepsia = epilepsia;
	}
	public String getPsicpsiqui() {
		return psicpsiqui;
	}
	public void setPsicpsiqui(String psicpsiqui) {
		this.psicpsiqui = psicpsiqui;
	}
	public String getStress() {
		return stress;
	}
	public void setStress(String stress) {
		this.stress = stress;
	}
	public String getOncologo() {
		return oncologo;
	}
	public void setOncologo(String oncologo) {
		this.oncologo = oncologo;
	}
	public String getDiabete() {
		return diabete;
	}
	public void setDiabete(String diabete) {
		this.diabete = diabete;
	}
	public String getAlgumdoenca() {
		return algumdoenca;
	}
	public void setAlgumdoenca(String algumdoenca) {
		this.algumdoenca = algumdoenca;
	}
	public String getMarcapasso() {
		return marcapasso;
	}
	public void setMarcapasso(String marcapasso) {
		this.marcapasso = marcapasso;
	}
    public String getCampoTratamentoMedico() {
		return CampoTratamentoMedico;
	}
	public void setCampoTratamentoMedico(String campoTratamentoMedico) {
		CampoTratamentoMedico = campoTratamentoMedico;
	}
	public String getCampoMedicamentoUso() {
		return CampoMedicamentoUso;
	}
	public void setCampoMedicamentoUso(String campoMedicamentoUso) {
		CampoMedicamentoUso = campoMedicamentoUso;
	}
	public String getCampoAlteracaoCardio() {
		return CampoAlteracaoCardio;
	}
	public void setCampoAlteracaoCardio(String campoAlteracaoCardio) {
		CampoAlteracaoCardio = campoAlteracaoCardio;
	}
	public String getCampoHipArterial() {
		return CampoHipArterial;
	}
	public void setCampoHipArterial(String campoHipArterial) {
		CampoHipArterial = campoHipArterial;
	}
	public String getCampoAlgumDisturbio() {
		return CampoAlgumDisturbio;
	}
	public void setCampoAlgumDisturbio(String campoAlgumDisturbio) {
		CampoAlgumDisturbio = campoAlgumDisturbio;
	}
	public String getCampoepilepsia() {
		return Campoepilepsia;
	}
	public void setCampoepilepsia(String campoepilepsia) {
		Campoepilepsia = campoepilepsia;
	}
	public String getCampoPsicPsiqui() {
		return CampoPsicPsiqui;
	}
	public void setCampoPsicPsiqui(String campoPsicPsiqui) {
		CampoPsicPsiqui = campoPsicPsiqui;
	}
	public String getCampoStress() {
		return CampoStress;
	}
	public void setCampoStress(String campoStress) {
		CampoStress = campoStress;
	}
	public String getCampoOncologo() {
		return CampoOncologo;
	}
	public void setCampoOncologo(String campoOncologo) {
		CampoOncologo = campoOncologo;
	}
	public String getCampoDiabete() {
		return CampoDiabete;
	}
	public void setCampoDiabete(String campoDiabete) {
		CampoDiabete = campoDiabete;
	}
	public String getCampoAlgumDoenca() {
		return CampoAlgumDoenca;
	}
	public void setCampoAlgumDoenca(String campoAlgumDoenca) {
		CampoAlgumDoenca = campoAlgumDoenca;
	}
	public String getCampomMarcapasso() {
		return CampomMarcapasso;
	}
	public void setCampomMarcapasso(String campomMarcapasso) {
		CampomMarcapasso = campomMarcapasso;
	}
	
	public String tratamentomedico;
	public String medicamentouso;
	public String alteracaocardio;
	public String hiparterial;
	public String algumdisturbio;
	public String epilepsia;
	public String psicpsiqui;
	public String stress;
	public String oncologo;
	public String diabete;
	public String algumdoenca;
	public String marcapasso;
	public String CampoTratamentoMedico;
    public String CampoMedicamentoUso;
    public String CampoAlteracaoCardio;
    public String CampoHipArterial;
    public String CampoAlgumDisturbio;
    public String Campoepilepsia;
    public String CampoPsicPsiqui;
    public String CampoStress;
    public String CampoOncologo;
    public String CampoDiabete;
    public String CampoAlgumDoenca;
    public String CampomMarcapasso;
		
}
