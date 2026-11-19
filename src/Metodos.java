import java.util.Random;
import javax.swing.JOptionPane;
import java.io.*;

public class Metodos {

    // Procedimento do menu que mostra as estatísticas da votação
    public void menuIndicadores(Votacao[] votacao)
    {
        // Loop do menu
        int opcIndicadores=0;
        while (opcIndicadores!=9)
        {
            opcIndicadores = Integer.parseInt(JOptionPane.showInputDialog("""
                    Menu para exibir os Indicadores - Votação
                    1 - Quantidade de eleitores por seção;
                    2 - Seção com Maior e Menor números de eleitores;
                    3 - Quantidade de votos por candidato;
                    4 - Os 10 primeiros colocados (nº do candidato e quantidade de votos);
                    9 - Finalizar Execução
                    """));

            // Switch do menu
            switch (opcIndicadores)
            {
                case 1:
                    qntEleitoresSecao(votacao);
                break;

                case 2:
                    secaoMaisMenosEleitores(votacao);
                break;

                case 3:
                    qntVotoCandidato(votacao);
                break;

                case 4:
                    rankingCandidatos(votacao);
                break;

                case 9:
                    JOptionPane.showMessageDialog(null, "FIM");
                break;

                default: JOptionPane.showMessageDialog(null, "Opção Inválida");
            } // Fim Switch
        } // Fim Loop Menu
    } // Fim menuIndicadores


    // Procedimento que calcula o número de eleitores por seção
    public void qntEleitoresSecao (Votacao[] votacao)
    {
        // Vetor com a quantidade de seções (0-10)
        int[] qntSecao = new int[11];

        // Percorre todos os votos
        for(int i=0; i<200; i++)
        {
            int secaoVoto = votacao[i].numSecao; // Armazena a seção daquele voto na posição i

            qntSecao[secaoVoto]++; // Incrementa mais um voto naquela seção
        } // Fim Loop Votos

        // Cria o bloco de texto com o título inicial
        StringBuilder resultado = new StringBuilder("Quantidade de eleitores por seção:\n");

        // Percorre as 11 seções (0 a 10) e vai adicionando cada linha no StringBuilder
        for (int j = 0; j < 11; j++)
        {
            resultado.append("Seção ").append(j).append(": ").append(qntSecao[j]).append(" eleitores\n");
        }

        // Exibe tudo de uma vez em uma única janela
        JOptionPane.showMessageDialog(null, resultado.toString());

    } // Fim qntEleitoresSecao


    public void secaoMaisMenosEleitores(Votacao[] votacao)
    {
        // Vetor com a quantidade de seções
        int[] qntSecao = new int[11];

        // Percorre todos os votos
        for (int i=0; i<200; i++)
        {
            int secaoVoto = votacao[i].numSecao; // Armazena a seção daquele voto

            qntSecao[secaoVoto]++; // Incrementa mais um voto naquela seção
        }

        int maiorQnt, menorQnt, j=0;

        // Valores iniciais para a comparação da quantidade de votos
        maiorQnt = qntSecao[j];
        menorQnt = qntSecao[j];

        // Variáveis para armazenar a seção
        int secaoMaior=0;
        int secaoMenor=0;

        for(j=1; j<11; j++)
        {
            // Maior
            if (maiorQnt < qntSecao[j])
            {
                maiorQnt = qntSecao[j];
                secaoMaior = j;
            }

            // Menor
            if (menorQnt > qntSecao[j])
            {
                menorQnt = qntSecao[j];
                secaoMenor =j;
            }
        } // Fim Loop Comparação

        JOptionPane.showMessageDialog(null, "Seção com maior nº de Eleitores: "+ secaoMaior + ", nº de votos: "+maiorQnt+
                                                                    "\nSeção com menor nº de Eleitores: "+secaoMenor+", nº de votos: "+menorQnt);

    } // Fim secaoMaisMenosEleitores


    // Procedimento que calcula a quantidade de voto de cada candidato
    public void qntVotoCandidato(Votacao[] votacao)
    {
        int[] qntCandidato = new int[301]; // Vetor com todos os candidatos

        // Percorrer todos os votos
        for(int i=0; i<200; i++)
        {
            int candidatoVoto = votacao[i].numCandidato; // Quantidade de voto que aquele candidato recebeu

            qntCandidato[candidatoVoto]++; // Incrementa mais um voto naquele candidato
        } // Fim Loop Votos

        // Título do bloco de texto
        StringBuilder listaCandidato = new StringBuilder("Quantidade de votos dos candidatos que receberam ao menos 1 voto: \n"); // Instanciando o StringBuilder

        // Preenchendo a lista
        for(int j=0; j<301; j++)
        {
            // Validação para mostrar apenas quantidade dos candidatos que receberam votos
            if (qntCandidato[j] > 0)
            {
                listaCandidato.append("Nº do Candidato: ").append(j).append(" - nº de votos: ").append(qntCandidato[j]).append("\n");
            }

        }

        // Exibe tudo para o usuário
        JOptionPane.showMessageDialog(null, listaCandidato.toString());

    } // Fim qntVotoCandidato


