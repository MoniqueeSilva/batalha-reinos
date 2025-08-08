public class Arqueiro extends Peca {
    public Arqueiro(int posicaoX, int posicaoY, String jogadorDono){
        super("Arqueiro", "A", jogadorDono, posicaoX, posicaoY);
    }

    public boolean podeMoverPara(int novoX, int novoY){ // Pode mover para uma posição nova
        // Quanto a peça vai se mover 
        int movimentoX = posicaoX - novoX;
        int movimentoY = posicaoY - novoY;

        return (movimentoX == movimentoY || movimentoX == -movimentoY) 
            && movimentoX >= -2 && movimentoX <= 2 
            && movimentoY >= -2 && movimentoY <= 2;
    }
}
