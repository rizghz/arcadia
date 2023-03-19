package Research;

import javax.swing.Timer;

public class Bullet extends Entity implements Runnable {
    
    private int absis;
    private int ordinat;
    
    private int degree;
    private float radius;
    
    private int mode;
    
    public Bullet() {
        super("#cd664d");
        setSize(10, 10);
    }
    
    public void SetMode(int mode) {
        this.mode = mode;
    }
    
    public boolean InEdge() {
        absis = getX();
        ordinat = getY();
        return (-10 <= absis && absis <= 500 + 10) &&
               (-10 <= ordinat && ordinat <= 800 + 10);
    }
    
    public void Move() {
        absis = getX();
        ordinat = getY();
        switch (mode) {
            case 1: {
                setLocation(absis, ordinat - 1);
                break;
            }
            case 2: {
                int x = (int) Math.round(Math.cos(degree * Math.PI / 180.0) * radius);
                int y = (int) Math.round(Math.sin(degree * Math.PI / 180.0) * radius);
                setLocation(absis + x, ordinat + y);
                break;
            }
        }
    }

    @Override
    public void run() {
        degree = 0;
        radius = 1;
        while (InEdge()) {
            Move();
            try {
                Thread.sleep(3);
            } catch (InterruptedException ex) {}
//            radius = radius + 0.1f;
            degree = degree + 1;
        }
    }
    
}
