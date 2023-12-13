package Graficos;

public class Animation {
    private int frameActual;
    private long tiempoUltimoFrame, retrasoFrame;
    private Sprite[] frames;

    // Constructor de la clase Animation
    public Animation(Sprite[] frames, long retrasoFrame) {
        this.frames = frames;
        this.retrasoFrame = retrasoFrame;
        this.frameActual = 0;
        this.tiempoUltimoFrame = 0;
    }

    // Método para actualizar la animación
    public void actualizar(long tiempoActual) {
        if (tiempoActual - tiempoUltimoFrame > retrasoFrame) {
            frameActual++;
            if (frameActual >= frames.length) {
                frameActual = 0;
            }
            tiempoUltimoFrame = tiempoActual;
        }
    }

    // Método para obtener el sprite actual de la animación
    public Sprite getSpriteActual() {
        return frames[frameActual];
    }

    // Getters y Setters si son necesarios
}

