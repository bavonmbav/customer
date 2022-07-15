
package customer;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Customer extends Application {
    Stage s;
    @Override
    public void start(Stage stage) throws IOException {
      FXMLLoader node = new  FXMLLoader(getClass().getResource("/fxml/splash.fxml"));
      
        Parent root = node.load();
        stage.setScene(new Scene(root));
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
        this.s = stage;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
