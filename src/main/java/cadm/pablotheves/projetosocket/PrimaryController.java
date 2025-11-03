package cadm.pablotheves.projetosocket;

import java.io.IOException;
import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void abrirChat() throws IOException {
        App.setRoot("Chat");
    }
}
