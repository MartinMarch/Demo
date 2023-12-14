package mapa;

import mapa.tiles.Tile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class MapaCargado extends Mapa{

    private int[] pixeles;
    public MapaCargado(String ruta) {
        super(ruta);
    }
    protected void cargarMapa(String ruta){
        try{
            BufferedImage imagen = ImageIO.read(MapaCargado.class.getResource(ruta));

            ancho = imagen.getWidth();
            alto = imagen.getHeight();
            tilesCatalogo = new Tile[ancho * alto];
            pixeles = new int[ancho * alto];

            imagen.getRGB(0,0,ancho,alto,pixeles,0,ancho);

        } catch (IOException e){
            e.printStackTrace();
        }
    }
    protected void generarMapa(){
        for (int i = 0; i< pixeles.length; i++){
            switch (pixeles[i]){
                case 0xff00ff00:
                    tilesCatalogo[i] = Tile.grass2;
                    continue;
                case 0xff7bc68d:
                    tilesCatalogo[i] = Tile.grass1;
                    continue;
                case 0xff784315:
                    tilesCatalogo[i] = Tile.grass3;
                    continue;
                case 0xff8a4e0f:
                    tilesCatalogo[i] = Tile.grass4;
                    continue;
                default:
                    tilesCatalogo[i] = Tile.vacio;
            }
        }
    }
}
