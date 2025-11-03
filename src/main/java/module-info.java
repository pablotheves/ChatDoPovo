module cadm.pablotheves.projetosocket {
    requires javafx.controls;
    requires javafx.fxml;

    opens cadm.pablotheves.projetosocket to javafx.fxml;
    exports cadm.pablotheves.projetosocket;
}
