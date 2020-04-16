package exercicios_aluguel_quartos_vetor.programa;

import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import exercicios_aluguel_quartos_vetor.entities.Quarto;

public class Principal {

	public static void main(String[] args) {

		Quarto quartos = new Quarto();
		Integer numQuarto;
		int y;
		int quant = 0;

		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);

		System.out.println(quartos.valorPorQuartoVazio());
		Integer quantQuartosVazio = quartos.getQuantQuartosVazio();
		
		if (quartos.quantQuartosVazios()) {
			do {
				System.out.println(String.format("Quantidade de Quartos Vazio %d", quantQuartosVazio));
				System.out.print("Quantidade de Quartos a serem alugados? ");
				quant = sc.nextInt();
			} while (quant > quantQuartosVazio);
		}

		for (int i = 1; i <= quant; i++) {

			System.out.println(" HOSPEDE: " + i + " = = = = = = = = = = = = = = = = = = = = = = = ");

			sc.nextLine();
			System.out.print("Nome hospede: ");
			String name = sc.nextLine().trim().toUpperCase();
			System.out.print("Quantidade de Dias: ");
			Integer quantDias = sc.nextInt();			

			do {
				y = 0;
				System.out.print("Numero Quarto: ");
				numQuarto = sc.nextInt();
				
				if (numQuarto < quartos.getQuantQuartos()) {
					if (quartos.vect[numQuarto] == null) {
						quartos.vect[numQuarto] = new Quarto(name, numQuarto, new Date(),quantDias);
					} else {
						y = 1;
						System.out.println(String.format("Quarto %d já ocupado, tente outra vez.", numQuarto));
						System.out.println("Quartos Vagos: ");
						System.out.println(quartos.mostraQuartosVazio());
						System.out.println(quartos.valorPorQuartoVazio());
					}
				} else {
					System.out.println(String.format("Quarto %d não existe", numQuarto));
				}

			} while (y == 1 || numQuarto > quartos.getQuantQuartos() && quartos.quantQuartosVazios());
		}

		for (int i = 1; i < quartos.vect.length; i++) {
			if (quartos.vect[i] != null) {
				System.out.println(quartos.vect[i]);
			} else {
				System.out.println(String.format("Quarto %s vazio", i));
			}

		}

		sc.close();

	}

}
