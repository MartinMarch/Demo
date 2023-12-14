package mapa;

import graficos.Pantalla;
import mapa.tiles.Tile;
import mapa.tiles.TileVacio;

public abstract class Mapa {
    protected int ancho;
    protected int alto;
    protected int[] Tiles;
    protected Tile[] tilesCatalogo;

    public Mapa(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
        Tiles = new int[ancho * alto];
        generarMapa();
    }

    public Mapa(String ruta) {
        cargarMapa(ruta);
        generarMapa();
    }

    protected void generarMapa() {
    }

    protected void cargarMapa(String ruta) {
    }

    public void actualizar() {
    }

    public void mostrar(int compensacionX, int compensacionY, Pantalla pantalla) {

        pantalla.setDiferencia(compensacionX, compensacionY);

        int o = compensacionX >> 5;
        int e = (compensacionX + pantalla.getAncho() + Tile.LADO_SPRITE) >> 5;
        int n = compensacionY >> 5;
        int s = (compensacionY + pantalla.getAlto() + Tile.LADO_SPRITE) >> 5;

        for (int y = n; y < s; y++) {
            for (int x = o; x < e; x++) {
                //obtenerTile(x, y).mostrar(x, y, pantalla);
                if (x < 0 || y < 0 || x >= ancho || y >= alto) {
                    Tile.vacio.mostrar(x, y, pantalla);
                } else {
                    tilesCatalogo[x + y * ancho].mostrar(x, y, pantalla);
                }
            }
        }
    }

    public Tile obtenerTile(int x, int y) {
        if (x < 0 || x >= ancho || y < 0 || y >= alto) {
            return Tile.vacio;
        }
        switch (Tiles[x + y * ancho]) {
            case 0:
                return Tile.grass1;
            case 1:
                return Tile.grass2;
            case 2:
                return Tile.grass3;
            case 3:
                return Tile.grass4;
            default:
                return Tile.vacio;
        }
    }



}
