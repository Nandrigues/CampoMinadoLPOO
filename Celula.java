package campominado;

import java.util.ArrayList;

public class Celula {
	private boolean bombado;
	private boolean clicado;
	private boolean sinalizado; 
	private boolean revelado;
	
	ArrayList <Celula> chunk; 
	
	public Celula(){
		this.bombado = false; 
		this.clicado = false; 
		this.sinalizado = false; 
		this.revelado = false;
		
		this.chunk = new ArrayList(); 
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
