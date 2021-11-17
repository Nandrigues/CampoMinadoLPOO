package campominado;
import java.io.IOException;
import java.util.Scanner;

public class Consoleui {
    int i, j, a, b, index;
    String opcaoCel, opcaoSin;
    Campo tabuleiro = new Campo();
    Scanner scan = new Scanner(System.in);
    
    
    public void printarCampo(){
        System.out.print("  1 2 3 4 5 6 7 8 \n");
        index = 1;
        for (i=0;i<Constantes.COLUNAS;i++) {
            System.out.print(index + " ");
            for (j=0;j<Constantes.LINHAS;j++){
                if(tabuleiro.celulaTab[i][j].getclicado()){ 
                	if((tabuleiro.celulaTab[i][j].getBombado()) == true) {
                		System.out.print("B ");
                	}else {
                	System.out.print("O ");
                	}           
                	}else if(tabuleiro.celulaTab[i][j].getsinalizado()) {
                	System.out.print("P ");
                	}else{
                	System.out.print("X ");
                }
                
            }System.out.print("\n");
            index++;
        } 
    }

    public void clearScreen(){
        //Clears Screen in java
        
            if (System.getProperty("os.name").contains("Windows"))
                try {
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                } catch (InterruptedException | IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            else
                try {
                    Runtime.getRuntime().exec("clear");
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        
    }

    public void lerAcao(){
        System.out.print("Qual celula vc deseja clicar?(Linha Coluna) \n");
        opcaoCel = scan.nextLine();
        a = Character.getNumericValue(opcaoCel.charAt(0)) -1;
        b = Character.getNumericValue(opcaoCel.charAt(2)) -1;
        System.out.print("\nDigite: 1 para clicar. 2 para sinalizar: \n");
        opcaoSin = scan.nextLine();
        if((tabuleiro.celulaTab[a][b].getclicado()) == false){
            if(opcaoSin.equals("1")){
                tabuleiro.celulaTab[a][b].setclicado(true);
            }else if(opcaoSin.equals("2")){
                tabuleiro.celulaTab[a][b].setsinalizado(true);
            }else{
            System.out.println("opcao invalida");
            }
        }else{
            System.out.println("essa celula ja foi clicada.");
        }
    }
}