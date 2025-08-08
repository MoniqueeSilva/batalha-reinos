public class Cavalo extends Peca {
    public Cavalo(int posicaoX, int posicaoY, String jogadorDono){
        super("Cavalo", "C", jogadorDono, posicaoX, posicaoY);
    }

    public boolean podeMoverPara(int novoX, int novoY){
        int movimentoX = posicaoX - novoX;
        int movimentoY = posicaoY - novoY;

        //codição ? valor se verdadeiro : valor se falso
        movimentoX = movimentoX < 0 ? -movimentoX : movimentoX; 
        movimentoY = movimentoY < 0 ? -movimentoY : movimentoY;

         return (movimentoX == 2 && movimentoY == 1) || 
               (movimentoX == 1 && movimentoY == 2);
    }
}
