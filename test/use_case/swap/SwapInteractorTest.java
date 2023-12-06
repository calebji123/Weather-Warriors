package use_case.swap;

import entity.*;
import entity.enemies.TimeTravelingPoacher;
import interface_adaptor.game.GameViewModel;
import interface_adaptor.swap.SwapController;
import interface_adaptor.swap.SwapPresenter;
import interface_adaptor.swap.SwapViewModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;


public class SwapInteractorTest {
    private SwapInteractor swapInteractor;
    private SwapController swapController;
    private SwapPresenter swapPresenter;
    private GameViewModel gameViewModel;
    private SwapViewModel swapViewModel;
    private Board board;
    private Deck deck;
    private Card card1;
    private Card card2;
    private Opponent opponent;

    @BeforeEach
    void setUp() {
        opponent = new TimeTravelingPoacher();
        card1 = new Card("Derk1", 1, 2, 100);
        card2 = new Card("Derk2", 1, 2, 100);
        List<Card> list = new ArrayList<>();
        list.add(card1);
        list.add(card2);
        deck = new Deck(list);
        board = new Board(deck, opponent, new Location("Uoft", 0.0, 0.0, 0, 0,
                "UTM", 0.0, 0.0));

        class MockDataAccess implements SwapDataAccessInterface {
            @Override
            public Card getNextCard() {
                return board.getDeck().getNext();
            }

            @Override
            public Boolean nextCardExists() {
                return board.getDeck().hasNext();
            }

            @Override
            public Card getActiveCard() {
                return board.getDeck().getActive();
            }

            @Override
            public Deck getDeck() {
                return deck;
            }

            @Override
            public void saveToLog(String message) {
                ;
            }

        }
        gameViewModel = new GameViewModel();
        swapViewModel = new SwapViewModel();
        swapPresenter = new SwapPresenter(gameViewModel, swapViewModel);
        MockDataAccess dataAccess = new MockDataAccess();
        swapInteractor = new SwapInteractor(dataAccess, swapPresenter);
        swapController = new SwapController(swapInteractor);
    }

    @Test
    void execute() {
        gameViewModel.getState().setActiveCardName(card1.getCardName());
        gameViewModel.getState().setNextCardName(card2.getCardName());
        swapController.execute();
        assertEquals(card2.getCardName(), gameViewModel.getState().getActiveCardName());
        assertEquals(card2, deck.getActive());
        assertEquals(card1, deck.getNext());
    }

    @Test
    void testOneCardLeft() {
        gameViewModel.getState().setActiveCardName(deck.getActive().getCardName());
        gameViewModel.getState().setNextCardName(deck.getNext().getCardName());
        deck.activeDeath();
        gameViewModel.getState().setActiveCardName(deck.getActive().getCardName());
        assertEquals(card2.getCardName(), gameViewModel.getState().getActiveCardName());
        swapController.execute();
        assertEquals("There are no more cards in your deck!",swapViewModel.getState().getSwapError());
        assert swapViewModel.getState().hasError();
    }

    @Test
    void testLog() {
        gameViewModel.getState().setActiveCardName(deck.getActive().getCardName());
        gameViewModel.getState().setNextCardName(deck.getNext().getCardName());
        swapController.execute();
        assertEquals("\r\nSwapped to Derk2!", gameViewModel.getState().getLog());
    }
}

