package interface_adaptor.swap;

public class SwapState {
    private Boolean hasError;
    private String swapError;

    public SwapState(){}

    public void setSwapError(String error) {this.swapError = error;}
    public String getSwapError() {return this.swapError;}
    public Boolean hasError() {return this.hasError;}
    public void setHasError(Boolean hasError) {this.hasError = hasError;}
}
