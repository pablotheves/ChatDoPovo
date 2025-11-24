# Projeto Socket - Chat do Povo

Este projeto consiste em uma aplicação de Chat Multicliente desenvolvida em Java, utilizando a API de Sockets para comunicação em tempo real e JavaFX para a interface gráfica. O sistema implementa uma arquitetura Cliente-Servidor robusta, capaz de gerenciar múltiplas conexões simultâneas via Threads.

## Sobre o Projeto

O objetivo principal foi criar uma sala de bate-papo funcional onde múltiplos usuários podem se conectar, trocar mensagens e visualizar a lista de participantes ativos. A interface foi estilizada com um tema "Aero" (efeito de vidro/transparência) utilizando CSS avançado no JavaFX.

### Funcionalidades Implementadas

* **Arquitetura Cliente-Servidor:** Comunicação via TCP/IP utilizando `ServerSocket` e `Socket`.
* **Multithreading:** O servidor gerencia cada cliente em uma Thread separada (`ClientHandler`), permitindo múltiplas conexões simultâneas sem bloqueios.
* **Sistema de Broadcast:** Mensagens enviadas por um usuário são retransmitidas automaticamente para todos os outros conectados.
* **Login com Nickname:** Tela inicial para identificação do usuário antes de entrar no chat.
* **Lista de Usuários Online:** Atualização em tempo real na interface (painel esquerdo) sempre que alguém entra ou sai.
* **Comandos Privados:** Implementação do comando `/lista` que retorna os usuários conectados apenas para o solicitante.
* **Interface Responsiva:** O layout se adapta ao redimensionamento da janela.
* **Estilização Personalizada (CSS):** Interface com tema Aero, transparências, sombras e background personalizado.

## Tecnologias Utilizadas

* **Linguagem:** Java (JDK 21)
* **Interface Gráfica:** JavaFX (FXML + CSS)
* **Gerenciamento de Dependências:** Maven
* **Conceitos:** Sockets, Threads, IO Streams (ObjectOutputStream/ObjectInputStream), Serialização.

## Estrutura do Projeto

* `src/main/java/classes/ServidorChat.java`: Ponto de entrada do servidor. Gerencia a lista de clientes e o loop de aceitação de conexões.
* `src/main/java/classes/ClientHandler.java`: Thread responsável por ouvir as mensagens de um cliente específico.
* `src/main/java/cadm/pablotheves/projetosocket/App.java`: Classe principal do JavaFX que inicia a interface do cliente.
* `src/main/java/cadm/pablotheves/projetosocket/ChatController.java`: Controlador da tela de chat, gerencia o envio/recebimento de mensagens e atualização da UI.
* `src/main/java/cadm/pablotheves/projetosocket/TelaLogin.java`: Controlador da tela de login.

## Como Executar

Para rodar o projeto localmente, siga a ordem de execução abaixo para evitar erros de conexão:

### 1. Iniciar o Servidor
Execute a classe `ServidorChat`.
O console deverá exibir a mensagem: `Servidor de Chat aguardando conexões...`

### 2. Iniciar o Cliente
Execute a classe `Launcher` (ou `App`).
Uma janela de login será aberta. Digite seu nome e clique em "ENTRAR".

Para testar a comunicação, execute múltiplas instâncias do Cliente e converse entre elas.

## Pré-requisitos

* Java JDK 11 ou superior.
* Maven instalado (ou IDE com suporte a Maven como NetBeans/IntelliJ/Eclipse).

## Autor

Pablo Theves, desenvolvido como atividade prática da disciplina de Linguagem de Programação III.
