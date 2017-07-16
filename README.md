# Mars Robot

[![GitHub release](https://img.shields.io/github/release/rafaelcam/mars-robot.svg)](https://github.com/rafaelcam/mars-robot/tree/v1.0)
[![Build Status](https://travis-ci.org/rafaelcam/mars-robot.svg?branch=master)](https://travis-ci.org/rafaelcam/mars-robot)
[![codecov](https://codecov.io/gh/rafaelcam/mars-robot/branch/master/graph/badge.svg)](https://codecov.io/gh/rafaelcam/mars-robot)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/f611cad015d542a0b80bede479627a34)](https://www.codacy.com/app/rafaelcam/mars-robot?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=rafaelcam/mars-robot&amp;utm_campaign=Badge_Grade)

## O Problema

Um time de robôs deve ser colocado pela NASA para explorar um terreno em Marte. Esse terreno, que é retangular, precisa 
ser navegado pelos robôs de tal forma que suas câmeras acopladas possam obter uma visão completa da região, enviando 
essas imagens novamente para a Terra.

A posição de cada robô é representada pela combinação de coordenadas cartesianas `(x, y)` e por uma letra, que pode 
representar uma das quatro orientações: `NORTH`, `SOUTH`, `EAST` e `WEST`. 

Para simplificar a navegação, a região "marciana" a ser explorada foi subdividia em sub-regiões retangulares. Uma posição 
válida de um robô, seria `(0, 0, N)`, que significa que o robô está posicionado no canto esquerdo inferior do terreno, voltado para o Norte.

Para controlar cada robô, a NASA envia uma string simples, que pode conter as letras `L`, `R` e `M`. As letras `L` e `R` 
fazem o robô rotacionar em seu próprio eixo 90 graus para esquerda ou para direita, respectivamente, sem se mover 
da sua posição atual. A letra `M` faz o robô deslocar-se uma posição para frente.

Assuma que um robô se movimenta para o Norte em relação ao eixo y. Ou seja, um passo para o Norte da posição `(x, y)`, é a posição `(x, y+1)`.

Exemplo: Se o robô está na posição `(0,0,N)`, o comando `MML` fará ele chegar na posição `(0,2,W)`

## Iniciando a Aplicação

Projeto Java implementado utilizando Java 8, Spring Boot, gerenciamento de builds com Maven, 
testes unitários com JUnit e de API com MockMVC do Spring. A interface de comunicação com o robô é REST.

### Requisitos

* Maven
* Java 8
* Docker (Opcional)
* Docker Compose (Opcional)

### Gerando o Pacote

Sendo um projeto Maven, execute os goals `clean` e `install` na raiz do projeto para baixar as dependências e gerar `jar` do projeto.

```bash
#!/mars-robot
$ mvn clean install
```

### Executando o Jar

Como se trata de um projeto Spring Boot, podemos simplismente executar o `jar` que foi gerado na pasta `target` e a aplicação irá subir em um tomcat embedded.

```bash
#!/market-web-view/target
$ java -jar mars-robot-0.0.1-SNAPSHOT.jar
```

Pronto, a aplicação deve estar online na porta `8080`.

### Executando com Docker (Opcional)

Se preferir, a aplicação também está configurada para gerar uma imagem que pode ser executada com o Docker Compose. 

Para gerar a imagem da aplicação execute: 

```bash
#!/market-web-view
$ mvn docker:build
```

Para criar o container utilizando a imagem gerada e inicia-lo execute:

```bash
#!/market-web-view
$ docker-compose up
```

## API

**ENDPOINT**

```
POST http://localhost:8080/robot/go/{route}
```

Exemplo de endpoint: `http://localhost:8080/robot/go/MML`

**PARÂMETROS DA REQUISIÇÃO**

Parâmetro | Descrição
------------ | -------------
`route` | String que representa a rota que o robo deve seguir. Ex: `MML`.

**RESPOSTAS POSSÍVEIS**

Código | Resposta
------------ | -------------
`200` | `(0, 2, N)` 
`400` | `Um dos comandos enviandos na rota não é válido.`
`400` | `A rota informada leva a uma posição inválida.`
`400` | `Ocorreu um problema desconhecido, para mais informações entre em contato com o suporte.`