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
                System.out.println("------------------");
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

        while(true){
            System.out.println("1. Add Plant");
            System.out.println("2. Show Plant's Info");
            System.out.println("3. Exit");
            System.out.print("Select an option: ");

            int n=sc.nextInt();

            if(n==1){
                sc.nextLine();
                System.out.print("Enter plant's name: ");
                String d=sc.nextLine();

                System.out.print("Enter plant's root_type: ");
                String a=sc.nextLine();

                System.out.print("Enter plant's body_type: ");
                String b=sc.nextLine();

                System.out.print("Enter plant's colour: ");
                String c=sc.nextLine();

                Plant p=new Plant(a, b, c, d);
                x.addPlant(p);
            }
            else if(n==2){
                sc.nextLine();
                System.out.print("Enter plant's name: ");
                String s=sc.nextLine();
                x.searching(s);
            }
            else{
                break;
            }
            System.out.println("***********************************");
        }
    }
}
