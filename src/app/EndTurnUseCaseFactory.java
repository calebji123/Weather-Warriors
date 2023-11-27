package app;

import interface_adaptor.end_turn.EndTurnController;
import interface_adaptor.end_turn.EndTurnPresenter;
import interface_adaptor.end_turn.EndTurnViewModel;
import use_case.end_turn.EndTurnDataAccessInterface;
import use_case.end_turn.EndTurnInputBoundary;
import use_case.end_turn.EndTurnInteractor;
import use_case.end_turn.EndTurnOutputBoundary;

public class EndTurnUseCaseFactory {

    public static EndTurnController createEndTurnUseCase(EndTurnViewModel viewModel, EndTurnDataAccessInterface dataAccessObject) {
        EndTurnOutputBoundary endTurnOutputBoundary = new EndTurnPresenter(viewModel);
        EndTurnInputBoundary endTurnInteractor = new EndTurnInteractor( endTurnOutputBoundary, dataAccessObject);
        return new EndTurnController(endTurnInteractor);
    }
}
