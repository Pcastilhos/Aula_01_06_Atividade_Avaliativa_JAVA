# ATIVIDADE AVALIATIVA - SISTEMA DE AGÊNCIA DE VIAGENS

## Situação-problema

A empresa Mundo Fácil Viagens deseja desenvolver um sistema em Java para cadastrar clientes e montar pacotes de viagem.

O sistema deve permitir que um cliente seja cadastrado com dados pessoais e endereço. Para preencher parte do endereço, o sistema deverá utilizar uma classe pronta chamada CepService, que consulta o CEP informado e retorna os dados disponíveis.

Depois de cadastrado, o cliente poderá contratar um ou mais pacotes de viagem, informando o destino, a data de início, a duração, a quantidade de acompanhantes e se a viagem é nacional ou internacional. O sistema também deve calcular automaticamente a data de término.

O sistema também deverá consultar o clima do destino por meio da classe ClimaService.

## Objetivo da atividade

A tarefa consiste em implementar um sistema orientado a objetos para uma agência de viagens, utilizando os conceitos estudados em aula.

O sistema deverá utilizar:

- Classes
- Objetos
- Herança
- Métodos
- Scanner
- if/else
- for
- ArrayList
- Relações 1:N
- Relações N:1
- Serviços externos prontos (.class)

## Serviços fornecidos

Os arquivos fornecidos pelo professor são CepService.class e ClimaService.class.

### CepService

Assinatura informada no enunciado: public String consultarCep(String cep).

Esse método recebe um CEP e retorna informações de endereço.

### ClimaService

Assinaturas informadas no enunciado:

- public String consultarClima(String cidade);
- public double consultarTemperatura(String cidade);

O método consultarClima() retorna uma descrição do clima, e consultarTemperatura() retorna a temperatura numérica da cidade.

## Requisitos funcionais

- RF01 - O sistema deve permitir cadastrar clientes.
- RF02 - O sistema deve permitir preencher dados de endereço a partir do CEP.
- RF03 - O sistema deve armazenar clientes em um ArrayList.
- RF04 - O sistema deve permitir cadastrar pacotes de viagem para um cliente.
- RF05 - Um cliente pode possuir mais de um pacote de viagem.
- RF06 - Um pacote pertence a apenas um cliente.
- RF07 - O sistema deve permitir cadastrar até 5 pessoas por pacote, considerando o dono do pacote e mais 4 pessoas.
- RF08 - O sistema deve consultar o clima do destino informado.
- RF09 - O sistema deve exibir uma mensagem de aviso conforme a temperatura do destino.
- RF10 - O sistema deve calcular o valor total do pacote.
- RF11 - O sistema deve diferenciar viagem nacional e internacional.
- RF12 - O sistema deve listar todos os clientes cadastrados.
- RF13 - O sistema deve listar todos os pacotes de um cliente.

## Regras de negócio

- RN01 - Cada cliente pode contratar mais de um pacote de viagem.
- RN02 - Cada pacote de viagem pertence a apenas um cliente.
- RN03 - Cada pacote pode ter no máximo 5 pessoas.
- RN04 - O preço base da passagem é de USD 300 por pessoa.
- RN05 - Acima de 3 pessoas, deve ser aplicado desconto progressivo: 3 pessoas = 10%, 4 pessoas = 20%, 5 pessoas = 30%.
- RN06 - O número total de pessoas deve considerar cliente principal + 4 acompanhantes.
- RN07 - Viagem nacional deve aplicar taxa administrativa de 20% sobre USD 1000.
- RN08 - Viagem internacional deve aplicar taxa administrativa de 60% sobre USD 1000.
- RN09 - Toda viagem deve incluir taxa de aeroporto de USD 400.
- RN10 - Se a temperatura for abaixo de 0 grau, mostrar: Alerta: destino muito frio. Recomenda-se levar roupas térmicas.
- RN11 - Se a temperatura for de 0 até 10 graus, mostrar: Aviso: destino frio. Recomenda-se levar casacos.
- RN12 - Se a temperatura for acima de 10 até 20 graus, mostrar: Aviso: clima ameno. Recomenda-se levar roupas leves e uma blusa.
- RN13 - Se a temperatura for acima de 20 graus, mostrar: Aviso: destino quente. Recomenda-se levar roupas leves.
- RN14 - O pacote pode ter duração de 7, 15 ou 30 dias.
- RN15 - O cliente pode fazer pacotes em datas diferentes.
- RN16 - O sistema deve calcular a data de término da viagem.

