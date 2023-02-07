import java.util.Arrays;

public class Problem3 {
    public static void main(String[] args) {
        //Don't edit anything here
        Integer[] a1 = new Integer[]{-1, -2, -3, -4, -5, -6, -7, -8, -9, -10};
        Integer[] a2 = new Integer[]{-1, 1, -2, 2, 3, -3, -4, 5};
        Double[] a3 = new Double[]{-0.01, -0.0001, -.15};
        String[] a4 = new String[]{"-1", "2", "-3", "4", "-5", "5", "-6", "6", "-7", "7"};
        
        bePositive(a1);
        bePositive(a2);
        bePositive(a3);
        bePositive(a4);
    }
    static <T> void bePositive(T[] arr){
        System.out.println("Processing Array:" + Arrays.toString(arr));
        //your code should set the indexes of this array
        Object[] output = new Object[arr.length];

        //TODO convert each value to positive
        //set the result to the proper index of the output array
        //hint: don't forget to handle the data types properly
        for(int i=0; i<arr.length; i++){ // parse all values in arr
            if(arr[i] instanceof Integer){ // check if current value is an int
                int temp = (Integer)arr[i]; // cast to int and store in a value to use
                output[i] = Math.abs(temp); // set index of output to absolute value of current value
            }
            if(arr[i] instanceof Double){ // check if current value is a double
                double temp = (Double)arr[i]; // cast to double and store in a value to use
                output[i] = Math.abs(temp); // set index of output to absolute value of current value
            }
            if(arr[i] instanceof String){ // check if current value is a string
                String temp = (String)arr[i]; // cast to string and store in a value to use
                if(temp.substring(0,1).equals("-")){ // check to see if first char is a -
                    output[i] = temp.substring(1); // if so, set index of output to same string but after the -
                }
                else output[i] = temp; // if it isn't negative just set index of output to the original string
            } // I (rmd2) completed all the above code on 2/7/2023.
        }
        //end edit section

        StringBuilder sb = new StringBuilder();
        for(Object i : output){
            if(sb.length() > 0){
                sb.append(",");
            }
            sb.append(String.format("%s (%s)", i, i.getClass().getSimpleName().substring(0,1)));
        }
        System.out.println("Result: " + sb.toString());
    }
}