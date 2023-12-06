package view;

import interface_adaptor.how_to_play.HowToPlayController;
import interface_adaptor.how_to_play.HowToPlayState;
import interface_adaptor.how_to_play.HowToPlayViewModel;
import interface_adaptor.start.StartController;
import interface_adaptor.start.StartViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MenuView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "menu";
    private final HowToPlayViewModel howToPlayViewModel;
    private final HowToPlayController howToPlayController;
    private final StartController startController;
    final JButton howToPlay;
    private final JButton howToPlayFrench;
    final JButton start;

    public MenuView(HowToPlayController howToPlayController, HowToPlayViewModel howToPlayViewModel, StartController startController) {
        this.howToPlayController = howToPlayController;
        this.howToPlayViewModel = howToPlayViewModel;
        this.startController = startController;
        howToPlayViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel("Weather Warriors");
        title.setFont(title.getFont().deriveFont(32.0f));
        title.setAlignmentX(0.5f);
        title.setBorder(BorderFactory.createEmptyBorder(30, 10, 50, 10));

        JPanel buttons = new JPanel();
        buttons.setLayout(new BoxLayout(buttons, BoxLayout.Y_AXIS));
        howToPlay = new JButton(HowToPlayViewModel.BUTTON_LABEL);
        howToPlay.setAlignmentX(0.5f);
        buttons.add(howToPlay);
        howToPlayFrench = new JButton("Comment jouer");
        howToPlayFrench.setAlignmentX(0.5f);
        buttons.add(howToPlayFrench);
        start = new JButton("Start");
        start.setAlignmentX(0.5f);
        buttons.add(start);
        buttons.setAlignmentX(0.5f);

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
        start.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource().equals(start)) {
                        startController.execute();
                    }
                }
            }
        );

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(buttons);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
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