## Fórmula de cálculo do pacote

Segundo o enunciado, o cálculo deve seguir esta lógica:

```text
valorPassagens = 300 * quantidadeTotalPessoas

desconto:
até 2 pessoas = 0%
3 pessoas = 10%
4 pessoas = 20%
5 pessoas = 30%

valorComDesconto = valorPassagens - desconto

taxaAdministrativa:
viagem nacional = 1000 * 1.2
viagem internacional = 1000 * 1.6

taxaAeroporto = 400

valorFinal = valorComDesconto + taxaAdministrativa + taxaAeroporto
```

## Relações esperadas

O enunciado define as seguintes relações entre as classes:

- Cliente herda de Pessoa.
- Cliente possui vários PacoteViagem.
- Relação: Cliente 1:N PacoteViagem.
- PacoteViagem possui vários Acompanhante.
- Relação: PacoteViagem 1:N Acompanhante.
- Cada PacoteViagem pertence a um Cliente.
- Relação: PacoteViagem N:1 Cliente.
- SistemaAgencia possui vários Cliente.
- Relação: SistemaAgencia 1:N Cliente.
- PacoteViagem utiliza ClimaService.
- Cliente utiliza CepService para preencher dados de endereço.

## Arquivos esperados

O trabalho espera os seguintes arquivos Java:

- Pessoa.java
- Cliente.java
- Acompanhante.java
- PacoteViagem.java
- SistemaAgencia.java
- Main.java

Além dos arquivos fornecidos pelo professor:

- CepService.class
- ClimaService.class

## Tarefa dos grupos

O programa deverá:

1. Cadastrar clientes usando Scanner.
2. Consultar o CEP usando CepService.
3. Preencher os dados de endereço disponíveis.
4. Armazenar os clientes em ArrayList.
5. Permitir que um cliente cadastre mais de um pacote.
6. Cadastrar destino, data de início, data de fim e duração da viagem.
7. Informar se a viagem é nacional ou internacional.
8. Consultar a temperatura do destino usando ClimaService.
9. Gerar aviso de clima conforme a temperatura.
10. Cadastrar até 5 acompanhantes.
11. Calcular o valor final do pacote.
12. Listar os clientes cadastrados.
13. Listar os pacotes de viagem de cada cliente.

## Observação importante

O grupo não precisa implementar internamente as classes CepService e ClimaService, porque essas classes serão fornecidas prontas em formato .class.

O grupo deve apenas criar objetos dessas classes e chamar seus métodos.

Exemplos fornecidos no enunciado:

```java
CepService cepService = new CepService();
String dadosCep = cepService.consultarCep("92000000");
```

```java
ClimaService climaService = new ClimaService();
String clima = climaService.consultarClima("Gramado");
double temperatura = climaService.consultarTemperatura("Gramado");
```

## Critérios de avaliação

- Uso correto de classes e objetos.
- Uso correto de herança.
- Uso correto de ArrayList.
- Implementação das relações 1:N e N:1.
- Uso correto dos serviços CepService e ClimaService.
- Implementação correta das regras de negócio.
- Programa compilando e executando.
- Clareza na organização dos arquivos.
- Capacidade do grupo de explicar a solução.

## Desafio extra

Implementar um menu principal com as opções abaixo:

1. Cadastrar cliente
2. Cadastrar pacote para cliente
3. Listar clientes
4. Listar pacotes de um cliente
5. Sair

Esse menu pode usar while ou do while.

## Aviso do enunciado

O PDF destaca que os códigos devem ser entregues e auditados, e afirma que o uso de IA para codificação anula o resultado do trabalho. O documento também informa que essa atividade vale até 1,0 caso o aluno fique abaixo da média.
