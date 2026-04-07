import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Window{
    //Variáveis
    static ArrayList<Integer> sequenciaCores = new ArrayList<>();
    static ArrayList<Integer> sequenciaClicada = new ArrayList<>();
    static int numAleatorio;

    public static void main(String[] args) {
        //Criação da janela e do quadro
        JFrame janela = new JFrame();
        janela.setLayout(new BorderLayout());

        JPanel quadro = new JPanel();
        quadro.setLayout(new GridLayout(2,2));
        //configuração de tamanha e visibilidade da janela
        janela.setSize(700,700);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //criação dos botões
        JButton bazul = new JButton();
        JButton bamarelo = new JButton();
        JButton bverde = new JButton();
        JButton bvermelho = new JButton();

        bazul.setBackground(Color.BLUE);
        bamarelo.setBackground(Color.YELLOW);
        bverde.setBackground(Color.GREEN);
        bvermelho.setBackground(Color.RED);

        quadro.add(bverde);
        quadro.add(bvermelho);
        quadro.add(bamarelo);
        quadro.add(bazul);

        //criação do quadro de pontuações
        JLabel pontuacao = new JLabel();
        pontuacao.setText("Pontos: 0");
        pontuacao.setHorizontalAlignment(SwingConstants.CENTER);

        //ORGANIZAÇÃO DA TELA
        janela.add(pontuacao, BorderLayout.NORTH);
        janela.add(quadro, BorderLayout.CENTER);
        janela.setVisible(true);

        //criação de botão como clicável
        bamarelo.addActionListener(e  -> {
            clicarBotao(3);
        });
        bazul.addActionListener(e -> {
            clicarBotao(4);
        });
        bverde.addActionListener(e -> {
            clicarBotao(1);
        });
        bvermelho.addActionListener(e -> {
            clicarBotao(2);
        });

        //lógica - Back-end
        numAleatorio = (int) (Math.random() * 4) + 1;
        sequenciaCores.add(numAleatorio);
    }
    public static int clicarBotao(int corClicada){
        System.out.println(corClicada);
        return corClicada;
    }
}