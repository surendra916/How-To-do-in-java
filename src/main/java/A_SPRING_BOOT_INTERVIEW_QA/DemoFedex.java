package A_SPRING_BOOT_INTERVIEW_QA;

import java.util.concurrent.CompletableFuture;

public class DemoFedex {
    public static void main(String[] args){
        int[] nums = {2,3,1,1,4};
        int j;
        for (int i = 0; i < nums.length; i = j) {
           for(j = i; j <= nums[i]; j++){ // 2, 3, 1
               CompletableFuture<String> cf = CompletableFuture.supplyAsync(() ->{
                   try {
                       Thread.sleep(1000);
                   } catch (InterruptedException e) {
                       throw new RuntimeException(e);
                   }
                   return "";
               });

           }

        }

    }
}
