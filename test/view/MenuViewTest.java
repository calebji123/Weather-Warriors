package view;

import app.MenuViewFactory;
import data_access.BoardDataAccessObject;
import data_access.HowToPlayDataAccess;
import interface_adaptor.ViewManagerModel;
import interface_adaptor.game.GameViewModel;
import interface_adaptor.how_to_play.HowToPlayState;
import interface_adaptor.how_to_play.HowToPlayViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.how_to_play.HowToPlayDataAccessInterface;

import java.awt.event.ActionEvent;

public class MenuViewTest {
    private MenuView menuView;

    @BeforeEach
    public void setUp() {
        HowToPlayViewModel howToPlayViewModel = new HowToPlayViewModel();
        GameViewModel gameViewModel = new GameViewModel();
        HowToPlayDataAccessInterface howToPlayDataAccessObject;
        try {
            howToPlayDataAccessObject = new HowToPlayDataAccess();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        BoardDataAccessObject boardDataAccessObject;
        try {
            boardDataAccessObject = new BoardDataAccessObject();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        menuView = MenuViewFactory.create(howToPlayViewModel, howToPlayDataAccessObject, boardDataAccessObject, viewManagerModel, gameViewModel);
    }

    @Test
    public void testHowToPlay() {
        menuView.howToPlay.doClick();
    }

    @Test
    public void testStart() {
        menuView.start.doClick();
    }
}
