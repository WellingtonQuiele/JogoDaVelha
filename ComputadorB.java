package com.uninter;
import java.util.Random;

public class ComputadorB extends Computador{
    Random numeroAleatorio = new Random(); // Classe java util.Random que trabalha com valores aleat�rios
    
    @Override
    public void jogar(String[][] mapa) {
        //varrendo  a matriz em posi��es aleatorias e marcando caso o espa�o esteja vazio; 
        int x,y;
        while(true){
            x = numeroAleatorio.nextInt(3);
            y = numeroAleatorio.nextInt(3);
            if(mapa[x][y].equals(" ")){
                mapa[x][y] = "O";
                return;
            }
            
        }
    }

}
