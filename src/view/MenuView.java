package view;

import interface_adaptor.how_to_play.HowToPlayController;
import interface_adaptor.how_to_play.HowToPlayState;
import interface_adaptor.how_to_play.HowToPlayViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MenuView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "menu";

    private final HowToPlayViewModel howToPlayViewModel;

    private final HowToPlayController howToPlayController;

    private final JButton howToPlay;

    private final JButton howToPlayFrench;

    private final JButton start;

    public MenuView(HowToPlayController howToPlayController, HowToPlayViewModel howToPlayViewModel) {
        this.howToPlayController = howToPlayController;
        this.howToPlayViewModel = howToPlayViewModel;
        howToPlayViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel("Menu Screen");
        title.setAlignmentX(0.5f);

        JPanel buttons = new JPanel();
        howToPlay = new JButton(HowToPlayViewModel.BUTTON_LABEL);
        buttons.add(howToPlay);
        howToPlayFrench = new JButton("Comment jouer");
        buttons.add(howToPlayFrench);
        start = new JButton("Start");
        buttons.add(start);

        howToPlay.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource().equals(howToPlay)) {
                        howToPlayController.execute("en");

                        JOptionPane.showMessageDialog(null, howToPlayViewModel.getState().getMessage());
                    }
                }
            }
        );

        howToPlayFrench.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource().equals(howToPlayFrench)) {
                        howToPlayController.execute("FR");

                        JOptionPane.showMessageDialog(null, howToPlayViewModel.getState().getMessage());
                    }
                }
            }
        );
        start.addActionListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(buttons);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showConfirmDialog(this, "Cancel not implemented yet.");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        HowToPlayState howToPlayState = (HowToPlayState) evt.getNewValue();
    }
}
