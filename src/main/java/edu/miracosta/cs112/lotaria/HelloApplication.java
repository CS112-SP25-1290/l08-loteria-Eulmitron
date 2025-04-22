package edu.miracosta.cs112.lotaria;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    private static final LoteriaCard[] LOTERIA_CARDS = {
            new LoteriaCard("Las matematicas", "1.png", 1),
            new LoteriaCard("Las ciencias", "2.png", 2),
            new LoteriaCard("La Tecnología", "8.png", 8),
            new LoteriaCard("La ingeniería", "9.png", 9),
    };

    //Class-Level Variables
    private Label messageLabel, titleLabel;
    private ImageView cardImageView;
    private Button drawCardButton;
    private ProgressBar gameProgressBar;

    @Override
    public void start(Stage stage) throws Exception {
        //Instantiate Components
        titleLabel = new Label("Welcome to EChALE STEM Loteria!");
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 16));

        cardImageView = new ImageView();
        cardImageView.setImage(LOTERIA_CARDS[0].getImage());
        cardImageView.setFitWidth(200);
        cardImageView.setPreserveRatio(true);

        messageLabel = new Label("Click the button to randomly draw a card.");
        messageLabel.setWrapText(true);

        drawCardButton = new Button("Draw Card");

        gameProgressBar = new ProgressBar(0.0);
        gameProgressBar.setPrefWidth(300);


        VBox mainLayout = new VBox(15); // 15px spacing
        mainLayout.setPadding(new Insets(20));
        mainLayout.setAlignment(Pos.CENTER);
        mainLayout.getChildren().addAll(titleLabel, cardImageView, messageLabel, drawCardButton, gameProgressBar);


        drawCardButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                int randomIndex = (int) (Math.random() * LOTERIA_CARDS.length);
                LoteriaCard randomCard = LOTERIA_CARDS[randomIndex];


                cardImageView.setImage(randomCard.getImage());


                messageLabel.setText("Drew card: " + randomCard.getCardName());
            }
        });

        // Setup Scene and Stage
        Scene scene = new Scene(mainLayout, 350, 500);
        stage.setTitle("EChALE STEM Loteria");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}