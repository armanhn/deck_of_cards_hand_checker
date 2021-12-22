import java.util.*;
import java.util.stream.*;


public class JavaApplication5{
    
    public static void main(String args[]) {
        String studentName = "p4nic";
        int[]deck = new int[52];
        String[] suits= {"Spades","Hearts","Clubs","Diamonds"};
        String [] ranks = {"A","2","3","4","5","6","7","8","9",
            "10","J","Q","K"};
        String[] pokerHands = {
        "Royal flush",
        "Straight flush",
        "Four of a kind",
        "Full house",
        "Flush",
        "Straight",
        "Three of a kind",
        "Two Pair",
        "Pair",
        "High Card",
        "next none yet"
        };
        System.out.println("Submitted by: "+studentName);
        Scanner input = new Scanner (System.in);
        System.out.println("\n Enter your 52 number: ");
        for(int i=0;i<deck.length;i++){
            deck[i]=input.nextInt();
        }

        System.out.println(Arrays.toString(deck)+"\n\n");
        int chunkSize = 5;
        
        String[] data = new String [52];
        int y = 0;
        for(int i = 0; i<4;i++){
            for(int j=0;j<13;j++){
                data[y] = ranks[j] + " of " + suits[i];
                y++;
            }
        }
        
        String [] final_array = new String[52];
        for(int i = 0; i<final_array.length;i++){
            final_array[i] = data[deck[i]];
        }
         
        String[][] output = splitArray(final_array, chunkSize);
            for (String[] x : output){
                if(x.length==5){
                //System.out.println();
                print_data(x,pokerHands);
            }
        }
        
            
        
    }
    
    public static String[][] splitArray(String[] final_array, int chunkSize) {
        return IntStream.iterate(0, i -> i + chunkSize)
                .limit((int) Math.ceil((double) final_array.length / chunkSize))
                .mapToObj(j -> Arrays.copyOfRange(final_array, j, Math.min(final_array.length, j + chunkSize)))
                .toArray(String[][]::new);
    }
    
    public static boolean four_of_a_kind_checker(String[] a){
        Boolean b1 = false;
        String[] arr = new String[5];
        for(int i=0;i<a.length;i++){
           String val = a[i]; 
           String[] splitter=val.split(" ");
           arr[i]= splitter[0];
        }
        
        int count=0;
        for (int i = 0; i < 4; i++){
            boolean val = arr[0].equals(arr[i+1]);
            if(val){
                count++;
            }     
        }
      if(count == 3){
          b1 = true;
      }
      return b1;
        
    }
    public static boolean three_of_a_kind_checker(String[] a){
        Boolean b1 = false;
        String[] arr = new String[5];
        for(int i=0;i<a.length;i++){
           String val = a[i]; 
           String[] splitter=val.split(" ");
           arr[i]= splitter[0];
        }
        int [] count_arr = new int[5];
        for(int i = 0;i<arr.length;i++){
            int count = 0;
            for (int j= 0; j < 5; j++){
                boolean val = arr[i].equals(arr[j]);
                if(val){
                    count++;
                }
                
            }
            count_arr[i] = count;
        }
        Arrays.sort(count_arr);
        if(count_arr[2]== 3 && count_arr[3]==3 && count_arr[4]== 3){
            b1 = true;
        }
      return b1;
        
    }
    public static boolean hand_pair_checker(String[] a){
        Boolean b1 = false;
        String[] arr = new String[5];
        for(int i=0;i<a.length;i++){
           String val = a[i]; 
           String[] splitter = val.split(" ");
           arr[i]= splitter[0];
        }
        int [] count_arr = new int[5];
 
        for(int i = 0;i<arr.length;i++){
            int count = 0;
            for (int j= 0; j < 5; j++){
                boolean val = arr[i].equals(arr[j]);
                if(val){
                    count++;
                }
                
            }
            count_arr[i] = count;
        }
        Arrays.sort(count_arr);
        
        if(count_arr[3] == 2 && count_arr[4] == 2){
            b1 = true;
        }
    return b1;
   
        
    }
    public static boolean flush_checker(String[] a){
        Boolean b1 = false;
        String[] arr = new String[5];
        for(int i=0;i<a.length;i++){
           String val = a[i]; 
           String[] splitter = val.split(" ");
           arr[i]= splitter[2];
        }
        
        int count=0;
        for (int i = 0; i < 4; i++){
            boolean val = arr[0].equals(arr[i+1]);
            if(val){
                count++;
            }     
        }
      if(count == 4){
          b1 = true;
      }
      return b1;
        
    }
    public static boolean straight_checker(String[] a){
        Boolean b1 = false;
        String[] arr = new String[5];
        for(int i=0;i<a.length;i++){
           String val = a[i]; 
           String[] splitter = val.split(" ");
           arr[i]= splitter[0];
        }
       
        for (int i = 0; i < arr.length; i++){
            if(arr[i].equals("J")){
                arr[i]="11";
            }else if(arr[i].equals("Q")){
                arr[i]="12";
            }else if(arr[i].equals("K")){
                arr[i]="13";
            }else if(arr[i].equals("A")){
                arr[i]="14";
            } 
        }
        Arrays.sort(arr);
        
        int val0=Integer.parseInt(arr[0]);
        int val1=Integer.parseInt(arr[1]);
        int val2=Integer.parseInt(arr[2]);
        int val3=Integer.parseInt(arr[3]);
        int val4=Integer.parseInt(arr[4]);
        int res1 = val0-val1;
        res1 = Math.abs(res1);
        int res2 = val0-val2;
        res2 = Math.abs(res2);
        int res3 = val0-val3;
        res3 = Math.abs(res3);
        int res4 = val0-val4;
        res4 = Math.abs(res4);
        if(res1 == 1 && res2 == 2 && res3 == 3 && res4 ==4){
            b1 = true;
        }else if(val0 == 14 && val1==2 && val2==3 && val3 == 4 && val4 == 5){
            b1 = true;
        }
        return b1;  
    }
    