    // Procedimento que faz um ranking dos 10 candidatos mais votados
    public void rankingCandidatos (Votacao[] votacao)
    {
        int[] qntCandidato = new int[301]; // Vetor com os candidatos que receberam votos

        // Percorrendo todos os votos
        for(int i=0; i<200; i++)
        {
            int candidatoVoto = votacao[i].numCandidato; // Variável que armazena a quantidade de votos que aquele candidato recebeu

            qntCandidato[candidatoVoto]++; // Incrementa mais um voto naquele candidato
        }

        int[] numeroCandidato = new int[301]; // Vetor que vai servir de 'etiqueta' para o candidato que recebeu aquela quantidade de votos

        // Loop que vai percorrer as posições dos candidatos
        for(int j=0; j<301; j++)
        {
            numeroCandidato[j] = j; // Guardando a posição
        }

        int auxQntVoto, auxCandidato; // Auxiliares para a troca

        // Ordenando(bubble sort) candidatos e alinhando com a quantidade de votos recebidos
        for(int x=0; x<300; x++)
        {
            for(int y=x+1; y<301; y++)
            {
                // Verificando qual candidato tem mais votos
                if (qntCandidato[x] < qntCandidato[y])
                {
                    // Ordenando os votos do candidato
                    auxQntVoto = qntCandidato[x];
                    qntCandidato[x] = qntCandidato[y];
                    qntCandidato[y] = auxQntVoto;

                    // Ordenando os candidatos
                    auxCandidato = numeroCandidato[x];
                    numeroCandidato[x] = numeroCandidato[y];
                    numeroCandidato[y] = auxCandidato;
                } // Fim Comparação
            } // Fim Loop y
        } // Fim Loop x

        // Titulo do texto exibido
        StringBuilder ranking = new StringBuilder("Ranking dos 10 candidatos mais votados: \n"); // Instanciando o StringBuilder

        // Loop dos 10 mais votados
        for (int k=0; k<10; k++)
        {
            ranking.append(k+1).append("º Lugar: ").append(numeroCandidato[k]).append(" - Quant. de votos: ").append(qntCandidato[k]).append("\n");
        }

        // Exibição
        JOptionPane.showMessageDialog(null, ranking.toString());

    } // Fim rankingCandidatos


    // Função que cadastra os dados da votação
    public Votacao[] cadastraVotacao (Votacao[] votacao)
    {
        // Instanciando o Random
        Random gerador = new Random();

        for(int i=0; i<200; i++)
        {
            // Gerando valores aleatórios e preenchendo o cadastro de votação
            votacao[i].numSecao = gerador.nextInt(11);
            votacao[i].numCandidato = gerador.nextInt(301);
        }

        JOptionPane.showMessageDialog(null, "Dados cadastrados com sucesso!");
        return votacao;
    } // Fim cadastraVotacao


    // Função que ordena a votação pelo número da seção
    // Algoritmo de ordenação Bubble Sort
    public Votacao[] classificaVotacao (Votacao[] votacao)
    {
        Votacao aux; // Variável auxiliar do tipo votação para receber todos os dados da classe

        for(int i=0; i<199; i++)
        {
            for(int j=i+1; j<200; j++)
            {
                // Comparando os valores
                if(votacao[i].numSecao > votacao[j].numSecao)
                {
                    aux = votacao[i];
                    votacao[i] = votacao[j];
                    votacao[j] = aux;
                }
            } // Fim Loop j
        } // Fim Loop i

        JOptionPane.showMessageDialog(null, "Votação classificada com sucesso!");
        return votacao;
    } // Fim classificaVotacao


    // Função que gera a gravação dos dados da votação
    public Votacao[] gravarVotacao(Votacao[] votacao) throws IOException
    {
        String fileName = "Votacao.txt";

        // Instanciando buffer
        BufferedWriter gravar = new BufferedWriter(new FileWriter(fileName)); // Variável 'gravar' vai armazenar o buffer que gera a gravação

        for(int i=0; i<200; i++)
        {
            // Gravando numSecao
            gravar.write(String.valueOf(votacao[i].numSecao)); // Convertendo p/ String
            gravar.newLine();

            // Gravando numCandidato
            gravar.write(String.valueOf(votacao[i].numCandidato));
            gravar.newLine();
        }

        gravar.close(); // Encerrando a gravação

        JOptionPane.showMessageDialog(null, "Arquivo gerado com sucesso!");

        return votacao;
    } // Fim gravarVotacao

} // Fim Metodos
