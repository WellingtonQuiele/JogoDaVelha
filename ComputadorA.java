package com.uninter;


public class ComputadorA extends Computador{
    @Override
    public void jogar(String mapa[][]){
        // o for verifica  a matriz em busca de espaço vazio, caso seja vazio a String "O" é armazenada. 
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(mapa[i][j].equals(" ")){
                    mapa[i][j] = "O";
                    return;
                }
            }
        }
    }

    
}
