# Simulador de Algoritmos de Substituição de Páginas

Projeto desenvolvido em Java para simular e comparar algoritmos de substituição de páginas em memória virtual.

## Objetivo

O programa recebe uma sequência de páginas e uma quantidade de quadros de memória. Em seguida, executa quatro algoritmos de substituição utilizando exatamente a mesma entrada e apresenta a quantidade de faltas de página de cada método.

## Algoritmos implementados

- FIFO (First In, First Out)
- LRU (Least Recently Used)
- Relógio / Clock
- Ótimo

Cada algoritmo foi implementado em um método próprio no arquivo `src/Main.java`.

## Tecnologias utilizadas

- Java
- Estruturas `ArrayList`, arrays e `Scanner`
- Git e GitHub

## Estrutura do projeto

```text
simulador-substituicao-paginas/
├── src/
│   └── Main.java
├── resultados/
│   └── testes.md
└── README.md
```

## Requisitos

Para executar o projeto é necessário ter o Java JDK instalado.

Exemplo de verificação:

```bash
java -version
javac -version
```

## Como executar pelo terminal

Entre na pasta `src` e compile o programa:

```bash
javac Main.java
```

Depois execute:

```bash
java Main
```

## Como executar no IntelliJ IDEA

1. Abra o projeto no IntelliJ IDEA.
2. Abra o arquivo `src/Main.java`.
3. Clique no botão de execução ao lado do método `main`.
4. Informe a sequência de páginas.
5. Informe a quantidade de quadros.
6. O programa exibirá a quantidade de faltas de página de cada algoritmo.

## Exemplo de entrada

```text
Sequência de páginas:
1 2 3 4 1 2 5 1 2 3 4 5

Quantidade de quadros:
3
```

## Exemplo de saída

```text
=== RESULTADOS ===
FIFO - 9 faltas de página
LRU - 10 faltas de página
Relógio - 9 faltas de página
Ótimo - 7 faltas de página
```

## Funcionamento dos algoritmos

### FIFO

O FIFO substitui a página que está há mais tempo na memória. A implementação utiliza um ponteiro para indicar a próxima posição a ser substituída.

### LRU

O LRU substitui a página que foi utilizada há mais tempo. A lista é reorganizada sempre que uma página é referenciada, mantendo a página usada mais recentemente no final da estrutura.

### Relógio / Clock

O algoritmo do Relógio utiliza um ponteiro circular e um bit de referência para cada quadro. Páginas recentemente utilizadas recebem uma segunda chance antes de serem substituídas.

### Ótimo

O algoritmo Ótimo analisa as referências futuras e substitui a página cujo próximo uso ocorrerá mais tarde. Por depender do conhecimento do futuro, é utilizado principalmente como referência teórica de desempenho.

## Comparação

Todos os algoritmos recebem a mesma sequência de páginas e a mesma quantidade de quadros, permitindo comparar diretamente a quantidade de faltas de página produzida em cada cenário.

Os testes utilizados no projeto estão documentados em [`resultados/testes.md`](resultados/testes.md).

## Integrantes

- Caio Gabriel Araujo Alves
- Leonardo Enzo

## Observação

A versão entregue neste repositório utiliza execução pelo terminal. A interface gráfica com Swing foi considerada como funcionalidade extra, mas não faz parte desta versão final do código.
