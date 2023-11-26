package interface_adaptor.start;

import use_case.start.StartInputBoundary;


public class StartController {
    final StartInputBoundary userStartUseCaseInteractor;
    public StartController(StartInputBoundary userStartUseCaseInteractor){
        this.userStartUseCaseInteractor = userStartUseCaseInteractor;
    }
    public void execute(){
        userStartUseCaseInteractor.execute();
    }
}
