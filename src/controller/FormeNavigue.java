
package controller;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.event.EventHandler;
import javafx.util.Duration;
import javafx.animation.FadeTransition;

public class FormeNavigue {
    public static void boucheApp(Node n, Duration dure, EventHandler<ActionEvent> eve)
    {
        //animation a l'entrer  de l'application
        FadeTransition fade = new FadeTransition(dure, n);
        fade.setCycleCount(1);
        fade.setAutoReverse(true);
        fade.setToValue(1);
        fade.setFromValue(0.2);
        fade.setOnFinished(eve);
        
       //animation a la sortie
         FadeTransition sortie = new FadeTransition(dure, n);
        sortie.setCycleCount(1);
        sortie.setAutoReverse(true);
        sortie.setToValue(0.2);
        sortie.setFromValue(1);
        sortie.play();
        
        sortie.setOnFinished((e)->{
            fade.play();
        });
        
    }
}
