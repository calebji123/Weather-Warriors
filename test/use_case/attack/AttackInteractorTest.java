package use_case.attack;

import entity.*;
import entity.enemies.TimeTravelingPoacher;
import interface_adaptor.attack.AttackController;
import interface_adaptor.attack.AttackPresenter;
import interface_adaptor.game.GameViewModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class AttackInteractorTest {
    private AttackInteractor attackInteractor;
    private AttackController attackController;
    private AttackPresenter attackPresenter;
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
                "UTM"));

        class MockDataAccess implements AttackDataAccessInterface {

            @Override
            public Board getBoard() {
                return board;
            }
            @Override
            public void saveToLog(String message) {
                ;
            }
        }
        viewModel = new GameViewModel();
        attackPresenter = new AttackPresenter(viewModel);
        MockDataAccess dataAccess = new MockDataAccess();
        attackInteractor = new AttackInteractor(dataAccess, attackPresenter);
        attackController = new AttackController(attackInteractor);
    }

    @Test
    void executeNormalAttack() {
        Integer expectedHP = opponent.getHP() - card.getRegularAttack().getDmg();
        this.attackController.execute(0);
        assertEquals(expectedHP, viewModel.getState().getOpponentCardHealth());
        assertEquals("\r\nDerk attacked Boss! Boss took 1 damage!", viewModel.getState().getLog());
        viewModel.getState().setLog(null);
    }
    @Test
    void executeSpecialAttack() {
        Integer expectedHP = opponent.getHP() - card.getSpecialAttack().getDmg();
        this.attackController.execute(1);
        assertEquals(expectedHP, viewModel.getState().getOpponentCardHealth());
        assertEquals("\r\nDerk attacked Boss! Boss took 1 damage!", viewModel.getState().getLog());
        viewModel.getState().setLog(null);
    }
}
