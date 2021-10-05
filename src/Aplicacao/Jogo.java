package Aplicacao;

import java.util.InputMismatchException;
import java.util.Scanner;

import xadrez.XadrezException;
import xadrez.XadrezPartida;
import xadrez.XadrezPeca;
import xadrez.XadrezPosicao;

public class Jogo {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		XadrezPartida xadrezPartida = new XadrezPartida();

		while (true) {
			try {
				UI.clearScreen();
				UI.printTabuleiro(xadrezPartida.getPecas());
				System.out.println();
				System.out.print("Posição de Origem: ");
				XadrezPosicao procura = UI.lerXadrezPosicao(sc);
				
				System.out.println();
				System.out.print("Posição Destino: ");
				XadrezPosicao alvo = UI.lerXadrezPosicao(sc);
			
			XadrezPeca capturaPeca = xadrezPartida.performeXadrezMover(procura, alvo);
			}
			catch (XadrezException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
			catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
		}
	}

}
