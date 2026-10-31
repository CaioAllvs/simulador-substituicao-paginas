# Testes do Simulador

Este arquivo registra os principais testes utilizados para validar os quatro algoritmos implementados.

## Teste 1

Sequência de páginas:

```text
1 2 3 4 1 2 5 1 2 3 4 5
```

Quantidade de quadros: `3`

Resultados esperados e validados:

| Algoritmo | Faltas de página |
|---|---:|
| FIFO | 9 |
| LRU | 10 |
| Relógio | 9 |
| Ótimo | 7 |

## Teste 2

Sequência de páginas:

```text
7 0 1 2 0 3 0 4 2 3 0 3 2
```

Quantidade de quadros: `3`

Resultados esperados e validados:

| Algoritmo | Faltas de página |
|---|---:|
| FIFO | 10 |
| LRU | 9 |
| Relógio | 9 |
| Ótimo | 7 |

## Teste 3

Sequência de páginas:

```text
1 2 3 1 4 1 2 5 1 2 3 4 5
```

Quantidade de quadros: `4`

Resultados esperados e validados:

| Algoritmo | Faltas de página |
|---|---:|
| FIFO | 10 |
| LRU | 8 |
| Relógio | 10 |
| Ótimo | 6 |

## Teste simples adicional

Sequência:

```text
2 2 4
```

Quantidade de quadros: `1`

Resultados:

| Algoritmo | Faltas de página |
|---|---:|
| FIFO | 2 |
| LRU | 2 |
| Relógio | 2 |
| Ótimo | 2 |

## Análise resumida

Os testes mostram que o desempenho depende da sequência de referências e da quantidade de quadros disponível. O algoritmo Ótimo apresentou a menor quantidade de faltas nos cenários avaliados, como esperado, pois utiliza conhecimento das referências futuras. FIFO, LRU e Relógio apresentam resultados diferentes conforme o padrão de acesso às páginas.
