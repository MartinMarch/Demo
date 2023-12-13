package control;

import java.awt.event.KeyEvent;

public final class Keyboard implements java.awt.event.KeyListener {
    private final static int numeroTeclas = 120;
private final boolean[] teclas = new boolean[numeroTeclas];
    public boolean arriba;
    public boolean abajo;
    public boolean izquierda;
    public boolean derecha;

    public void actualizar() {
        arriba = teclas[KeyEvent.VK_W];
        abajo = teclas[KeyEvent.VK_S];
        izquierda = teclas[KeyEvent.VK_A];
        derecha = teclas[KeyEvent.VK_D];
    }




    @Override
    public void keyPressed(KeyEvent keyEvent) {
        teclas[keyEvent.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        teclas[keyEvent.getKeyCode()] = false;
    }
    @Override
    public void keyTyped(KeyEvent keyEvent) {
    }
}
