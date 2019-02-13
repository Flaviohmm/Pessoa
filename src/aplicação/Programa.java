package aplicação;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entidade.Pessoa;
import entidade.PessoaFisica;
import entidade.PessoaJuridica;

public class Programa {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner scanner = new Scanner(System.in);
		List<Pessoa> lista = new ArrayList<>();

		System.out.print("Entre com o número de pagadores de impostos: ");
		int numero = scanner.nextInt();

		for (int i = 1; i <= numero; i++) {
			System.out.println("Pagador de imposto #" + i + " dados:");
			System.out.print("Pessoa Física ou Jurídica (f/j)? ");
			char opcao = scanner.next().charAt(0);
			System.out.print("Nome: ");
			scanner.nextLine();
			String nome = scanner.nextLine();
			System.out.print("Renda Anual: ");
			double renda_anual = scanner.nextDouble();
			
			if(opcao == 'f' || opcao == 'F') {
				System.out.print("Gastos com Saúde: ");
				double gastos_saude = scanner.nextDouble();
				lista.add(new PessoaFisica(nome, renda_anual, gastos_saude));
			} else if(opcao == 'j' || opcao == 'J') {
				System.out.print("Número de Funcionarios: ");
				int numFuncionario = scanner.nextInt();
				lista.add(new PessoaJuridica(nome, renda_anual, numFuncionario));
			}
		}
		
		System.out.println();
		System.out.println("PAGAMENTO DE IMPOSTOS:");
		
		double sum = 0.0;
		for (Pessoa pessoa : lista) {
			System.out.println(pessoa);
			sum += pessoa.calculaImpostos();
		}
		
		System.out.println();
		System.out.println("TOTAL DE IMPOSTOS: $ " + String.format("%.2f", sum));
		
		scanner.close();
	}

}
