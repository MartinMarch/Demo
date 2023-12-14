package graficos;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class HojaSprite {
    private final int ancho;
    private final int alto;
    public final int[] pixeles;
    // Coleccion de hojas de sprites
    public static HojaSprite prueba;
    public static HojaSprite mapa;
    public static HojaSprite grass;
    static{
        try {
            prueba = new HojaSprite("/sprites/Prueba.png", 320, 320);
            grass = new HojaSprite("/sprites/grass.png",192,64);

            System.out.println("hojaSprite creada correctamente");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Constructor de la clase HojaSprite
    public HojaSprite(String ruta, int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
        this.pixeles = new int[ancho * alto];
        BufferedImage image;
        try {
            image = ImageIO.read(HojaSprite.class.getResourceAsStream(ruta));
            image.getRGB(0, 0, ancho, alto, pixeles, 0, ancho);
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



