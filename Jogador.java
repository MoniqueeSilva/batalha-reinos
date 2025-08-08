import java.util.ArrayList;
import java.util.List;

public class Jogador {
    private String nome;
    private List<Peca> pecas;

    public Jogador(String nome) {
        this.nome = nome;
        this.pecas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public List<Peca> getPecas() {
        return pecas;
    }

    public void adicionarPeca(Peca peca) {
        pecas.add(peca);
    }

    public void removerPeca(Peca peca) {
        pecas.remove(peca);
    }

    public boolean temPecas() {
        return pecas.size() > 0;
    }

    public boolean estaSemPecas() {
        return pecas.size() == 0;
    }

    public void mostrarPecas() {
        for (int i = 0; i < pecas.size(); i++) {
            Peca p = pecas.get(i);
            System.out.println(i + ": " + p.getClass().getSimpleName() + " na posição (" + p.getPosicaoX() + ", " + p.getPosicaoY() + ")");
            //class: pega a classe peça: G, A, C
            //simplesName: pega só o nome da classe: ex Arqueiro
        }
    }

    public Peca getPeca(int index) {
        if (index >= 0 && index < pecas.size()) {
            return pecas.get(index);
        }
        return null;
    }

    public boolean temPeca(Peca peca) {
        for(Peca p : pecas ){
            if(p == peca){
                return true;
            }
        }
        return false;
    }
}
