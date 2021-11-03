package campominado;

public class Campo {
	Celula [] [] celulaTab;
	int i,j;
	
	
	public Campo() {
		celulaTab = new Celula [Constantes.LINHAS][Constantes.COLUNAS];
		for(i=0;i<Constantes.LINHAS;i++) { // Adicionando as celulas a matriz
			for(j=0;j<Constantes.COLUNAS;j++) {
				celulaTab [i][j] = new Celula(); 
			}
		}
	}
		
		public void adicionandoVizinhos() {

		for(i=0; i<Constantes.LINHAS; i++) { // Adicionando os vizinhos das celula escolhida
			for(j=0;j<Constantes.COLUNAS;j++) {
				if((i>0 && i<Constantes.LINHAS-1)&&(j>0 && j<Constantes.COLUNAS-1)) {
						celulaTab[i][j].addchunk(celulaTab[i-1][j-1]);
						celulaTab[i][j].addchunk(celulaTab[i-1][j]);
						celulaTab[i][j].addchunk(celulaTab[i-1][j+1]);
						celulaTab[i][j].addchunk(celulaTab[i][j-1]);
						celulaTab[i][j].addchunk(celulaTab[i][j+1]);
						celulaTab[i][j].addchunk(celulaTab[i+1][j-1]);
						celulaTab[i][j].addchunk(celulaTab[i+1][j]);
						celulaTab[i][j].addchunk(celulaTab[i+1][j+1]);
					}
				if(i == 0 && (j>0 && j<Constantes.COLUNAS-1)) {
						celulaTab[i][j].addchunk(celulaTab[i][j-1]);
						celulaTab[i][j].addchunk(celulaTab[i][j+1]);
						celulaTab[i][j].addchunk(celulaTab[i+1][j-1]);
						celulaTab[i][j].addchunk(celulaTab[i+1][j]);
						celulaTab[i][j].addchunk(celulaTab[i+1][j+1]);
				}
				if(i == Constantes.LINHAS-1 && (j>0 && j<Constantes.COLUNAS-1) ) {
						celulaTab[i][j].addchunk(celulaTab[i][j-1]);
						celulaTab[i][j].addchunk(celulaTab[i][j+1]);
						celulaTab[i][j].addchunk(celulaTab[i-1][j-1]);
						celulaTab[i][j].addchunk(celulaTab[i-1][j]);
						celulaTab[i][j].addchunk(celulaTab[i-1][j+1]);
				}
				if(j == 0 && (i>0 && i<Constantes.LINHAS-1)) {
						celulaTab[i][j].addchunk(celulaTab[i-1][j]);
						celulaTab[i][j].addchunk(celulaTab[i-1][j+1]);
						celulaTab[i][j].addchunk(celulaTab[i][j+1]);
						celulaTab[i][j].addchunk(celulaTab[i+1][j]);
						celulaTab[i][j].addchunk(celulaTab[i+1][j+1]);
				}
				if(j == Constantes.COLUNAS-1 && (i>0 && i<Constantes.LINHAS-1)) {
						celulaTab[i][j].addchunk(celulaTab[i-1][j]);
						celulaTab[i][j].addchunk(celulaTab[i-1][j-1]);
						celulaTab[i][j].addchunk(celulaTab[i][j-1]);
						celulaTab[i][j].addchunk(celulaTab[i+1][j-1]);
						celulaTab[i][j].addchunk(celulaTab[i+1][j]);
				}
				if(i == 0 && j == 0) {
						celulaTab[i][j].addchunk(celulaTab[i][j+1]);
						celulaTab[i][j].addchunk(celulaTab[i+1][j+1]);
						celulaTab[i][j].addchunk(celulaTab[i+1][j]);
				}
				if(i == Constantes.LINHAS-1 && j == 0) {
						celulaTab[i][j].addchunk(celulaTab[i][j+1]);
						celulaTab[i][j].addchunk(celulaTab[i-1][j]);
						celulaTab[i][j].addchunk(celulaTab[i-1][j+1]);
				}
				if(i == 0 && j == Constantes.COLUNAS-1) {
						celulaTab[i][j].addchunk(celulaTab[i][j-1]);
						celulaTab[i][j].addchunk(celulaTab[i+1][j-1]);
						celulaTab[i][j].addchunk(celulaTab[i+1][j]);
				}
				if(i == Constantes.LINHAS -1 && j == Constantes.COLUNAS-1) {
						celulaTab[i][j].addchunk(celulaTab[i][j-1]);
						celulaTab[i][j].addchunk(celulaTab[i-1][j]);
						celulaTab[i][j].addchunk(celulaTab[i-1][j-1]);
				}
			}
		} 
		
		
	}
		
		public int bombando() {
			
		}
}
