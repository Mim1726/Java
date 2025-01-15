import java.util.*;
public class Main{
    static void usingLists(){
        List list=new ArrayList<>();
        list.add("color");
        list.add(10.5);
        list.add('a');
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
    public static void main(String[] args){
        usingLists();
    }
}
