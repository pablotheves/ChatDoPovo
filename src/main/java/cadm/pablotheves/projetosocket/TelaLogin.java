package cadm.pablotheves.projetosocket;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class TelaLogin {
    
    
    @FXML
    TextField txtNome;
    
    @FXML
    TextField txtSenha;
    
    
    @FXML
    private void abrirChat() throws IOException {
        String nome = txtNome.getText();
        
        if(nome.isEmpty()){
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Atencao");
            alerta.setHeaderText("Nome obrigatório");
            alerta.setContentText("Por favor, digite seu nome de usuário para entrar.");
            alerta.showAndWait();
            return;
           
        }
        
        App.nomeUsuario = nome;
        App.setRoot("Chat");
    }
}
