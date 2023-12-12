package Logic;
import Entities.Jugador;

import javax.swing.JFrame;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Game extends JPanel {

    private Image backgroundImage;
    private Jugador jugador;

    public Game() {
        backgroundImage = new ImageIcon("CarpetaDeRecursos/escenari.jpg").getImage();
        String[] rutasJugador = {"CarpetaDeRecursos/J1/j1MirandoHaciaDelante.png", "CarpetaDeRecursos/J1/j1MirandoHaciaDetras.png", "CarpetaDeRecursos/J1/j1MirandoHaciaIzquierda.png", "CarpetaDeRecursos/J1/j1MirandoHaciaDerecha.png",
                "CarpetaDeRecursos/J1/j1CaminaHaciaDelante1.png","CarpetaDeRecursos/J1/j1CaminaHaciaDelante2.png"
                ,"CarpetaDeRecursos/J1/j1CaminaHaciaDerecha2.png","CarpetaDeRecursos/J1/j1CaminaHaciaDerecha1.png"
                ,"CarpetaDeRecursos/J1/j1CaminaHaciaIzquierda2.png", "CarpetaDeRecursos/J1/j1CaminaHaciaIzquierda1.png"
                ,"CarpetaDeRecursos/J1/j1CaminaHaciaDetras2.png", "CarpetaDeRecursos/J1/j1CaminaHaciaDetras1.png"};
        jugador = new Jugador(100, 100, rutasJugador);


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
        setFocusable(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
        jugador.dibujar(g);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Mi Juego 2D con Jugador");
        Game game = new Game();
        frame.add(game);
        frame.setSize(800, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
