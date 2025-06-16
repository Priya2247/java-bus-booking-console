import java.util.*;
import java.text.*;
class Bus{
    private int BusNo;
    private int Capacity;
    private boolean AC;
    Bus(int n,int c,boolean a){
        this.BusNo=n;
        this.Capacity=c;
        this.AC=a;
    }
    public int getBusNo() {return BusNo;}
    public void setBusNo(int n){ BusNo=n;}
    public int getCapacity(){ return Capacity;}
    public void setCapacity(int n){ Capacity=n;}
    public boolean getAC(){ return AC;}
    public void setAC(boolean ac) {AC=ac;}
    public void display(){
        System.out.println("--------------------------------------------");
        System.out.println();
        System.out.println("The bus No is "+BusNo+"\nIts Capacity is "+Capacity+"\nIt contain AC is "+AC);
        System.out.println();
        System.out.println("--------------------------------------------");
        
    }
}

class Booking{
    Scanner sc=new Scanner(System.in);
    String PassengerName;
    int BusNo;
    String From;
    String To;
    Date date;
    Booking(){
        System.out.println("Enter your name Please?");
        PassengerName=sc.nextLine();
        System.out.println("Enter the busNo");
        BusNo=sc.nextInt();
        while(true){
        System.out.println("Enter the date you want to make the journey in the format dd-MM-yyyy");
        String d=sc.next();
        SimpleDateFormat s=new SimpleDateFormat("dd-MM-yyyy");
        try{
        date=s.parse(d);
        break;
        }
        catch(Exception e){
            System.out.println("Date format is not correct");
        }
        }
    }
    public boolean isAvailable(ArrayList<Bus> buses,ArrayList<Booking> booking){
        int capacity=0;
        int count=0;
        for(Bus b:buses){
            if(b.getBusNo()==BusNo){
                capacity=b.getCapacity();
                break;
                }
        }
        for(Booking b:booking){
            if(b.BusNo==BusNo && b.date.equals(date)) count++;
        }
        return (count<capacity)?true:false;
    }
    
}
public class Main{
   static  ArrayList<Bus> buses=new ArrayList<>();
    static ArrayList<Booking> booking=new ArrayList<>();
    public static void display(){
        for(Bus b:buses){
            b.display();
        }
    }
    public static void main(String args[]){
        buses.add(new Bus(1,50,true));
        buses.add(new Bus(2,2,false));
        Scanner sc=new Scanner(System.in);
        int user=1;
        while(user==1){
            System.out.println("Enter 1 to book and 2 to stop");
            user=sc.nextInt();
            if(user==1){
                display();
                Booking b=new Booking();
                if(b.isAvailable(buses,booking)){
                    booking.add(b);
                    System.out.println("Booking confirmed!!!!");
                }
                else{
                    System.out.println("Booking is full sorry! :( check another dates availability");
                }
                
            }
        }
    }
}