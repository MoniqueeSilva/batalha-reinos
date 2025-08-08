public abstract class Peca{
    public String nome, simbolo, jogadorDono;
    public int posicaoX, posicaoY;

    public Peca(String nome, String simbolo, String jogadorDono, int posicaoX, int posicaoY){
        this.nome = nome;
        this.simbolo = simbolo;
        this.jogadorDono = jogadorDono;
        this.posicaoX = posicaoX;
        this.posicaoY = posicaoY;
    }

    public String getNome(){
        return nome;
    }
    public String getSimbolo(){
        return simbolo;
    }
    public String getJogadorDono(){
        return jogadorDono;
    }
    public int getPosicaoX(){
        return posicaoX;
    }
    public int getPosicaoY(){
        return posicaoY;
    }

    public void setPosicao(int x, int y) {
    this.posicaoX = x;
    this.posicaoY = y;
}

    public abstract boolean podeMoverPara(int novoX, int novoY); //método abstrato

    public void moverPara(int novoX, int novoY){
        this.posicaoX = novoX;
        this.posicaoY = novoY;
    }
}