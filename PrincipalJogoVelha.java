package com.uninter; 
import java.util.Scanner;

public class PrincipalJogoVelha {
    
    
    public static void main(String[] args) {
        
        
        Scanner teclado = new Scanner(System.in); 
      
        Jogador player = new Jogador(); // classe Jogador
        ComputadorA cpu1 = new ComputadorA(); // classes filha de Computador,verifica  a matriz em busca de espaço vazio, caso seja vazio a String "O" é armazenada. 
        ComputadorB cpu2 = new ComputadorB(); // random
        ComputadorB cpu3 = new ComputadorB(); // compara os lados da tabela e tenta impedir a vitoria, se não conseguir o modelo irão trabalhar com valores aleatprios
        
        //  Menu do jogo 
        while(true){
            Tabuleiro tabVelha = new Tabuleiro(); 
            int nivel = menu();//exibe o menu e niveis de dificuldade
            boolean vitoriaJogador; 
            
            //Loop do jogo 
            
            do{
            	
                if(tabVelha.qtdJogadas == 9){// fim do jogo
                    break;
                }
                String x,y; // variaveis de entrada de dados posicão x e y da matriz
                x = y = "";  
                tabVelha.imprimirTabuleiro(); // imprime o tabuleiro para o usuário 
                
                //Entrada de tratamento de dados - permite que o usupario digite
                do{
                    System.out.print("Insira a posiçao da linha: "); 
                    x = teclado.next();
                    System.out.print("Posição da Coluna: "); 
                    y  = teclado.next();
                }while(!(player.jogar(tabVelha.matTabuleiro, x, y)));
                tabVelha.qtdJogadas++;//adicionando  numero de jogadas
                
                // verificando se há algum ganhador 
                
                vitoriaJogador = tabVelha.verificarVitoria();
                if(!(vitoriaJogador)){
                	
                    //faz a jogada de acordo com a nivel selecionado
                    
                	switch(nivel){
                    case 1:
                        cpu1.jogar(tabVelha.matTabuleiro);
                        break;
                    case 2:
                        cpu2.jogar(tabVelha.matTabuleiro);
                        break;
                    case 3:
                        cpu3.jogar(tabVelha.matTabuleiro);
                        break;
                    }
                    tabVelha.qtdJogadas++;//adiciona numero de jogadas
                }
                
             // o jogo encerra se ouver empate o vitoria;    
            }while(!(tabVelha.verificarVitoria()));// 
            
            //
            tabVelha.imprimirTabuleiro();
            System.out.println(tabVelha.statusJogo());
            System.out.println("Digite um numero e pressione enter para jogar novamente");
            teclado.next();
            
            
        }
        
        
        
        
        
        
    // função menu  
    }
    public static int menu(){
        Scanner teclado = new Scanner(System.in);
        int nivel = 0;
        // retorna o valor de acordo com os dados de entrada do teclado 
        while(true){
            try{
                System.out.print("\nSelecione o nivel para jogar 1,2,3: ");
                nivel = Integer.parseInt(teclado.next());
                switch(nivel){
                    case 1:
                        return 1;
                    case 2:
                        return 2;
                    case 3:
                        return 3;
                    default: // caso não digite 1,2,3 a mensagem de erro e exibida
                        System.out.println("Nivel inválido, tente novamente!" );
                }
             // não permite digitar outro tipo a não ser numeros inteiros   
            }catch(Exception e){
                    System.out.println("Por favor, Digite apenas numeros inteiros");
            }
        }
    }
    
    
}



