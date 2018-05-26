package edu.pw.htmlextractor.app;

import com.google.common.collect.ImmutableSet;
import edu.pw.htmlextractor.app.Controller;
import javafx.beans.property.StringProperty;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.util.Pair;
import org.fxmisc.flowless.VirtualizedScrollPane;
import org.fxmisc.richtext.CodeArea;
import org.fxmisc.richtext.LineNumberFactory;

import java.io.File;
import java.util.*;

public class MainScene {
    private Scene scene;

    public MainScene(Controller controller) {
        // set up layout
        VBox root = new VBox(0);
        scene = new Scene(root, 800, 600);

        Menu loadMenu = new Menu("Load");
        MenuItem fileMenuItem = new MenuItem("From file");
        MenuItem webMenuItem = new MenuItem("From web");
        loadMenu.getItems().addAll(fileMenuItem, webMenuItem);

        Menu filterMenu = new Menu("Filter");
        RadioMenuItem enableFilterItem = new RadioMenuItem("Enabled");
        enableFilterItem.setSelected(false);
        MenuItem editFilterItem = new MenuItem("Edit");
        filterMenu.getItems().addAll(enableFilterItem, editFilterItem);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(loadMenu, filterMenu);

        CodeArea codeArea = new CodeArea();
        codeArea.setParagraphGraphicFactory(LineNumberFactory.get(codeArea));
        codeArea.setEditable(false);
        VirtualizedScrollPane scrollPane = new VirtualizedScrollPane<>(codeArea);
        VBox.setVgrow(scrollPane, Priority.ALWAYS);
        codeArea.setStyle("-fx-background-color: #eeeeee");

        root.getChildren().addAll(menuBar, scrollPane);

        // dialog windows
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Load file");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.dir")));
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("HTML Sources", "*.html"));

        TextInputDialog urlChooser = new TextInputDialog();
        urlChooser.setHeaderText(null);
        urlChooser.setGraphic(null);
        urlChooser.setTitle("Load website");
        urlChooser.setContentText("Enter valid URL:");
        urlChooser.getEditor().setPrefWidth(400);

        Dialog<Pair<ImmutableSet<String>, ImmutableSet<String>>> filterSettings = new Dialog<>();
        filterSettings.setHeaderText(null);
        filterSettings.setGraphic(null);
        filterSettings.setTitle("Edit filter settings");
        filterSettings.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        TextField tagsField = new TextField();
        tagsField.setPrefWidth(400);
        TextField attributesField = new TextField();
        attributesField.setPrefWidth(400);
        grid.add(new Label("Selected tags (separated by spaces):"), 0, 0);
        grid.add(tagsField, 1, 0);
        grid.add(new Label("Selected attributes (separated by spaces):"), 0, 1);
        grid.add(attributesField, 1, 1);
        filterSettings.getDialogPane().setContent(grid);
        filterSettings.setResultConverter(button -> {
            return button.equals(ButtonType.OK)
                ? new Pair<>(ImmutableSet.of(tagsField.getText().split("\\s+")), ImmutableSet.of(attributesField.getText().split("\\s+")))
                : null;
        });

        // events
        controller.setOnContentChanged(content ->
            codeArea.replaceText(((StringProperty) content).getValue())
        );

        fileMenuItem.setOnAction(event ->
            Optional.ofNullable(fileChooser.showOpenDialog(scene.getWindow())).ifPresent(controller::loadFile)
        );

        webMenuItem.setOnAction(event -> {
            urlChooser.getEditor().setPromptText("http://www.website.com");
            urlChooser.showAndWait().ifPresent(controller::loadWebsite);
        });

        enableFilterItem.setOnAction(event ->
            controller.getFilter().setEnabled(((RadioMenuItem) event.getSource()).isSelected())
        );

        editFilterItem.setOnAction(event -> {
            tagsField.setText(String.join(" ", controller.getFilter().getTags()));
            attributesField.setText(String.join(" ", controller.getFilter().getAttributes()));
            filterSettings.showAndWait().ifPresent(filter ->
                controller.getFilter().setFilterData(filter.getKey(), filter.getValue())
            );
        });
    }

    public Scene getScene() {
        return scene;
    }
}
