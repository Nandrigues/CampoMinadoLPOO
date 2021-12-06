package campominado;

import arquivosetempo.Cronometro;

public class Principal {
	public static void main(String[] args) throws InterruptedException{
		Consoleui console = new Consoleui();
		Cronometro cronometro = new Cronometro();

		console.modoDeJogo();
		console.clearScreen();
		console.printarCampo();
		cronometro.start();
			do {
					
				console.lerAcao();
				Thread.sleep(1000);
				console.clearScreen();
				console.printarCampo();
				
			} while (console.getrodar() == true);
			cronometro.stop();
			System.out.println("Tempo: " + cronometro.getElapsedTimeSecs() + " segundos" );
		}
}


