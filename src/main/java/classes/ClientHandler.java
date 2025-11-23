/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author pablo
 */
public class ClientHandler implements Runnable {

    private ObjectInputStream in;
    private ObjectOutputStream out;
    private String nomeCliente;//guarda quem é o cliente

    public ClientHandler(ObjectInputStream in, ObjectOutputStream out) {
        this.in = in;
        this.out = out;

    }

    @Override
    public void run() {
        try {
            while (true) {
                // Fica esperando chegar uma Mensagem deste cliente
                Mensagem primeiraMsg = (Mensagem) in.readObject();
                this.nomeCliente = primeiraMsg.nome;

                ServidorChat.listaNomes.add(nomeCliente);
                ServidorChat.atualizarListaUsuarios();
                ServidorChat.broadcast(primeiraMsg);

                while (true) {
                    Mensagem msg = (Mensagem) in.readObject();

                    if (msg.mensagem.equalsIgnoreCase("/listar")) {// se identifica que o usuario pediu o comando
                        String nomes = String.join(", ", ServidorChat.listaNomes);

                        Mensagem resposta = new Mensagem("Usuários ", "online: " + nomes);

                        out.writeObject(resposta);//ENVIA SO PRA QUEM PEDIU

                    } else {
                        // Se não for comando, envia pra todos
                        ServidorChat.broadcast(msg);
                    }

                }

            }
        } catch (Exception e) {
            System.out.println(this.nomeCliente + " desconectou-se.");
            ServidorChat.listaNomes.remove(this.nomeCliente);
            ServidorChat.atualizarListaUsuarios();
        }
    }

}
