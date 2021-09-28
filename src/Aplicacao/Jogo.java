package Aplicacao;

import xadrez.XadrezPartida;

public class Jogo {

	public static void main(String[] args) {

		XadrezPartida xadrezPartida = new XadrezPartida();

		UI.printTabuleiro(xadrezPartida.getPecas());

	}

}
