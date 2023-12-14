package graficos;

import mapa.tiles.Tile;

public class Pantalla {
    private final int ancho;
    private final int alto;
    private int diferenciaX;
    private int diferenciaY;

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

    public void mostrarTile(int compensacionX, int compensacionY, Tile tile){
        compensacionX -= diferenciaX;
        compensacionY -= diferenciaY;

        for(int y = 0; y < tile.sprite.getLado(); y++){
            int posicionY = y + compensacionY;
            for(int x = 0; x < tile.sprite.getLado(); x++){
                int posicionX = x + compensacionX;
                if(posicionX < -tile.sprite.getLado() || posicionX >= ancho || posicionY < 0 || posicionY >= alto) {
                    break;
                }
                if (posicionX <0){
                    posicionX = 0;
                }
                pixeles[posicionX + posicionY * ancho] = tile.sprite.pixeles[x + y * tile.sprite.getLado()];
            }
        }
    }
    public void setDiferencia(final int diferenciaX, final int diferenciaY){
        this.diferenciaX = diferenciaX;
        this.diferenciaY = diferenciaY;
    }

    public int getAncho(){
        return ancho;
    }
    public int getAlto(){
        return alto;
    }

}

