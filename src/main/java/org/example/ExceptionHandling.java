package org.example;

public class ExceptionHandling {
    public static void main(String[] args) {
         try{
             int value=ExceptionHandling.get();
         }
         catch (ArrayIndexOutOfBoundsException e){
             System.out.println(e);
         }
         finally {
             System.out.println("code of finally block");
         }

         try{
             int age=-10;
             if(age<=0){
                 throw  new CustomException("age can't be negative");
             }
         }
         catch (CustomException e){
             System.out.println(e);
         }
    }
    static int get(){
        int[] arr ={1,2,3};
        return arr[4];
    }

}

class CustomException extends Exception {
    public CustomException(String message) {
        super(message);
    }
}
