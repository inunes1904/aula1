package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.NivelTrabalhador;

public class Funcionario {
	private String name;
	private NivelTrabalhador nivel;
	private double salariobase;
	
	private Departamento departamento;
	private List<ContratoHora> contratos = new ArrayList<>();
	
	public Funcionario() {
		
	}

	public Funcionario(String name, NivelTrabalhador nivel, double salariobase, Departamento departamento) {
//		super();
		this.name = name;
		this.nivel = nivel;
		this.salariobase = salariobase;
		this.departamento = departamento;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public NivelTrabalhador getNivel() {
		return nivel;
	}

	public void setNivel(NivelTrabalhador nivel) {
		this.nivel = nivel;
	}

	public double getSalariobase() {
		return salariobase;
	}

	public void setSalariobase(double salariobase) {
		this.salariobase = salariobase;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<ContratoHora> getContratos() {
		return contratos;
	}

	public void addcontrato(ContratoHora contrato) {
		contratos.add(contrato);		
	}
	public void removecontrato(ContratoHora contrato) {
		contratos.remove(contrato);		
	}
	
	public double valoraReceber(int ano,int mes) {
		double soma=salariobase;
		Calendar calendario = Calendar.getInstance();
		for( ContratoHora c : contratos) {
			calendario.setTime(c.getData());
			int c_ano = calendario.get(Calendar.YEAR);
			int c_mes = 1 + calendario.get(Calendar.MONTH);
			if(ano == c_ano && mes == c_mes) {
				soma+=c.valorTotal();
			}	
		}
		return soma;		
	}
	

}
