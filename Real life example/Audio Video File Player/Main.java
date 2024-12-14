import java.util.*;
class CD{
    private String name;
    private String extension;
    private String date;
    private int size;

    CD(String name,String extension,String date,int size){
        this.name=name;
        this.extension=extension;
        this.date=date;
        this.size=size;
    }

    public String getType(){
        return name;
    }

    public String getExtension(){
        return extension;
    }

    public String getDate(){
        return date;
    }

    public int getSize(){
        return size;
    }
}

class AudioPlayer{

    Scanner sc = new Scanner(System.in);
    public void Play(CD cd,String media){
        System.out.println("\nNow Playing "+cd.getType()+cd.getExtension() + " in " + media + ".");
    }
    public void Player(CD cd){
        System.out.println("\nWhich media player do you want to use?");
        System.out.println("1. VLC Media Player.");
        System.out.println("2. Spotify.");
        System.out.println("3. iTunes.\n");
        System.out.print("Enter your choice: ");
        int n = sc.nextInt();
        if(n==1){
            Play(cd,"VLC Media Player");
        }
        else if(n==2){
            Play(cd,"Spotify");
        }
        else if(n==3){
            Play(cd,"iTunes");
        }
        else{
            System.out.println("You have given invalid input.");
        }
    }
}

class VideoPlayer{
    Scanner sc = new Scanner(System.in);
    public void Play(CD cd,String media){
        System.out.println("\nNow Playing "+cd.getType()+cd.getExtension() + " in " + media + ".");
    }

    public void Player(CD cd){
        System.out.println("\nWhich media player do you want to use?");
        System.out.println("1. VLC Media Player.");
        System.out.println("2. Windows Media Player.");
        System.out.println("3. MX Player.\n");
        System.out.print("Enter your choice: ");
        int n = sc.nextInt();
        if(n==1){
            Play(cd,"VLC Media Player");
        }
        else if(n==2){
            Play(cd,"Windows Media Player");
        }
        else if(n==3){
            Play(cd,"MX Player");
        }
        else{
            System.out.println("You have given invalid input.");
        }
    }
}

class Controller{ 
    AudioPlayer x = new AudioPlayer();
    VideoPlayer y = new VideoPlayer();

    public void select(CD cd){
        if(cd.getExtension()==".mp4"){
            y.Player(cd);
        }
        else{
            x.Player(cd);
        }
    }
}

public class Main{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        CD[] arr = {
            new CD("Album1", ".mp3", "2024-11-23", 5),
            new CD("Album2", ".mp3", "2024-11-23", 7),
            new CD("Album3", ".mp3", "2024-11-23", 8),
            new CD("Video1", ".mp4", "2024-11-23", 13),
            new CD("Video2", ".mp4", "2024-11-23", 17),
            new CD("Video3", ".mp4", "2024-11-23", 20),
        };
    
        System.out.println("Which album do you want to play?");
        System.out.println("1. Album1.mp3  date created:2024-11-23  size:5");
        System.out.println("2. Album2.mp3  date created:2024-11-23  size:7");
        System.out.println("3. Album3.mp3  date created:2024-11-23  size:8");
        System.out.println("4. Video1.mp4  date created:2024-11-23  size:13");
        System.out.println("5. Video2.mp4  date created:2024-11-23  size:17");
        System.out.println("6. Video3.mp4  date created:2024-11-23  size:20\n");
        System.out.print("Enter album's number: ");

        int n = sc.nextInt();

        Controller c = new Controller();
        c.select(arr[n-1]);

        sc.close();
    }
}
