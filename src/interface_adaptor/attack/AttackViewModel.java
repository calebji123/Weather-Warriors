package interface_adaptor.attack;

import interface_adaptor.ViewModel;

import java.beans.PropertyChangeListener;

public class AttackViewModel extends ViewModel {
    public AttackViewModel(String viewName) {
        super(viewName);
    }

    @Override
    public void firePropertyChanged() {

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }
}
