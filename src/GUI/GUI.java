package GUI;

import Logic.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;

public class GUI implements ActionListener {
        // Global classes
        Images img = new Images();
        IconImages icImg = new IconImages();
        ProgressBar pB = new ProgressBar();

        // Static properties
        private static final int fWidth = 600;
        private static final int fHeight = 800;
        private static String bgImgPath = "C:\\Users\\Daniel\\Desktop\\Programming\\Java\\MusicPlayer\\src\\Resources\\Images\\backgroundImg.jpg";
        private static String[] buttIconsPath = {
                        "C:\\Users\\Daniel\\Desktop\\Programming\\Java\\MusicPlayer\\src\\Resources\\Icons\\prev.png",
                        "C:\\Users\\Daniel\\Desktop\\Programming\\Java\\MusicPlayer\\src\\Resources\\Icons\\play.png",
                        "C:\\Users\\Daniel\\Desktop\\Programming\\Java\\MusicPlayer\\src\\Resources\\Icons\\next.png" };

        // Declaring GUI elements
        private JFrame mainFrame;
        private JButton[] controlButtons;
        private JPanel mainPanel, controlPanel, imgPanel, infoPanel, textPanel;
        private JProgressBar progBar;
        private JLabel albumName, songTitle, artName;
        private ImageIcon[] imgIcon;

        // Declaring global non-static variables
        Artist artistas = new Artist();
        private int artIndex = 0, albIndex = 0, songIndex = 0;

        // Constructor method
        public GUI() {

        }

        private void initializeMainFrame() {
                mainFrame = new JFrame("Music Player");
                mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                mainFrame.setSize(fWidth, fHeight);
                mainFrame.setResizable(false);
                mainFrame.setContentPane(new Images());
                ((Images) mainFrame.getContentPane()).setBackgroundImage(bgImgPath);
                mainFrame.setLayout(new GridBagLayout());
        }

