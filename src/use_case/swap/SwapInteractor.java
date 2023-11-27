package use_case.swap;

import entity.Card;
import entity.Deck;

public class SwapInteractor implements SwapInputBoundary{
final SwapDataAccessInterface dataAccessObject;
final SwapOutputBoundary swapPresenter;

    public SwapInteractor(SwapDataAccessInterface dataAccessObject, SwapOutputBoundary swapPresenter) {
        this.dataAccessObject = dataAccessObject;
        this.swapPresenter = swapPresenter;
    }

    @Override
    public void execute(SwapInputData data) {
        if (!dataAccessObject.nextCardExists()) {
            swapPresenter.prepareFailView("There are no more cards in your deck!");
        }
        else {
            Deck deck = dataAccessObject.getDeck();
            deck.shuffle();
            Card activeCard = dataAccessObject.getActiveCard();
            Card nextCard = dataAccessObject.getNextCard();

            String message = "Swapped to " + activeCard.getCardName() + "!";
            dataAccessObject.saveToLog(message);
            SwapOutputData swapOutputData = new SwapOutputData(message, activeCard.getCardName(), activeCard.getHP(), nextCard.getCardName());
            swapPresenter.prepareSuccessView(swapOutputData);
        }

    }
}
