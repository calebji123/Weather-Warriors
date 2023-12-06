package use_case.end_turn;

import entity.*;
import entity.enemies.TimeTravelingPoacher;
import interface_adaptor.end_turn.EndTurnController;
import interface_adaptor.end_turn.EndTurnPresenter;
import interface_adaptor.game.GameViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EndTurnInteractorTest {
    private EndTurnInteractor endTurnInteractor;
    private EndTurnController endTurnController;
    private EndTurnPresenter endTurnPresenter;
    private GameViewModel viewModel;
    private Board board;
    private Deck deck;
    private Card card;
    private Opponent opponent;

    @BeforeEach
    void setup() {
        opponent = new TimeTravelingPoacher();
        card = new Card("Derk", 1, 2, 100);
        List<Card> list = new ArrayList<>();
        list.add(card);
        deck = new Deck(list);
        board = new Board(deck, opponent, new Location("Uoft",0.0,0.0,0,0,
                "UTM", 0.0, 0.0));

        class MockDataAccess implements EndTurnDataAccessInterface {

            @Override
            public Board getBoard() {
                return board;
            }
            @Override
            public void saveToLog(String message) {
                ;
            }

            @Override
            public void addTurn() {
                board.setTurn(board.getTurn() + 1);
            }
        }
        viewModel = new GameViewModel();
        endTurnPresenter = new EndTurnPresenter(viewModel);
        MockDataAccess dataAccess = new MockDataAccess();
        endTurnInteractor = new EndTurnInteractor(endTurnPresenter, dataAccess);
        endTurnController = new EndTurnController(endTurnInteractor);
    }

    @Test
    void executeEndTurn() {
        Integer expectedTurn = board.getTurn() + 1;
        this.endTurnController.execute();
        assertEquals(expectedTurn, board.getTurn());
        assert(!viewModel.getState().getLog().isEmpty());
        assertEquals(viewModel.getState().getActiveCardName(), board.getDeck().getActive().getCardName());
        assertEquals(viewModel.getState().getActiveCardHealth(), board.getDeck().getActive().getHP());
    }
}