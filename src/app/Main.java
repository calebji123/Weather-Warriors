package app;

import data_access.HowToPlayDataAccess;
import interface_adaptor.ViewManagerModel;
import interface_adaptor.how_to_play.HowToPlayViewModel;
import use_case.how_to_play.HowToPlayDataAccessInterface;
import view.GameView;
import view.MenuView;
import view.ViewManager;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        JFrame application = new JFrame("Weather Warriors");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();
        JPanel views = new JPanel(cardLayout);
        application.add(views);

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        HowToPlayViewModel howToPlayViewModel = new HowToPlayViewModel();

        HowToPlayDataAccessInterface dataAccessObject;
        try {
            dataAccessObject = new HowToPlayDataAccess();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        MenuView menuView = MenuViewFactory.create(howToPlayViewModel, dataAccessObject);
        views.add(menuView, menuView.viewName);

        GameView gameView = GameViewFactory.create();
        views.add(gameView, gameView.viewName);

        viewManagerModel.setCurrentView(menuView.viewName);
        viewManagerModel.firePropertyChanged();

        application.setSize(800, 600);
        application.validate();
        application.setVisible(true);
    }
}
