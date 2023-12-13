package graficos;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class Sprite {
    private final int lado; // El lado de un sprite en un sprite sheet cuadrado
    private int x, y; // Posición del sprite en la hoja de sprites
    public int[] pixeles; // Pixeles del sprite
    private final HojaSprite hoja; // La hoja de sprites a la que pertenece este sprite
    public static Sprite prueba;
    public static Sprite mapaMuro;
    public static Sprite mapaHierbaCentral;
    public static Sprite grass1;
    static{
        try {
            prueba = new Sprite(32, 0, 0, HojaSprite.prueba);
            mapaMuro = new Sprite(48,0,0, HojaSprite.mapa);
            mapaHierbaCentral = new Sprite(48,4,1, HojaSprite.mapa);
            grass1 = new Sprite(32,5,0,HojaSprite.grass);

            System.out.println("Sprite creado correctamente");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // Constructor de la clase Sprite
    public Sprite(final int lado, final int columna, final int fila, final HojaSprite hoja) {
        this.lado = lado;
        this.x = columna * lado;
        this.y = fila * lado;
        this.hoja = hoja;
        this.pixeles = new int[lado * lado];
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



