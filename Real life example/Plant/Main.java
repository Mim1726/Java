import java.util.*;
class Plant{
    String root_type;
    String body_type;
    String colour;
    String name;

    Plant(String a,String b,String c,String d){
        root_type=a;
        body_type=b;
        colour=c;
        name=d;
    }
}
class Identification{

    Plant[] pArr=new Plant[100];
    int cnt;

    void addPlant(Plant p){
        pArr[cnt]=p;
        cnt++;
    }

    void searching(String s){
        for(int i=0;i<cnt;i++){
            if(s.equals(pArr[i].name)){
                System.out.println("Plant information:");
                System.out.println("************************");
                System.out.println("Plant name: "+pArr[i].name);
                System.out.println("Plant root_type: "+pArr[i].root_type);
                System.out.println("Plant body_type: "+pArr[i].body_type);
                System.out.println("Plant color: "+pArr[i].colour);
                return;
            }
        }
        System.out.println("Plant not found");
    }
}
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Identification x=new Identification();
        Plant p=new Plant("Upper Root", "Thick", "Green", "Kormocha");
        x.addPlant(p);
        String s=sc.nextLine();
        x.searching(s);
    }
}
