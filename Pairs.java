import java.util.HashSet;
import java.util.Set;

public class Pairs{
     public static void main(String[] args){
        int[] shirts = new int[]{10, 20, 20, 10, 10, 30, 50, 10, 20};
        HashSet<Integer> set=new HashSet();
        int numberPairs = 0;
        for(int item: shirts){
            if(set.contains(item)){
                //Item in hashset
                set.remove(item);
                numberPairs++;
            }else{
                  set.add(item);
            }
        }
        System.out.println(numberPairs);
      }
}