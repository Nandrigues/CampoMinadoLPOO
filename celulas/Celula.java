package celulas;


import java.util.ArrayList;

public abstract class Celula {
	protected boolean bombado, ehVizinha;
	private boolean clicado, maluca;
	protected boolean sinalizado;
	protected int vizinhosbomba;
	private ArrayList<Celula> chunk;

	public Celula() { // Construtor
		this.bombado = false;
		this.maluca = false;
		this.clicado = false;
		this.sinalizado = false;
		this.vizinhosbomba = 9;
		this.ehVizinha = false;
		this.setChunk(new ArrayList<Celula>());

	}

	public void setChunk(ArrayList<Celula> chunk) {
		try {
			this.chunk = chunk;
		} catch (Exception e) {
			System.out.println("Valor Invalido");
		}
	}

	public ArrayList<Celula> getChunk() {
		return this.chunk;
	}

	public void addchunk(Celula a) { // Adicionando o Array de vizinhos
		this.getChunk().add(a);
	}

	public void setclicado(boolean click) { // Setando o clicado
		try {
			this.clicado = click;
		} catch (Exception e) {
			System.out.println("Valor Invalido");
		}
	}

	public boolean getclicado() { // Checando se esta clicado
		return this.clicado;
	}

	public void setsinalizado(boolean sinal) { // Setando a sinalizacao
		try {
			this.sinalizado = sinal;
		} catch (Exception e) {
			System.out.println("Valor Invalido");
		}
	}

	public boolean getMaluca() {
		return this.maluca;
	}

	public void setMaluca(boolean ehmaluca) {
		try {
			this.maluca = ehmaluca;
		} catch (Exception e) {
			System.out.println("Valor Invalido");
		}
	}

	public boolean getsinalizado() { // Checando se esta sinalizado
		return this.sinalizado;
	}

	public void setBombado(boolean bomb) { // Setando a bomba
		try {
			this.bombado = bomb;
		} catch (Exception e) {
			System.out.println("Valor Invalido");
		}
	}

	public boolean getBombado() { // Checando se tem bomba
		return this.bombado;
	}

	public void setehVizinha(boolean bomb) { // Setando que nao eh bombada
		try {
			this.ehVizinha = bomb;
			this.bombado = !(bomb);
		} catch (Exception e) {
			System.out.println("Valor Invalido");
		}
	}

	public boolean getehVizinha() {
		return this.ehVizinha;
	}

	public int getVizinhosbomba() { // Quantidade de vizinhos com bomba
		return this.vizinhosbomba;
	}

	public void setVizinhosbomba(int vbomba) {
		try {
			this.vizinhosbomba = vbomba;
		} catch (Exception e) {
			System.out.println("Valor Invalido");
		}
	}

}
