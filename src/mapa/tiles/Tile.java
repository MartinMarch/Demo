package mapa.tiles;

import graficos.Pantalla;
import graficos.Sprite;

public abstract class Tile {
    public int x;
    public int y;
    public Sprite sprite;

    public static final int LADO_SPRITE = 32;

    // Colección de tiles
    public static final Tile prueba = new TilePrueba(Sprite.prueba);
    public static final Tile vacio = new TileVacio(Sprite.vacio);
    public static final Tile grass1 = new Grass1(Sprite.grass1);
    public static final Tile grass2 = new Grass2(Sprite.grass2);
    public static final Tile grass3 = new Grass3(Sprite.grass3);
    public static final Tile grass4 = new Grass4(Sprite.grass4);



    // Fin colección de tiles

    public Tile(Sprite sprite) {
        this.sprite = sprite;
    }
    public void mostrar(int x, int y, Pantalla pantalla){
        pantalla.mostrarTile(x << 5, y <<5, this);
    }
    public boolean solido(){
        return false;
    }
}
