package forca;

import java.util.Random;
import java.util.Scanner;

public class ForcaMain {

	public static void main(String[] args) {
		Random gerador = new Random();

		String vetorTemasPalasvras[][] = new String[5][5];

		vetorTemasPalasvras[0][0] = "futeboll";
		vetorTemasPalasvras[1][0] = "casamento";
		vetorTemasPalasvras[0][1] = "bola";
		vetorTemasPalasvras[0][2] = "luva";

		vetorTemasPalasvras[1][1] = "noiva";
		vetorTemasPalasvras[1][2] = "bolo";


		vetorTemasPalasvras[1][1] = "vestido";
		vetorTemasPalasvras[1][2] = "noiva";

		int opcao = 0;
		String palavraChave = "";
		String letraUsadas = "";
		String palavraSendoAdivinhada = "";
		int MAX_TENTATIVA = 5;
		int v = 0;

		System.out.println("----------------------------------------------");
		System.out.println("------------------FORCA-----------------------");
		System.out.println("----------------------------------------------");

		while (true) {
			System.out.println("------------------MENU-----------------------");
			System.out.println("1: Gerenciar Temas  ");
			System.out.println("2: Gerenciar Palavras");
			System.out.println("3: Jogar");
			System.out.println("4: Sair");

			Scanner t = new Scanner(System.in);
			opcao = Integer.parseInt(t.nextLine());

			if (opcao == 1) {

				System.out.println("----------Gerenciar Temas-----------");
				System.out.println("1: Cadastro:  ");
				System.out.println("2: Exclus�o");
				System.out.println("3: Busca");
				opcao = Integer.parseInt(t.nextLine());

				if (opcao == 1) {
					for (int i = 0; i < vetorTemasPalasvras.length; i++) {
						if (vetorTemasPalasvras[i][v] == null) {

							System.out.println("informa o tema desejado");
							vetorTemasPalasvras[i][v] = t.nextLine();
							System.out.println(vetorTemasPalasvras[i][v]);
							break;
						}
					}
				}
				if (opcao == 3){

					for (int i = 0; i < vetorTemasPalasvras.length; i++) {

						int contador = i;
						if (vetorTemasPalasvras[i][v] != null) {
							System.out.println((contador + 1) + ":" + vetorTemasPalasvras[i][v]);
							
						}						
					}
					opcao = 0;
				}

			}

			if (opcao == 2) {
				System.out.println("----------Gerenciar Palavras-----------");
				System.out.println("1: Cadastro:  ");
				System.out.println("2: Exclus�o");
				System.out.println("3: Busca");
				System.out.println("4: Listagem");
				opcao = Integer.parseInt(t.nextLine());

				if (opcao == 1) {
					for (int i = 0; i < vetorTemasPalasvras.length; i++) {

						int contador = i;
						if (vetorTemasPalasvras[i][v] != null) {
							System.out.println((contador + 1) + ":" + vetorTemasPalasvras[i][v]);
						}	
												
					}					
					for (int k = 1; k < vetorTemasPalasvras.length; k++) {
						System.out.println("selecione o tema para poder cadastra uma palavra");
						v = Integer.parseInt(t.nextLine())-1;

						if (vetorTemasPalasvras[v][k] != null) {

							System.out.println("informa o a palavra ");
							vetorTemasPalasvras[v][k] = t.nextLine();
							System.out.println(vetorTemasPalasvras[k][v]);
						}
					}
				}
				if(opcao == 4){
					for (int i = 0; i < vetorTemasPalasvras.length; i++) {

						int contador = i;
						if (vetorTemasPalasvras[i][v] != null) {
							System.out.println((contador + 1) + ":" + vetorTemasPalasvras[i][v]);
						}							
					}
					System.out.println("selecione o tema para poder listar as palavra");
					v = Integer.parseInt(t.nextLine())-1;

					for (int i = 0; i < vetorTemasPalasvras[v].length; i++) {

						int contador = i;
						if (vetorTemasPalasvras[v][i] != null) {
							System.out.println((contador + 1) + ":" + vetorTemasPalasvras[v][i]);				
						}	
					}
				}
			}

			if (opcao == 3) {

				for (int i = 0; i < vetorTemasPalasvras.length; i++) {

					int contador = i;
					if (vetorTemasPalasvras[i][v] != null) {
						System.out.println((contador + 1) + ":" + vetorTemasPalasvras[i][v]);
					}	
											
				}
				System.out.println("selecione o tema para poder jogar");
						v = Integer.parseInt(t.nextLine())-1;

						for (int i = 0; i < vetorTemasPalasvras.length; i++) {

							if(vetorTemasPalasvras[v][i] == null){
								palavraChave = vetorTemasPalasvras[v][gerador.nextInt(i-1)] ;

							}
							
						}

				for (int i = 1; i <= MAX_TENTATIVA; i++) {
					palavraSendoAdivinhada += "_";

					for (int tentativas = 0;; tentativas++) {
						if (tentativas == MAX_TENTATIVA) {
							System.out.println("Você perdeu!");
						}
						System.out.printf("rodada %d. ate agora %s: qual e a sua proxima letra ", tentativas,
								palavraSendoAdivinhada);

						char letraTentada = new Scanner(System.in).next().charAt(0);

						if (letraUsadas.indexOf(letraTentada) >= 0) {
							System.out.printf(" vc ja tentou a letra %c ", letraTentada);
						} else {
							letraUsadas += letraTentada;

							if (palavraChave.indexOf(letraTentada) >= 0) {
								palavraSendoAdivinhada = "";

								for (int j = 0; j < palavraChave.length(); j++) {
									palavraSendoAdivinhada += letraUsadas.indexOf(palavraChave.charAt(j)) >= 0
											? palavraChave.charAt(j)
											: "_";
								}

								if (palavraSendoAdivinhada.contains("_")) {
									System.out.printf("muito bem: %S existe na palavra e ainda tem leta escondida ",
											letraTentada);
								} else {
									System.out.printf("Parabéns! Você acertou a palavra! Deseja jogar novamente");
									
								}
							} else {
								System.out.println("a letra informada n existe ");
							}
						}

						
					}
									
				}

			}
			if (opcao == 4) {
				System.exit(0);
			}
		}

	}

}
