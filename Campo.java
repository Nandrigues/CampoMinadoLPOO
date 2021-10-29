package campominado;

public class Campo {
	Celula [] [] tabuleiro;
	int i,j; 
	
	public Campo() {
		tabuleiro = new Celula [Constantes.LINHAS][Constantes.COLUNAS];
		for(i=0;i<Constantes.LINHAS;i++) {
			for(j=0;j<Constantes.COLUNAS;j++) {
				tabuleiro [i][j] = new Celula(); 
			}
		}
	} 
}
