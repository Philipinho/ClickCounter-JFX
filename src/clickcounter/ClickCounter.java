package clickcounter;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ClickCounter extends Application {
    @Override
    public void start(Stage projectStage){
        projectStage.setTitle("Click Counter");
        Group root = new Group();
        Scene scene = new Scene(root);
        projectStage.setScene(scene);
        Canvas canvas = new Canvas(300,300);
        root.getChildren().add(canvas);
        
        intValue counter = new intValue(0);
        
        scene.setOnMouseClicked(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
           counter.value++;
        }
         
    });
       
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Font font = Font.font("New Times Roman",FontWeight.BOLD,30);
        new AnimationTimer() {
            @Override
            public void handle(long currentNanoTime) {
                gc.setFill(new Color(0.85,0.85,1,1));
                gc.fillRect(0, 0, 300, 300);
                
                gc.setFill(Color.GREEN);
                gc.setFont(font);
                String clicks = "Clicks: "+counter.value;
                gc.fillText(clicks, 80, 150);
            }
        }.start();
        
        
        projectStage.show();
    }
    
public class intValue {
   public int value;
    
    public intValue(int i) {
        value = i;
    }
}

    public static void main(String[] args) {
        launch(args);
    }
    
}
