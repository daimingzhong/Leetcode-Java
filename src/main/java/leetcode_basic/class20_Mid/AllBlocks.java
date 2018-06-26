package leetcode_basic.class20_Mid;

/**
 * Created by Dai on 2016/11/15.
 */
public class AllBlocks {
    public void printBlocks(int n) {
        char[] array = new char[2 * n];
        helper(array, n, n, 0);
    }

    private void helper(char[] array, int left, int right, int position) {
        if (position == array.length && left == 0 && right == 0) {
            printSol (array, 0);
            return;
        }
        if (left > 0) {
            array[position] = "{".toCharArray()[0];
                helper (array, left - 1, right, position + 1);
            }
            if (right > left) {
                array[position] = "}".toCharArray()[0];
                helper(array, left, right - 1, position + 1);
        }
    }
    private void printSol (char[] array, int space) {
        for (int i = 0; i < array.length; i++) {
            //if (array[i] == "{") {
                //printSpace(space);
                System.out.println("if {");
                    space  +=  2;
              //  } else {
                    space -= 2;
               //     printSpace (space);
                    System.out.println("}");
            }
            }
        //}
    private void printSpace (char[] array, int space) {
        for (int i = 0; i < space; i++) {
            System.out.print(" ");
        }
    }

}
