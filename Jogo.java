import java.util.Scanner;

public class Jogo {
    private Peca[][] tabuleiro = new Peca[8][8];
    private Jogador jogador1;
    private Jogador jogador2;
    private Scanner scanner = new Scanner(System.in);

    public void iniciar() {
        System.out.print("Digite o nome do Jogador 1: ");
        String nome1 = scanner.nextLine();
        jogador1 = new Jogador(nome1);

        System.out.print("Digite o nome do Jogador 2: ");
        String nome2 = scanner.nextLine();
        jogador2 = new Jogador(nome2);

        colocarPecas(jogador1, 0);
        colocarPecas(jogador2, 7);

        // Inicia o jogo
        jogar();
    }

    private void colocarPecas(Jogador jogador, int linha1) {
        tabuleiro[linha1][0] = new Guerreiro(linha1, 0, jogador1.getNome());
        tabuleiro[linha1][1] = new Arqueiro(linha1, 1, jogador1.getNome());
        tabuleiro[linha1][2] = new Cavalo(linha1, 2, jogador1.getNome());

        // Adiciona as peças na lista do jogador
        for (int i = 0; i < 3; i++) {
            jogador.adicionarPeca(tabuleiro[linha1][i]);
        }
    }

    public void jogar() {
    Jogador jogadorAtual = jogador1;
    Jogador jogadorInimigo = jogador2;
    boolean jogoAtivo = true;

    while (jogoAtivo) {
        exibirTabuleiro();
        System.out.println("\nVez de " + jogadorAtual.getNome());
        jogadorAtual.mostrarPecas(); //  as peças

        System.out.print("Escolha o número da peça: ");
        int escolha = scanner.nextInt();

        Peca pecaEscolhida = jogadorAtual.getPeca(escolha);
        if (pecaEscolhida == null) {
            System.out.println("Escolha inválida.");
            continue;
        }

        System.out.print("Nova posição X: ");
        int novoX = scanner.nextInt();
        System.out.print("Nova posição Y: ");
        int novoY = scanner.nextInt();

        if (!pecaEscolhida.podeMoverPara(novoX, novoY)) { //movimentar peças no tabuleiro
            System.out.println("Movimento inválido para essa peça!");
            continue;
        }

        // Verifica se tem peça na nova posição
        Peca pecaAlvo = tabuleiro[novoX][novoY]; // Oque tem na posição
        if (pecaAlvo != null) {
            boolean pecaEhMinha = jogadorAtual.temPeca(pecaAlvo);
            boolean pecaEhInimiga = !pecaEhMinha; // Se não 
            if (pecaEhMinha) {
                System.out.println("Você já tem uma peça nessa posição.");
                continue;
            }
            if (pecaEhInimiga) {
                System.out.println("Ataque! Peça inimiga removida!");
                removerPeca(pecaAlvo);
                tabuleiro[novoX][novoY] = null;
            }
        }

        // Move a peça
        tabuleiro[pecaEscolhida.getPosicaoX()][pecaEscolhida.getPosicaoY()] = null;
        pecaEscolhida.setPosicao(novoX, novoY);
        tabuleiro[novoX][novoY] = pecaEscolhida;

        // Verifica vitória
        if (jogadorInimigo.estaSemPecas()) {
            System.out.println(jogadorAtual.getNome() + " venceu o jogo!");
            jogoAtivo = false;
        } else {
            // Troca os jogadores
            Jogador temp = jogadorAtual;
            jogadorAtual = jogadorInimigo;
            jogadorInimigo = temp;
        }
    }
}


    private void removerPeca(Peca peca) {
        if (peca.getJogadorDono().equals(jogador1.getNome())) {
            jogador1.removerPeca(peca);
        } else {
            jogador2.removerPeca(peca);
        }
    }

    public void exibirTabuleiro() {
    System.out.println("\n    0   1   2   3   4   5   6   7");
    System.out.println("  ---------------------------------");

        for (int i = 0; i < 8; i++) {
            System.out.print(i + " |");
            for (int j = 0; j < 8; j++) {
                if (tabuleiro[i][j] != null) {
                    System.out.print(" " + tabuleiro[i][j].getSimbolo() + " |");
                } else {
                    System.out.print("   |");
                }
            }
            System.out.println();
            System.out.println("  ---------------------------------");
        }
    }

}
