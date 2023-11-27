package use_case.how_to_play;

import interface_adaptor.how_to_play.HowToPlayController;
import interface_adaptor.how_to_play.HowToPlayPresenter;
import interface_adaptor.how_to_play.HowToPlayViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HowToPlayInteractorTest {

    private HowToPlayViewModel viewModel;
    private HowToPlayPresenter presenter;
    private HowToPlayInteractor interactor;
    private HowToPlayController controller;


    @BeforeEach
    void setUp() {
        class MockDataAccess implements HowToPlayDataAccessInterface {
            @Override
            public String getHowToPlay() {
                return "Hello";
            }
        }
        viewModel = new HowToPlayViewModel();
        presenter = new HowToPlayPresenter(viewModel);
        MockDataAccess dataAccess = new MockDataAccess();
        interactor = new HowToPlayInteractor(dataAccess, presenter);
        controller = new HowToPlayController(interactor);
    }

    @Test
    void execute() {
        this.controller.execute("EN");
        assertEquals("Hello", viewModel.getState().getMessage());
    }

    @Test
    void executeWithLang() {
        this.controller.execute("FR");
        assertEquals("Bonjour", viewModel.getState().getMessage());
    }
}