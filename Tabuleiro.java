package com.uninter;


public class Tabuleiro {

    public String matTabuleiro[][] = new String[3][3];//matriz do tabuleiro
    public int qtdJogadas; // armazena quantidade de jogadas 
    private String marca; //armazenar (X ou O) do vencedor 
    
    public Tabuleiro(){
        this.qtdJogadas = 0;
        iniciarPosicoes();
        this.marca = "";
    }
    
    private void iniciarPosicoes(){
        //inicia as posições com string vazia 
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                this.matTabuleiro[i][j] = " ";
            }
        }
    } //atualizada a tela a cada jogada
    private void atualizaTela(){
        for(int i = 0; i < 30; i++){
            System.out.println();
        }
        // Mostra as coordenadas de cada jogada  para o usuário
        System.out.println("======================");
        System.out.println("   JOGO DA VELHA");
        System.out.println("X - PLAYER | O - CPU\n");
        System.out.println("======================");
        
    }
    public void imprimirTabuleiro(){
       atualizaTela(); // atualiza de tela a cada jogada
       
       // mostra as marcações do tabuleiro 
       for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                System.out.print(this.matTabuleiro[i][j]);
                if(j<2){
                    System.out.print("|");
                }
                
            }
            if(i<2){
                System.out.println("\n-|-|-");
            }
        }
        System.out.println("\n");
    }
    public boolean verificarVitoria(){
        //Verificar se a  possibilidade de vitoria por numeros de jogadas
        if(qtdJogadas < 5){
            return false;
        }
        // verificando possibilidade de vitorias = horizontal, vertical e diagonal
        //Verificar vitoria diagonal 1 
        if(matTabuleiro[0][0].equals(matTabuleiro[1][1]) && matTabuleiro[1][1].equals(matTabuleiro[2][2]) && !(matTabuleiro[1][1].equals(" "))){
            this.marca = matTabuleiro[0][0];
            return true;
        } //Verificar vitoria diagonal 2 
        if(matTabuleiro[2][0].equals(matTabuleiro[1][1]) && matTabuleiro[1][1].equals(matTabuleiro[0][2]) && !(matTabuleiro[1][1].equals(" "))){
            this.marca = matTabuleiro[2][0];
            return true;
            
        }
        //verificar todas as possibilidades de vitoria verticais e horizontais
        for(int i = 0; i < 3; i++){
            //Verificar vitoria VERTICAL
            if(matTabuleiro[i][0].equals(matTabuleiro[i][1]) && matTabuleiro[i][1].equals(matTabuleiro[i][2]) && !(matTabuleiro[i][1].equals(" "))){
                this.marca = matTabuleiro[i][0];
                return true;
            }
            
            // Verificar vitoria HORIZONTAL
            if(matTabuleiro[0][i].equals(matTabuleiro[1][i]) && matTabuleiro[1][i].equals(matTabuleiro[2][i]) && !(matTabuleiro[1][i].equals(" "))){
                this.marca = matTabuleiro[0][i];
                return true;
            }
            
        }
        return false;
    }
    
    public String statusJogo(){
        //mostrando status atual da partida
        boolean statusVitoria = verificarVitoria(); 
        // condicação que retorn qual o vencedor ou empate na jogada 
        if(statusVitoria == false && qtdJogadas == 9){
            return "EMPATE";
        }else if(statusVitoria == false){
            return "INACABADO";
        }else{
            if(this.marca == "X"){
                return "JOGADOR VENCE";
            }else{
                return "COMPUTADOR VENCE";
            }
        }
    }
    
}
