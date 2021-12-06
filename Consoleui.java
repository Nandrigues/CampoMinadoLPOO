package campominado;

import java.io.IOException;
import java.util.Scanner;


import celulas.*;

public class Consoleui implements IConsoleui {
    private int i, j, a, b, c, index,cont,abremais,bombapertada =0;
    private boolean rodar = true;
    private String opcaoCel, opcaoSin;
    private Campo tabuleiro = new Campo(); 
    Scanner scan = new Scanner(System.in);
    Scanner scanear = new Scanner(System.in);
    
    public void modoDeJogo() throws InterruptedException {
        System.out.println("Que modo de jogo deseja jogar?");
        System.out.println("    1- Normal     2-Maluco    ");
        c = scan.nextInt();
        if(c==2){
            System.out.println("Qual a dificuldade da maluquisse");
            System.out.println("1              2");
            tabuleiro = new CampoMinadoMaluco(scan.nextInt());
            
        }else{
        	 tabuleiro = new CampoNormal();
        }scan.nextLine();
    }


    public void printarCampo(){
        tabuleiro.adicionandoVizinhos();
        tabuleiro.contaBombas();
        if(tabuleiro instanceof CampoNormal){
            System.out.println("    N O R M A L");
        }else if(tabuleiro instanceof CampoMinadoMaluco){
            System.out.println("    M A L U C O");}
        System.out.print("  1 2 3 4 5 6 7 8 \n");
        index = 1;
        for (i=0;i<Constantes.COLUNAS;i++) {
            System.out.print(index + " ");
            for (j=0;j<Constantes.LINHAS;j++){
                if(tabuleiro.celulaTab[i][j].getclicado()){ 
                	if((tabuleiro.celulaTab[i][j] instanceof CelulaBombada) == true) {
                		System.out.print("B ");
                        bombapertada++;
                	}
                    else {
                	System.out.print(tabuleiro.celulaTab[i][j].getVizinhosbomba() + " ");
                	}           
                }else if(tabuleiro.celulaTab[i][j].getsinalizado()) {
                	System.out.print("P ");
                }else if(tabuleiro.celulaTab[i][j].getMaluca()){
                    System.out.print("M ");
                }else{
                	System.out.print("X ");
                }
                
            }System.out.print("\n");
            index++;
        } 
        if(bombapertada>0){
            System.out.println("BOOMM, voce perdeu!");
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            rodar = false;
        }
        checarVitoria();
        
    }
    

    public void checarVitoria(){
        cont = 0;
        for (i=0;i<Constantes.COLUNAS;i++) {
            for (j=0;j<Constantes.LINHAS;j++){
                if(tabuleiro.celulaTab[i][j].getclicado() || tabuleiro.celulaTab[i][j] instanceof CelulaBombada){
                    cont++;
                }
            }
        }
        if(cont == 64){
            System.out.println("VITÓRIA!!!!!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            rodar = false;
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
        System.out.println("Qual celula vc deseja clicar?(Linha Coluna)");
        opcaoCel = scanear.nextLine();
        a = Character.getNumericValue(opcaoCel.charAt(0))-1;
        b = Character.getNumericValue(opcaoCel.charAt(2))-1;
        System.out.print("\nDigite: 1 para clicar. 2 para sinalizar. 3 para fechar: \n");
        opcaoSin = scanear.nextLine();
        if((tabuleiro.celulaTab[a][b].getclicado()) == false){
            if(opcaoSin.equals("1")){
                if((tabuleiro.celulaTab[a][b].getsinalizado())== false){
                    tabuleiro.celulaTab[a][b].setclicado(true);
                        if(!(tabuleiro.celulaTab[a][b].getBombado())&&tabuleiro.celulaTab[a][b].getVizinhosbomba()==0){
                            clicarVizinhos();
                        }
                    
                    }else{
                        System.out.println("nao pode clicar em celula sinalizada");
                    }
            }else if(opcaoSin.equals("2")){ // Celula Maluca Sinalizada
                if(tabuleiro.celulaTab[a][b].getsinalizado() == false){
            	        
                        if(tabuleiro instanceof CampoMinadoMaluco){
                            ((CampoMinadoMaluco) tabuleiro).transformacaoCelulaMaluca(a,b);
                            // Eh necessario chamar o metodo do nivel junto a celula maluca
                        }tabuleiro.celulaTab[a][b].setsinalizado(true);
                    }else{tabuleiro.celulaTab[a][b].setsinalizado(false);}
                
            }else if(opcaoSin.equals("3")){
                rodar = false;
            }
            else{
                System.out.println("opcao invalida");
            }
        }else{
            System.out.println("essa celula ja foi clicada.");
        }
    }
    
    public boolean getrodar(){
      return rodar;  
    }
    
    public void clicarVizinhos(){
        
        do{
            abremais=0;
            for (i=0;i<Constantes.COLUNAS;i++) {
                for (j=0;j<Constantes.LINHAS;j++){
                    if(tabuleiro.celulaTab[i][j].getclicado() && tabuleiro.celulaTab[i][j].getVizinhosbomba()==0){
                    for(cont = 0; cont<tabuleiro.celulaTab[i][j].getChunk().size();cont++){
                        if(tabuleiro.celulaTab[i][j].getChunk().get(cont).getclicado()==false && tabuleiro.celulaTab[i][j].getChunk().get(cont).getMaluca() == false && !(tabuleiro.celulaTab[i][j] instanceof CelulaMaluca) ){
                        tabuleiro.celulaTab[i][j].getChunk().get(cont).setclicado(true);
                        abremais++;
                        }            
                        }                    
                    }
                }
            }
            

        }while(abremais>0);
    
    }
}


