package mapa.tiles;

import graficos.Pantalla;
import graficos.Sprite;

public abstract class Tile {
    public int x;
    public int y;
    public Sprite sprite;

    // Colección de tiles
    public static final Tile prueba = new TilePrueba(Sprite.prueba);

    // Fin colección de tiles

    public Tile(Sprite sprite) {
        this.sprite = sprite;
    }
    public void mostrar(int x, int y, Pantalla pantalla){
    }
    public boolean solido(){
        return false;
    }
}
