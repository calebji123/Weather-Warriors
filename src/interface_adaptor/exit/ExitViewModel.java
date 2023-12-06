package interface_adaptor.exit;

import interface_adaptor.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ExitViewModel {
    private final String viewName;

    public ExitViewModel() {
        this.viewName = "menu";
    }

    public String getViewName() {
        return viewName;
    }
}
