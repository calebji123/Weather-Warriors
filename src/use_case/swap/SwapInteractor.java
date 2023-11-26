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
        if (dataAccessObject.nextCardExists()) {
            Card nextCard = dataAccessObject.getNextCard();
            activeCard.swapped();
            nextCard.activate();
            nextCard.notNext();
        }

    }
}
