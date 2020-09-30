import java.util.Arrays;

public class DivisibleByThree {

    public static void main(String[] args) throws Exception {
        System.out.println(divisibleByThree(new int[]{1,4,6,8}));
    }

    //Takes a list of numbers and returns the highest number divisible by 3 that can be produced from concatenating numbers in the list
    public static int divisibleByThree(int[] l) {
        int highest;

        //sort the array in descending order
        Arrays.sort(l);
        for (int i = 0; i< l.length / 2; i++) {
            int temp = l[i];
            l[i] = l[l.length - 1 - i];
            l[l.length - 1 - i] = temp;
        }

        highest = buildInt(l);
        if (highest % 3 == 0) return highest;

        //index for if more than one element needs to be removed
        int index1 = -1;
        int index2 = -1;


        if (highest % 3 == 1) {
            for (int i = l.length - 1; i >= 0; i--) {
                if (l[i] % 3 == 1) {
                    return buildInt(removeElement(l,i));
                }
                if (l[i] % 3 == 2) {
                    if (index1 == -1){
                        index1 = i;
                    }
                    else if (index2 == -1){
                        index2 = i;
                    }
                }
            }
        }
        else {
            for (int i = l.length - 1; i >= 0; i--) {
                if (l[i] % 3 == 2) {
                    return buildInt(removeElement(l,i));
                }
                if (l[i] % 3 == 1) {
                    if (index1 == -1){
                        index1 = i;
                    }
                    else if (index2 == -1){
                        index2 = i;
                    }
                }
            }
        }

        if (index1 != -1 && index2 != -1){
            return buildInt(removeElement(removeElement(l,index1),index2));
        }

        return 0;
    }

    public static int[] removeElement (int[] l , int index){
        int[] newArray = new int[l.length -1];

        for (int i = 0, k = 0; i < l.length; i++) {
            if (i != index){
                newArray[k++] = l[i];
            }
        }

        return newArray;
    }

    //takes an Array and turns it into an int
    public static int buildInt(int[] l) {
        if (l.length == 0) return 0;
        StringBuilder total = new StringBuilder();
        for (int i : l) {
            total.append(i);
        }
        return Integer.parseInt(total.toString());
    }
}
