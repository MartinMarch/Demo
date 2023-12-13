package Graficos;

import java.awt.*;

public final class Sprite {
    private final int lado;
    private int x;
    private int y;
    public int[] pixeles;
    private final HojaSprite hoja;
    public static Sprite knight = new Sprite(32, 0, 0, HojaSprite.knight);

    public Sprite(final int lado, final int columna, final int fila, final HojaSprite hoja) {
        this.lado = lado;
        pixeles = new int[lado * lado];
        this.x = columna * lado;
        this.y = fila * lado;
        this.hoja = hoja;

        for (int y = 0; y < lado; y++) {
            for (int x = 0; x < lado; x++) {
                pixeles[x + y * lado] = hoja.pixeles[(x + this.x) + (y + this.y) * hoja.getAncho()];
            }
        }
    }

}
