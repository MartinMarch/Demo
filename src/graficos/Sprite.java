package graficos;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class Sprite {
    private final int lado; // El lado de un sprite en un sprite sheet cuadrado
    private int x, y; // Posición del sprite en la hoja de sprites
    public int[] pixeles; // Pixeles del sprite
    private HojaSprite hoja; // La hoja de sprites a la que pertenece este sprite
    public static Sprite grass1;
    public static Sprite grass2;
    public static Sprite grass3;
    public static Sprite grass4;
    public static Sprite vacio;
    public static Sprite j1SurDePie;
    public static Sprite j1SurDePieCaminando1;
    public static Sprite j1SurDePieCaminando2;
    public static Sprite j1SurDePieCaminando3;
    public static Sprite j1SurDePieCaminando4;
    public static Sprite j1NorteDePie;
    public static Sprite j1NorteDePieCaminando1;
    public static Sprite j1NorteDePieCaminando2;
    public static Sprite j1NorteDePieCaminando3;
    public static Sprite j1NorteDePieCaminando4;
    public static Sprite j1EsteDePie;
    public static Sprite j1EsteDePieCaminando1;
    public static Sprite j1EsteDePieCaminando2;
    public static Sprite j1EsteDePieCaminando3;
    public static Sprite j1EsteDePieCaminando4;
    public static Sprite j1OesteDePie;
    public static Sprite j1OesteDePieCaminando1;
    public static Sprite j1OesteDePieCaminando2;
    public static Sprite j1OesteDePieCaminando3;
    public static Sprite j1OesteDePieCaminando4;
    static{
        try {
            //sprites de paisaje
            grass1 = new Sprite(32,0,0,HojaSprite.grass);
            grass2 = new Sprite(32,5,0,HojaSprite.grass);
            grass3 = new Sprite(32,3,0,HojaSprite.grass);
            grass4 = new Sprite(32,4,0,HojaSprite.grass);
            vacio = new Sprite(32,0);
            //sprites de personaje
            j1SurDePie = new Sprite(32,0,0,HojaSprite.knigth);
            j1SurDePieCaminando1 = new Sprite(32,1,0,HojaSprite.knigth);
            j1SurDePieCaminando2 = new Sprite(32,2,0,HojaSprite.knigth);
            j1SurDePieCaminando3 = new Sprite(32,3,0,HojaSprite.knigth);
            j1SurDePieCaminando4 = new Sprite(32,4,0,HojaSprite.knigth);
            j1NorteDePie = new Sprite(32,0,1,HojaSprite.knigth);
            j1NorteDePieCaminando1 = new Sprite(32,1,1,HojaSprite.knigth);
            j1NorteDePieCaminando2 = new Sprite(32,2,1,HojaSprite.knigth);
            j1NorteDePieCaminando3 = new Sprite(32,3,1,HojaSprite.knigth);
            j1NorteDePieCaminando4 = new Sprite(32,4,1,HojaSprite.knigth);
            j1EsteDePie = new Sprite(32,0,2,HojaSprite.knigth);
            j1EsteDePieCaminando1 = new Sprite(32,1,3,HojaSprite.knigth);
            j1EsteDePieCaminando2 = new Sprite(32,2,3,HojaSprite.knigth);
            j1EsteDePieCaminando3 = new Sprite(32,3,3,HojaSprite.knigth);
            j1EsteDePieCaminando4 = new Sprite(32,4,3,HojaSprite.knigth);
            j1OesteDePie = new Sprite(32,0,3,HojaSprite.knigth);
            j1OesteDePieCaminando1 = new Sprite(32,1,2,HojaSprite.knigth);
            j1OesteDePieCaminando2 = new Sprite(32,2,2,HojaSprite.knigth);
            j1OesteDePieCaminando3 = new Sprite(32,3,2,HojaSprite.knigth);
            j1OesteDePieCaminando4 = new Sprite(32,4,2,HojaSprite.knigth);
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
    public Sprite(final int lado, final int color){
        this.lado = lado;
        pixeles = new int[lado * lado];
        for(int i = 0; i < pixeles.length; i++){
            pixeles[i] = color;
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



