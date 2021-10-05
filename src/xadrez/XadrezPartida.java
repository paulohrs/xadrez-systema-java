package xadrez;

import tabuleirojogo.Peca;
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
	
	public XadrezPeca performeXadrezMover(XadrezPosicao produrarPosicao, XadrezPosicao alvoPosicao) {	
		Posicao procura = produrarPosicao.toPosicao();
		Posicao alvo = alvoPosicao.toPosicao();
		validarProcuraPosicao(procura);
		Peca capturaPeca = fazerMovimento(procura, alvo);
		return (XadrezPeca) capturaPeca;
	}
	
	private Peca fazerMovimento(Posicao procura, Posicao alvo) {
		Peca p = tabuleiro.removerPeca(procura);
		Peca capturaPeca = tabuleiro.removerPeca(alvo);
		tabuleiro.lugarPeca(p, alvo);
		return (XadrezPeca)capturaPeca;
	}
	private void validarProcuraPosicao(Posicao posicao) {
		if (!tabuleiro.temUmaPeca(posicao)) {
			throw new XadrezException("Não existe peça na posição de origem");
		}
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
