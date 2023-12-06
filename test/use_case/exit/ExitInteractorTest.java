package use_case.exit;

import interface_adaptor.ViewManagerModel;
import interface_adaptor.exit.ExitController;
import interface_adaptor.exit.ExitPresenter;
import interface_adaptor.exit.ExitViewModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;
public class ExitInteractorTest {

    private ViewManagerModel viewManagerModel;
    private ExitInteractor exitInteractor;
    private ExitController exitController;
    private ExitPresenter exitPresenter;
    private ExitViewModel exitViewModel;

    @BeforeEach
    void setup() {
        viewManagerModel = new ViewManagerModel();
        exitViewModel = new ExitViewModel();
        exitPresenter = new ExitPresenter(exitViewModel,viewManagerModel);
        exitInteractor = new ExitInteractor(exitPresenter);
    }

    @Test
    void testViewChanged() {
        exitInteractor.execute();
        assertEquals("menu", viewManagerModel.getCurrentView());
    }
}
