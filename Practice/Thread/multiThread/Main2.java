class MyThread extends Thread{
    public void run(){
        for(int i=1;i<=5;i++){
            System.out.println("currently running "+Thread.currentThread().getName()+" - "+i);
            try{
                Thread.sleep(1);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
public class Solution{
    public static void main(String[] args){

        MyThread t1=new MyThread();
        MyThread t2=new MyThread();

        t1.setName("Thread1");
        t2.setName("Thread2");

        t1.start();
        t2.start();
    }
}
/*
output:
currently running Thread2 - 1
currently running Thread1 - 1
currently running Thread2 - 2
currently running Thread1 - 2
currently running Thread2 - 3
currently running Thread2 - 4
currently running Thread1 - 3
currently running Thread1 - 4
currently running Thread2 - 5
currently running Thread1 - 5
*/
