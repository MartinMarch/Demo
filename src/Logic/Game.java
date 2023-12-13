package Logic;
import Entities.Jugador;
import Graficos.HojaSprite;
import Graficos.Sprite;
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
        // Cargar la imagen de fondo
        backgroundImage = new ImageIcon("CarpetaDeRecursos/escenari.jpg").getImage();

        // Inicializar el personaje del jugador
        Sprite[] spritesMovimiento = cargarSprites();
        jugador = new Jugador(100, 100, spritesMovimiento, 100); // 100 es el frameDelay

        // Gestionar el desplazamiento del jugador con el teclado
        setFocusable(true);
        requestFocus();
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int velocidad = 10;
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_A: jugador.mover('A', velocidad); break;
                    case KeyEvent.VK_D: jugador.mover('D', velocidad); break;
                    case KeyEvent.VK_W: jugador.mover('W', velocidad); break;
                    case KeyEvent.VK_S: jugador.mover('S', velocidad); break;
                }
                repaint();
            }
        });
    }

    // Método para cargar los sprites del jugador
    private Sprite[] cargarSprites() {
        // Implementa la carga de los sprites aquí
        // Puedes usar la clase Graficos.HojaSprite y Graficos.Sprite
        // y la carpeta de sprites que tienes en CarpetaDeRecursos
        // Por ejemplo:
        return new Sprite[] { new Sprite(32, 0, 0, HojaSprite.knight)};
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
        jugador.dibujar(g);
    }
}


