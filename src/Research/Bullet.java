package Research;

public class Bullet extends Entity implements Runnable {
    
    private int x;
    private int y;
    
    private int degree;
    public float radius;
    
    private int direction;
    
    public Bullet() {
        super("#cd664d");
        setSize(10, 10);
    }
    
    public void SetDirection(int direction) {
        this.direction = direction;
    }
    
    public boolean InEdge() {
        int a = getX();
        int b = getY();
        return (-10 <= a && a <= 500 + 10) &&
               (-10 <= b && b <= 800 + 10);
    }
    
    public void Move() {
        switch (direction) {
            case 1: {
                setLocation(x, getY() - 1);
                break;
            }
            case 2: {
                float a = (float) Math.cos(degree * Math.PI / 180.0) * radius;
                float b = (float) Math.sin(degree * Math.PI / 180.0) * radius;
                setLocation(x + Math.round(a), y + Math.round(b));
                break;
            }
        }
    }

    @Override
    public void run() {
        x = getX();
        y = getY();
        degree = 0;
        radius = 5;
        while (InEdge()) {
            this.Move();
            try {
                Thread.sleep(3);
            } catch (Exception ex) {}
            radius = radius + 0.1f;
            degree = degree + 1;
            if (degree % 360 == 0) {
                y = y - 0;
            }
        }
    }
    
}
