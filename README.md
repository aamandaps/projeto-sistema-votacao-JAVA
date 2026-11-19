# 🗳️ Sistema de Votação em Java

![Java](https://img.shields.io/badge/JAVA-D8BFD8?style=for-the-badge&logo=openjdk&logoColor=1E1E1E)
![IntelliJ IDEA](https://img.shields.io/badge/INTELLIJ%20IDEA-D8BFD8?style=for-the-badge&logo=intellijidea&logoColor=1E1E1E)

## Sobre o Projeto

Projeto de um **Sistema de Votação** desenvolvido inteiramente em **Java**, criado para consolidar meus estudos iniciais de **Programação Orientada a Objetos (POO)**, manipulação e gravação de arquivos de texto, algoritmos de ordenação e lógica de programação com vetores e objetos.

O sistema simula o registro de **200 votos** distribuídos entre **11 seções eleitorais (0 a 10)** e **301 candidatos (0 a 300)**, utilizando menus interativos via `JOptionPane`. Estrutura:
```
src/
├── Main.java       # Classe principal com a inicialização dos objetos e o menu interativo
├── Votacao.java    # Classe modelo representando cada registro de voto (numSecao e numCandidato)
└── Metodos.java    # Classe contendo as regras de negócio, ordenação, gravação em arquivo e indicadores 
````
<br>

## Funcionalidades

### Menu Principal
* **1 - Carregar Seção/Número Eleitor:** Gera aleatoriamente (`Random`) os 200 registros de votos com número da seção e número do candidato.
* **2 - Classificar Seção:** Ordena os registros de votação em ordem crescente pelo número da seção utilizando o algoritmo **Bubble Sort**.
* **3 - Gravar Registros:** Salva todos os dados da votação em um arquivo externo (`Votacao.txt`) utilizando `BufferedWriter`.
* **4 - Mostrar Indicadores:** Abre o submenu de estatísticas da eleição.
* **9 - Finalizar Execução:** Encerra o programa.

### Menu de Indicadores
* **1 - Quantidade de eleitores por seção:** Exibe o total de votos computados em cada uma das 11 seções.
* **2 - Seção com Maior e Menor números de eleitores:** Identifica e exibe qual seção teve a maior e qual teve a menor participação.
* **3 - Quantidade de votos por candidato:** Lista a apuração de votos de cada candidato que recebeu ao menos 1 voto.
* **4 - Os 10 primeiros colocados:** Ordena os candidatos por quantidade de votos (do maior para o menor) e exibe o ranking do **Top 10**.

<br>
