package entities;
import java.awt.*;
import graficos.Sprite;

public class Jugador {
    private int x, y;
    private int velocidad;
    private Animation animacionActual;
    private Sprite[] spritesMovimiento;

    public Jugador(int x, int y, Sprite[] spritesMovimiento, long frameDelay) {
        this.x = x;
        this.y = y;
        this.spritesMovimiento = spritesMovimiento;
        this.animacionActual = new Animation(spritesMovimiento, frameDelay);
    }

    public void mover(char direccion, int velocidad) {
        this.velocidad = velocidad;
        switch (direccion) {
            case 'A': // Izquierda
                x -= velocidad;
                animacionActual.setFrames(new Sprite[]{Sprite.knightOeste0, Sprite.knightOeste1, Sprite.knightOeste2});
                break;
            case 'D': // Derecha
                x += velocidad;
                animacionActual.setFrames(new Sprite[]{Sprite.knightEste0, Sprite.knightEste1, Sprite.knightEste2});
                break;
            case 'W': // Arriba
                y -= velocidad;
                animacionActual.setFrames(new Sprite[]{Sprite.knightNorte0, Sprite.knightNorte1, Sprite.knightNorte2});
                break;
            case 'S': // Abajo
                y += velocidad;
                animacionActual.setFrames(new Sprite[]{Sprite.knightSur0, Sprite.knightSur1, Sprite.knightSur2});
                break;
        }
        animacionActual.actualizar(System.currentTimeMillis());
    }


    public void dibujar(Graphics g) {
        // Obtener el sprite actual de la animación.
        Sprite spriteActual = animacionActual.getSpriteActual();

        // Verificar que el sprite actual no es nulo
        if (spriteActual != null) {
            Image imagen = spriteActual.obtenerImagen();
            if (imagen != null) {
                // Dibujar el sprite en la posición actual del jugador.
                g.drawImage(imagen, x, y, null);
            } else {
                // Opcional: Manejar el caso en que la imagen no se haya cargado correctamente.
                System.out.println("Imagen del sprite no encontrada");
            }
        } else {
            // Opcional: Manejar el caso en que el sprite actual sea nulo.
            System.out.println("Sprite actual es nulo");
        }
    }
}


/*public class Jugador {
    private int x, y;
    private Image[] imagenes;
    private int indiceImagenActual;
    private char ultimaDireccion = ' ';
    private int[] option;
    private int i = 0;



    public Jugador(int x, int y, String[] rutasImagenes) {
        this.option = new int[3];
        for(int i = 0; i < 3; i++){
            option[i] = i;
        }

        this.x = x;
        this.y = y;
        this.imagenes = new Image[rutasImagenes.length];
        for (int i = 0; i < rutasImagenes.length; i++) {
            this.imagenes[i] = new ImageIcon(rutasImagenes[i]).getImage();
        }
        this.indiceImagenActual = 0; // Inicia con la primera imagen
    }

    public void mover(char direccion, int velocidad) {
        if (ultimaDireccion != direccion) {
            ultimaDireccion = direccion;
            if (direccion == 'A') indiceImagenActual = 2;
            if (direccion == 'D') indiceImagenActual = 3;
            if (direccion == 'W') indiceImagenActual = 1;
            if (direccion == 'S') indiceImagenActual = 0;
        } else if (direccion == 'S') {
            if(i == 3){i = 0;}if (option[i] == 0) {indiceImagenActual = 4;} else if (option[i] == 1) {indiceImagenActual = 0;} else if (option[i] == 2) {indiceImagenActual = 5; }i++;
        }else if (direccion == 'D') {
            if(i == 3){i = 0;}if (option[i] == 0) {indiceImagenActual = 6;} else if (option[i] == 1) {indiceImagenActual = 3;} else if (option[i] == 2) {indiceImagenActual = 7; }i++;
        }else if (direccion == 'A') {
            if(i == 3){i = 0;}if (option[i] == 0) {indiceImagenActual = 8;} else if (option[i] == 1) {indiceImagenActual = 2;} else if (option[i] == 2) {indiceImagenActual = 9; }i++;
        }else if (direccion == 'W') {
            if(i == 3){i = 0;}if (option[i] == 0) {indiceImagenActual = 10;} else if (option[i] == 1) {indiceImagenActual = 1;} else if (option[i] == 2) {indiceImagenActual = 11; }i++;
        }


        switch (direccion) {
                case 'A':
                    x -= velocidad;
                    break;
                case 'D':
                    x += velocidad;
                    break;
                case 'W':
                    y -= velocidad;
                    break;
                case 'S':
                    y += velocidad;
                    break;
            }
        }

        public void dibujar (Graphics g){
            g.drawImage(imagenes[indiceImagenActual], x, y, null);
        }

        // Métodos getters y setters para x, y...
    }*/



