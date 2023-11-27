package use_case.swap;

import entity.Card;

public class SwapInteractor implements SwapInputBoundary{
final SwapDataAccessObject dataAccessObject;
final SwapOutputBoundary swapPresenter;

    public SwapInteractor(SwapDataAccessObject dataAccessObject, SwapOutputBoundary swapPresenter) {
        this.dataAccessObject = dataAccessObject;
        this.swapPresenter = swapPresenter;
    }

    @Override
    public void execute(SwapInputData data) {
        String activeCardName = data.getActiveCardName();
        Card activeCard = dataAccessObject.getCard(activeCardName);
        if (!dataAccessObject.nextCardExists()) {
            swapPresenter.prepareFailView("There are no more cards in your deck!");
        }
        else {
            //If there are still cards in the deck we deactivate the current, and activate the next.
            Card nextCard = dataAccessObject.getNextCard();
            activeCard.deactivate();
            nextCard.activate();

            String message = "Swapped to " + nextCard.getCardName() + "!";
            SwapOutputData swapOutputData = new SwapOutputData(message, nextCard.getCardName(), nextCard.getHP());
            swapPresenter.prepareSuccessView(swapOutputData);
        }

    }
}