    public static boolean straight_flush_checker(String[] a){
        Boolean b1 = false;
        
       boolean checker1 = flush_checker(a);
       boolean checker2 = straight_checker(a);
       
      if(checker1 && checker2){
         b1 = true;
      }
      return b1;     
    }
    
    public static boolean full_house_checker(String[] a){
        Boolean b1 = false;
       
        String[] arr = new String[5];
        for(int i=0;i<a.length;i++){
           String val = a[i]; 
           String[] splitter = val.split(" ");
           arr[i]= splitter[0];
        }
   
        int [] count_arr = new int [5];
        for(int i = 0;i<arr.length;i++){
            int count = 0;
            for (int j= 0; j < 5; j++){
                boolean val = arr[i].equals(arr[j]);
                if(val){
                    count++;
                }
                
            }
            count_arr[i] = count;
        }
        Arrays.sort(count_arr);
        if(count_arr[0] == 2 && count_arr[1] == 2 && count_arr[2] == 3 &&count_arr[3] == 3 && count_arr[4] == 3){
            b1 = true;
        }
        return b1;     
    }
    public static boolean two_pair_checker(String[] a){
        Boolean b1 = false;
        String[] arr = new String[5];
        for(int i=0;i<a.length;i++){
           String val = a[i]; 
           String[] splitter = val.split(" ");
           arr[i]= splitter[0];
        }
        int [] count_arr = new int[5];
 
        for(int i = 0;i<arr.length;i++){
            int count = 0;
            for (int j= 0; j < 5; j++){
                boolean val = arr[i].equals(arr[j]);
                if(val){
                    count++;
                }
                
            }
            count_arr[i] = count;
        }
        Arrays.sort(count_arr);
        
        if(count_arr[1] == 2 && count_arr[2] == 2 && count_arr[3] == 2 && count_arr[4] == 2){
            b1 = true;
        }
    return b1;
        
    }
    public static boolean royal_flush_checker(String[] a){
        Boolean b1 = false;
        
       boolean checker1 = flush_checker(a); 
       boolean checker2 = straight_checker(a);
       String[] arr = new String[5];
        for(int i=0;i<a.length;i++){
           String val = a[i]; 
           String[] splitter = val.split(" ");
           arr[i]= splitter[0];
        }
       
        for (int i = 0; i < arr.length; i++){
            if(arr[i].equals("J")){
                arr[i]="11";
            }else if(arr[i].equals("Q")){
                arr[i]="12";
            }else if(arr[i].equals("K")){
                arr[i]="13";
            }else if(arr[i].equals("A")){
                arr[i]="14";
            } 
        }
        Arrays.sort(arr);
       
      if(checker1 && checker2 && arr[0]== "10" && arr[4]== "14"){
         b1 = true;
      }
      return b1;     
    }
    public static boolean high_card_checker(String[] a){
        Boolean b1 = false;

        boolean checker1 = hand_pair_checker(a);
        boolean checker2 = two_pair_checker(a);
        boolean checker3 = three_of_a_kind_checker(a);
        boolean checker4 = straight_checker(a);
        boolean checker5 = flush_checker(a);
        boolean checker6= full_house_checker(a);
        boolean checker7 = four_of_a_kind_checker(a);
        boolean checker8 = straight_flush_checker(a);
        boolean checker9 = royal_flush_checker(a);
       
       
      if(!checker1 && !checker2 &&!checker3 && !checker4 && !checker5 && !checker6 &&!checker7 && !checker8 && !checker9){
         b1 = true;
      }
      return b1;     
    }
    public static void print_data(String [] a , String[] b){
        
        boolean checker=four_of_a_kind_checker(a);
        boolean checker2=three_of_a_kind_checker(a);
        boolean checker3=hand_pair_checker(a);
        boolean checker4=flush_checker(a);
        boolean checker5=straight_checker(a);
        boolean checker6=straight_flush_checker(a);
        boolean checker7=full_house_checker(a);
        boolean checker8=two_pair_checker(a);
        boolean checker9=royal_flush_checker(a);
        boolean checker10 = high_card_checker(a);
        if(!checker && !checker2 &&!checker3 && !checker4 && !checker5 && !checker6 &&!checker7 && !checker8 ){
            System.out.println(Arrays.toString(a) + " is a "+ b[0]);
        }else if(!checker && !checker2 &&!checker3 && checker4 && checker5 && !checker9 &&!checker7 && !checker8 && checker6 ){
            System.out.println(Arrays.toString(a) + " is a " + b[1]);
        }else if(!checker2 &&!checker3 && !checker4 && !checker5 && !checker9 &&!checker7 && !checker8 && !checker6){
            System.out.println(Arrays.toString(a) +  " is a "+ b[2]);
        }else if(checker7){
            System.out.println(Arrays.toString(a) +  " is a "+ b[3]);
        }else if(!checker2 &&!checker3 && !checker7 && !checker5 && !checker9 && !checker8 && !checker6 && !checker){
           System.out.println(Arrays.toString(a) +  " is a "+ b[4]);
        }else if(!checker2 &&!checker3 && !checker7 && !checker4 && !checker9 && !checker8 && !checker6 && !checker){
           System.out.println(Arrays.toString(a) +  " is a "+ b[5]);
        }else if(!checker5 &&!checker3 && !checker7 && !checker4 && !checker9 && !checker8 && !checker6 && !checker){
           System.out.println(Arrays.toString(a) +  " is a "+ b[6]);
        }else if(!checker5 && checker3 && !checker7 && !checker4 && !checker9 && !checker2 && !checker6 && !checker && checker8){
           System.out.println(Arrays.toString(a) +  " is a "+ b[7]);
        }else if(!checker5 &&!checker8 && !checker7 && !checker4 && !checker9 && !checker2 && !checker6 && !checker){
           System.out.println(Arrays.toString(a) +  " is a "+ b[8]);
        }else if(checker10){
           System.out.println(Arrays.toString(a) +  " is a "+ b[9]);
        }else{
            System.out.println(Arrays.toString(a) +  " is a "+ b[10]);
        }
   
    }
        
}
     
  
    
