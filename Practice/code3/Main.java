public class Main{
    public static void main(String[] args){
        int a=10,b=0;
        try{
            int ans=a/b;
            System.out.println(ans);
        } catch(ArithmeticException e){
            System.out.println("An error occured: "+e.getMessage());
        } 
        finally{
            System.out.println("Cleaning up resources...");
        }
        System.out.println("Program continues...");
    }
}
