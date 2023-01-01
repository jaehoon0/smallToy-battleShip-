package pos;

import define.Define;

public class Pos {
    private int topLeftX;
    private int topLeftY;

    public Pos(int x, int y) {
        topLeftX=x;
        topLeftY=y;
    }

    public boolean moveTop(int distance) {
        if(topLeftY-distance<Define.MAP_TOP)
            return false;
        topLeftY-=distance;
        return true;
    }

    public boolean moveBottom(int distance) {
        if(topLeftY+distance>Define.MAP_BOTTOM)
            return false;
        topLeftY+=distance;
        return true;
    }

    public boolean moveLeft(int distance) {
        if(topLeftX-distance<Define.MAP_LEFT)
            return false;
        topLeftX-=distance;
        return true;
    }

    public boolean moveRight(int distance) {
        if(topLeftX+distance>Define.MAP_RIGHT)
            return false;
        topLeftX+=distance;
        return true;
    }

    public int[] getPos() {
        int[] poses=new int[2];
        poses[0]=topLeftX;
        poses[1]=topLeftY;
        return poses;
    }
}