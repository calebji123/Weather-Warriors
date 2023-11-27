package interface_adaptor.location;

import interface_adaptor.ViewModel;

import java.beans.PropertyChangeSupport;

public class LocationViewModel extends ViewModel {
    private LocationState locationState;

    public LocationViewModel() {
        super("location");
    }

    public LocationState getState() {
        return locationState;
    }

    public void setState(LocationState locationState) {
        this.locationState = locationState;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("locationState", null, this.locationState);
    }

    @Override
    public void addPropertyChangeListener(java.beans.PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

}
