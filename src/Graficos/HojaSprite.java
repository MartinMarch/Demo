package Graficos;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class HojaSprite {
    public final int[] pixeles;
    private final int ancho;
    private final int alto;

    // Coleccion de hojas de sprites
    public static HojaSprite knight = new HojaSprite("/Knight/knight.png", 320, 320);
    public HojaSprite(final String ruta, final int ancho, final int alto) {
        this.ancho = ancho;
        this.alto = alto;
        pixeles = new int[ancho * alto];

        BufferedImage imagen;
        try {
            imagen = ImageIO.read(HojaSprite.class.getResource(ruta));
            imagen.getRGB(0, 0, ancho, alto, pixeles, 0, ancho);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getAncho() {
        return ancho;
    }


}
