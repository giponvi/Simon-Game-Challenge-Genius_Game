import javax.swing.*;
import java.awt.*;

void main() {
    JFrame janela = new JFrame();
    janela.setLayout(new BorderLayout());

    JPanel quadro = new JPanel();
    quadro.setLayout(new GridLayout(2,2));
//criação dos botões
    JButton bazul = new JButton();
    JButton bamarelo = new JButton();
    JButton bverde = new JButton();
    JButton bvermelho = new JButton();

    quadro.add(bverde);
    quadro.add(bvermelho);
    quadro.add(bamarelo);
    quadro.add(bazul);

//criação do quadro de pontuações
    JLabel pontuacao = new JLabel();

//ORGANIZAÇÃO DA TELA
    janela.add(pontuacao, BorderLayout.NORTH);
    janela.add(quadro, BorderLayout.CENTER);
}