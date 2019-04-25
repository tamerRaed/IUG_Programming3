
package GUIPart3;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.util.List;

public class ListCopy extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {
        ListView<String> colors = new ListView<>();
        colors.setItems(FXCollections.observableArrayList(
                "Cyan","Black","Yellow","Blue","Gray","Light Gray","Dark Gray","Green","Red")
        );
        
        colors.setMaxSize(150,170);
        colors.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
        Button button = new Button("Copy >>>");
        
        TextArea area = new TextArea();
        area.setEditable(false);
        area.setMaxSize(150,170);
        
        FlowPane FPane = new FlowPane();
        FPane.setAlignment(Pos.CENTER);
        Scene container = new Scene(FPane,400,180);
        primaryStage.setScene(container);

        EventHandler event= new EventHandler() {
            @Override
            public void handle(Event event) {
                List<String> selected;
                selected = colors.getSelectionModel().getSelectedItems();
                String text = "";
                for (String string:selected) {
                    text = text.concat(string+"\n");
                }
                area.setText(text);
                if (selected.isEmpty()){
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("WARNING");
                    alert.setHeaderText("No Items Selected!!");
                    alert.setContentText("Select An Item");
                    alert.showAndWait();
                }
            }
        };

        button.addEventHandler(MouseEvent.MOUSE_CLICKED,event);


        FPane.getChildren().addAll(colors,button,area);
        primaryStage.setTitle("Multiple Selection List");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
