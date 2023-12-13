package Graficos;

// La clase Animation maneja la secuencia de sprites
public class Animation {
    private Sprite[] frames;
    private int currentFrame;
    private long frameTimer;
    private long frameDelay;

    public Animation(Sprite[] frames, long frameDelay) {
        this.frames = frames;
        this.frameDelay = frameDelay;
        this.frameTimer = 0;
        this.currentFrame = 0;
    }

    public void update(long elapsedTime) {
        frameTimer += elapsedTime;
        if (frameTimer > frameDelay) {
            frameTimer = 0;
            currentFrame = (currentFrame + 1) % frames.length;
        }
    }

    public Sprite getCurrentFrame() {
        return frames[currentFrame];
    }
}
