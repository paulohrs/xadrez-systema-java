package Aplicacao;

import java.util.Scanner;

import xadrez.XadrezPartida;
import xadrez.XadrezPeca;
import xadrez.XadrezPosicao;

public class Jogo {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		XadrezPartida xadrezPartida = new XadrezPartida();

		while (true) {
			UI.printTabuleiro(xadrezPartida.getPecas());
			System.out.println();
			System.out.print("Posição de Origem: ");
			XadrezPosicao procura = UI.lerXadrezPosicao(sc);
			
			System.out.println();
			System.out.print("Posição Destino: ");
			XadrezPosicao alvo = UI.lerXadrezPosicao(sc);
			
			XadrezPeca capturaPeca = xadrezPartida.performeXadrezMover(procura, alvo);
			sc.close();
		}
	}

}
