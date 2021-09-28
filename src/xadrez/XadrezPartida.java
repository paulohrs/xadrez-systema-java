package xadrez;

import tabuleirojogo.Posicao;
import tabuleirojogo.Tabuleiro;
import xadrez.pecas.Rei;
import xadrez.pecas.Torre;

public class XadrezPartida {
	
	private Tabuleiro tabuleiro;
	
	public XadrezPartida() {
		tabuleiro = new Tabuleiro(8, 8);
		inicialPartida();
	}
	
	public XadrezPeca[][] getPecas(){
		XadrezPeca[][] mat = new XadrezPeca[tabuleiro.getLinhas()][tabuleiro.getColunas()];
		for (int i=0; i<tabuleiro.getLinhas(); i++) {
			for (int j=0; j<tabuleiro.getColunas(); j++) {
				mat[i][j] = (XadrezPeca) tabuleiro.peca(i, j);
			}
		}
		
		return mat;
	}
	
	private void inicialPartida() {
		tabuleiro.lugarPeca(new Rei(tabuleiro, Cor.BRANCAS), new Posicao(2, 1));
		tabuleiro.lugarPeca(new Torre(tabuleiro, Cor.PRETAS), new Posicao(0,4));
		tabuleiro.lugarPeca(new Rei(tabuleiro, Cor.PRETAS), new Posicao(7, 4));
	}
}
