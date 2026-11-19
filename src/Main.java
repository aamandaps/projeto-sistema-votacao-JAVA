import javax.swing.JOptionPane;
import java.io.IOException;

public class Main {

    public static void main (String[] args) throws IOException {

        // Instanciando classe Votacao
        Votacao[] votacao = new Votacao[200];

        // Instanciando classe Metodos
        Metodos m = new Metodos();

        // Execução do construtor da Classe Votacao
        for(int i=0; i<200; i++)
        {
            votacao[i] = new Votacao();
        }

        int opcMain=0;
        // Loop Menu
        while (opcMain!=9)
        {
            opcMain = Integer.parseInt(JOptionPane.showInputDialog("""
                    Sistema de Votação
                    1 - Carregar Seção/Número Eleitor;
                    2 - Classificar Seção;
                    3 - Gravar Registros;
                    4 - Mostrar Indicadores;
                    9 - Finalizar Execução.
                    """));

            // Switch do Menu
            switch (opcMain)
            {
                case 1:
                    votacao = m.cadastraVotacao(votacao); // Função
                break;

                case 2:
                    votacao = m.classificaVotacao(votacao); // Função
                break;

                case 3:
                    votacao = m.gravarVotacao(votacao); // Função
                break;

                case 4:
                    m.menuIndicadores(votacao); // Procedimento
                break;

                case 9:
                    JOptionPane.showMessageDialog(null, "FIM");
                    System.exit(0);
                break;

                default: JOptionPane.showMessageDialog(null, "Opção Inválida.");
            } // Fim Switch
        } // Fim Loop
    } // Fim Main
}
