package cadm.pablotheves.projetosocket;

import classes.Mensagem;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.invoke.MethodHandles;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class ChatController implements Initializable {

    @FXML
    private TextField txtMensagem;

    @FXML
    private VBox vBoxChat;

    @FXML
    private ListView<String> listaUsuarios;

    private Socket socket;
    private ObjectOutputStream out;
    private ObjectInputStream in;

    private String meuNome = App.nomeUsuario;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            socket = new Socket("localhost", 12345);

            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());

            out.writeObject(new Mensagem(meuNome, "entrou no chat!"));

            Thread escuta = new Thread(() -> {
                try {
                    while (true) {
                        Mensagem msg = (Mensagem) in.readObject();
                        System.out.println("Recebi nome: '" + msg.nome + "'");
                        // Verifica se é uma atualização de lista
                        if (msg.nome.equals("lista_servidor")) {
                            // O servidor mandou os nomes separados por vírgula
                            String[] nomes = msg.mensagem.split(",");

                            Platform.runLater(() -> {
                                listaUsuarios.getItems().clear();
                                listaUsuarios.getItems().addAll(nomes);
                            });
                        } else {
                            // trata como mensagem normal
                            Platform.runLater(() -> atualizarTela(msg));
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Conexão perdida: " + e.getMessage());
                }
            });
            escuta.setDaemon(true); // fecha o thread quando a janela fecha
            escuta.start();

        } catch (IOException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
        }
    }

    @FXML
    private void Enviar() {
        String texto = txtMensagem.getText();
        if (texto.isEmpty()) {
            return;
        }

        try {
            Mensagem m = new Mensagem(meuNome, texto);
            out.writeObject(m);
            out.flush();
            txtMensagem.clear();

        } catch (IOException e) {
            System.out.println("Erro ao enviar: " + e.getMessage());
        }
    }

    private void atualizarTela(Mensagem msg) {
        Label label = new Label(msg.nome + ": " + msg.mensagem);
        vBoxChat.getChildren().add(label);
    }
}
