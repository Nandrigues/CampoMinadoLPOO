package campominado;

import java.util.Random;

import celulas.*;


public class CampoMinadoMaluco extends Campo {
	
	private int nivel,taxaMaluca, imal, jmal; 
	
	public CampoMinadoMaluco(int nivel) throws InterruptedException { // Construtor
		Celula [] [] celulaTab;
		celulaTab = new Celula [Constantes.LINHAS][Constantes.COLUNAS];
		for(i=0;i<Constantes.LINHAS;i++) { 
			for(j=0;j<Constantes.COLUNAS;j++) {
				celulaTab [i][j] = new CelulaBranca(); // Adicionando as celulas a matriz
			}
		}
		setNivel(nivel);

		ajeitar();
	}
	

	public int getNivel() {
		return nivel;
	}


	public void setNivel(int nivel) {
		this.nivel = nivel;
	}


	public void contaBombas(){
		for(i=0; i<Constantes.LINHAS; i++) { // Adicionando os vizinhos das celula escolhida
			for(j=0;j<Constantes.COLUNAS;j++) {
				vizcombomba = 0;
				if(!(celulaTab[i][j] instanceof CelulaBombada)){
					for (int cont = 0; cont < celulaTab[i][j].getChunk().size(); cont++) {
						if(celulaTab[i][j].getChunk().get(cont) instanceof CelulaBombada || (celulaTab[i][j].getChunk().get(cont) instanceof CelulaMaluca && celulaTab[i][j].getChunk().get(cont).getBombado()) ){
							vizcombomba++;
						}
					}celulaTab[i][j].setVizinhosbomba(vizcombomba);
				}
			}
		}
	}
	
	public void setCelulasMalucas() throws InterruptedException{
		Random randmaluco = new Random(); 
			malucas = 0; 
			do {
			imal = randmaluco.nextInt(Constantes.LINHAS);
			jmal = randmaluco.nextInt(Constantes.COLUNAS);
				if(!(celulaTab[imal][jmal].getMaluca())) {
					celulaTab[imal][jmal].setMaluca(true);
					malucas++;
				} 
			}while(malucas<Constantes.NUMALUCAS);
			 
		}

	public void ajeitar() throws InterruptedException{

		setCelulasMalucas();
		
		adicionandoVizinhos();
		nomeAosBois();
		adicionandoVizinhos();
		
	}
	
	public void transformacaoCelulaMaluca(int a, int b) {
		Random rand = new Random();
		taxaMaluca = rand.nextInt(10);
		
		switch(getNivel()) {
			case 1:
			if(taxaMaluca < 5) { //teste (40% de chance)				
				if(celulaTab[a][b].getMaluca()) {
					if(celulaTab[a][b].getBombado()){
						celulaTab[a][b].setBombado(false);
					}else{ celulaTab[a][b].setBombado(true);
					}
				}	
			break;
			}
			case 2:
				if(taxaMaluca < 9) { //teste (80% de chance)				
					if(celulaTab[a][b].getMaluca()) {
						if(celulaTab[a][b] instanceof CelulaBombada){
							maluca = celulaTab[a][b].getMaluca();
							celulaTab[a][b] = new CelulaVizinhaBomba();
							celulaTab[a][b].setMaluca(maluca);
						}else{maluca = celulaTab[a][b].getMaluca();
							  celulaTab[a][b] = new CelulaBombada();
							  celulaTab[a][b].setMaluca(maluca);
						}
					}	
				break;
			}
			default: 
				break;	
			}
		 
		}
	
}