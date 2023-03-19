package Research;

public class Bullet extends Entity implements Runnable {
    
    public Bullet() {
        super("#cd664d");
        this.setSize(10, 10);
    }

    @Override
    public void run() {
        while (getY() != -10) {
            setLocation(getX(), getY() - 1);
            try {
                Thread.sleep(3);
            } catch (InterruptedException ex) {}
        }
    }
    
}
