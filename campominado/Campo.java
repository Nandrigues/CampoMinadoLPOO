package campominado;


import celulas.*; 
import java.util.Random;


public class Campo implements ICampo {
	Celula [] [] celulaTab;
	int i,j,cont,vizcombomba,minas,ibomba,jbomba, nivel, malucas,maluquisse, imaluca,jmaluca;
	boolean maluca;
	
	
	public Campo() { // Construtor
		celulaTab = new Celula [Constantes.LINHAS][Constantes.COLUNAS];
		for(i=0;i<Constantes.LINHAS;i++) { 
			for(j=0;j<Constantes.COLUNAS;j++) {
				celulaTab [i][j] = new CelulaBranca(); // Adicionando as celulas a matriz
			}
		}
		setBombaTabuleiro();
		

	}
		
		public void adicionandoVizinhos() {

		for(i=0; i<Constantes.LINHAS; i++) { // Adicionando os vizinhos das celula escolhida
			for(j=0;j<Constantes.COLUNAS;j++) {
				celulaTab[i][j].getChunk().clear();
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
		

		public void contaBombas(){
			for(i=0; i<Constantes.LINHAS; i++) { // Adicionando os vizinhos das celula escolhida
				for(j=0;j<Constantes.COLUNAS;j++) {
					vizcombomba = 0;
					if(!(celulaTab[i][j] instanceof CelulaBombada)){
						for (int cont = 0; cont < celulaTab[i][j].getChunk().size(); cont++) {
							if(celulaTab[i][j].getChunk().get(cont) instanceof CelulaBombada ){
								vizcombomba++;
							}
						}celulaTab[i][j].setVizinhosbomba(vizcombomba);
					}
				}
		}
  }

  		
	public void maluquisse(int i, int j){
		Random rand = new Random();
				if(celulaTab[i][j].getMaluca()&&rand.nextInt(nivel)>=1){
				//em tese nv 1 - 50% nv 2 - 66% nv 3 - 75%
					if(celulaTab[i][j] instanceof CelulaBombada){
						celulaTab[i][j] = new CelulaBranca();
					}else{celulaTab[i][j] = new CelulaBombada();
					}
					
				}
			}
	
		

		public void setBombaTabuleiro() {
			Random rand = new Random(); 
				minas = 0; 
				do {
				ibomba = rand.nextInt(Constantes.LINHAS);
				jbomba = rand.nextInt(Constantes.COLUNAS);
					if(!(celulaTab[ibomba][jbomba].getBombado())) {
						celulaTab[ibomba][jbomba] = new CelulaBombada();

						minas++; 
					} 
				}while(minas<Constantes.NUMINAS);
				 
			}

			/*public void setMaluquisse() {
				Random rand = new Random(); 
					malucas = 0; 
					do {
					ibomba = rand.nextInt(Constantes.LINHAS);
					jbomba = rand.nextInt(Constantes.COLUNAS);
						if(!(celulaTab[ibomba][jbomba].getMaluca())) {
							celulaTab[ibomba][jbomba] = new CelulaMaluca();
							malucas++; 
						} 
					}while(malucas<Constantes.NUMALUCAS);
				}*/

		public void nomeAosBois() {
			for (i = 0; i<Constantes.LINHAS; i++) {
				for (j = 0; j <Constantes.COLUNAS; j++) {
					if(celulaTab[i][j].getBombado()){
						for(cont = 0; cont<celulaTab[i][j].getChunk().size();cont++){
							if(!(celulaTab[i][j].getChunk().get(cont).getBombado())){
								celulaTab[i][j].getChunk().get(cont).setehVizinha(true);
							}
						}
					}
				}
				
			}
			for (i = 0; i<Constantes.LINHAS; i++) {
				for (j = 0; j <Constantes.COLUNAS; j++) {
			if(celulaTab[i][j].getehVizinha()){
				maluca = celulaTab[i][j].getMaluca();
				celulaTab[i][j] = new CelulaVizinhaBomba();
				celulaTab[i][j].setMaluca(maluca);
			}}}
		}
	
		/*
		public void transformacaoNivelUm() {
			Random rand = new Random();
			int coeficienteMaluco;
			coeficienteMaluco = rand.nextInt(10);
			
			if(coeficienteMaluco > 4) {
				celulaTab[i][j].getBombado();
			}

		}*/
		
		
}


