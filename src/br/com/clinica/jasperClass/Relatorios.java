package br.com.clinica.jasperClass;

import java.util.List;

import br.com.clinica.model.Paciente;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class Relatorios {
	
	private String path; //caminho base
	private String pathToReportPackage; //caminho para o package onde estao armazenados relatorios
	
	public Relatorios(){
		this.path = this.getClass().getClassLoader().getResource("br/com/clinica/relatorios").getPath();
		this.pathToReportPackage = this.path + "br/com/clinica/relatorios";
		System.out.println(path);
	}
	
	//Imprime e gera  uma lista de pacientes
	public void imprimir(List<Paciente>pacientes) throws Exception
	{
		
		JasperReport report = JasperCompileManager.compileReport(this.getPathToReportPackage() + "Paciente.jrxml");
		JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(pacientes));
		JasperExportManager.exportReportToPdfFile(print, "D:/nova/Paciente.pdf");
		
	}
    public String getPathToReportPackage(){
    	return this.pathToReportPackage;
    }
    public String getPath(){
    	return this.path;
    }
}
