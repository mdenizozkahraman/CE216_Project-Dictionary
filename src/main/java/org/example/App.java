package org.example;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;



public class App extends Application {
    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage stage) throws Exception {

        MenuBar menuBar = new MenuBar();
        VBox mainLayout = new VBox(menuBar);
        HBox firstLine = new HBox(8);
        HBox secondLine = new HBox(8);

        firstLine.setAlignment(Pos.CENTER);
        secondLine.setAlignment(Pos.CENTER_LEFT);


        Label label = new Label("Word: ");
        Label label1 = new Label("Select: ");

        Button buttonAdd = new Button("Add");
        Button buttonEdit = new Button("Edit");

        TextField txtInfo = new TextField();

        ListView listView = new ListView<>();
        VBox.setVgrow(listView, Priority.ALWAYS);


        HBox.setHgrow(txtInfo, Priority.ALWAYS);
        Button buttonTranslate = new Button("Translate");

        ComboBox<String> subjects = new ComboBox<>();
        subjects.setPromptText("English");
        subjects.getItems().add("French");
        subjects.getItems().add("German");
        subjects.getItems().add("Modern Greek");
        subjects.getItems().add("English");
        subjects.getItems().add("Italian");
        subjects.getItems().add("Swedish");
        subjects.getItems().add("Turkish");

        txtInfo.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                buttonTranslate.fire();
            }
        });

        buttonTranslate.setOnAction(new EventHandler<>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                listView.getItems().clear();
                int languageIndex = 3;

                String selectedSubject = subjects.getSelectionModel().getSelectedItem();
                selectedSubject = selectedSubject != null ? selectedSubject : "English";

                switch (selectedSubject){
                    case "French": languageIndex = 0;break;
                    case "German": languageIndex = 1;break;
                    case "Modern Greek": languageIndex = 2;break;
                    case "English": break;
                    case "Italian": languageIndex = 4;break;
                    case "Swedish": languageIndex = 5;break;
                    case "Turkish": languageIndex = 6;break;
                    default:

                }

                try {
                    if (languageIndex != 0) listView.getItems().add("French        : " +  FileProcess.WordFinder(txtInfo.getText(),languageIndex,0));
                    if (languageIndex != 1) listView.getItems().add("German        : " +  FileProcess.WordFinder(txtInfo.getText(),languageIndex,1));
                    if (languageIndex != 2) listView.getItems().add("Modern Greek  : " +  FileProcess.WordFinder(txtInfo.getText(),languageIndex,2));
                    if (languageIndex != 3) listView.getItems().add("English       : " +  FileProcess.WordFinder(txtInfo.getText(),languageIndex,3));
                    if (languageIndex != 4) listView.getItems().add("Italian       : " +  FileProcess.WordFinder(txtInfo.getText(),languageIndex,4));
                    if (languageIndex != 5) listView.getItems().add("Swedish       : " +  FileProcess.WordFinder(txtInfo.getText(),languageIndex,5));
                    if (languageIndex != 6) listView.getItems().add("Turkish       : " +  FileProcess.WordFinder(txtInfo.getText(),languageIndex,6));
                }
                catch (Exception e){

                }

            }
        });


        VBox.setMargin(firstLine, new Insets(8));
        VBox.setMargin(secondLine, new Insets(8));
        VBox.setMargin(listView, new Insets(8));

        firstLine.getChildren().addAll(label, txtInfo, buttonTranslate);
        secondLine.getChildren().addAll(label1, subjects, buttonAdd, buttonEdit);
        mainLayout.getChildren().addAll(firstLine, secondLine,listView);

        buttonAdd.setOnAction(new EventHandler<>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                FileProcess.addWord("dicts/deu/deneme.txt",txtInfo.getText());
            }
        });

        Menu h = new Menu("Help");
        MenuItem h1 = new MenuItem("About");

        h1.setAccelerator(new KeyCodeCombination(KeyCode.H, KeyCodeCombination.CONTROL_DOWN));
        h1.setOnAction(e -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("About Dictionary App");
            alert.setHeaderText("User Guide");
            alert.setContentText("The user writes the word in the first box.After user click on the Translate button, one can see the translated words in other 6 languages. ");
            alert.show();

        });

        h.getItems().add(h1);
        menuBar.getMenus().add(h);

        Scene scene = new Scene(mainLayout, 400, 300);

        stage.setTitle("Dictionary");
        stage.setScene(scene);
        stage.show();

    }

}

