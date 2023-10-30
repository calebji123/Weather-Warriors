package interface_adaptor;

import java.beans.PropertyChangeSupport;

public class ViewManagerModel {
    private String activeViewName;

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange("view", null, this.activeViewName);
    }

    public void addPropertyChangeListener(java.beans.PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public String getCurrentView() {
        return activeViewName;
    }

    public void setCurrentView(String activeViewName) {
        this.activeViewName = activeViewName;
    }
}
