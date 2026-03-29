import java.util.Scanner;
import java.util.ArrayList;

void main() {
    int numAleatorio;
    boolean acerto = true;
    String vontadeInicial,vontade;
    int contador = 0;
    ArrayList<Integer> numSorteados = new ArrayList<>();
    ArrayList<Integer> respostas = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    while (true) {
    System.out.println("Bem vindo ao jogo Genius, deseja jogar?: [S]-[N]");
    vontadeInicial = sc.nextLine();
    vontade = vontadeInicial.toUpperCase().substring(0,1);

        try {
            if (vontade.equals("S")){
                while(true){
                    if(acerto) {
                        numAleatorio = (int) (Math.random() * 4) + 1;
                        numSorteados.add(numAleatorio);
                        contador+=1;
                        if (numAleatorio == 1) {
                            System.out.println("Azul");
                        } else if (numAleatorio == 2) {
                            System.out.println("Amarelo");
                        } else if (numAleatorio == 3) {
                            System.out.println("Vermelho");
                        } else {
                            System.out.println("Verde");
                        }
                        System.out.println("Escolha uma cor:");
                        System.out.println("[1]Azul - [2]Amarelo - [3]Vermelho - [4]Verde");
                        respostas.clear();
                        for(int i = 0; i < numSorteados.size(); i++){
                                System.out.printf("Digite o %d° da sequencia: ", i+1);
                                respostas.add(sc.nextInt());
                                if (respostas.getLast().equals(numSorteados.get(i))){
                                    System.out.println("...");
                                }else{
                                    break;
                                }
                        }
                        //forma preguiçosa de limpar o console!!! Trocar dps
                        if (numSorteados.equals(respostas)){
                            for (int i = 0; i < 50; ++i) {
                                System.out.println();
                            }
                        }else{
                            acerto=false;
                            System.out.println("errou!!");
                        }
                    }
                    else{break;}
                }
                break;
            }else if (vontade.equals("N")){
                System.out.println("Entendido...");
                System.out.println("Fechando jogo");
                break;
        }
        }
        catch (InputMismatchException e){
            System.out.println("Entrada inválida!");
            System.out.println("Código de erro: " + e);
            break;
        }
        finally {
            System.out.printf("Você teve %d acertos antes de falhar!", contador-1);
        }
    }
}