        private void initializePanels() {
                // Initialize mainPanel
                mainPanel = new PanelRound(50, 50, 50, 50);
                Insets Insets = new Insets(-150, 90, -250, 90);
                GridBagConstraints mainPGbc = new GridBagConstraints(
                                0,
                                0,
                                1,
                                1,
                                1.0,
                                0.0,
                                GridBagConstraints.PAGE_START,
                                GridBagConstraints.BOTH, Insets,
                                0,
                                0);
                mainPanel.setLayout(new GridBagLayout());

                // Initialize imgPanel
                imgPanel = new JPanel();
                imgPanel.setSize(200, 200);
                imgPanel.setLayout(new BorderLayout());
                img.setBackgroundImage("Test");
                imgPanel.add(img, BorderLayout.CENTER);
                Border border = BorderFactory.createLineBorder(Color.black, 2);
                imgPanel.setBorder(border);
                Insets imgInsets = new Insets(-200, 175, 0, 175);
                GridBagConstraints imgGbc = new GridBagConstraints(
                                0,
                                0,
                                1,
                                1,
                                1.0,
                                0.0,
                                GridBagConstraints.PAGE_START,
                                GridBagConstraints.BOTH, imgInsets,
                                0,
                                0);

                // Initialize infoPanel
                infoPanel = new JPanel();
                infoPanel.setSize(175, 300);
                Insets infoInsets = new Insets(-30, 85, -90, 85);
                GridBagConstraints infoGbc = new GridBagConstraints(
                                0,
                                0,
                                1,
                                0,
                                0.0,
                                0.0,
                                GridBagConstraints.PAGE_START,
                                GridBagConstraints.BOTH, infoInsets,
                                0,
                                0);
                infoPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 5));

                controlPanel = new JPanel();
                controlPanel.setSize(175, 300);
                Insets ctrlInsets = new Insets(110, 85, -150, 85);
                GridBagConstraints ctrlGbc = new GridBagConstraints(
                                0,
                                0,
                                1,
                                0,
                                0,
                                0.0,
                                GridBagConstraints.PAGE_START,
                                GridBagConstraints.BOTH, ctrlInsets,
                                0,
                                0);
                controlPanel.setLayout(new FlowLayout());

                // Initialize textPanel
                textPanel = new JPanel();
                textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
                textPanel.setBorder(new EmptyBorder(20, 0, 0, 0));

                // Adding elements to mainPanel
                mainPanel.add(infoPanel, infoGbc);
                mainPanel.add(controlPanel, ctrlGbc);

                // Adding elements to mainFrame
                mainFrame.add(imgPanel, imgGbc);
                mainFrame.add(mainPanel, mainPGbc);
        }

        public void initializeComponents() {
                // Initialize progress bar
                progBar = new ProgressBar().applyStyle(new JProgressBar(), 0, 180, infoPanel.getWidth(), 5);

                // Initializing JLabels
                songTitle = new JLabel("Test");
                albumName = new JLabel("Test");
                artName = new JLabel("Test");

                songTitle.setFont(new Font("Arial", Font.BOLD, 24)); // Set font size and style
                albumName.setFont(new Font("Arial", Font.BOLD, 12)); // Set font size and style
                artName.setFont(new Font("Arial", Font.BOLD, 12));

                // Aligning Labels
                songTitle.setAlignmentX(Component.CENTER_ALIGNMENT); // Center horizontally
                albumName.setAlignmentX(Component.CENTER_ALIGNMENT); // Center horizontally
                artName.setAlignmentX(Component.CENTER_ALIGNMENT); // Center horizontally

                // Initializing buttons
                controlButtons = new JButton[3];
                imgIcon = new ImageIcon[buttIconsPath.length];

                // Initializing icons and scaling them accordingly
                for (int i = 0; i < buttIconsPath.length; i++) {
                        imgIcon[i] = new ImageIcon(buttIconsPath[i]);
                        icImg.resizeImage(imgIcon[i].getImage(), 30, 30);
                        imgIcon[i].setImage(icImg.getScaledImg());
                }

                // Setting up buttons properties
                for (int i = 0; i < controlButtons.length; i++) {
                        controlButtons[i] = new JButton();
                        controlButtons[i].setBorderPainted(false);
                        controlButtons[i].setContentAreaFilled(false);
                        controlButtons[i].setFocusPainted(false);
                        controlButtons[i].setOpaque(false);
                        controlButtons[i].setIcon(imgIcon[i]);
                }
                controlButtons[0].addActionListener(this);
                controlButtons[2].addActionListener(this);

        }

        public void addComponents() {
                // Adding JLabels
                textPanel.add(Box.createVerticalGlue());
                textPanel.add(songTitle);
                textPanel.add(Box.createVerticalStrut(10)); // Add some spacing between labels
                textPanel.add(albumName);
                textPanel.add(Box.createVerticalGlue());
                textPanel.add(Box.createVerticalStrut(10));
                textPanel.add(artName);
                textPanel.add(Box.createVerticalGlue());

                // Adding progress and textPanel bar to infoPanel
                infoPanel.add(progBar);
                infoPanel.add(textPanel);

                // Adding buttons to control panel
                for (int i = 0; i < 3; i++) {
                        controlPanel.add(controlButtons[i]);
                }

        }

        private void updateDisplayedInfo() {
                // Get the artist based on the updated artIndex
                Artist currentArtist = artistas.getArtistList().get(artIndex);
                // You can update other components here based on the new artist
                // For example, updating the album and song information based on the artist's
                // albums
                // You can access the albums and songs using currentArtist.getAllAlbums() and
                // album.getSongs()
                // Update imgPanel's background image based on the album cover path
                // Update JLabels with the new artist's information
                img.setBackgroundImage(currentArtist.getAllAlbums().get(albIndex).getCoverPath());
                songTitle.setText(currentArtist.getAllAlbums().get(albIndex).getSongs().get(songIndex).getName());
                albumName.setText(currentArtist.getAllAlbums().get(albIndex).getName());
                artName.setText(currentArtist.getName());
                imgPanel.repaint();// Repaint the imgPanel to update the background image

        }

        private void initializeGui() {

                initializeMainFrame();
                initializePanels();
                initializeComponents();
                addComponents();
                updateDisplayedInfo();
                mainFrame.setVisible(true);
        }

        public static void main(String[] args) {

                Logic.Artist myArtist = new Artist();

                // Adding artists
                myArtist.createArtist("Gustavo Cerati");
                myArtist.createArtist("MGMT");
                myArtist.createArtist("Alberto Spinetta");

                // Adding albums & songs
                myArtist.returnArtist("Gustavo Cerati").addCollection(
                                "Bocanada",
                                "C:\\Users\\Daniel\\Desktop\\Programming\\Java\\MusicPlayer\\src\\Resources\\Images\\gus.jpg");

                myArtist.getArtistList().get(0).currentAlbum("Gustavo Cerati",
                                "Bocanada").addSong("Puente", 180);

                myArtist.getArtistList().get(0).addCollection("Fuerza Natural",
                                "C:\\Users\\Daniel\\Desktop\\Programming\\Java\\MusicPlayer\\src\\Resources\\Images\\FN.jpg");

                myArtist.getArtistList().get(0).currentAlbum("Gustavo Cerati",
                                "Fuerza Natural").addSong("Deja Vu", 180);

                myArtist.returnArtist("Alberto Spinetta").addCollection("Almendra",
                                "C:\\Users\\Daniel\\Desktop\\Programming\\Java\\MusicPlayer\\src\\Resources\\Images\\Spinetta.jpg");

                myArtist.currentAlbum("Alberto Spinetta",
                                "Almendra").addSong("Muchacha ojos de papel", 200);

                myArtist.returnArtist("MGMT").addCollection("Little Dark Age",
                                "C:\\Users\\Daniel\\Desktop\\Programming\\Java\\MusicPlayer\\src\\Resources\\Images\\Little Dark Age.jpg");

                myArtist.currentAlbum("MGMT", "Little Dark Age").addSong("Electic Feel", 180);

                System.out.println(myArtist.getArtistList().get(0).getAllAlbums().size());
                System.out.println(myArtist.getArtistList().get(0).getAllAlbums().get(0).getSongs().size());

                System.out.println(myArtist.getArtistList().get(1).getAllAlbums().size());
                System.out.println(myArtist.getArtistList().get(1).getAllAlbums().get(0).getSongs().size());

                GUI myGUI = new GUI();
                myGUI.initializeGui();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                if (e.getSource() == controlButtons[2]) { // Check if "Next" button is clicked
                        artIndex++; // Increment artIndex
                        // Check bounds to ensure it stays within the artist list size
                        if (artIndex >= 0 && artIndex < artistas.getArtistList().size()) {
                                // Update displayed information based on the new artIndex
                                updateDisplayedInfo();
                        } else {
                                // Handle the case where artIndex goes out of bounds (if needed)
                                artIndex = 0;
                                updateDisplayedInfo();
                        }
                } else if (e.getSource() == controlButtons[0]) {
                        artIndex--;
                        if (artIndex >= 0 && artIndex < artistas.getArtistList().size()) {
                                // Update displayed information based on the new artIndex
                                updateDisplayedInfo();
                        } else {
                                // Handle the case where artIndex goes out of bounds (if needed)
                                artIndex = artistas.getArtistList().size() - 1;
                                updateDisplayedInfo();
                        }
                }
        }
}
