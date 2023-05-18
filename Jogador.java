package com.uninter;


public class Jogador {
    
	// recebe  x e y como parametro 
    public boolean jogar(String mapa[][], String horizontal, String vertical){
        
    	//verifica se a posi��o est� ocupada e caso esteja, marca com um X (padr�o do Jogador player)
        try{
        	
        	// tratamento de dados para evitar erros no programa 
            int x = Integer.parseInt(horizontal);
            int y = Integer.parseInt(vertical);
            if (mapa[x-1][y-1].equals(" ")){
                mapa[x-1][y-1] = "X";
                return true;
            }else{
                
                System.out.println("Tente novamente:" );   //exibindo mensagem de erro 
                return false;
            } // tratamento caso o usu�rio coloque  um valor que n�o seja inteiro 
        }catch(Exception e){
            System.out.println("Valor invalido");  
            return false;
        }
                    
    }
}
