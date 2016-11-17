import java.util.ArrayList;
import java.util.List;

public class TreeNums {
  public static int[] searcher(int h, int[] integerList) {
     int[] answerList = new int[integerList.length];
     for (int i = 0; i < integerList.length; i++) {
       answerList[i] = 0;
     }
     int headIndex = (int) (Math.pow(2.0,h)-1.0);
     int hminus1 = (int) Math.pow(2.0,h-1);
     int leftChildIndex = headIndex - hminus1;
     int rightChildIndex = headIndex-1;

     answerList = matchExists(integerList, headIndex, leftChildIndex, answerList);
     answerList = matchExists(integerList, headIndex, rightChildIndex, answerList);

     answerList = helpSearcher(leftChildIndex,h-1, integerList, answerList);
     answerList = helpSearcher(rightChildIndex,h-1, integerList, answerList);

     for(int i = 0; i < answerList.length; i++) {
       if(answerList[i]==0) {
         answerList[i] = -1;
       }
     }

     return answerList;
   }

   public static int[] matchExists (int[] integerList, int parentIndex, int childIndex, int[] answerList) {
     for(int i = 0; i < integerList.length; i++) {
       if (integerList[i]==childIndex) {
         answerList[i] = parentIndex;
       }
     }
     return answerList;
   }

   public static int[] helpSearcher(int headIndex, int h, int[] integerList, int[] answerList) {
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
