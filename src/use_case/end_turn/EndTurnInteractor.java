package use_case.end_turn;

public class EndTurnInteractor implements EndTurnInputBoundary {
    private final EndTurnOutputBoundary endTurnOutputBoundary;

    public EndTurnInteractor(EndTurnOutputBoundary endTurnOutputBoundary) {
        this.endTurnOutputBoundary = endTurnOutputBoundary;
    }

    @Override
    public void execute() {
        //TODO implement after more information on entities gets released
    }
}
