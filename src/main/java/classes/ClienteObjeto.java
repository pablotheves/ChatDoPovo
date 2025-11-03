/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.net.Socket;

/**
 *
 * @author pablo
 */

public class ClienteObjeto {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("localhost", 12345);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

        Pessoa p = new Pessoa("João", 25);
        out.writeObject(p);

        Pessoa echo = (Pessoa) in.readObject();
        System.out.println("Servidor respondeu: " + echo.nome);
        
    }
}
