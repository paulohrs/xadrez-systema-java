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
		ColoqueNovaPeca('e', 1, new Rei(tabuleiro, Cor.PRETAS));
		ColoqueNovaPeca('c', 2, new Torre(tabuleiro, Cor.BRANCAS));
		ColoqueNovaPeca('d', 2, new Torre(tabuleiro, Cor.BRANCAS));
		ColoqueNovaPeca('e', 2, new Torre(tabuleiro, Cor.BRANCAS));
		ColoqueNovaPeca('e', 4, new Torre(tabuleiro, Cor.BRANCAS));
		ColoqueNovaPeca('d', 1, new Rei(tabuleiro, Cor.BRANCAS));

		ColoqueNovaPeca('c', 7, new Torre(tabuleiro, Cor.PRETAS));
		ColoqueNovaPeca('c', 8, new Torre(tabuleiro, Cor.PRETAS));
        ColoqueNovaPeca('d', 7, new Torre(tabuleiro, Cor.PRETAS));
        ColoqueNovaPeca('e', 7, new Torre(tabuleiro, Cor.PRETAS));
        ColoqueNovaPeca('e', 8, new Torre(tabuleiro, Cor.PRETAS));
        ColoqueNovaPeca('d', 8, new Rei(tabuleiro, Cor.PRETAS));
	}
}
