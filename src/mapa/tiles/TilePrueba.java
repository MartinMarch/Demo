package mapa.tiles;

import graficos.Pantalla;
import graficos.Sprite;

public class TilePrueba extends Tile {
    public TilePrueba(Sprite sprite) {
        super(sprite);
    }
    public void mostrar(int x, int y, Pantalla pantalla){
        pantalla.mostrarTile(x, y, this);
    }
}
