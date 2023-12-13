package Entities;
import java.awt.*;
import javax.swing.ImageIcon;

import java.awt.Image;
import javax.swing.ImageIcon;

import java.awt.*;
import Graficos.Sprite;

public class Jugador {
    private int x, y;
    private Sprite spriteActual;
    // Supongamos que tienes sprites para cada dirección y acción
    private Sprite[] spritesMovimiento;

    public Jugador(int x, int y, Sprite[] spritesMovimiento) {
        this.x = x;
        this.y = y;
        this.spritesMovimiento = spritesMovimiento;
        this.spriteActual = spritesMovimiento[0]; // Iniciar con un sprite por defecto
    }

    public void mover(char direccion, int velocidad) {
        // Cambia el spriteActual según la dirección y la acción
        // ...
    }

    public void dibujar(Graphics g) {
        g.drawImage(spriteActual.obtenerImagen(), x, y, null);
    }

    // Método en Sprite para obtener la imagen
    public Image obtenerImagen() {
        // Convierte el array de píxeles a una imagen
        // ...
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



