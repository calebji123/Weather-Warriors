package view;

import interface_adaptor.how_to_play.HowToPlayState;

import javax.swing.*;
import javax.tools.Tool;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class GameView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "game";

    private final JButton exit;

    private final JButton information;

    private final JButton attack;

    private final JButton specialAttack;

    private final JButton swap;

    public GameView() {

        JPanel headerPanel = new JPanel();
        JLabel title = new JLabel("Weather Warriors");

        exit = new JButton("Exit");

        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.X_AXIS));
        headerPanel.add(title);
        headerPanel.add(exit);

        JPanel gamePanel = new JPanel();
        gamePanel.setLayout(new BoxLayout(gamePanel, BoxLayout.X_AXIS));
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));


        JPanel locationPanel = new JPanel();
        locationPanel.setLayout(new BoxLayout(locationPanel, BoxLayout.Y_AXIS));
        JLabel location = new JLabel("Toronto");
        JLabel weather = new JLabel("Sunny, -30 degrees");
        JLabel nextLocation = new JLabel("Next location: Montreal");
        locationPanel.add(location);
        locationPanel.add(weather);
        locationPanel.add(nextLocation);

        JPanel sidebar = new JPanel();
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        information = new JButton("Information");
        attack = new JButton("Attack");
        specialAttack = new JButton("Special Attack");
        swap = new JButton("Swap");
        sidebar.add(information);
        sidebar.add(attack);
        sidebar.add(specialAttack);
        sidebar.add(swap);

        leftPanel.add(locationPanel);
        leftPanel.add(sidebar);

        JPanel playerPanel = new JPanel();
        JLabel playerTempImage = new JLabel("Player Image goes here");
        JLabel playerHealth = new JLabel("10 hp");
        playerPanel.add(playerTempImage);
        playerPanel.add(playerHealth);

        JPanel enemyPanel = new JPanel();
        JLabel enemyTempImage = new JLabel("Enemy Image goes here");
        JLabel enemyHealth = new JLabel("10 hp");
        enemyPanel.add(enemyTempImage);
        enemyPanel.add(enemyHealth);

        centerPanel.add(playerPanel);
        centerPanel.add(enemyPanel);

        JScrollPane log = new JScrollPane();
        log.setPreferredSize(new Dimension(50, 200));
        log.setAlignmentX(Component.LEFT_ALIGNMENT);
        JLabel logLabel = new JLabel("They did this\n then they did that \n then all do this\n then we did that\n");
        log.add(logLabel);

        JPanel deck = new JPanel();
        JLabel deckTempImage = new JLabel("Deck Image goes here");
        JLabel deckLabel = new JLabel("Deck: 10 cards");
        deck.add(deckTempImage);
        deck.add(deckLabel);

        rightPanel.add(log);
        rightPanel.add(deck);

        gamePanel.add(leftPanel);
        gamePanel.add(centerPanel);
        gamePanel.add(rightPanel);


        exit.addActionListener(this);
        information.addActionListener(this);
        attack.addActionListener(this);
        specialAttack.addActionListener(this);
        swap.addActionListener(this);


        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(headerPanel);
        this.add(gamePanel);


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
