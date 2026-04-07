import javax.swing.*;
import java.awt.*;

//Variáveis
static ArrayList<Integer> sequenciaCores = new ArrayList<>();
static int numAleatorio;
static int contador = 0;
static JButton bverde, bvermelho, bamarelo, bazul;
static int pontos = 0;
static JLabel pontuacao;

void main() {
    //Criação da janela e do quadro
    JFrame janela = new JFrame();
    janela.setLayout(new BorderLayout());

    JPanel quadro = new JPanel();
    quadro.setLayout(new GridLayout(2, 2));
    //configuração de tamanha e visibilidade da janela
    janela.setSize(700, 700);
    janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //criação dos botões
    bazul = new JButton();
    bamarelo = new JButton();
    bverde = new JButton();
    bvermelho = new JButton();

    bazul.setBackground(Color.BLUE);
    bamarelo.setBackground(Color.YELLOW);
    bverde.setBackground(Color.GREEN);
    bvermelho.setBackground(Color.RED);

    quadro.add(bverde);
    quadro.add(bvermelho);
    quadro.add(bamarelo);
    quadro.add(bazul);

    //criação do quadro de pontuações
    pontuacao = new JLabel();
    pontuacao.setFont(new Font("Arial", Font.BOLD, 40));
    pontuacao.setText("Pontos: 0");
    pontuacao.setHorizontalAlignment(SwingConstants.CENTER);

    //ORGANIZAÇÃO DA TELA
    janela.add(pontuacao, BorderLayout.NORTH);
    janela.add(quadro, BorderLayout.CENTER);
    janela.setVisible(true);

    //criação de botão como clicável
    bamarelo.addActionListener(_ -> clicarBotao(3));
    bazul.addActionListener(_ -> clicarBotao(4));
    bverde.addActionListener(_ -> clicarBotao(1));
    bvermelho.addActionListener(_ -> clicarBotao(2));

    // Lógica Inicial
    numAleatorio = (int) (Math.random() * 4) + 1;
    sequenciaCores.add(numAleatorio);
    mostrarSequencia();
}

public static void clicarBotao(int corClicada) {
    //Faz o botão brilhar independente de acertar ou errar
    if (corClicada == 1) piscarBotao(bverde, Color.GREEN);
    else if (corClicada == 2) piscarBotao(bvermelho, Color.RED);
    else if (corClicada == 3) piscarBotao(bamarelo, Color.YELLOW);
    else if (corClicada == 4) piscarBotao(bazul, Color.BLUE);

    // Agora a lógica de verificação que você criou:
    if (corClicada == sequenciaCores.get(contador)) {
        contador++;

        // Se terminou a sequência, sorteia nova e mostra
        if (contador == sequenciaCores.size()) {
            IO.println("Nível concluído!");
            pontos++;
            pontuacao.setText("Pontos: " + pontos);

            contador = 0;
            // Adiciona nova cor e mostra a sequência
            Timer pausa = new Timer(1000, _ -> {
                numAleatorio = (int) (Math.random() * 4) + 1;
                sequenciaCores.add(numAleatorio);
                mostrarSequencia();
            });
            pausa.setRepeats(false);
            pausa.start();
        }
    } else {
        falha();
    }
}

public static void falha() {
    IO.println("GAME OVER! Pontuação final: " + pontos);

    //Faz todos os botões ficarem vermelhos ao mesmo tempo
    bverde.setBackground(Color.RED);
    bvermelho.setBackground(Color.RED);
    bamarelo.setBackground(Color.RED);
    bazul.setBackground(Color.RED);

    //Timer para voltar as cores originais após 500ms
    Timer resetCores = new Timer(500, _ -> {
        bverde.setBackground(Color.GREEN);
        bvermelho.setBackground(Color.RED);
        bamarelo.setBackground(Color.YELLOW);
        bazul.setBackground(Color.BLUE);

        //Reinicia o jogo após as cores voltarem
        pontos = 0;
        pontuacao.setText("Pontos: 0");
        contador = 0;
        sequenciaCores.clear();

        //Sorteia a primeira cor do novo jogo
        numAleatorio = (int) (Math.random() * 4) + 1;
        sequenciaCores.add(numAleatorio);
        mostrarSequencia();
    });

    resetCores.setRepeats(false);
    resetCores.start();
}

public static void piscarCor(int numeroCor) {
    if (numeroCor == 1) piscarBotao(bverde, Color.GREEN);
    else if (numeroCor == 2) piscarBotao(bvermelho, Color.RED);
    else if (numeroCor == 3) piscarBotao(bamarelo, Color.YELLOW);
    else if (numeroCor == 4) piscarBotao(bazul, Color.BLUE);
}

public static void piscarBotao(JButton botao, Color corOriginal) {
    botao.setBackground(Color.WHITE);

    Timer timer = new Timer(200, _ -> botao.setBackground(corOriginal));

    timer.setRepeats(false);
    timer.start();
}

public static void mostrarSequencia() {
    // Criamos um contador interno para o Timer saber qual cor piscar agora
    final int[] posicao = {0};

    Timer timer = new Timer(700, e -> { // A cada 700ms...
        if (posicao[0] < sequenciaCores.size()) {
            int corParaPiscar = sequenciaCores.get(posicao[0]);

            // Aqui você chama a função que faz o botão brilhar
            piscarCor(corParaPiscar);

            posicao[0]++;
        } else {
            ((Timer) e.getSource()).stop(); // Para o show quando acabar a lista
        }
    });
    timer.start();
}