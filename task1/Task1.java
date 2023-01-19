public class Task1 {
    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);

        int[] array = new int[n * m];
        int count = 1;

        if (n <= 0){
            System.out.println("Error n <= 0");
        } else if (m <= 0){
            System.out.println("Error m <= 0");
        } else {
            System.out.print(1);
            for (int i = 0; i < array.length - 1; i++) {
                if ((i + 1) % m == 0) {
                    if (count == 1) {
                        break;
                    }
                    System.out.print(count);
                    array[i] = count;
                    i++;
                }
                if (count == n) {
                    array[i] = n;
                    count = 1;
                } else {
                    array[i] = count;
                    count++;
                }
            }
        }
    }
}
