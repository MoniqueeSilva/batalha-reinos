public class Guerreiro extends Peca {
    public Guerreiro(int posicaoX, int posicaoY, String jogadorDono){
        super("Guerreiro", "G", jogadorDono, posicaoX, posicaoY);
    }

    public boolean podeMoverPara(int novoX, int novoY){
        int movimentoX = posicaoX - novoX;
        int movimentoY = posicaoY - novoY;

        return movimentoX == 0 && movimentoY >= -3 && movimentoY <= 3 
            || movimentoY == 0 && movimentoX >= -3 && movimentoX <= 3;
    }
}
// calculo - : quantas casas a peça quer se mover
// movimento == 0 indica que: não pode andar na diagonal