package Graficos;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class Sprite {
    private final int lado; // El lado de un sprite en un sprite sheet cuadrado
    private int x, y; // Posición del sprite en la hoja de sprites
    private int[] pixeles; // Pixeles del sprite
    private final HojaSprite hoja; // La hoja de sprites a la que pertenece este sprite
    public static Sprite knight = new Sprite(32, 0, 0, HojaSprite.knight);

    // Constructor de la clase Sprite
    public Sprite(final int lado, final int columna, final int fila, final HojaSprite hoja) {
        this.lado = lado;
        this.x = columna * lado;
        this.y = fila * lado;
        this.hoja = hoja;
        this.pixeles = new int[lado * lado];
        cargar();
    }

    // Método para cargar el sprite desde la hoja de sprites
    private void cargar() {
        for (int y = 0; y < lado; y++) {
            for (int x = 0; x < lado; x++) {
                pixeles[x + y * lado] = hoja.pixeles[(x + this.x) + (y + this.y) * hoja.getAncho()];
            }
        }
    }

    // Getters y Setters si son necesarios
    public int[] getPixeles() {
        return pixeles;
    }

    public int getLado() {
        return lado;
    }

    public BufferedImage obtenerImagen() {
        BufferedImage imagen = new BufferedImage(lado, lado, BufferedImage.TYPE_INT_ARGB);
        int[] imagenPixeles = ((DataBufferInt) imagen.getRaster().getDataBuffer()).getData();

        for (int y = 0; y < lado; y++) {
            for (int x = 0; x < lado; x++) {
                int colorPixel = pixeles[x + y * lado];
                imagenPixeles[x + y * lado] = colorPixel;
            }
        }

        return imagen;
    }


    // Otros métodos según se necesiten...
}



