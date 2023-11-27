package use_case.swap;

public interface SwapOutputBoundary {
    void prepareSuccessView(SwapOutputData data);
    void prepareFailView(String error);
}
