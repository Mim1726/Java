import java.util.*;

class CD{
    String name;
    String extension;
    String created_date;
    String file_size;

    CD(String a,String b,String c,String d){
        name=a;
        extension=b;
        created_date=c;
        file_size=d;
    }
}
class addCD{
    CD[] cd=new CD[100];
    int cnt=0;

    void add_file(CD x){
        cd[cnt]=x;
        cnt++;
    }
}
class AudioPlayer{
    Scanner sc=new Scanner(System.in);

    void print(CD cd,String media){
        System.out.println("\n---------------------------------------");
        System.out.println("Now playing "+cd.name+cd.extension+" in "+media+".");
        System.out.println("---------------------------------------");
    }

    void player(CD cd){
        System.out.println("\nWhich media player do you want to choose?");

        System.out.println("1. VLC Media Player");
        System.out.println("2. Spotify");
        System.out.println("3. iTunes");

        System.out.print(("\nEnter your choice: "));
        int n=sc.nextInt();

        if(n==1){
            print(cd, "VLC Media Player");
        }
        else if(n==2){
            print(cd, "Spotify");
        }
        else if(n==3){
            print(cd, "iTunes");
        }
        else{
            System.out.println("You have not entered a valid input.");
        }
    }
}
class VideoPlayer{
    Scanner sc=new Scanner(System.in);

    void print(CD cd,String media){
        System.out.println("\n---------------------------------------");
        System.out.println("Now playing "+cd.name+cd.extension+" in "+media+".");
        System.out.println("---------------------------------------");
    }

    void player(CD cd){
        System.out.println("\nWhich media player do you want to choose?");

        System.out.println("1. VLC Media Player");
        System.out.println("2. Windows Media Player");
        System.out.println("3. MX Player");

        System.out.print("\nEnter your choice: ");
        int n=sc.nextInt();

        if(n==1){
            print(cd, "VLC Media Player");
        }
        else if(n==2){
            print(cd, "Windows Media Player");
        }
        else if(n==3){
            print(cd, "MX Player");
        }
        else{
            System.out.println("\nYou have not entered a valid input.");
        }
    }
}
class controller{
    AudioPlayer x=new AudioPlayer();
    VideoPlayer y=new VideoPlayer();

    void select(CD cd){
        if(cd.extension.equals(".mp4")){
            y.player(cd);
        }
        else{
            x.player(cd);
        }
    }
}
public class Main{
    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);
        addCD add=new addCD();
        controller ctrl=new controller();

        while(true){
            System.out.println("\n1. Add CD");
            System.out.println("2. Play CD");
            System.out.println("3. Exit");

            System.out.print("\nSelect an option: ");
            int n=sc.nextInt();

            if(n==1){
                sc.nextLine();
                System.out.print("\nEnter CD name: ");
                String a=sc.nextLine();

                System.out.print("Enter CD's extension: ");
                String b=sc.nextLine();

                System.out.print("Enter created date: ");
                String c=sc.nextLine();

                System.out.print("Enter file size: ");
                String d=sc.nextLine();

                CD x=new CD(a, b, c, d);
                add.add_file(x);
            }
            else if(n==2){
                if(add.cnt==0){
                    System.out.println("\nNo CDs available to play.");
                    continue;
                }

                System.out.println("\nAvailable CDs:");

                for(int i=0;i<add.cnt;i++){
                    System.out.println((i+1)+". "+add.cd[i].name+add.cd[i].extension+" "+add.cd[i].created_date+" "+add.cd[i].file_size);
                }

                System.out.print("\nWhich CD you want to play?Enter number: ");
                int choice=sc.nextInt();

                if(choice<1 || choice>add.cnt){
                    System.out.println("\nInvalid choice.");
                }
                else{
                    ctrl.select(add.cd[choice-1]);
                }
            }
            else{
                break;
            }
        }
        sc.close();
    }
}
