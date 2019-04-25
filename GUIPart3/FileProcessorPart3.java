
package GUIPart3;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;


public class FileProcessorPart3 extends Application{
    private File selected;
    @Override
    public void start(Stage primaryStage) throws Exception {
    
        MenuBar menu = new MenuBar();
        Menu menuFile = new Menu("File");
        Menu menuEdit = new Menu("Edit");

        MenuItem open = new MenuItem("Open");
        MenuItem save = new MenuItem("Save");
        MenuItem close = new MenuItem("Close");
        MenuItem exit = new MenuItem("Exit");
        menuFile.getItems().addAll(open,save,close,exit);

        MenuItem font = new MenuItem("Font");
        MenuItem color = new MenuItem("Color");
        menuEdit.getItems().addAll(font,color);

        TextArea area = new TextArea();
        area.setEditable(false);
        area.prefHeightProperty().bind(primaryStage.heightProperty());
        area.prefWidthProperty().bind(primaryStage.widthProperty());

        menu.getMenus().addAll(menuFile,menuEdit);
        menu.prefWidthProperty().bind(primaryStage.widthProperty());


        FileChooser fileChooser = new FileChooser();
        EventHandler openHandler = new EventHandler() {
            @Override
            public void handle(Event event) {
                 selected = fileChooser.showOpenDialog(primaryStage);

                if (selected!=null){
                    Scanner scanner = null;
                    try {
                        scanner = new Scanner(selected);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    if (scanner==null) throw new AssertionError();
                    while(scanner.hasNext()){
                        area.setText(area.getText()+"\n" + scanner.nextLine());
                    }
                    area.setEditable(true);
                }
            }
        };
        open.setOnAction(openHandler);
        
        save.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (selected!=null){
                    String textHolder="";
                    String newLine = System.getProperty("line.separator");
                    Scanner scanner = new Scanner(area.getText());
                    while (scanner.hasNext()){
                        textHolder = textHolder.concat(scanner.nextLine()+newLine);
                    }
                    String path = selected.getPath();
                    FileOutputStream fos = null;
                    try {
                        fos = new FileOutputStream(path);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    PrintWriter pw = new PrintWriter(fos);
                    pw.write(textHolder);
                    pw.flush();
                    pw.close();
                }
            }
        });
        
        EventHandler closeHandler = new EventHandler() {
            @Override
            public void handle(Event event) {
                area.setText("");
                area.setEditable(false);
                selected=null;                        
            }
        };
        close.setOnAction(closeHandler);

        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });

        List<String> colors = new ArrayList<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");
        colors.add("Black");


        ChoiceDialog<String> choseColor = new ChoiceDialog<>("Black", colors);
        choseColor.setTitle("Color Selection");
        choseColor.setHeaderText("Select the Color from list");
        choseColor.setContentText("Available Colors:");

        color.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Optional<String> selectedColor = choseColor.showAndWait();

                if (selectedColor.isPresent()){
                    switch (selectedColor.get()) {
                        case "Red":
                            area.setStyle("-fx-text-fill:red");
                            break;
                        case "Black":
                            area.setStyle("-fx-text-fill:black");
                            break;    
                        case "Blue":
                            area.setStyle("-fx-text-fill:blue");
                            break;
                        case "Green":
                            area.setStyle("-fx-text-fill:green");
                            break;    
                        
                    }
                }
            }
        });


        List<String> fonts = new ArrayList<>();
        fonts.add("Arial");
        fonts.add("Georgia");
        fonts.add("Times New Roman");
        
        



        ChoiceDialog<String> fontPicker = new ChoiceDialog<>("Verdana", fonts);
        fontPicker.setTitle("Font Selection");
        fontPicker.setHeaderText("Select the Font from list");
        fontPicker.setContentText("Available Font:");


        font.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Optional<String> selectedFont = fontPicker.showAndWait();
                if (selectedFont.isPresent()){
                    switch (selectedFont.get()) {
                        case "Arial":
                            area.setFont(Font.font("Arial"));
                            break;
                        case "Georgia":
                            area.setFont(Font.font("Georgia"));
                            break;
                        case "Times New Roman":
                            area.setFont(Font.font("Times New Roman"));
                            break;
                        case "Verdana":
                            area.setFont(Font.font("Verdana"));
                            break;
                    }
                }
            }
        });

        FlowPane flowPane = new FlowPane();
        Scene container = new Scene(flowPane,450,490);
        primaryStage.setScene(container);
        primaryStage.setResizable(true);
        primaryStage.setTitle("File Viewer");
        flowPane.getChildren().addAll(menu,area);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
