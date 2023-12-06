package view;

import interface_adaptor.attack.AttackController;
import interface_adaptor.end_turn.EndTurnController;
import interface_adaptor.exit.ExitController;
import interface_adaptor.exit.ExitViewModel;
import interface_adaptor.game.GameState;
import interface_adaptor.game.GameViewModel;
import interface_adaptor.how_to_play.HowToPlayController;
import interface_adaptor.how_to_play.HowToPlayViewModel;
import interface_adaptor.location.LocationController;
import interface_adaptor.swap.SwapController;
import interface_adaptor.swap.SwapViewModel;

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
    private final EndTurnController endTurnController;
    private final HowToPlayViewModel howToPlayViewModel;
    private final HowToPlayController howToPlayController;
    private final AttackController attackController;
    private final SwapViewModel swapViewModel;
    private final SwapController swapController;
    private final ExitViewModel exitViewModel;
    private final ExitController exitController;
    private final LocationController locationController;
    private final GameViewModel gameViewModel;
    private final JButton exit;
    private final JButton information;
    final JButton attack;
    final JButton specialAttack;
    final JButton swap;
    private final JLabel enemyHealth;
    private final JLabel playerHealth;
    private final JLabel playerName;
    private final JLabel nextLocationLabel;
    private final JLabel locationLabel;
    private final JLabel nextLabel;
    private final JLabel temperature;
    private final JLabel humidity;
    private final JTextArea logText;

    public GameView(EndTurnController endTurnController,
                    HowToPlayController howToPlayController, HowToPlayViewModel howToPlayViewModel,
                    AttackController attackController,
                    SwapController swapController, SwapViewModel swapViewModel,
                    ExitController exitController, ExitViewModel exitViewModel,
                    LocationController locationController, GameViewModel gameViewModel) {

        this.endTurnController = endTurnController;
        this.howToPlayController = howToPlayController;
        this.howToPlayViewModel = howToPlayViewModel;
        this.attackController = attackController;
        this.swapController = swapController;
        this.swapViewModel = swapViewModel;
        this.exitController = exitController;
        this.exitViewModel = exitViewModel;
        this.locationController = locationController;
        this.gameViewModel = gameViewModel;
        gameViewModel.addPropertyChangeListener(this);
        GameState gameState = gameViewModel.getState();


        // Header
        JPanel headerPanel = new JPanel();
        JLabel title = new JLabel("Weather Warriors");
        exit = new JButton("Exit");
        exit.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource().equals(exit)) {
                        exitController.execute();
                    }
                }
            }
        );

        headerPanel.setLayout(new GridBagLayout());
        headerPanel.add(title);
        headerPanel.add(exit);

        // Left Panel
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BorderLayout());
        leftPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JPanel locationPanel = new JPanel();
        locationPanel.setLayout(new BoxLayout(locationPanel, BoxLayout.Y_AXIS));
        JLabel locationTitle = new JLabel("Location:");
        locationLabel = new JLabel(gameState.getLocation());
        temperature = new JLabel("Temperature: " + gameState.getTemperature());
        humidity = new JLabel("Humidity: " + gameState.getHumidity());
        nextLocationLabel = new JLabel("Next location: " + gameState.getNextLocation());
        locationPanel.add(locationTitle);
        locationPanel.add(locationLabel);
        locationPanel.add(temperature);
        locationPanel.add(humidity);
        locationPanel.add(nextLocationLabel);

        JPanel sidebar = new JPanel();
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        sidebar.setBorder(new EmptyBorder(50, 10, 10, 10));
        information = new JButton("Information");
        attack = new JButton("Attack");
        specialAttack = new JButton("Special Attack");
        swap = new JButton("Swap");
        information.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource().equals(information)) {
                        howToPlayController.execute("EN");

                        JOptionPane.showMessageDialog(null, howToPlayViewModel.getState().getMessage());
                    }
                }
            }
        );
        attack.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource().equals(attack) && !gameState.getGameOver()) {
                        attackController.execute(0);
                        if (gameState.getGameOver()){
                            JOptionPane.showMessageDialog(null, "Game Over, you won");
                        } else {
                            endTurnController.execute();
                            if (gameState.getGameOver()){
                                JOptionPane.showMessageDialog(null, "Game Over, you lost");
                            } else {
                                locationController.execute();
                            }
                        }
                    }
                }
            }
        );
        specialAttack.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource().equals(specialAttack) && !gameState.getGameOver()) {
                        attackController.execute(1);

                        if (gameState.getGameOver()){
                            JOptionPane.showMessageDialog(null, "Game Over, you won");
                        } else {
                            endTurnController.execute();
                            if (gameState.getGameOver()){
                                JOptionPane.showMessageDialog(null, "Game Over, you lost");
                            } else {
                                locationController.execute();
                            }
                        }
                    }
                }
            }
        );
        swap.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource().equals(swap)) {
                        swapController.execute();

                        endTurnController.execute();
                        if (gameState.getGameOver()){
                            JOptionPane.showMessageDialog(null, "Game Over, you lost");
                        } else {
                            locationController.execute();
                        }
                    }
                }
            }
        );
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
            BufferedImage playerPicture = ImageIO.read(new File("src/assets/capybara.jpg"));
            playerPictureLabel = new JLabel(new ImageIcon(playerPicture
                    .getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
        } catch (IOException e) {
            playerPictureLabel = new JLabel("Player Image could not load");
        }
        playerPictureLabel.setAlignmentX(0.5f);
        playerName = new JLabel(gameState.getActiveCardName());
        playerName.setAlignmentX(0.5f);
        playerHealth = new JLabel(gameState.getActiveCardHealth().toString() + " hp");
        playerHealth.setAlignmentX(0.5f);
        playerPanel.add(playerName);
        playerPanel.add(playerPictureLabel);
        playerPanel.add(playerHealth);

        JPanel enemyPanel = new JPanel();
        enemyPanel.setLayout(new BoxLayout(enemyPanel, BoxLayout.Y_AXIS));
        JLabel enemyPictureLabel;
        try {
            BufferedImage enemyPicture = ImageIO.read(new File("src/assets/opponent.jpg"));
            enemyPictureLabel = new JLabel(new ImageIcon(enemyPicture
                    .getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
        } catch (IOException e) {
            enemyPictureLabel = new JLabel("Opponent Image could not load");
        }
        enemyPictureLabel.setAlignmentX(0.5f);
        JLabel enemyName = new JLabel("Capybara Boss");
        enemyName.setAlignmentX(0.5f);
        enemyHealth = new JLabel(gameState.getOpponentCardHealth().toString() + " hp");
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
        rightPanel.setPreferredSize(new Dimension(250, 600));

        JPanel log = new JPanel();
        log.setAlignmentX(Component.LEFT_ALIGNMENT);
        logText = new JTextArea(gameState.getLog());
        logText.setLineWrap(true);
        logText.setWrapStyleWord(true);
        logText.setBackground(Color.white);
        logText.setPreferredSize(new Dimension(200, 10000));
        log.add(logText);
        JScrollPane logScroll = new JScrollPane(log);
        logScroll.setPreferredSize(new Dimension(250, 250));


        JPanel deck = new JPanel();
        deck.setLayout(new BoxLayout(deck, BoxLayout.Y_AXIS));
        JLabel deckPictureLabel;
        try {
            BufferedImage nextPicture = ImageIO.read(new File("src/assets/kangaroo.jpg"));
            deckPictureLabel = new JLabel(new ImageIcon(nextPicture
                    .getScaledInstance(150, 200, Image.SCALE_SMOOTH)));
        } catch (IOException e) {
            deckPictureLabel = new JLabel("Deck Image could not load");
        }
        nextLabel = new JLabel("Next: " + gameState.getNextCardName());
        JLabel deckLabel = new JLabel("Deck: 10 cards");
        deck.add(nextLabel);
        deck.add(deckPictureLabel);
        deck.add(deckLabel);

        rightPanel.add(logScroll, BorderLayout.NORTH);
        rightPanel.add(deck, BorderLayout.SOUTH);


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
        GameState state = (GameState) evt.getNewValue();
        setFields(state);
    }

    private void setFields(GameState state) {
        locationLabel.setText(state.getLocation());
        nextLocationLabel.setText("Next location: " + state.getNextLocation());
        playerName.setText(state.getActiveCardName());
        playerHealth.setText(state.getActiveCardHealth().toString() + " hp");
        enemyHealth.setText(state.getOpponentCardHealth().toString() + " hp");
        nextLabel.setText("Next: " + state.getNextCardName());
        temperature.setText("Temperature: " + state.getTemperature());
        humidity.setText("Humidity: " + state.getHumidity());
        logText.setText(state.getLog());
    }
}
