package Graficos;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.awt.Graphics;

public class Pantalla {
    private final int ancho;
    private final int alto;
    private BufferedImage imagen;
    private int[] pixeles;

    public Pantalla(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
        this.imagen = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_ARGB);
        this.pixeles = ((DataBufferInt) imagen.getRaster().getDataBuffer()).getData();
    }

    public void limpiar() {
        for (int i = 0; i < pixeles.length; i++) {
            pixeles[i] = 0; // Establece el color de los pixeles a negro (o al color de fondo deseado)
        }
    }

    public void dibujarSprite(int x, int y, Sprite sprite) {
        for (int j = 0; j < sprite.getLado(); j++) {
            for (int i = 0; i < sprite.getLado(); i++) {
                int colorPixel = sprite.getPixeles()[i + j * sprite.getLado()];
                if (colorPixel != 0xFFFF00FF) { // 0xFFFF00FF es el color magenta, a menudo se usa como color transparente
                    pixeles[(x + i) + (y + j) * ancho] = colorPixel;
                }
            }
        }
    }

    public void renderizar(Graphics g) {
        g.drawImage(imagen, 0, 0, ancho, alto, null);
    }

    // Getters y Setters si son necesarios
}

