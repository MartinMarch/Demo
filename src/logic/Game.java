package logic;
import control.Keyboard;
import graficos.Pantalla;
import mapa.Mapa;
import mapa.MapaGenerado;

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
    private static String CONTADOR_APS = "";
    private static String CONTADOR_FPS = "";
    private static int aps = 0;
    private static int fps = 0;
    private static int x = 0;
    private static int y = 0;

    private static JFrame ventana;

    private static Thread thread;
    private static Keyboard teclado;
    private static Pantalla pantalla;
    private static Mapa mapa;

    private static BufferedImage imagen = new BufferedImage(ANCHO, ALTO, BufferedImage.TYPE_INT_RGB);
    private static int[] pixeles = ((DataBufferInt) imagen.getRaster().getDataBuffer()).getData();
    private static final ImageIcon icono = new ImageIcon(Game.class.getResource("/icon/icono1.png"));

    private Game() {
        setPreferredSize(new Dimension(ANCHO, ALTO));

        pantalla = new Pantalla(ANCHO, ALTO);

        mapa = new MapaGenerado(128, 128);

        teclado = new Keyboard();
        addKeyListener(teclado);

        ventana = new JFrame(NOMBRE);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        ventana.setIconImage(icono.getImage());
        ventana.setLayout(new BorderLayout());
        ventana.add(this, BorderLayout.CENTER);
        ventana.setUndecorated(true);
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
        if (teclado.arriba){
            y--;
        }
        if(teclado.abajo){
            y++;
        }
        if(teclado.derecha){
            x++;
        }
        if(teclado.izquierda){
            x--;
        }
        if(teclado.salir){
            System.exit(0);
        }

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

        mapa.mostrar(x, y, pantalla);

        System.arraycopy(pantalla.pixeles, 0, pixeles, 0, pixeles.length);
        Graphics g = estrategia.getDrawGraphics();

        g.drawImage(imagen, 0, 0, getWidth(), getHeight(), null);
        g.setColor(Color.WHITE);
        g.fillRect(ANCHO/2, ALTO/2, 32, 32);
        g.drawString(CONTADOR_APS, 10, 20);
        g.drawString(CONTADOR_FPS, 10, 35);
        g.dispose();

        estrategia.show();

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
                CONTADOR_APS = "APS: " + aps;
                CONTADOR_FPS = "FPS: " + fps;

                aps = 0;
                fps = 0;
                referenciaContador = System.nanoTime();
            }
        }
    }
}


