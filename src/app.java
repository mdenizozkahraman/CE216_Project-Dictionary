import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;


public class app extends Application {
    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage stage) throws Exception {

        MenuBar menuBar = new MenuBar();
        VBox mainLayout = new VBox(menuBar);
        HBox firstLine = new HBox(8);
        firstLine.setAlignment(Pos.CENTER);
        Label label = new Label("Word: ");

        HBox secondLine = new HBox(8);
        firstLine.setAlignment(Pos.CENTER);
        Label label1 = new Label("Select: ");
        Button bttnAdd1 = new Button("Add");
        Button bttnAdd2 = new Button("Delete");
        Button bttnAdd3 = new Button("Edit");


        TextField txtInfo = new TextField();
        HBox.setHgrow(txtInfo, Priority.ALWAYS);
        Button bttnAdd = new Button("Translate");

        bttnAdd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //  translate butonuna basınca bu metod çalışacak
            }
        });


        ListView listView = new ListView<>();
        VBox.setVgrow(listView, Priority.ALWAYS);

        VBox.setMargin(firstLine, new Insets(8));
        VBox.setMargin(secondLine, new Insets(8));
        VBox.setMargin(listView, new Insets(8));


        firstLine.getChildren().addAll(label, txtInfo, bttnAdd);

        secondLine.getChildren().addAll(label1, bttnAdd1, bttnAdd2, bttnAdd3);

        mainLayout.getChildren().addAll(firstLine, secondLine, listView);


        Menu h = new Menu("Help");
        Menu f = new Menu("File");
        Menu ed = new Menu("Edit");
        Menu v = new Menu("View");
        Menu o = new Menu("Options");


        MenuItem h1 = new MenuItem("about");
        Menu o1 = new Menu("Language (app)");
        MenuItem f1 = new MenuItem("save");
        MenuItem f2 = new MenuItem("open");
        MenuItem f3 = new MenuItem("new");
        MenuItem f4 = new MenuItem("exit");
        MenuItem ed1 = new MenuItem("copy");
        MenuItem ed2 = new MenuItem("paste");

        MenuItem tr = new MenuItem("turkish");
        MenuItem swe = new MenuItem("swedish");
        MenuItem ger = new MenuItem("german");
        MenuItem eng = new MenuItem("english");
        MenuItem ita = new MenuItem("italian");
        MenuItem mod = new MenuItem("modern greek");
        MenuItem fr = new MenuItem("french");

        o1.getItems().add(tr);
        o1.getItems().add(fr);
        o1.getItems().add(eng);
        o1.getItems().add(ita);
        o1.getItems().add(swe);
        o1.getItems().add(mod);
        o1.getItems().add(ger);


        f1.setOnAction(e -> saveFile(stage));
        f2.setOnAction(e -> openFile(stage));
        h1.setOnAction(e -> alert());

        tr.setOnAction(e -> selectLanguage1(stage));
        swe.setOnAction(e -> selectLanguage2(stage));
        ger.setOnAction(e -> selectLanguage3(stage));
        ita.setOnAction(e -> selectLanguage5(stage));
        mod.setOnAction(e -> selectLanguage6(stage));
        fr.setOnAction(e -> selectLanguage7(stage));

        h1.setAccelerator(KeyCombination.keyCombination("Ctrl + A"));
        o1.setAccelerator(KeyCombination.keyCombination("Ctrl + L"));
        f1.setAccelerator(KeyCombination.keyCombination("Ctrl + S"));
        f2.setAccelerator(KeyCombination.keyCombination("Ctrl + O"));
        f3.setAccelerator(KeyCombination.keyCombination("Ctrl + N"));
        f4.setAccelerator(KeyCombination.keyCombination("Ctrl + E"));
        ed1.setAccelerator(KeyCombination.keyCombination("Ctrl + C"));
        ed2.setAccelerator(KeyCombination.keyCombination("Ctrl + P"));

        h.getItems().add(h1);
        o.getItems().add(o1);
        f.getItems().add(f1);
        f.getItems().add(f2);
        f.getItems().add(f3);
        f.getItems().add(f4);
        ed.getItems().add(ed1);
        ed.getItems().add(ed2);


        menuBar.getMenus().add(f);
        menuBar.getMenus().add(o);
        menuBar.getMenus().add(v);
        menuBar.getMenus().add(ed);
        menuBar.getMenus().add(h);


        Scene scene = new Scene(mainLayout, 400, 300);

        stage.setTitle("Dictionary");
        stage.setScene(scene);
        stage.show();

    }

    private void saveFile(Stage stage) {
        FileChooser fc = new FileChooser();
        fc.setTitle("Select file to save!");
        File f = fc.showSaveDialog(stage);
    }

    private void openFile(Stage stage) {
        FileChooser fc = new FileChooser();
        fc.setTitle("Select file to open!");
        File f = fc.showOpenDialog(stage);
    }


    private void alert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About Dictionary App");
        alert.setHeaderText("User Guide");
        alert.setContentText("The user writes the word in the first box.After user click on the Translate button, one can see the translated words in other 6 languages. ");
        alert.show();

    }


    private void selectLanguage1(Stage stage) {

        MenuBar menuBar = new MenuBar();
        VBox mainLayout = new VBox(menuBar);
        HBox firstLine = new HBox(8);
        firstLine.setAlignment(Pos.CENTER);
        Label label = new Label("Kelime: ");

        HBox secondLine = new HBox(8);
        firstLine.setAlignment(Pos.CENTER);
        Label label1 = new Label("Seçiniz: ");
        Button bttnAdd1 = new Button("Ekle");
        Button bttnAdd2 = new Button("Sil");
        Button bttnAdd3 = new Button("Düzenle");


        TextField txtInfo = new TextField();
        HBox.setHgrow(txtInfo, Priority.ALWAYS);
        Button bttnAdd = new Button("Çevir");


        ListView listView = new ListView<>();
        VBox.setVgrow(listView, Priority.ALWAYS);

        VBox.setMargin(firstLine, new Insets(8));
        VBox.setMargin(secondLine, new Insets(8));
        VBox.setMargin(listView, new Insets(8));


        firstLine.getChildren().addAll(label, txtInfo, bttnAdd);

        secondLine.getChildren().addAll(label1, bttnAdd1, bttnAdd2, bttnAdd3);

        mainLayout.getChildren().addAll(firstLine, secondLine, listView);


        Menu h = new Menu("Yardım");
        Menu f = new Menu("Dosya");
        Menu ed = new Menu("Düzenle");
        Menu v = new Menu("Görüntü");
        Menu o = new Menu("Seçenekler");


        MenuItem h1 = new MenuItem("Hakkında");
        Menu o1 = new Menu("Diller (uygulama)");
        MenuItem f1 = new MenuItem("Kaydet");
        MenuItem f2 = new MenuItem("Aç");
        MenuItem f3 = new MenuItem("Yeni");
        MenuItem f4 = new MenuItem("Çıkış");
        MenuItem ed1 = new MenuItem("Kopyala");
        MenuItem ed2 = new MenuItem("Yapıştır");

        MenuItem tr = new MenuItem("Türkçe");
        MenuItem swe = new MenuItem("İsveççe");
        MenuItem ger = new MenuItem("Almanca");
        MenuItem eng = new MenuItem("İngilizce");
        MenuItem ita = new MenuItem("İtalyanca");
        MenuItem mod = new MenuItem("Modern Yunanca");
        MenuItem fr = new MenuItem("Fransızca");

        o1.getItems().add(tr);
        o1.getItems().add(fr);
        o1.getItems().add(eng);
        o1.getItems().add(ita);
        o1.getItems().add(swe);
        o1.getItems().add(mod);
        o1.getItems().add(ger);

        f1.setOnAction(e -> saveFile(stage));
        f2.setOnAction(e -> openFile(stage));
        h1.setOnAction(e -> alert1());

        swe.setOnAction(e -> selectLanguage2(stage));
        ger.setOnAction(e -> selectLanguage3(stage));
        eng.setOnAction(e -> selectLanguage4(stage));
        ita.setOnAction(e -> selectLanguage5(stage));
        mod.setOnAction(e -> selectLanguage6(stage));
        fr.setOnAction(e -> selectLanguage7(stage));

        h1.setAccelerator(KeyCombination.keyCombination("Ctrl + H"));
        o1.setAccelerator(KeyCombination.keyCombination("Ctrl + D"));
        f1.setAccelerator(KeyCombination.keyCombination("Ctrl + K"));
        f2.setAccelerator(KeyCombination.keyCombination("Ctrl + A"));
        f3.setAccelerator(KeyCombination.keyCombination("Ctrl + Y"));
        f4.setAccelerator(KeyCombination.keyCombination("Ctrl + Ç"));
        ed1.setAccelerator(KeyCombination.keyCombination("Ctrl + C"));
        ed2.setAccelerator(KeyCombination.keyCombination("Ctrl + V"));

        h.getItems().add(h1);
        o.getItems().add(o1);
        f.getItems().add(f1);
        f.getItems().add(f2);
        f.getItems().add(f3);
        f.getItems().add(f4);
        ed.getItems().add(ed1);
        ed.getItems().add(ed2);


        menuBar.getMenus().add(f);
        menuBar.getMenus().add(o);
        menuBar.getMenus().add(v);
        menuBar.getMenus().add(ed);
        menuBar.getMenus().add(h);


        Scene scene = new Scene(mainLayout, 400, 300);
        stage.setTitle("Sözlük");
        stage.setScene(scene);
        stage.show();
    }

    private void alert1() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Sözlük Uygulaması Hakkında");
        alert.setHeaderText("kullanıcı kılavuzu");
        alert.setContentText("Kullanıcı çevirmek istediği kelimeyi ilk kutucuğa yazıp çevir butonuna bastıktan sonra aşağıdaki kutucukta 6 dile çevrilmiş halini görür.");
        alert.show();
    }

    private void selectLanguage2(Stage stage) {

        MenuBar menuBar = new MenuBar();
        VBox mainLayout = new VBox(menuBar);
        HBox firstLine = new HBox(8);
        firstLine.setAlignment(Pos.CENTER);
        Label label = new Label("Ord: ");

        HBox secondLine = new HBox(8);
        firstLine.setAlignment(Pos.CENTER);
        Label label1 = new Label("Välj: ");
        Button bttnAdd1 = new Button("Tillägga");
        Button bttnAdd2 = new Button("Radera");
        Button bttnAdd3 = new Button("Redigera");


        TextField txtInfo = new TextField();
        HBox.setHgrow(txtInfo, Priority.ALWAYS);
        Button bttnAdd = new Button("Översätt");


        ListView listView = new ListView<>();
        VBox.setVgrow(listView, Priority.ALWAYS);

        VBox.setMargin(firstLine, new Insets(8));
        VBox.setMargin(secondLine, new Insets(8));
        VBox.setMargin(listView, new Insets(8));


        firstLine.getChildren().addAll(label, txtInfo, bttnAdd);

        secondLine.getChildren().addAll(label1, bttnAdd1, bttnAdd2, bttnAdd3);

        mainLayout.getChildren().addAll(firstLine, secondLine, listView);


        Menu h = new Menu("Hjälp");
        Menu f = new Menu("Fil");
        Menu ed = new Menu("Redigera");
        Menu v = new Menu("Se");
        Menu o = new Menu("Alternativ");


        MenuItem h1 = new MenuItem("Handla om");
        Menu o1 = new Menu("Språk (App)");
        MenuItem f1 = new MenuItem("Spara");
        MenuItem f2 = new MenuItem("Öppen");
        MenuItem f3 = new MenuItem("Ny");
        MenuItem f4 = new MenuItem("Utgång");
        MenuItem ed1 = new MenuItem("Kopiera");
        MenuItem ed2 = new MenuItem("Klistra");

        MenuItem tr = new MenuItem("Turkiska");
        MenuItem swe = new MenuItem("Svenska");
        MenuItem ger = new MenuItem("Tysk");
        MenuItem eng = new MenuItem("Engelsk");
        MenuItem ita = new MenuItem("italienska");
        MenuItem mod = new MenuItem("modern grekiska");
        MenuItem fr = new MenuItem("Fransızca");

        o1.getItems().add(tr);
        o1.getItems().add(fr);
        o1.getItems().add(eng);
        o1.getItems().add(ita);
        o1.getItems().add(swe);
        o1.getItems().add(mod);
        o1.getItems().add(ger);

        f1.setOnAction(e -> saveFile(stage));
        f2.setOnAction(e -> openFile(stage));
        h1.setOnAction(e -> alert2());

        tr.setOnAction(e -> selectLanguage1(stage));
        ger.setOnAction(e -> selectLanguage3(stage));
        eng.setOnAction(e -> selectLanguage4(stage));
        ita.setOnAction(e -> selectLanguage5(stage));
        mod.setOnAction(e -> selectLanguage6(stage));
        fr.setOnAction(e -> selectLanguage7(stage));

        h1.setAccelerator(KeyCombination.keyCombination("Ctrl + H"));
        o1.setAccelerator(KeyCombination.keyCombination("Ctrl + D"));
        f1.setAccelerator(KeyCombination.keyCombination("Ctrl + K"));
        f2.setAccelerator(KeyCombination.keyCombination("Ctrl + A"));
        f3.setAccelerator(KeyCombination.keyCombination("Ctrl + Y"));
        f4.setAccelerator(KeyCombination.keyCombination("Ctrl + Ç"));
        ed1.setAccelerator(KeyCombination.keyCombination("Ctrl + C"));
        ed2.setAccelerator(KeyCombination.keyCombination("Ctrl + V"));

        h.getItems().add(h1);
        o.getItems().add(o1);
        f.getItems().add(f1);
        f.getItems().add(f2);
        f.getItems().add(f3);
        f.getItems().add(f4);
        ed.getItems().add(ed1);
        ed.getItems().add(ed2);


        menuBar.getMenus().add(f);
        menuBar.getMenus().add(o);
        menuBar.getMenus().add(v);
        menuBar.getMenus().add(ed);
        menuBar.getMenus().add(h);


        Scene scene = new Scene(mainLayout, 400, 300);
        stage.setTitle("Lexikon");
        stage.setScene(scene);
        stage.show();
    }

    private void alert2() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Om Ordboksappen");
        alert.setHeaderText("Användarguide");
        alert.setContentText("Efter att användaren skrivit ordet han vill översätta i den första rutan och tryckt på översättknappen, ser han den översatta versionen på 6 språk i rutan nedan.");
        alert.show();
    }


    private void selectLanguage3(Stage stage) {

        MenuBar menuBar = new MenuBar();
        VBox mainLayout = new VBox(menuBar);
        HBox firstLine = new HBox(8);
        firstLine.setAlignment(Pos.CENTER);
        Label label = new Label("Wort: ");

        HBox secondLine = new HBox(8);
        firstLine.setAlignment(Pos.CENTER);
        Label label1 = new Label("Wählen: ");
        Button bttnAdd1 = new Button("Hinzufügen");
        Button bttnAdd2 = new Button("Löschen");
        Button bttnAdd3 = new Button("Bearbeiten");


        TextField txtInfo = new TextField();
        HBox.setHgrow(txtInfo, Priority.ALWAYS);
        Button bttnAdd = new Button("Übersetzen");


        ListView listView = new ListView<>();
        VBox.setVgrow(listView, Priority.ALWAYS);

        VBox.setMargin(firstLine, new Insets(8));
        VBox.setMargin(secondLine, new Insets(8));
        VBox.setMargin(listView, new Insets(8));


        firstLine.getChildren().addAll(label, txtInfo, bttnAdd);

        secondLine.getChildren().addAll(label1, bttnAdd1, bttnAdd2, bttnAdd3);

        mainLayout.getChildren().addAll(firstLine, secondLine, listView);


        Menu h = new Menu("Hilfe");
        Menu f = new Menu("Datei");
        Menu ed = new Menu("Bearbeiten");
        Menu v = new Menu("Bild");
        Menu o = new Menu("Optionen");


        MenuItem h1 = new MenuItem("Um");
        Menu o1 = new Menu("Sprachen (App)");
        MenuItem f1 = new MenuItem("Speichern");
        MenuItem f2 = new MenuItem("Hungrig");
        MenuItem f3 = new MenuItem("Neu");
        MenuItem f4 = new MenuItem("Ausfahrt");
        MenuItem ed1 = new MenuItem("Kopieren");
        MenuItem ed2 = new MenuItem("Paste");

        MenuItem tr = new MenuItem("Türkisch");
        MenuItem swe = new MenuItem("Schwedisch");
        MenuItem ger = new MenuItem("Deutsch");
        MenuItem eng = new MenuItem("Englisch");
        MenuItem ita = new MenuItem("Italienisch");
        MenuItem mod = new MenuItem("Neugriechisch");
        MenuItem fr = new MenuItem("Französisch");

        o1.getItems().add(tr);
        o1.getItems().add(fr);
        o1.getItems().add(eng);
        o1.getItems().add(ita);
        o1.getItems().add(swe);
        o1.getItems().add(mod);
        o1.getItems().add(ger);

        f1.setOnAction(e -> saveFile(stage));
        f2.setOnAction(e -> openFile(stage));
        h1.setOnAction(e -> alert3());


        swe.setOnAction(e -> selectLanguage2(stage));
        tr.setOnAction(e -> selectLanguage1(stage));
        eng.setOnAction(e -> selectLanguage4(stage));
        ita.setOnAction(e -> selectLanguage5(stage));
        mod.setOnAction(e -> selectLanguage6(stage));
        fr.setOnAction(e -> selectLanguage7(stage));

        h1.setAccelerator(KeyCombination.keyCombination("Ctrl + U"));
        o1.setAccelerator(KeyCombination.keyCombination("Ctrl + S"));
        f1.setAccelerator(KeyCombination.keyCombination("Ctrl + A"));
        f2.setAccelerator(KeyCombination.keyCombination("Ctrl + H"));
        f3.setAccelerator(KeyCombination.keyCombination("Ctrl + N"));
        f4.setAccelerator(KeyCombination.keyCombination("Ctrl + X"));
        ed1.setAccelerator(KeyCombination.keyCombination("Ctrl + C"));
        ed2.setAccelerator(KeyCombination.keyCombination("Ctrl + F"));

        h.getItems().add(h1);
        o.getItems().add(o1);
        f.getItems().add(f1);
        f.getItems().add(f2);
        f.getItems().add(f3);
        f.getItems().add(f4);
        ed.getItems().add(ed1);
        ed.getItems().add(ed2);


        menuBar.getMenus().add(f);
        menuBar.getMenus().add(o);
        menuBar.getMenus().add(v);
        menuBar.getMenus().add(ed);
        menuBar.getMenus().add(h);


        Scene scene = new Scene(mainLayout, 400, 300);
        stage.setTitle("Wörterbuch");
        stage.setScene(scene);
        stage.show();
    }

    private void alert3() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Über die Wörterbuch-App");
        alert.setHeaderText("Benutzerhandbuch");
        alert.setContentText("Der Benutzer schreibt das Wort in das erste Feld. Nachdem der Benutzer auf die Schaltfläche Übersetzen geklickt hat, kann man die übersetzten Wörter in anderen 6 Sprachen sehen.");
        alert.show();
    }

    public void selectLanguage4(Stage stage) {
        MenuBar menuBar = new MenuBar();
        VBox mainLayout = new VBox(menuBar);
        HBox firstLine = new HBox(8);
        firstLine.setAlignment(Pos.CENTER);
        Label label = new Label("Word: ");

        HBox secondLine = new HBox(8);
        firstLine.setAlignment(Pos.CENTER);
        Label label1 = new Label("Select: ");
        Button bttnAdd1 = new Button("Add");
        Button bttnAdd2 = new Button("Delete");
        Button bttnAdd3 = new Button("Edit");


        TextField txtInfo = new TextField();
        HBox.setHgrow(txtInfo,Priority.ALWAYS);
        Button bttnAdd = new Button("Translate");


        ListView listView = new ListView<>();
        VBox.setVgrow(listView, Priority.ALWAYS);

        VBox.setMargin(firstLine, new Insets(8));
        VBox.setMargin(secondLine, new Insets(8));
        VBox.setMargin(listView, new Insets(8));


        firstLine.getChildren().addAll(label, txtInfo, bttnAdd);

        secondLine.getChildren().addAll(label1, bttnAdd1, bttnAdd2, bttnAdd3);

        mainLayout.getChildren().addAll(firstLine, secondLine, listView);


        Menu h = new Menu("Help");
        Menu f = new Menu("File");
        Menu ed = new Menu("Edit");
        Menu v = new Menu("View");
        Menu o = new Menu("Options");


        MenuItem h1 = new MenuItem("about");
        Menu o1 = new Menu("Language (app)");
        MenuItem f1 = new MenuItem("save");
        MenuItem f2 = new MenuItem("open");
        MenuItem f3 = new MenuItem("new");
        MenuItem f4 = new MenuItem("exit");
        MenuItem ed1 = new MenuItem("copy");
        MenuItem ed2 = new MenuItem("paste");

        MenuItem tr = new MenuItem("turkish");
        MenuItem swe = new MenuItem("swedish");
        MenuItem ger = new MenuItem("german");
        MenuItem eng = new MenuItem("english");
        MenuItem ita = new MenuItem("italian");
        MenuItem mod = new MenuItem("modern greek");
        MenuItem fr = new MenuItem("french");

        o1.getItems().add(tr);
        o1.getItems().add(fr);
        o1.getItems().add(eng);
        o1.getItems().add(ita);
        o1.getItems().add(swe);
        o1.getItems().add(mod);
        o1.getItems().add(ger);


        f1.setOnAction(e -> saveFile(stage));
        f2.setOnAction(e -> openFile(stage));
        h1.setOnAction(e -> alert4());

        tr.setOnAction(e -> selectLanguage1(stage));
        swe.setOnAction(e -> selectLanguage2(stage));
        ger.setOnAction(e -> selectLanguage3(stage));
        ita.setOnAction(e -> selectLanguage5(stage));
        mod.setOnAction(e -> selectLanguage6(stage));
        fr.setOnAction(e -> selectLanguage7(stage));

        h1.setAccelerator(KeyCombination.keyCombination("Ctrl + A"));
        o1.setAccelerator(KeyCombination.keyCombination("Ctrl + L"));
        f1.setAccelerator(KeyCombination.keyCombination("Ctrl + S"));
        f2.setAccelerator(KeyCombination.keyCombination("Ctrl + O"));
        f3.setAccelerator(KeyCombination.keyCombination("Ctrl + N"));
        f4.setAccelerator(KeyCombination.keyCombination("Ctrl + E"));
        ed1.setAccelerator(KeyCombination.keyCombination("Ctrl + C"));
        ed2.setAccelerator(KeyCombination.keyCombination("Ctrl + P"));

        h.getItems().add(h1);
        o.getItems().add(o1);
        f.getItems().add(f1);
        f.getItems().add(f2);
        f.getItems().add(f3);
        f.getItems().add(f4);
        ed.getItems().add(ed1);
        ed.getItems().add(ed2);


        menuBar.getMenus().add(f);
        menuBar.getMenus().add(o);
        menuBar.getMenus().add(v);
        menuBar.getMenus().add(ed);
        menuBar.getMenus().add(h);


        Scene scene = new Scene(mainLayout, 400, 300);
        stage.setTitle("Dictionary");
        stage.setScene(scene);
        stage.show();

    }


    private void alert4() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About Dictionary App");
        alert.setHeaderText("User Guide");
        alert.setContentText("The user writes the word in the first box.After user click on the Translate button, one can see the translated words in other 6 languages. ");
        alert.show();

    }

    public void selectLanguage5(Stage stage) {
        MenuBar menuBar = new MenuBar();
        VBox mainLayout = new VBox(menuBar);
        HBox firstLine = new HBox(8);
        firstLine.setAlignment(Pos.CENTER);
        Label label = new Label("Parola: ");

        HBox secondLine = new HBox(8);
        firstLine.setAlignment(Pos.CENTER);
        Label label1 = new Label("Selezionare: ");
        Button bttnAdd1 = new Button("Aggiungere");
        Button bttnAdd2 = new Button("Eliminare");
        Button bttnAdd3 = new Button("Modificare");


        TextField txtInfo = new TextField();
        HBox.setHgrow(txtInfo,Priority.ALWAYS);
        Button bttnAdd = new Button("Tradurre");


        ListView listView = new ListView<>();
        VBox.setVgrow(listView, Priority.ALWAYS);

        VBox.setMargin(firstLine, new Insets(8));
        VBox.setMargin(secondLine, new Insets(8));
        VBox.setMargin(listView, new Insets(8));


        firstLine.getChildren().addAll(label, txtInfo, bttnAdd);

        secondLine.getChildren().addAll(label1, bttnAdd1, bttnAdd2, bttnAdd3);

        mainLayout.getChildren().addAll(firstLine, secondLine, listView);


        Menu h = new Menu("Aiuto");
        Menu f = new Menu("File");
        Menu ed = new Menu("Modificare");
        Menu v = new Menu("Visualizzazione");
        Menu o = new Menu("Opzioni");


        MenuItem h1 = new MenuItem("Di");
        Menu o1 = new Menu("Lingua (app)");
        MenuItem f1 = new MenuItem("salva");
        MenuItem f2 = new MenuItem("aprire");
        MenuItem f3 = new MenuItem("nuovo");
        MenuItem f4 = new MenuItem("Uscita");
        MenuItem ed1 = new MenuItem("Copia");
        MenuItem ed2 = new MenuItem("paste");

        MenuItem tr = new MenuItem("turca");
        MenuItem swe = new MenuItem("svedese");
        MenuItem ger = new MenuItem("tedesco");
        MenuItem eng = new MenuItem("inglese");
        MenuItem ita = new MenuItem("italiana");
        MenuItem mod = new MenuItem("greco moderno");
        MenuItem fr = new MenuItem("francese");

        o1.getItems().add(tr);
        o1.getItems().add(fr);
        o1.getItems().add(eng);
        o1.getItems().add(ita);
        o1.getItems().add(swe);
        o1.getItems().add(mod);
        o1.getItems().add(ger);


        f1.setOnAction(e -> saveFile(stage));
        f2.setOnAction(e -> openFile(stage));
        h1.setOnAction(e -> alert5());

        tr.setOnAction(e -> selectLanguage1(stage));
        swe.setOnAction(e -> selectLanguage2(stage));
        ger.setOnAction(e -> selectLanguage3(stage));
        eng.setOnAction(e -> selectLanguage4(stage));
        mod.setOnAction(e -> selectLanguage6(stage));
        fr.setOnAction(e -> selectLanguage7(stage));

        h1.setAccelerator(KeyCombination.keyCombination("Ctrl + D"));
        o1.setAccelerator(KeyCombination.keyCombination("Ctrl + L"));
        f1.setAccelerator(KeyCombination.keyCombination("Ctrl + S"));
        f2.setAccelerator(KeyCombination.keyCombination("Ctrl + A"));
        f3.setAccelerator(KeyCombination.keyCombination("Ctrl + N"));
        f4.setAccelerator(KeyCombination.keyCombination("Ctrl + U"));
        ed1.setAccelerator(KeyCombination.keyCombination("Ctrl + C"));
        ed2.setAccelerator(KeyCombination.keyCombination("Ctrl + P"));

        h.getItems().add(h1);
        o.getItems().add(o1);
        f.getItems().add(f1);
        f.getItems().add(f2);
        f.getItems().add(f3);
        f.getItems().add(f4);
        ed.getItems().add(ed1);
        ed.getItems().add(ed2);


        menuBar.getMenus().add(f);
        menuBar.getMenus().add(o);
        menuBar.getMenus().add(v);
        menuBar.getMenus().add(ed);
        menuBar.getMenus().add(h);


        Scene scene = new Scene(mainLayout, 400, 300);
        stage.setTitle("Dizionario");
        stage.setScene(scene);
        stage.show();

    }


    private void alert5() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Informazioni sull'app Dizionario");
        alert.setHeaderText("Guida utente");
        alert.setContentText("L'utente scrive la parola nella prima casella. Dopo che l'utente ha fatto clic sul pulsante Traduci, è possibile vedere le parole tradotte in altre 6 lingue. ");
        alert.show();

    }

    public void selectLanguage6(Stage stage) {
        MenuBar menuBar = new MenuBar();
        VBox mainLayout = new VBox(menuBar);
        HBox firstLine = new HBox(8);
        firstLine.setAlignment(Pos.CENTER);
        Label label = new Label("λέξη: ");

        HBox secondLine = new HBox(8);
        firstLine.setAlignment(Pos.CENTER);
        Label label1 = new Label("Επιλέγω: ");
        Button bttnAdd1 = new Button("Προσθήκη");
        Button bttnAdd2 = new Button("Διαγράφω");
        Button bttnAdd3 = new Button("Επεξεργασία");


        TextField txtInfo = new TextField();
        HBox.setHgrow(txtInfo,Priority.ALWAYS);
        Button bttnAdd = new Button("Μεταφράζω");


        ListView listView = new ListView<>();
        VBox.setVgrow(listView, Priority.ALWAYS);

        VBox.setMargin(firstLine, new Insets(8));
        VBox.setMargin(secondLine, new Insets(8));
        VBox.setMargin(listView, new Insets(8));


        firstLine.getChildren().addAll(label, txtInfo, bttnAdd);

        secondLine.getChildren().addAll(label1, bttnAdd1, bttnAdd2, bttnAdd3);

        mainLayout.getChildren().addAll(firstLine, secondLine, listView);


        Menu h = new Menu("Βοήθεια");
        Menu f = new Menu("Αρχείο");
        Menu ed = new Menu("Επεξεργασία");
        Menu v = new Menu("Θέα");
        Menu o = new Menu("Επιλογές");


        MenuItem h1 = new MenuItem("σχετικά με");
        Menu o1 = new Menu("Γλώσσα (εφαρμογή)");
        MenuItem f1 = new MenuItem("αποθηκεύσετε");
        MenuItem f2 = new MenuItem("Άνοιξε");
        MenuItem f3 = new MenuItem("νέος");
        MenuItem f4 = new MenuItem("έξοδος");
        MenuItem ed1 = new MenuItem("αντίγραφο");
        MenuItem ed2 = new MenuItem("Επικόλληση");

        MenuItem tr = new MenuItem("τούρκικος");
        MenuItem swe = new MenuItem("Σουηδικά");
        MenuItem ger = new MenuItem("Γερμανός");
        MenuItem eng = new MenuItem("Αγγλικά");
        MenuItem ita = new MenuItem("ιταλικός");
        MenuItem mod = new MenuItem("Νέα Ελληνικά");
        MenuItem fr = new MenuItem("γαλλική γλώσσα");

        o1.getItems().add(tr);
        o1.getItems().add(fr);
        o1.getItems().add(eng);
        o1.getItems().add(ita);
        o1.getItems().add(swe);
        o1.getItems().add(mod);
        o1.getItems().add(ger);


        f1.setOnAction(e -> saveFile(stage));
        f2.setOnAction(e -> openFile(stage));
        h1.setOnAction(e -> alert6());

        tr.setOnAction(e -> selectLanguage1(stage));
        swe.setOnAction(e -> selectLanguage2(stage));
        ger.setOnAction(e -> selectLanguage3(stage));
        eng.setOnAction(e -> selectLanguage4(stage));
        ita.setOnAction(e -> selectLanguage5(stage));
        fr.setOnAction(e -> selectLanguage7(stage));


        h1.setAccelerator(KeyCombination.keyCombination("Ctrl + σ"));
        o1.setAccelerator(KeyCombination.keyCombination("Ctrl + Γ"));
        f1.setAccelerator(KeyCombination.keyCombination("Ctrl + α"));
        f2.setAccelerator(KeyCombination.keyCombination("Ctrl + A"));
        f3.setAccelerator(KeyCombination.keyCombination("Ctrl + V"));
        f4.setAccelerator(KeyCombination.keyCombination("Ctrl + έ"));
        ed1.setAccelerator(KeyCombination.keyCombination("Ctrl + A"));
        ed2.setAccelerator(KeyCombination.keyCombination("Ctrl + E"));

        h.getItems().add(h1);
        o.getItems().add(o1);
        f.getItems().add(f1);
        f.getItems().add(f2);
        f.getItems().add(f3);
        f.getItems().add(f4);
        ed.getItems().add(ed1);
        ed.getItems().add(ed2);


        menuBar.getMenus().add(f);
        menuBar.getMenus().add(o);
        menuBar.getMenus().add(v);
        menuBar.getMenus().add(ed);
        menuBar.getMenus().add(h);


        Scene scene = new Scene(mainLayout, 400, 300);
        stage.setTitle("Dictionary");
        stage.setScene(scene);
        stage.show();

    }


    private void alert6() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Σχετικά με την εφαρμογή Λεξικό");
        alert.setHeaderText("οδηγούς χρήσης");
        alert.setContentText(" Ο χρήστης γράφει τη λέξη στο πρώτο πλαίσιο. Αφού ο χρήστης κάνει κλικ στο κουμπί Μετάφραση, μπορεί κανείς να δει τις μεταφρασμένες λέξεις σε άλλες 6 γλώσσες.");
        alert.show();

    }

    public void selectLanguage7(Stage stage) {
        MenuBar menuBar = new MenuBar();
        VBox mainLayout = new VBox(menuBar);
        HBox firstLine = new HBox(8);
        firstLine.setAlignment(Pos.CENTER);
        Label label = new Label("Mot: ");

        HBox secondLine = new HBox(8);
        firstLine.setAlignment(Pos.CENTER);
        Label label1 = new Label("Sélectionner: ");
        Button bttnAdd1 = new Button("Ajouter");
        Button bttnAdd2 = new Button("Supprimer");
        Button bttnAdd3 = new Button("Editer");


        TextField txtInfo = new TextField();
        HBox.setHgrow(txtInfo,Priority.ALWAYS);
        Button bttnAdd = new Button("Traduire");


        ListView listView = new ListView<>();
        VBox.setVgrow(listView, Priority.ALWAYS);

        VBox.setMargin(firstLine, new Insets(8));
        VBox.setMargin(secondLine, new Insets(8));
        VBox.setMargin(listView, new Insets(8));


        firstLine.getChildren().addAll(label, txtInfo, bttnAdd);

        secondLine.getChildren().addAll(label1, bttnAdd1, bttnAdd2, bttnAdd3);

        mainLayout.getChildren().addAll(firstLine, secondLine, listView);


        Menu h = new Menu("Aide");
        Menu f = new Menu("Fichier");
        Menu ed = new Menu("Editer");
        Menu v = new Menu("Voir");
        Menu o = new Menu("Options");


        MenuItem h1 = new MenuItem("à propos");
        Menu o1 = new Menu("langues (app)");
        MenuItem f1 = new MenuItem("sauver");
        MenuItem f2 = new MenuItem("ouvert");
        MenuItem f3 = new MenuItem("nouveau");
        MenuItem f4 = new MenuItem("sortie");
        MenuItem ed1 = new MenuItem("copie");
        MenuItem ed2 = new MenuItem("pâte");

        MenuItem tr = new MenuItem("turc");
        MenuItem swe = new MenuItem("suédois");
        MenuItem ger = new MenuItem("allemand");
        MenuItem eng = new MenuItem("anglais");
        MenuItem ita = new MenuItem("italien");
        MenuItem mod = new MenuItem("grec moderne");
        MenuItem fr = new MenuItem("français");

        o1.getItems().add(tr);
        o1.getItems().add(fr);
        o1.getItems().add(eng);
        o1.getItems().add(ita);
        o1.getItems().add(swe);
        o1.getItems().add(mod);
        o1.getItems().add(ger);


        f1.setOnAction(e -> saveFile(stage));
        f2.setOnAction(e -> openFile(stage));
        h1.setOnAction(e -> alert7());

        tr.setOnAction(e -> selectLanguage1(stage));
        swe.setOnAction(e -> selectLanguage2(stage));
        ger.setOnAction(e -> selectLanguage3(stage));
        eng.setOnAction(e -> selectLanguage4(stage));
        ita.setOnAction(e -> selectLanguage5(stage));
        mod.setOnAction(e -> selectLanguage6(stage));


        h1.setAccelerator(KeyCombination.keyCombination("Ctrl + A"));
        o1.setAccelerator(KeyCombination.keyCombination("Ctrl + L"));
        f1.setAccelerator(KeyCombination.keyCombination("Ctrl + S"));
        f2.setAccelerator(KeyCombination.keyCombination("Ctrl + O"));
        f3.setAccelerator(KeyCombination.keyCombination("Ctrl + N"));
        f4.setAccelerator(KeyCombination.keyCombination("Ctrl + S"));
        ed1.setAccelerator(KeyCombination.keyCombination("Ctrl + C"));
        ed2.setAccelerator(KeyCombination.keyCombination("Ctrl + P"));

        h.getItems().add(h1);
        o.getItems().add(o1);
        f.getItems().add(f1);
        f.getItems().add(f2);
        f.getItems().add(f3);
        f.getItems().add(f4);
        ed.getItems().add(ed1);
        ed.getItems().add(ed2);


        menuBar.getMenus().add(f);
        menuBar.getMenus().add(o);
        menuBar.getMenus().add(v);
        menuBar.getMenus().add(ed);
        menuBar.getMenus().add(h);


        Scene scene = new Scene(mainLayout, 400, 300);
        stage.setTitle("Dictionnaire");
        stage.setScene(scene);
        stage.show();

    }


    private void alert7() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("À propos de l'application Dictionnaire");
        alert.setHeaderText("Guide de l'utilisateur");
        alert.setContentText(" Après avoir cliqué sur le bouton Traduire, l'utilisateur peut voir les mots traduits dans les 6 autres langues.");
        alert.show();

    }


}

