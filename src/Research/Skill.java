package Research;

public class Skill {
    
    private Bullet[] cluster;
    private int mode;

    public Skill(Entity e, Frame f) {
        cluster = new Bullet[32];
    }
    
    public void SetMode(int mode) {
        this.mode = mode;
    }
    
    public int GetMode() {
        return this.mode;
    }
    
    public void Basic(Frame f) {
        cluster[0] = new Bullet();
        cluster[0].setLocation (
            (f.player.getX()) + (f.player.getWidth()  / 2) - (cluster[0].getWidth() / 2), 
            (f.player.getY()) + (f.player.getHeight() / 2) - (cluster[0].getHeight())
        );
        cluster[0].SetDirection(1);
        f.add(cluster[0]);
        f.bullet.add(new Thread(cluster[0]));
        f.bullet.getLast().start();
        f.add(f.background);
    }
    
    public void Special(Frame f) {
        int i = 0;
//        while (i < 8) {
            cluster[i] = new Bullet();
            cluster[i].setLocation (
                (f.player.getX()) + (f.player.getWidth()  / 2) - (cluster[i].getWidth() / 2), 
                (f.player.getY()) + (f.player.getHeight() / 2) - (cluster[i].getHeight())
            );
            cluster[i].SetDirection(2);
            f.add(cluster[i]);
            f.bullet.add(new Thread(cluster[i]));
            f.bullet.getLast().start();
            f.add(f.background);
            i++;
//        }
    }
    
}
