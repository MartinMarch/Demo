package Logic;
import javax.swing.JFrame;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Game extends JPanel {

    // Método para actualizar el estado del juego
    private void update() {
        // Lógica de actualización del juego
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // Dibuja los gráficos del juego aquí
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Mi Juego 2D");
        Game game = new Game();
        frame.add(game);
        frame.setSize(800, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Bucle principal del juego
        while (true) {
            game.update();
            game.repaint();
            try {
                Thread.sleep(10); // Controla la velocidad del bucle
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
