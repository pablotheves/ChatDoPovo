/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author pablo
 */

public class ServidorObjeto {
    public static void main(String[] args) throws Exception{
        ServerSocket server = new ServerSocket(12345);
        System.out.println("Servidor aguardando conexão...");
        Socket socket = server.accept(); // espera cliente
        
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        
        //receber objeto do cliente
        Pessoa recebida = (Pessoa) in.readObject();
        System.out.println("Recebido: " + recebida.nome + " (" + recebida.idade + ")");
        
        //Envia resposta como outro objeto
        Pessoa resposta = new Pessoa("Servidor", 100);
        out.writeObject(resposta);
        
        socket.close();
        server.close();
    }
}
