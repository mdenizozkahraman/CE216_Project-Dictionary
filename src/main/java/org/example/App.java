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

//deneme deneme deneme

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

//        buttonAdd.setOnAction(new EventHandler<>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                FileProcess.addWord("dicts/deu/deneme.txt",txtInfo.getText());
//            }
//        });

        buttonAdd.setOnAction(e -> addGUI());



        Menu h = new Menu("Help");
        MenuItem h1 = new MenuItem("About");

        h1.setAccelerator(new KeyCodeCombination(KeyCode.H, KeyCodeCombination.CONTROL_DOWN));
        h1.setOnAction(e -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("About Dictionary App");
            alert.setHeaderText("User Guide");
            alert.setContentText("When the user wants to see the meaning of a " +
                    "word in other languages,the user has to type the word they want to translate into text space in \"Word: \" part. After clicking the translate button," +
                    " the application shows the equivalents it finds for each language in the box below. If the user is searching for a word written in the same way in more than one language," +
                    " she/he should select the language she/he wants to search in the \"Select\" section and then search for the word. If user want to add a new word to the dictionary, user must click the add button from the \"Select\" part of the word. " +
                    "Then, in the window that appears, user should write the word he/she want to add that corresponds to language " +
                    "and user should write the spelling of the word in other languages in a way " +
                    " that corresponds to each language and click the  and click the OK button.");
            alert.show();

        });

        h.getItems().add(h1);
        menuBar.getMenus().add(h);

        Scene scene = new Scene(mainLayout, 400, 300);

        stage.setTitle("Dictionary");
        stage.setScene(scene);
        stage.show();

    }

    private void addGUI() {

        VBox layout = new VBox();

        HBox Line1 = new HBox(8);
        HBox Line2 = new HBox(8);
        HBox Line3 = new HBox(8);
        HBox Line4 = new HBox(8);
        HBox Line5 = new HBox(8);
        HBox Line6 = new HBox(8);
        HBox Line7 = new HBox(8);
        HBox Line9 = new HBox(8);

        Label label1 = new Label("French:            ");
        Label label2 = new Label("German:           ");
        Label label3 = new Label("Modern Greek: ");
        Label label4 = new Label("English:             ");
        Label label5 = new Label("Italian:              ");
        Label label6 = new Label("Swedish:            ");
        Label label7 = new Label("Turkish:              ");


        Button OK = new Button("OK");
        Line9.setAlignment(Pos.BASELINE_RIGHT);

        VBox.setMargin(Line1, new Insets(3));
        VBox.setMargin(Line2, new Insets(3));
        VBox.setMargin(Line3, new Insets(3));
        VBox.setMargin(Line4, new Insets(3));
        VBox.setMargin(Line5, new Insets(3));
        VBox.setMargin(Line6, new Insets(3));
        VBox.setMargin(Line7, new Insets(3));


        TextField txtInfo1 = new TextField();
        TextField txtInfo2 = new TextField();
        TextField txtInfo3 = new TextField();
        TextField txtInfo4 = new TextField();
        TextField txtInfo5 = new TextField();
        TextField txtInfo6 = new TextField();
        TextField txtInfo7 = new TextField();


        OK.setOnAction(new EventHandler<>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                String[] addedWords = {
                        txtInfo1.getText(),
                        txtInfo2.getText(),
                        txtInfo3.getText(),
                        txtInfo4.getText(),
                        txtInfo5.getText(),
                        txtInfo6.getText(),
                        txtInfo7.getText()};

                FileProcess.addWord(addedWords);
            }
        });


        HBox.setHgrow(txtInfo1, Priority.ALWAYS);
        HBox.setHgrow(txtInfo2, Priority.ALWAYS);
        HBox.setHgrow(txtInfo3, Priority.ALWAYS);
        HBox.setHgrow(txtInfo4, Priority.ALWAYS);
        HBox.setHgrow(txtInfo5, Priority.ALWAYS);
        HBox.setHgrow(txtInfo6, Priority.ALWAYS);
        HBox.setHgrow(txtInfo7, Priority.ALWAYS);



        Line1.getChildren().addAll(label1, txtInfo1);
        Line2.getChildren().addAll(label2, txtInfo2);
        Line3.getChildren().addAll(label3, txtInfo3);
        Line4.getChildren().addAll(label4, txtInfo4);
        Line5.getChildren().addAll(label5, txtInfo5);
        Line6.getChildren().addAll(label6, txtInfo6);
        Line7.getChildren().addAll(label7, txtInfo7);

        Line9.getChildren().add(OK);

        layout.getChildren().addAll(Line1,Line2,Line3,Line4,Line5,Line6,Line7,Line9);

        Scene scene = new Scene(layout, 300, 300);
        Stage newStage = new Stage();
        newStage.setTitle("Word Adder");
        newStage.setScene(scene);
        newStage.show();

    }

    private void editGUI() {

        VBox layout = new VBox();

        HBox Line1 = new HBox(8);
        HBox Line2 = new HBox(8);
        HBox Line3 = new HBox(8);
        HBox Line4 = new HBox(8);
        HBox Line5 = new HBox(8);
        HBox Line6 = new HBox(8);
        HBox Line7 = new HBox(8);
        HBox Line9 = new HBox(8);

        Label label1 = new Label("French:       ");
        Label label2 = new Label("German:           ");
        Label label3 = new Label("Modern Greek: ");
        Label label4 = new Label("English:          ");
        Label label5 = new Label("Italian:          ");
        Label label6 = new Label("Swedish:          ");
        Label label7 = new Label("Turkish:          ");


        Button OK = new Button("OK");
        Line9.setAlignment(Pos.BASELINE_RIGHT);
        OK.setOnAction(e-> close());

        VBox.setMargin(Line1, new Insets(25));
        VBox.setMargin(Line2, new Insets(3));
        VBox.setMargin(Line3, new Insets(3));
        VBox.setMargin(Line4, new Insets(3));
        VBox.setMargin(Line5, new Insets(3));
        VBox.setMargin(Line6, new Insets(3));
        VBox.setMargin(Line7, new Insets(3));


        TextField txtInfo1 = new TextField();
        TextField txtInfo2 = new TextField();
        TextField txtInfo3 = new TextField();
        TextField txtInfo4 = new TextField();
        TextField txtInfo5 = new TextField();
        TextField txtInfo6 = new TextField();
        TextField txtInfo7 = new TextField();


        OK.setOnAction(new EventHandler<>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                String[] addedWords = {
                        txtInfo1.getText(),
                        txtInfo2.getText(),
                        txtInfo3.getText(),
                        txtInfo4.getText(),
                        txtInfo5.getText(),
                        txtInfo6.getText(),
                        txtInfo7.getText(),};

                FileProcess.addWord(addedWords);
            }
        });


        HBox.setHgrow(txtInfo1, Priority.ALWAYS);
        HBox.setHgrow(txtInfo2, Priority.ALWAYS);
        HBox.setHgrow(txtInfo3, Priority.ALWAYS);
        HBox.setHgrow(txtInfo4, Priority.ALWAYS);
        HBox.setHgrow(txtInfo5, Priority.ALWAYS);
        HBox.setHgrow(txtInfo6, Priority.ALWAYS);
        HBox.setHgrow(txtInfo7, Priority.ALWAYS);



        Line1.getChildren().addAll(label1, txtInfo1);
        Line2.getChildren().addAll(label2, txtInfo2);
        Line3.getChildren().addAll(label3, txtInfo3);
        Line4.getChildren().addAll(label4, txtInfo4);
        Line5.getChildren().addAll(label5, txtInfo5);
        Line6.getChildren().addAll(label6, txtInfo6);
        Line7.getChildren().addAll(label7, txtInfo7);

        Line9.getChildren().add(OK);

        layout.getChildren().addAll(Line1,Line2,Line3,Line4,Line5,Line6,Line7,Line9);

        Scene scene = new Scene(layout, 300, 300);
        Stage newStage = new Stage();
        newStage.setTitle("Adding Words");
        newStage.setScene(scene);
        newStage.show();

    }
    public void close(){
        close();
    }

}

