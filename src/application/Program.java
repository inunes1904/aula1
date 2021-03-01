package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.ContratoHora;
import entities.Departamento;
import entities.Funcionario;
import entities.enums.NivelTrabalhador;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.print("Introduza o nome do Departameto:");
		String departamento = sc.nextLine();
		System.out.println("Introduza os dados do Trabalhador:");
		System.out.print("Nome:");
		String name = sc.nextLine();
		System.out.print("Nivel do Trabalhador:");
		String nivel = sc.nextLine();
		System.out.print("Salario Base:");
		double salariobase = sc.nextDouble();
		Funcionario funcionario = new Funcionario( name, NivelTrabalhador.valueOf(nivel),  salariobase, new Departamento(departamento));
		System.out.print("Quantos Contratos possui este trabalhador?");
		int numCont = sc.nextInt();
		for (int i = 1; i <= numCont; i++) {
			System.out.println("Introduza a informação do #"+i+" contrato");
			System.out.print("Data do contrato(DD/MM/YYYY):");
			Date dataContrato = sdf.parse(sc.next());
			System.out.print("Valor hora:");
			double valorHora = sc.nextDouble();
			System.out.print("Duração do contrato:");
			int horas = sc.nextInt();
			ContratoHora contrato = new ContratoHora(dataContrato, valorHora, horas);
			funcionario.addcontrato(contrato);
		}
		System.out.println("Introduz o mês e o ano do salario (MM/YYYY)");
		String mesAno = sc.next();
		int mes = Integer.parseInt(mesAno.substring(0,2));
		int ano = Integer.parseInt(mesAno.substring(3));
		System.out.println("Nome: "+funcionario.getName());
		System.out.println("Departamento: "+funcionario.getDepartamento().getName());
		System.out.println("Quanto o Funcionario ganhou "+mesAno+": "+ String.format("%.2f", funcionario.valoraReceber(ano, mes)));

		sc.close();
	}

}
