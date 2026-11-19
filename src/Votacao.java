public class Votacao {

    // Atributos
    int numSecao;
    int numCandidato;

    // Construtor
    Votacao()
    {
        this(0, 0); // Como cada atributo vai ser inicializado
    }

    Votacao (int numSecao, int numCandidato)
    {
        this.numSecao = numSecao;
        this.numCandidato = numCandidato;
    }
} // Fim Classe
