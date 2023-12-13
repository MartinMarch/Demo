package Logic;

import Entities.Jugador;
import Graficos.Sprite;
import Graficos.HojaSprite;

import javax.swing.JPanel;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Game extends JPanel {
    private Image backgroundImage;
    private Jugador jugador;

    public Game() {
        try {
            // Cargar la imagen de fondo
            backgroundImage = new ImageIcon("CarpetaDeRecursos/escenari.jpg").getImage();

            // Verificar que la imagen de fondo se ha cargado correctamente
            if (backgroundImage == null) {
                throw new Exception("La imagen de fondo no se pudo cargar.");
            }
            try {
                // pintar el fondo
                repaint();
            } catch (Exception e) {
                System.out.println("Error al pintar el fondo: " + e.getMessage());
                e.printStackTrace();
                return; // Terminar la inicialización si hay un error
            }
            // Inicializar el personaje del jugador
            Sprite[] spritesJugador = cargarSprites();  // Cargar los sprites del jugador
            jugador = new Jugador(0, 0, spritesJugador, 100); // Crear el jugador en la posición (0, 0) con los sprites cargados

            try {
                addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        int velocidad = 10;
                        switch (e.getKeyCode()) {
                            case KeyEvent.VK_A:
                                jugador.mover('A', velocidad);
                                break;
                            case KeyEvent.VK_D:
                                jugador.mover('D', velocidad);
                                break;
                            case KeyEvent.VK_W:
                                jugador.mover('W', velocidad);
                                break;
                            case KeyEvent.VK_S:
                                jugador.mover('S', velocidad);
                                break;
                        }
                        repaint();
                    }
                });
            } catch (Exception e) {
                System.out.println("Error al mover el jugador: " + e.getMessage());
                e.printStackTrace();
                return; // Terminar la inicialización si hay un error
            }



        } catch (Exception e) {
        System.out.println("Error en la inicialización de Game: " + e.getMessage());
        e.printStackTrace();
        }
    }

    // Método para cargar los sprites del jugador
    private Sprite[] cargarSprites() {
        try {
            // Devolver el arreglo de sprites
            return new Sprite[] { Sprite.knightNorte0, Sprite.knightNorte1, Sprite.knightNorte2,
                    Sprite.knightEste0, Sprite.knightEste1, Sprite.knightEste2,
                    Sprite.knightSur0, Sprite.knightSur1, Sprite.knightSur2,
                    Sprite.knightOeste0, Sprite.knightOeste1, Sprite.knightOeste2};
        } catch (Exception e) {
            System.out.println("Error al cargar los sprites: " + e.getMessage());
            e.printStackTrace();
            return null; // O manejar de otra manera
        }
    }

    // Método para pintar el fondo y el jugador
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
        if (jugador != null) {
            jugador.dibujar(g);
        }
    }
}


