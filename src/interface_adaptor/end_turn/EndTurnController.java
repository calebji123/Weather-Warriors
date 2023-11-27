package interface_adaptor.end_turn;

import use_case.end_turn.EndTurnDataAccessInterface;
import use_case.end_turn.EndTurnInputBoundary;

public class EndTurnController {
    final EndTurnInputBoundary endTurnInteractor;

    public EndTurnController(EndTurnInputBoundary endTurnInteractor) {
        this.endTurnInteractor = endTurnInteractor;
    }

    public void execute() {
        endTurnInteractor.execute();
    }
}
