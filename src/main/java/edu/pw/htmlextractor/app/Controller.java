package edu.pw.htmlextractor.app;

import edu.pw.htmlextractor.dom.HtmlDom;
import edu.pw.htmlextractor.parser.Parser;
import edu.pw.htmlextractor.parser.ParsingException;
import javafx.beans.InvalidationListener;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.stage.Stage;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.Optional;

public class Controller implements Observer {
    private static final String WINDOW_TITLE = "HTMLExtractor";

    private Stage stage;
    private StringProperty content;
    private HtmlDom htmlDom;
    private Filter filter;

    public Controller(Stage stage) {
        this.stage = stage;
        content = new SimpleStringProperty();
        filter = new Filter();
        filter.addObserver(this);
        stage.setTitle(WINDOW_TITLE);
        stage.setScene(new MainScene(this).getScene());
    }

    public void setOnContentChanged(InvalidationListener listener) {
        content.addListener(listener);
    }

    public Filter getFilter() {
        return filter;
    }

    public void loadFile(File file) {
        setWindowTitle(file.getAbsolutePath());
        htmlDom = null;
        try {
            htmlDom = Parser.parse(new FileInputStream(file));
            displayContent(htmlDom.toString(filter));
        } catch (IOException e) {
            displayContent("Cannot open file '" + file.getPath() + "'");
        } catch (ParsingException e) {
            displayContent(e.getMessage());
        }
    }

    public void loadWebsite(String url) {
        setWindowTitle(url);
        htmlDom = null;
        try {
            htmlDom = Parser.parse(new URL(url).openStream());
            displayContent(htmlDom.toString(filter));
        } catch (MalformedURLException e){
            displayContent("Cannot open website '" + url + "': missing protocol");
        } catch (IOException e) {
            displayContent("Cannot open website '" + url + "'");
        } catch (ParsingException e) {
            displayContent(e.getMessage());
        }
    }

    private void setWindowTitle(String title) {
        stage.setTitle(WINDOW_TITLE + " [" + title + "]");
    }

    private void displayContent(String content) {
        this.content.set(content);
    }

    @Override
    public void update(Observable o, Object arg) {
        Optional.ofNullable(htmlDom).ifPresent(dom -> displayContent(dom.toString(filter)));
    }
}
