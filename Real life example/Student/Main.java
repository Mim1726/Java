import java.util.*;
class Student{
    String name;
    int roll;
    int attendance[];

    Student(String s,int n,int arr[]){
        name=s;
        roll=n;
        attendance=arr;
    }

    float percentage(){
        int cnt=0;
        for(int i=0;i<7;i++){
            if(attendance[i]==1){
                cnt++;
            }
        }
        return ((float)cnt/7)*100;
    }
    void display(){
        System.out.println("Name: "+name);
        System.out.println("Roll Number: "+roll);
        System.out.println("Attendance Percentage: "+percentage()+"%");
    }
}
class findStudent{
    Scanner sc=new Scanner(System.in);
    List<Student> st=new ArrayList<>();

    void addStudent(){
        System.out.print("Enter name: ");
        sc.nextLine();
        String s=sc.nextLine();

        System.out.print("Enter roll: ");
        int n=sc.nextInt();

        int[] arr=new int[7];
        System.out.print("Enter attendance of 7 days(1 for present,0 for absent): ");
        for(int i=0;i<7;i++){
            arr[i]=sc.nextInt();
        }

        st.add(new Student(s, n, arr));
        System.out.println("Student added successfully!\n");
    }

    void viewAttendance(){
        if(st.isEmpty()){
            System.out.println("No students have been added yet.");
            return;
        }
        System.out.println("Student Attendance details:");
        for(Student s:st){
            s.display();
            System.out.println("----------------------------");
        }
    }
    void select(){
        while(true){
            System.out.println("\n1. Add student");
            System.out.println("2. View attendance");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int n=sc.nextInt();
            if(n==1){
                addStudent();
            }
            else if(n==2){
                viewAttendance();
            }
            else if(n==3){
                System.out.println("Exiting...");
                sc.close();
                return;
            }
            else{
                System.out.println("Invalid input. Please try again");
            }
        }
    }
}
public class Main{
    public static void main(String[] args){
        findStudent x=new findStudent();
        x.select();
    }
}
