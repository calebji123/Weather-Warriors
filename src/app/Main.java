package app;

import data_access.BoardDataAccessObject;
import data_access.HowToPlayDataAccess;
import interface_adaptor.ViewManagerModel;
import interface_adaptor.exit.ExitViewModel;
import interface_adaptor.game.GameViewModel;
import interface_adaptor.how_to_play.HowToPlayViewModel;
import interface_adaptor.swap.SwapViewModel;
import org.json.simple.parser.ParseException;
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

        HowToPlayDataAccessInterface howToPlayDataAccessObject;
        try {
            howToPlayDataAccessObject = new HowToPlayDataAccess();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        BoardDataAccessObject boardDataAccessObject;
        try {
            boardDataAccessObject = new BoardDataAccessObject();
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }

        GameViewModel gameViewModel = new GameViewModel();
        SwapViewModel swapViewModel = new SwapViewModel();
        ExitViewModel exitViewModel = new ExitViewModel();

        MenuView menuView = MenuViewFactory.create(howToPlayViewModel, howToPlayDataAccessObject, boardDataAccessObject, viewManagerModel, gameViewModel);
        views.add(menuView, menuView.viewName);

        GameView gameView = GameViewFactory.create(boardDataAccessObject, howToPlayViewModel, howToPlayDataAccessObject, boardDataAccessObject, swapViewModel, boardDataAccessObject, exitViewModel, boardDataAccessObject, viewManagerModel, gameViewModel);
        views.add(gameView, gameView.viewName);

        viewManagerModel.setCurrentView(menuView.viewName);
        viewManagerModel.firePropertyChanged();

        application.setSize(800, 600);
        application.validate();
        application.setVisible(true);
    }
}
