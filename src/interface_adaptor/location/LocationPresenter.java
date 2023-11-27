package interface_adaptor.location;

import use_case.location.LocationOutputBoundary;
import use_case.location.LocationOutputData;

public class LocationPresenter implements LocationOutputBoundary {
    private final LocationViewModel locationViewModel;

    public LocationPresenter(LocationViewModel locationViewModel) {
        this.locationViewModel = locationViewModel;
    }

    public LocationViewModel prepareView(LocationOutputData locationOutputData) {
        LocationState locationState = locationViewModel.getState();
        //TODO
    }
}
