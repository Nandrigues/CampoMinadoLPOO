package campominado;

import celulas.*;

public class CampoNormal extends Campo {
	
	
	public CampoNormal() { // Construtor
		Celula [] [] celulaTab;
		celulaTab = new Celula [Constantes.LINHAS][Constantes.COLUNAS];
		for(i=0;i<Constantes.LINHAS;i++) { 
			for(j=0;j<Constantes.COLUNAS;j++) {
				celulaTab [i][j] = new CelulaBranca(); // Adicionando as celulas a matriz
			}
		}
		adicionandoVizinhos();
		nomeAosBois();
		adicionandoVizinhos();
		contaBombas();

	}
}
