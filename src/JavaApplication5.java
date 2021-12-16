import java.util.*;
import java.util.stream.*;


public class JavaApplication5{
    
    public static void main(String args[]) {
        int[] inputArray = {10,36,23,49,6,1,16,2,3,4,28,15,11,24,12,9,21,34,8,5,7,20,33,14,27,
            40,0,17,29,41,44,43,45,46,47,37,25,22,35,19,26,30,32,31,38,50,51,39,42,48,13,18};
        int chunkSize = 5;
        
        String[] data = {"A of spades","2 of spades","3 of spades","4 of spades","5 of spades","6 of spades","7 of spades","8 of spades"
        ,"9 of spades","10 of spades","J of spades","Q of spades","K of spades",
        "A of hearts","2 of hearts","3 of hearts","4 of hearts","5 of hearts","6 of hearts","7 of hearts","8 of hearts"
        ,"9 of hearts","10 of hearts","J of hearts","Q of hearts","K of hearts",
        "A of clubs","2 of clubs","3 of clubs","4 of clubs","5 of clubs","6 of clubs","7 of clubs","8 of clubs"
        ,"9 of clubs","10 of clubs","J of clubs","Q of clubs","K of clubs",
        "A of diamonds","2 of diamonds","3 of diamonds","4 of diamonds","5 of diamonds","6 of diamonds","7 of diamonds","8 of diamonds"
        ,"9 of diamonds","10 of diamonds","J of diamonds","Q of diamonds","K of diamonds"};
        
        String [] final_array = new String[52];
        for(int i = 0; i<final_array.length;i++){
            final_array[i] = data[inputArray[i]];
        }
         
        String[][] output = splitArray(final_array, chunkSize);
            for (String[] x : output){
                if(x.length==5){
                //System.out.println();
                print_data(x);
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
        
       boolean checker1 = hand_pair_checker(a);
       boolean checker2 = three_of_a_kind_checker(a);
       
      if(checker1 && checker2){
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
    public static void print_data(String [] a){
        
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
            System.out.println(Arrays.toString(a) + " is a Royal Flush");
        }else if(!checker && !checker2 &&!checker3 && checker4 && checker5 && !checker9 &&!checker7 && !checker8 && checker6 ){
            System.out.println(Arrays.toString(a) + " is a Straight Flush");
        }else if(!checker2 &&!checker3 && !checker4 && !checker5 && !checker9 &&!checker7 && !checker8 && !checker6){
            System.out.println(Arrays.toString(a) + " is a Four of a Kind");
        }else if(checker2 && checker3 && !checker4 && !checker5 && !checker9 && !checker8 && !checker6 && !checker){
            System.out.println(Arrays.toString(a) + " is a Full house");
        }else if(!checker2 &&!checker3 && !checker7 && !checker5 && !checker9 && !checker8 && !checker6 && !checker){
           System.out.println(Arrays.toString(a) + " is a Flush");
        }else if(!checker2 &&!checker3 && !checker7 && !checker4 && !checker9 && !checker8 && !checker6 && !checker){
           System.out.println(Arrays.toString(a) + " is a Straight");
        }else if(!checker5 &&!checker3 && !checker7 && !checker4 && !checker9 && !checker8 && !checker6 && !checker){
           System.out.println(Arrays.toString(a) + " is a three of a Kind");
        }else if(!checker5 && checker3 && !checker7 && !checker4 && !checker9 && !checker2 && !checker6 && !checker && checker8){
           System.out.println(Arrays.toString(a) + " is a two pair");
        }else if(!checker5 &&!checker8 && !checker7 && !checker4 && !checker9 && !checker2 && !checker6 && !checker){
           System.out.println(Arrays.toString(a) + " is a pair");
        }else if(checker10){
           System.out.println(Arrays.toString(a) + " is a High card");
        }else{
            System.out.println(Arrays.toString(a) + " Unknown rank");
        }
   
    }
        
}
     
  
    
