package ship;

import java.util.Random;
import pos.Pos;
import define.Define;

public abstract class Ship {
    protected Pos pos;
    protected int launchTimes;
    protected int searchTimes;
    protected int horizontal;
    protected int vertical;
    protected int durability;

    public Ship() {
        Random gen=new Random();
        int x=gen.nextInt(Define.MAP_RIGHT+1);
        int y=gen.nextInt(Define.MAP_BOTTOM+1);
        pos=new Pos(x, y);        
        launchTimes=0;        
        searchTimes=0;
    }

    public abstract void move();
    
    public abstract void shoot(Ship ship);

    public abstract void showInfo();

    public abstract void search(Ship ship);
    
    public boolean hit(int x, int y) {
        int[] poses=pos.getPos();
        int posX=poses[0];
        int posY=poses[1];
        if(x>=posX && x<=posX+horizontal && y>=posY && y<=posY+vertical)
            return true;
        return false;
    }

    public void damaged(int force) {
        System.out.println("배가 공격을 받음\n");
        durability-=force;
        if(durability<=0)
            System.out.println("배가 침몰함\n");
    }

    public boolean isDestruction() {
        return durability<=0;
    }

    public int getLaunchTimes() {
        return launchTimes;
    }

    public int getSearchTimes() {
        return searchTimes;
    }
}