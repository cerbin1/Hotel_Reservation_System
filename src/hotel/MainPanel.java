package hotel;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainPanel extends Application {
    private Scene addingGuest;
    private Scene main;
    private TableView table;

    private Scene tableOfGuests = new Scene(new Group());

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);

        Button addGuestButton = new Button("Add a guest");
        addGuestButton.setOnAction(event -> changeSceneToAddGuest(primaryStage));
        vBox.getChildren().add(addGuestButton);

        createGuestsTable();
        Button showClients = new Button("Show clients");
        showClients.setOnAction(event -> {
            primaryStage.setScene(tableOfGuests);
        });
        vBox.getChildren().add(showClients);

        main = new Scene(vBox, 500, 500);

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));
        addingGuest = new Scene(gridPane, 500, 500);

        gridPane.add(new Label("Name"), 0, 0);
        TextField name = new TextField();
        gridPane.add(name, 1, 0);

        gridPane.add(new Label("Surname"), 0, 1);
        TextField surname = new TextField();
        gridPane.add(surname, 1, 1);

        gridPane.add(new Label("Date of Birth"), 0, 2);
        TextField birthDate = new TextField();
        gridPane.add(birthDate, 1, 2);

        gridPane.add(new Label("Country"), 0, 3);
        TextField country = new TextField();
        gridPane.add(country, 1, 3);

        gridPane.add(new Label("City"), 0, 4);
        TextField city = new TextField();
        gridPane.add(city, 1, 4);

        gridPane.add(new Label("Address"), 0, 5);
        TextField address = new TextField();
        gridPane.add(address, 1, 5);

        gridPane.add(new Label("Zip-code"), 0, 6);
        TextField zipCode = new TextField();
        gridPane.add(zipCode, 1, 6);

        gridPane.add(new Label("Arrival"), 0, 7);
        DatePicker arrival = new DatePicker();
        gridPane.add(arrival, 1, 7);

        gridPane.add(new Label("Departure"), 0, 8);
        DatePicker departure = new DatePicker();
        gridPane.add(departure, 1, 8);

        Button addGuest = new Button("Add guest");
        gridPane.add(addGuest, 0, 10);

        Button setMainScene = new Button("Back");
        setMainScene.setOnAction(event -> changeSceneToMain(primaryStage));
        gridPane.add(setMainScene, 0, 11);


        primaryStage.setTitle("Hotel Reservation System");
        primaryStage.setScene(main);
        primaryStage.show();
    }

    private void createGuestsTable() {
        table = new TableView();
        table.setEditable(false);

        TableColumn name = new TableColumn("Name");
        TableColumn surname = new TableColumn("Name");
        TableColumn age = new TableColumn("Name");
        table.getColumns().addAll(name, surname, age);

        VBox vbox = new VBox();
        vbox.getChildren().add(table);
        ((Group) tableOfGuests.getRoot()).getChildren().add(vbox);
    }


    private void changeSceneToAddGuest(Stage primaryStage) {
        primaryStage.setScene(addingGuest);
    }

    private void changeSceneToMain(Stage primaryStage) {
        primaryStage.setScene(main);
    }

    public static void main(String[] args) {
        launch();
    }
}
