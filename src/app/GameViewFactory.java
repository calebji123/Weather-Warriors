package app;

import interface_adaptor.end_turn.EndTurnController;
import interface_adaptor.end_turn.EndTurnViewModel;
import use_case.end_turn.EndTurnDataAccessInterface;
import view.GameView;

public class GameViewFactory {
    public static GameView create(EndTurnViewModel endTurnViewModel, EndTurnDataAccessInterface endTurnDataAccessObject) {
        EndTurnController endTurnController = EndTurnUseCaseFactory.createEndTurnUseCase(endTurnViewModel, endTurnDataAccessObject);
        return new GameView(endTurnController, endTurnViewModel);
    }
}
