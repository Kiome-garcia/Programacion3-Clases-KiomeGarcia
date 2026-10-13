import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    public void start(Stage stage) {
        Label titulo = new Label("Evaluación de estudiante");
        titulo.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        TextField campoNombre = new TextField();
        campoNombre.setPromptText("Nombre del estudiante");

        TextField campoNota = new TextField();
        campoNota.setPromptText("Calificación (0-100)");

        Button boton = new Button("Evaluar");
        boton.setStyle("-fx-background-color: #2148f3ea; -fx-text-fill: white; -fx-font-weight: bold;");

        Label resultado = new Label();

        boton.setOnAction(e -> {
            String nombre = campoNombre.getText().trim();
            try {
                int nota = Integer.parseInt(campoNota.getText().trim());

                if (nota < 0 || nota > 100) {
                    throw new NumberFormatException();
                }

                if (nota >= 70) {
                    resultado.setText(nombre + ": Aprobado");
                    resultado.setStyle("-fx-background-color: green; -fx-text-fill: white; -fx-padding: 10;");
                } else if (nota >= 60) {
                    resultado.setText(nombre + ": Completivo");
                    resultado.setStyle("-fx-background-color: yellow; -fx-text-fill: black; -fx-padding: 10;");
                } else {
                    resultado.setText(nombre + ": Reprobado");
                    resultado.setStyle("-fx-background-color: red; -fx-text-fill: white; -fx-padding: 10;");
                }
            } catch (NumberFormatException ex) {
                resultado.setText("Nota inválida");
                resultado.setStyle("-fx-background-color: gray; -fx-text-fill: white; -fx-padding: 10;");
            }
        });

        VBox raiz = new VBox(10, titulo, campoNombre, campoNota, boton, resultado);
        raiz.setPadding(new Insets(20));
        raiz.setAlignment(Pos.CENTER);

        stage.setScene(new Scene(raiz, 350, 300));
        stage.setTitle("Evaluación");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}