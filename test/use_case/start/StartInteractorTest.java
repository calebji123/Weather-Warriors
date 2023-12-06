package use_case.start;

import entity.*;
import entity.enemies.TimeTravelingPoacher;
import interface_adaptor.ViewManagerModel;
import interface_adaptor.game.GameState;
import interface_adaptor.game.GameViewModel;
import interface_adaptor.start.StartController;
import interface_adaptor.start.StartPresenter;
import interface_adaptor.start.StartViewModel;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class StartInteractorTest {
    private GameViewModel viewModel;
    private StartPresenter presenter;
    private StartInteractor interactor;
    private StartController controller;
    private ViewManagerModel viewManagerModel;
    @BeforeEach
    void setup(){
        class MockDataAccess implements StartDataAccessInterface{
            private Board board;
            @Override
            public void initializeBoard() {
                Card card1 = new Card("card1", 1, 11, 10);
                Card card2 = new Card("card2", 1, 21, 10);
                Card card3 = new Card("card3", 1, 61, 10);
                Card card4 = new Card("card4", 1, 71, 10);
                Card card5 = new Card("card5", 1, 1, 10);
                List<Card> cardList = new ArrayList<>();
                cardList.add(card1);
                cardList.add(card2);
                cardList.add(card3);
                cardList.add(card4);
                cardList.add(card5);
                Deck deck = new Deck(cardList);
                Opponent villain = new TimeTravelingPoacher();
                Location Boston = new Location("Boston", 94.5, 90.9, 4, 33,"Alton", 1.2, 2.3);
                this.board = new Board(deck, villain, Boston);
            }

            @Override
            public Board getBoard() {
                return this.board;
            }
        }
        viewModel = new GameViewModel();
        viewManagerModel = new ViewManagerModel();
        presenter = new StartPresenter(viewModel, viewManagerModel);
        interactor = new StartInteractor(new MockDataAccess(), presenter);
        controller = new StartController(interactor);
    }

    @Test
    void executeCheckCard(){
        this.controller.execute();
        assertEquals("card1", this.viewModel.getState().getActiveCardName());
    }
    @Test
    void executeCheckWeather(){
        this.controller.execute();
        assertEquals("Boston", this.viewModel.getState().getLocation());
    }
    @Test
    void executeCheckEnemy(){
        this.controller.execute();
        assertEquals(500, this.viewModel.getState().getOpponentCardHealth());
    }

}
