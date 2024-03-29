
public class MultiCatchSample {
    public static void main(String[] args) {
        MultiCatchSample sample = new MultiCatchSample();
        sample.multiCatch();
        sample.multiCatchOrderChange();
        sample.multiCatchThree();
    }
    public void multiCatch() {
        int[] intArray = new int[5];
        try{
            System.out.println(intArray[5]);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("ArrayIndexOutOfBoundsException occured");
        }
        catch(Exception e){
            System.out.println(intArray.length);
        }
       
    }
    
    public void multiCatchOrderChange() {
        int[] intArray = new int[5];
        try{
            System.out.println(intArray[5]);
        }
        catch(Exception e){
            System.out.println(intArray.length);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("ArrayIndexOutOfBoundsException occured");
        }       
    }
    public void multiCatchThree() {
        int[] intArray = new int[5];
        try{
            intArray = null;
            System.out.println(intArray[5]);
        }
        catch(NullPointerException e){
            System.out.println("NullPointerException occured");
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("ArrayIndexOutOfBoundsException occured");
        }
        catch(Exception e){
            System.out.println("Exception occured");
        }
       
    }
}
