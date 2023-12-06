package app;

import interface_adaptor.end_turn.EndTurnController;
import interface_adaptor.end_turn.EndTurnPresenter;
import interface_adaptor.game.GameViewModel;
import use_case.end_turn.EndTurnDataAccessInterface;
import use_case.end_turn.EndTurnInputBoundary;
import use_case.end_turn.EndTurnInteractor;
import use_case.end_turn.EndTurnOutputBoundary;

public class EndTurnUseCaseFactory {

    public static EndTurnController createEndTurnUseCase( EndTurnDataAccessInterface dataAccessObject, GameViewModel gameViewModel) {
        EndTurnOutputBoundary endTurnOutputBoundary = new EndTurnPresenter(gameViewModel);
        EndTurnInputBoundary endTurnInteractor = new EndTurnInteractor( endTurnOutputBoundary, dataAccessObject);
        return new EndTurnController(endTurnInteractor);
    }
}
