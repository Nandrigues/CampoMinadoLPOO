package campominado;

import java.util.ArrayList;

public class Celula {
	private boolean bombado;
	private boolean clicado;
	private boolean sinalizado; 
	private boolean branco;
	
	
	
	ArrayList <Celula> chunk; 
	
	public Celula(){ // Construtor
		this.bombado = false; 
		this.clicado = false; 
		this.sinalizado = false; 
		this.branco = false;
		
		
		this.chunk = new ArrayList(); // Alocagem dinamica
	}
	
	public void addchunk(Celula a) {
		this.chunk.add(a); 
	}
	public int clicado() {
		this.clicado = true; 
		if(this.bombado == true) {
			return -1; 
		}else return 1; 
	}
	
	public boolean bomba() {
		if(this.bombado == false) {
			return this.bombado = true; 
		}else {
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
	
	
	
}
