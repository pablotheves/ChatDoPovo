package classes;

import cadm.pablotheves.projetosocket.App;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pablo
 */
public class ServidorChat {

    private static List<ObjectOutputStream> listaDeClientes = new ArrayList<>();
    public static List<String> listaNomes = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        ServerSocket server = new ServerSocket(12345);
        System.out.println("Servidor aguardando conexão...");

        while (true) {
            Socket socket = server.accept(); // espera cliente
            System.out.println("======cliente se conectou=====");

            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

            listaDeClientes.add(out);

            ClientHandler handler = new ClientHandler(in, out);
            Thread t = new Thread(handler);
            t.start();

        }

    }

    public static void broadcast(Mensagem msg) {
        for (ObjectOutputStream cliente : listaDeClientes) {
            try {
                cliente.writeObject(msg);
            } catch (Exception e) {

            }
        }
    }
    
    public static void atualizarListaUsuarios(){
        String nomesTexto = String.join(",", listaNomes);// junta os nomes em uma string
        Mensagem m = new Mensagem("lista_servidor", nomesTexto);
        
        broadcast(m);
    }
    
}
