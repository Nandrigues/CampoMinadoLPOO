package campominado;

import java.util.ArrayList;

public class Celula {
	protected boolean bombado;
	private boolean clicado;
	protected boolean sinalizado; 
	protected int vizinhosbomba;
	
	
	ArrayList <Celula> chunk; 
	
	public Celula(){ // Construtor
		this.bombado = false; 
		this.clicado = false; 
		this.sinalizado = false; 
		this.vizinhosbomba = 9;
		
		this.chunk = new ArrayList(); // Alocagem dinamica
	}
	
	public void addchunk(Celula a) { // Adicionando o Array de vizinhos
		this.chunk.add(a); 
	}
	
	public boolean getclicado() { // Checando se está clicado 
		return this.clicado;
	}
	
	public void setclicado(boolean click) { // Setando o clicado
		this.clicado = click;
	}

	public boolean getsinalizado() { // Checando se está sinalizado
		return this.sinalizado;
	}
	
	public void setsinalizado(boolean a) { // Setando a sinalização 
		this.sinalizado = a;
	}
	
	public void setBombado(boolean bomb) { // Setando a bomba
		this.bombado = bomb;
	}
	
	public boolean getBombado() { // Checando se tem bomba
		return this.bombado; 
	}
	
	public boolean tembomba() { 
		if(this.bombado == true){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean sinalizar() {
		if(this.sinalizado == false) {
			return this.sinalizado = true;
		}else {
			return false; 
		}
		
	}
	public void vizinhosBombados(int v){ // Quantidade de vizinhos com bomba
		this.vizinhosbomba = v;
	}
	
	
	
}
