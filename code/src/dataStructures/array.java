package dataStructures;

public class array {
    public static void main(String[] args) {
    
    }

    public void log(int[] numbers, String[] names) {
    
        // 0(n + m) == 0(n)
        for (int number : numbers) 
            System.out.println(number);
        for (String name : names) 
            System.out.println(name);
    }
}