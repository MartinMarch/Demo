package graficos;

import mapa.tiles.Tile;

public class Pantalla {
    private final int ancho;
    private final int alto;
    //temporales
    private final static int LADO_SPRITE = 32;
    private final static int MASCARA_SPRITE = LADO_SPRITE - 1;
    //fin temporales
    public final int[] pixeles;

    public Pantalla(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;

        pixeles = new int[ancho * alto];
    }

    public void limpiar() {
        for (int i = 0; i < pixeles.length; i++) {
            pixeles[i] = 0; // Establece el color de los pixeles a negro (o al color de fondo deseado)
        }
    }

    public void mostrar(final int compensacionX, final int compensacionY){
        for(int y = 0; y < alto; y++){
            int posicionY = y + compensacionY;
            if(posicionY < 0 || posicionY >= alto){
                continue;
            }
            for(int x = 0; x < ancho; x++){
                int posicionX = x + compensacionX;
                if(posicionX < 0 || posicionX >= ancho){
                    continue;
                }
                //Temporal
                pixeles[posicionX + posicionY * ancho] = Sprite.grass1.pixeles[(x & MASCARA_SPRITE) + (y & MASCARA_SPRITE) * LADO_SPRITE];
            }
        }
    }

    public void mostrarTile(int compensacionX, int compensacionY, Tile tile){
        for(int y = 0; y < tile.sprite.getLado(); y++){
            int posicionY = y + compensacionY;
            for(int x = 0; x < tile.sprite.getLado(); x++){
                int posicionX = x + compensacionX;
                if(posicionX < 0 || posicionX > ancho || posicionY < 0 ||posicionY > alto) {
                    break;
                }
                pixeles[posicionX + posicionY * ancho] = tile.sprite.pixeles[x + y * tile.sprite.getLado()];
            }
        }
    }

}

