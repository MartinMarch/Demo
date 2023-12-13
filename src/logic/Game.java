package logic;
import control.Keyboard;
import graficos.Pantalla;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class Game extends Canvas implements Runnable{
    private static final long serialVersionUID = 1L;
    private static final int ANCHO = 800;
    private static final int ALTO = 600;
    private static volatile boolean enFuncionamiento = false;

    private static final String NOMBRE = "Mi Demo 2D";
    private static int aps = 0;
    private static int fps = 0;
    private static int x = 0;
    private static int y = 0;

    private static JFrame ventana;

    private static Thread thread;
    private static Keyboard teclado;
    private static Pantalla pantalla;

    private static BufferedImage imagen = new BufferedImage(ANCHO, ALTO, BufferedImage.TYPE_INT_RGB);
    private static int[] pixeles = ((DataBufferInt) imagen.getRaster().getDataBuffer()).getData();

    private Game() {
        setPreferredSize(new java.awt.Dimension(ANCHO, ALTO));

        pantalla = new Pantalla(ANCHO, ALTO);

        teclado = new Keyboard();
        addKeyListener(teclado);

        ventana = new JFrame(NOMBRE);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        ventana.setLayout(new BorderLayout());
        ventana.add(this, BorderLayout.CENTER);
        ventana.pack();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }

    public static void main(String[] args) {
        Game demo = new Game();
        demo.iniciar();
    }

    private synchronized void iniciar() {
        enFuncionamiento = true;
        thread = new Thread(this, "graficos");
        thread.start();
    }

    private synchronized void detener() {
        enFuncionamiento = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void actualizar() {
        // Actualizar el estado del juego
        teclado.actualizar();

        aps++;
    }
    private void mostrar() {
        // Mostrar el juego
        BufferStrategy estrategia = getBufferStrategy();
        if (estrategia == null) {
            createBufferStrategy(3);
            return;
        }
        pantalla.limpiar();
        pantalla.mostrar(x, y);

        System.arraycopy(pantalla.pixeles, 0, pixeles, 0, pixeles.length);
        Graphics g = estrategia.getDrawGraphics();

        g.drawImage(imagen, 0, 0, getWidth(), getHeight(), null);
        g.dispose();

        fps++;
    }

    @Override
    public void run() {
        final int NS_POR_SEGUNDO = 1000000000;
        final byte APS_OBJETIVO = 60;
        final double NS_POR_ACTUALIZACION = NS_POR_SEGUNDO / APS_OBJETIVO;

        long referenciaActualizacion = System.nanoTime();
        long referenciaContador = System.nanoTime();

        double tiempoTranscurrido;
        double delta = 0;

        requestFocus();

        while (enFuncionamiento) {
            final long inicioBucle = System.nanoTime();
            tiempoTranscurrido = inicioBucle - referenciaActualizacion;
            referenciaActualizacion = inicioBucle;

            delta += tiempoTranscurrido / NS_POR_ACTUALIZACION;
            while (delta >= 1) {
                actualizar();
                delta--;
            }
            mostrar();
            if(System.nanoTime() - referenciaContador > NS_POR_SEGUNDO){
                ventana.setTitle(NOMBRE + " || APS: " + aps + " || FPS: " + fps);
                aps = 0;
                fps = 0;
                referenciaContador = System.nanoTime();
            }
        }
    }
}


