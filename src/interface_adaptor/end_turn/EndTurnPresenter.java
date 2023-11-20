package interface_adaptor.end_turn;

import use_case.end_turn.EndTurnOutputBoundary;
import use_case.end_turn.EndTurnOutputData;

public class EndTurnPresenter implements EndTurnOutputBoundary {
    private final EndTurnViewModel viewModel;

    public EndTurnPresenter(EndTurnViewModel viewModel) {
        this.viewModel = viewModel;
    }

    public void prepareSuccessView(EndTurnOutputData outputData) {

    }
}
