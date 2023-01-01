package ship;

import java.util.Scanner;

import define.Define;

public class SmallShip extends Ship {    
    public SmallShip() {
        vertical=Define.SMALL_SHIP_VER;
        horizontal=Define.SMALL_SHIP_HOR;
        durability=Define.SMALL_SHIP_DURABILITY;
    }

    @Override    
    public void move() {
        while(true) {
            System.out.println("움직일 방향을 선택하세요\n");
            System.out.println(Define.DIVIDER);
            System.out.println("1. 위\n");
            System.out.println("2. 아래\n");
            System.out.println("3. 오른쪽\n");
            System.out.println("4. 왼쪽\n");
            Scanner scan=new Scanner(System.in);
            int direction=scan.nextInt();
    
            boolean isAvail=false;
            switch(direction) {
                case 1:
                    if(pos.moveTop(Define.SMALL_SHIP_MOVE))
                        isAvail=true;
                    break;
                case 2:
                    if(pos.moveBottom(Define.SMALL_SHIP_MOVE))
                        isAvail=true;
                    break;
                case 3:
                    if(pos.moveRight(Define.SMALL_SHIP_MOVE))
                        isAvail=true;
                    break;
                case 4:
                    if(pos.moveLeft(Define.SMALL_SHIP_MOVE))
                        isAvail=true;
                    break;                    
            }

            if(isAvail)
                break;
            System.out.println("그 방향으로 움직일 수 없습니다...!\n");
        }
    }

    @Override    
    public void shoot(Ship ship) {
        System.out.println("공격할 좌표를 입력해 주세요(x y): ");
        Scanner scan=new Scanner(System.in);
        int x=scan.nextInt(), y=scan.nextInt();
        if(ship.hit(x, y)) {
            ship.damaged(Define.SMALL_SHIP_FORCE);
        }
        launchTimes++;
    }

    @Override
    public void showInfo() {
        System.out.println(Define.DIVIDER);
        System.out.println("<조그마한 배>\n");
        System.out.println("위치(x, y) : "+pos.getPos()[0]+", "+pos.getPos()[1]+"\n");
        System.out.println("크기: "+Define.SMALL_SHIP_HOR+"*"+Define.SMALL_SHIP_VER+"\n");
        System.out.println("내구도: "+durability+"/"+Define.SMALL_SHIP_DURABILITY+"\n");
        System.out.println("기동 범위: "+Define.SMALL_SHIP_MOVE+"\n");
        System.out.println("대포 성능: "+Define.SMALL_SHIP_FORCE+"\n");
        System.out.println("이어서 플레이하려면 엔터를 눌러주세요...\n");
        Scanner scan=new Scanner(System.in);
        scan.nextLine();
    }
    

    @Override
    public void search(Ship ship) {
        System.out.println("적을 수색중입니다...\n");
        System.out.println("적의 정보는 자신의 배 기준으로 상하 또는 좌우로 떨어진 거리 중 더 가까운 방향 정보 하나만 제공됩니다.\n");
        int enemyX=ship.pos.getPos()[0], enemyY=ship.pos.getPos()[1];
        int myX=this.pos.getPos()[0], myY=this.pos.getPos()[1];
        
        if(Math.abs(enemyX-myX)>Math.abs(enemyY-myY)) {
            if(enemyY<myY) {
                System.out.println("적은 우리 배보다 위쪽에 있습니다\n");
            }
            else {
                System.out.println("적은 우리 배보다 아래쪽 혹은 같은 높이에 있습니다\n");
            }
        }
        else {
            if(enemyX<myX) {
                System.out.println("적은 우리 배보다 왼쪽에 있습니다\n");
            }
            else {
                System.out.println("적은 우리 배보다 오른쪽 혹은 같은 너비에 있습니다\n");
            }
        }
        searchTimes++;
        System.out.println("이어서 플레이하려면 엔터를 눌러주세요...\n");
        Scanner scan=new Scanner(System.in);
        scan.nextLine();
    }
}