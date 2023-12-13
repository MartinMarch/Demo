package Graficos;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class HojaSprite {
    private final int ancho;
    private final int alto;
    public final int[] pixeles;
    // Coleccion de hojas de sprites
    public static HojaSprite knight = new HojaSprite("/Sprites/knight.png", 320, 320);
    // Constructor de la clase HojaSprite
    public HojaSprite(String ruta, int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
        this.pixeles = new int[ancho * alto];
        cargarHojaSprite(ruta);
    }

    // Método para cargar la imagen de la hoja de sprites
    private void cargarHojaSprite(String ruta) {
        try {
            BufferedImage imagen = ImageIO.read(getClass().getResourceAsStream(ruta));
            imagen.getRGB(0, 0, ancho, alto, pixeles, 0, ancho);
        } catch (IOException e) {
            e.printStackTrace();
            // Gestionar el error de la carga de la imagen
        }
    }

    // Getters y Setters si son necesarios
    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }
}



