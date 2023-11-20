package use_case.how_to_play;

import interface_adaptor.how_to_play.HowToPlayPresenter;
import interface_adaptor.how_to_play.HowToPlayViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HowToPlayInteractorTest {

    private HowToPlayViewModel viewModel;
    private HowToPlayPresenter presenter;
    private HowToPlayInteractor interactor;



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
    }

    @Test
    void execute() {
        this.interactor.execute("en");
        assertEquals("Hello", viewModel.getState().getMessage());
    }
}