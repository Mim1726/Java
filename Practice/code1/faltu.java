class solution{
    solution(){
        System.out.println("first");
    }
    void array(){
        int arr[]={2,6,7,8};
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println("\n**********************");
        for(var x:arr){
            System.out.print(x+" ");
        }
    }
    void multArr() {
        int v1[][] = new int[4][5];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                v1[i][j] = i * j;
            }
        }
        System.out.println();
        System.out.println("\n**********************");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                if(j!=0) System.out.print(" ");
                System.out.print(v1[i][j]);
            }
            System.out.println();
        }
    }    
    
}
public class faltu{
    public static void main(String[] args){
        solution s=new solution();
        s.array();
        s.multArr();
    }
}
