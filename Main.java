import java.util.Scanner;

import ship.Ship;
import ship.SmallShip;
import define.Define;

public class Main {
    public static void main(String[] args) {
        SmallShip enemy=new SmallShip();
        SmallShip my=new SmallShip();
        
        while(!enemy.isDestruction()) {
            System.out.println("명령을 내려주세요\n");
            System.out.println(Define.DIVIDER);
            System.out.println("1. 이동한다\n");
            System.out.println("2. 공격한다\n");
            System.out.println("3. 배의 정보를 본다\n");
            System.out.println("4. 적을 수색한다\n");
            Scanner scan=new Scanner(System.in);
            int order=scan.nextInt();
            
            System.out.println("\n");
            System.out.println(Define.DIVIDER);
            System.out.println("\n");
            
            if(order==1) {
                my.move();
            }
            else if(order==2) {
                my.shoot(enemy);
            }
            else if(order==3) {
                my.showInfo();
            }
            else if(order==4) {
                my.search(enemy);
            }
            System.out.println("\n");
            System.out.println(Define.DIVIDER);
            System.out.println("\n");
        }
        System.out.println("\n");
        System.out.println(Define.DIVIDER);
        System.out.println("당신은 "+my.getLaunchTimes()+"번의 발사 / "+my.getSearchTimes()+"번의 수색 끝에 적을 처치했습니다...!");
        System.out.println(Define.DIVIDER);
        System.out.println("\n");
    }    
}