package interface_adaptor.start;

import use_case.start.StartOutputData;

public class StartPresenter {
    private final  StartViewModel viewModel;
    public StartPresenter(StartViewModel viewModel){
        this.viewModel = viewModel;
    }

    public void prepareSuccessView(StartOutputData outputData){

    }


}
