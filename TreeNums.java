import java.util.ArrayList;
import java.util.List;

public class TreeNums {
  public static List<Integer> searcher(int h, List<Integer> integerList) {
     List<Integer> answerList = new ArrayList<>();
     for (int i = 0; i < integerList.size(); i++) {
       answerList.add(0);
     }
     int headIndex = (int) (Math.pow(2.0,h)-1.0);
     int hminus1 = (int) Math.pow(2.0,h-1);
     int leftChildIndex = headIndex - hminus1;
     int rightChildIndex = headIndex-1;

     answerList = matchExists(integerList, headIndex, leftChildIndex, answerList);
     answerList = matchExists(integerList, headIndex, rightChildIndex, answerList);

     answerList = helpSearcher(leftChildIndex,h-1, integerList, answerList);
     answerList = helpSearcher(rightChildIndex,h-1, integerList, answerList);

     for(int i = 0; i < answerList.size(); i++) {
       if(answerList.get(i).equals(0)) {
         answerList.set(i, -1);
       }
     }

     return answerList;
   }

   public static List<Integer> matchExists (List<Integer> integerList, int parentIndex, int childIndex, List<Integer> answerList) {
     for(int i = 0; i < integerList.size(); i++) {
       if (integerList.get(i).equals(childIndex)) {
         answerList.set(i, parentIndex);
       }
     }
     return answerList;
   }

   public static List<Integer> helpSearcher(int headIndex, int h, List<Integer> integerList, List<Integer> answerList) {
     if(h > 1) {
       int hminus1 = (int) Math.pow(2.0,h-1);
       int leftChildIndex = headIndex - hminus1;
       int rightChildIndex = headIndex-1;

       answerList = matchExists(integerList, headIndex, leftChildIndex, answerList);
       answerList = matchExists(integerList, headIndex, rightChildIndex, answerList);

       answerList = helpSearcher(leftChildIndex, h-1, integerList, answerList);
       answerList = helpSearcher(rightChildIndex, h-1, integerList, answerList);
       return answerList;

     } else {
       return answerList;
     }
   }
}
