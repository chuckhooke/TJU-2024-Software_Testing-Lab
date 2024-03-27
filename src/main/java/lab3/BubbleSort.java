package lab3;

public class BubbleSort {

    public int[] bubbleSort (int[] array){

        int length = array.length;

        for(int i = length - 2; i >= 0; i--){
            for(int j = 0; j <= i; j++){
                if (array[j] > array[j + 1]){
                    int tmp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = tmp;
                }
            }
        }

        return array;
    }

    public static void main(String[] args) {
        BubbleSort b = new BubbleSort();
        int[] array = new int[5];

        for (int i = 0; i < 5; i++) {
            array[i] = 5 - i;
        }

        for (int i : array) {
            System.out.println(i);
        }

        int[] brray = b.bubbleSort(array);
        for (int i : brray) {
            System.out.println(i);
        }
    }


}
