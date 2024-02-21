import java.util.Random;
public class Arrays {

    public static int[] createIntArray(int size, int a, int b) throws Exception {
        if (size == 0) {
            throw new Exception("Size should be >=0, operation failed");
        }
        if (a > b) {
            throw new Exception("a < b");
        }

        int arr[] = new int[size]; 

        Random rand = new Random(); 
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(a-b);
        }

        return arr; 
    }
    public static void main(String[] args) {

    }
}
