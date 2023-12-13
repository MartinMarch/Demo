import Logic.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;

public class MainMenu extends JPanel {
    public MainMenu() {
        setLayout(new BorderLayout());
        setBackground(new Color(224, 224, 224)); // Color de fondo gris claro

        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(new Color(224, 224, 224)); // Mismo color de fondo
        JLabel titleLabel = new JLabel("Demo de Juego");
        titleLabel.setFont(new Font("Helvetica", Font.BOLD, 48)); // Fuente y tamaño de letra
        Map<TextAttribute, Object> attributes = new HashMap<>();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        titleLabel.setForeground(Color.DARK_GRAY); // Color del texto en tono gris oscuro
        titleLabel.setFont(titleLabel.getFont().deriveFont(attributes));
        titlePanel.add(titleLabel);

        JPanel buttonPanel = new JPanel(new GridLayout(3, 1, 0, 20));
        buttonPanel.setBackground(new Color(224, 224, 224)); // Mismo color de fondo

        JButton startButton = createButton("Iniciar Juego");
        JButton settingsButton = createButton("Ajustes"); // Cambiado a "Ajustes"
        JButton exitButton = createButton("Salir");

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Mi Demo 2D con Jugador");
                frame.setSize(800, 600);
                frame.setLocationRelativeTo(null); // Centrar la ventana en la pantalla
                frame.setVisible(true);
                Game game = new Game();
                frame.add(game);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            }
        });

        settingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showSettingsDialog(); // Mostrar la ventana de ajustes
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        buttonPanel.add(startButton);
        buttonPanel.add(settingsButton);
        buttonPanel.add(exitButton);

        add(titlePanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Helvetica", Font.PLAIN, 24)); // Fuente y tamaño de letra de los botones
        button.setBackground(Color.LIGHT_GRAY); // Color de fondo gris claro
        button.setForeground(Color.DARK_GRAY); // Color del texto en tono gris oscuro
        button.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2)); // Borde gris oscuro
        button.setFocusPainted(false); // Eliminar el resaltado del botón al enfocar
        return button;
    }

    private void showSettingsDialog() {
        JDialog settingsDialog = new JDialog();
        settingsDialog.setTitle("Ajustes de Volumen");
        settingsDialog.setSize(800, 600);
        settingsDialog.setResizable(false);
        settingsDialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        settingsDialog.setLocationRelativeTo(null); // Centrar la ventana en la pantalla

        JPanel settingsPanel = new JPanel();
        settingsPanel.setLayout(new FlowLayout());

        // Aquí puedes agregar controles para ajustar el volumen, como un control deslizante
        JSlider volumeSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50); // Rango de 0 a 100, valor inicial 50
        volumeSlider.setMajorTickSpacing(10);
        volumeSlider.setMinorTickSpacing(1);
        volumeSlider.setPaintTicks(true);
        volumeSlider.setPaintLabels(true);

        settingsPanel.add(volumeSlider);

        settingsDialog.add(settingsPanel);
        settingsDialog.setVisible(true);

        // Manejar el cierre de la ventana de ajustes
        settingsDialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Guardar el valor del volumen ajustado aquí y aplicarlo al juego
                int volumeValue = volumeSlider.getValue();
                // Aplicar el volumen al juego (puedes implementar esta lógica)
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame mainFrame = new JFrame("Menú Principal");
                MainMenu mainMenu = new MainMenu();
                mainFrame.add(mainMenu);
                mainFrame.setSize(800, 600);
                mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                mainFrame.setVisible(true);
                mainFrame.setLocationRelativeTo(null); // Centrar la ventana en la pantalla
            }
        });
    }
}




