package campominado;

public class Principal {
	public static void main(String[] args) throws InterruptedException{
		Consoleui console = new Consoleui();

		console.modoDeJogo();
		console.clearScreen();
		console.printarCampo();
			do {
					
				console.lerAcao();
				Thread.sleep(1000);
				console.clearScreen();
				console.printarCampo();
				
			} while (console.getrodar() == true);
		}
}


