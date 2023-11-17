package view;

import interface_adaptor.how_to_play.HowToPlayState;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "game";

    private final JButton exit;

    private final JButton information;

    private final JButton attack;

    private final JButton specialAttack;

    private final JButton swap;

    public GameView() {

        // Header
        JPanel headerPanel = new JPanel();
        JLabel title = new JLabel("Weather Warriors");
        exit = new JButton("Exit");

        headerPanel.setLayout(new GridBagLayout());
        headerPanel.add(title);
        headerPanel.add(exit);

        // Left Panel
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BorderLayout());
        leftPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JPanel locationPanel = new JPanel();
        locationPanel.setLayout(new BoxLayout(locationPanel, BoxLayout.Y_AXIS));
        JLabel locationLabel = new JLabel("Location and Weather:");
        JLabel location = new JLabel("Toronto");
        JLabel weather = new JLabel("Sunny, -30 degrees");
        JLabel nextLocation = new JLabel("Next location: Montreal");
        locationPanel.add(locationLabel);
        locationPanel.add(location);
        locationPanel.add(weather);
        locationPanel.add(nextLocation);

        JPanel sidebar = new JPanel();
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        sidebar.setBorder(new EmptyBorder(50, 10, 10, 10));
        information = new JButton("Information");
        attack = new JButton("Attack");
        specialAttack = new JButton("Special Attack");
        swap = new JButton("Swap");
        sidebar.add(information);
        sidebar.add(attack);
        sidebar.add(specialAttack);
        sidebar.add(swap);

        leftPanel.add(locationPanel, BorderLayout.NORTH);
        leftPanel.add(sidebar, BorderLayout.SOUTH);

        // Center Panel
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        centerPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JPanel playerPanel = new JPanel();
        playerPanel.setLayout(new BoxLayout(playerPanel, BoxLayout.Y_AXIS));
        JLabel playerPictureLabel;
        try {
            BufferedImage playerPicture = ImageIO.read(new File("assets/capybara.jpg"));
            playerPictureLabel = new JLabel(new ImageIcon(playerPicture
                    .getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
        } catch (IOException e) {
            playerPictureLabel = new JLabel("Player Image could not load");
        }
        playerPictureLabel.setAlignmentX(0.5f);
        JLabel playerName = new JLabel("Capybara");
        playerName.setAlignmentX(0.5f);
        JLabel playerHealth = new JLabel("10 hp");
        playerHealth.setAlignmentX(0.5f);
        playerPanel.add(playerName);
        playerPanel.add(playerPictureLabel);
        playerPanel.add(playerHealth);

        JPanel enemyPanel = new JPanel();
        enemyPanel.setLayout(new BoxLayout(enemyPanel, BoxLayout.Y_AXIS));
        JLabel enemyPictureLabel;
        try {
            BufferedImage enemyPicture = ImageIO.read(new File("assets/capybara.jpg"));
            enemyPictureLabel = new JLabel(new ImageIcon(enemyPicture
                    .getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
        } catch (IOException e) {
            enemyPictureLabel = new JLabel("Player Image could not load");
        }
        enemyPictureLabel.setAlignmentX(0.5f);
        JLabel enemyName = new JLabel("Capybara Boss");
        enemyName.setAlignmentX(0.5f);
        JLabel enemyHealth = new JLabel("10 hp");
        enemyHealth.setAlignmentX(0.5f);
        enemyPanel.add(enemyName);
        enemyPanel.add(enemyPictureLabel);
        enemyPanel.add(enemyHealth);

        centerPanel.add(enemyPanel, BorderLayout.NORTH);
        centerPanel.add(playerPanel, BorderLayout.SOUTH);

        // Right Panel
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BorderLayout());
        rightPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        rightPanel.setPreferredSize(new Dimension(200, 600));

        JPanel log = new JPanel();
        log.setAlignmentX(Component.LEFT_ALIGNMENT);
        JTextArea logText = new JTextArea("They did this\n" +
                "Then they did this sadfasdfasdfasdf\n" +
                "Then they did this\n" +
                "Then they did this\n" +
                "Then they did this\n" +
                "Then they did this\n" +
                "Then they did this\n" +
                "Then they did this\n" +
                "Then they did this\n" +
                "Then they did this\n" +
                "Then they did this\n" +
                "Then they did this\n" +
                "Then they did this\n" +
                "Then they did this\n" +
                "Then they did this\n" +
                "Then they did this\n" +
                "Then they did this\n" +
                "Then they did this\n" +
                "Then they did this\n" +
                "Then they did this\n" +
                "Then they did this\n" +
                "Finally did this");
        logText.setLineWrap(true);
        logText.setWrapStyleWord(true);
        logText.setBackground(Color.white);
        logText.setPreferredSize(new Dimension(200, logText.getPreferredSize().height));
        log.add(logText);
        JScrollPane logScroll = new JScrollPane(log);
        logScroll.setPreferredSize(new Dimension(200, 300));
        logScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        logScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);


        JPanel deck = new JPanel();
        deck.setLayout(new BoxLayout(deck, BoxLayout.Y_AXIS));
        JLabel deckPictureLabel;
        try {
            BufferedImage enemyPicture = ImageIO.read(new File("assets/card-back.jpeg"));
            deckPictureLabel = new JLabel(new ImageIcon(enemyPicture
                    .getScaledInstance(150, 200, Image.SCALE_SMOOTH)));
        } catch (IOException e) {
            deckPictureLabel = new JLabel("Deck Image could not load");
        }
        JLabel deckLabel = new JLabel("Deck: 10 cards");
        deck.add(deckPictureLabel);
        deck.add(deckLabel);

        rightPanel.add(logScroll, BorderLayout.NORTH);
        rightPanel.add(deck, BorderLayout.SOUTH);


        // Button action listeners
        exit.addActionListener(this);
        information.addActionListener(this);
        attack.addActionListener(this);
        specialAttack.addActionListener(this);
        swap.addActionListener(this);


        this.setLayout(new BorderLayout());
        this.add(headerPanel, BorderLayout.PAGE_START);
        this.add(leftPanel, BorderLayout.LINE_START);
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(rightPanel, BorderLayout.LINE_END);
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
