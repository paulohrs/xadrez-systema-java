package xadrez;

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
	
	private void ColoqueNovaPeca(char coluna, int linha, XadrezPeca peca) {
		tabuleiro.lugarPeca(peca, new XadrezPosicao(coluna, linha).toPosicao());
	}
	
	private void inicialPartida() {
		ColoqueNovaPeca('b', 6, new Rei(tabuleiro, Cor.BRANCAS));
		ColoqueNovaPeca('e', 8, new Torre(tabuleiro, Cor.PRETAS));
		ColoqueNovaPeca('e', 1, new Rei(tabuleiro, Cor.PRETAS));
	}
}
