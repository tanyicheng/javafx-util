package com.example;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class StickyNotesApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        StackPane notedPane = new StackPane();
        notedPane.setPrefSize(20, 20);
        notedPane.setMaxSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);
        notedPane.setStyle("-fx-background-color: purple;");

        StackPane rootPane = new StackPane(notedPane);
        rootPane.setPrefSize(400, 400);
        StackPane.setAlignment(notedPane, Pos.BOTTOM_CENTER);

        stage.setScene(new Scene(rootPane));
        stage.show();

        Stage stickyNotesStage = new Stage();
        stickyNotesStage.initOwner(stage);
        stickyNotesStage.initStyle(StageStyle.UNDECORATED);
        StackPane stickyNotesPane = new StackPane();
        stickyNotesPane.setPrefSize(200, 200);
        stickyNotesPane.setStyle("-fx-background-color: yellow;");
        stickyNotesStage.setScene(new Scene(stickyNotesPane));


        notedPane.hoverProperty().addListener((ChangeListener<Boolean>) (observable, oldValue, newValue) -> {
            if (newValue) {
                stickyNotesStage.show();
            } else {
                stickyNotesStage.hide();
            }
        });


        Tooltip.install(notedPane, new Tooltip("鼠标悬浮显示的文字"));
    }
}