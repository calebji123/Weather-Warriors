package view;

import app.GameViewFactory;
import data_access.BoardDataAccessObject;
import data_access.HowToPlayDataAccess;
import interface_adaptor.ViewManagerModel;
import interface_adaptor.end_turn.EndTurnController;
import interface_adaptor.exit.ExitViewModel;
import interface_adaptor.game.GameViewModel;
import interface_adaptor.how_to_play.HowToPlayViewModel;
import interface_adaptor.swap.SwapViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.how_to_play.HowToPlayDataAccessInterface;

public class GameViewTest {
    private GameView gameView;

    @BeforeEach
    public void setup() {
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
        GameViewModel gameViewModel = new GameViewModel();
        SwapViewModel swapViewModel = new SwapViewModel();
        ExitViewModel exitViewModel = new ExitViewModel();
        HowToPlayViewModel howToPlayViewModel = new HowToPlayViewModel();

        boardDataAccessObject.initializeBoard();
        gameView = GameViewFactory.create(boardDataAccessObject, howToPlayViewModel, howToPlayDataAccessObject, boardDataAccessObject, swapViewModel, boardDataAccessObject, exitViewModel, boardDataAccessObject, viewManagerModel, gameViewModel);
    }

    @Test
    public void testAttack() {
        gameView.attack.doClick();
    }

    @Test
    public void testSpecialAttack() {
        gameView.specialAttack.doClick();
    }

    @Test
    public void testSwap() {
        gameView.swap.doClick();
    }
}

