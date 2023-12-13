package graficos;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class HojaSprite {
    private final int ancho;
    private final int alto;
    public final int[] pixeles;
    // Coleccion de hojas de sprites
    public static HojaSprite knight = new HojaSprite("/sprites/knight.png", 320, 320);
    public static HojaSprite cave = new HojaSprite("/sprites/cave.png", 320, 320);
    public static HojaSprite prueba = new HojaSprite("/sprites/cave.png", 320, 320);


    // Constructor de la clase HojaSprite
    public HojaSprite(String ruta, int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
        this.pixeles = new int[ancho * alto];
        try {
            BufferedImage imagen = ImageIO.read(getClass().getResourceAsStream(ruta));
            imagen.getRGB(0, 0, ancho, alto, pixeles, 0, ancho);
        } catch (IOException e) {
            e.printStackTrace();
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



