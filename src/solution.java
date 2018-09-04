
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class solution {

    static int[] doPreOrder (int[] rights, int[] lefts, int n) {
        int[] returnList = new int[n];
        int[] st = new int[n];
        int index = 0;
        int top = -1;
        st[++top] = 1;
        while(top>=0){
            int cur = st[top--];
            returnList[index++] = cur;

            if(rights[cur] != 0){
                st[++top] = (rights[cur]);
            }
            if(lefts[cur] != 0){
                st[++top] = (lefts[cur]);
            }
        }
       return returnList;
    }

    static int[] doPostOrder (int[] rights, int[] lefts, int n) {
        int[] list  = new int[n];
        int[] S = new int[n];
        int index = 0;
        int top = -1;
        S[++top] = 1;
        int prev = 0;
        while (top>=0)
        {
            int current = S[top];

            if (prev == 0 || lefts[prev] == current ||
                    rights[prev] == current)
            {
                if (lefts[current] != 0)
                    S[++top] = (lefts[current]);
                else if (rights[current] != 0)
                    S[++top] = (rights[current]);
                else
                {
                    top--;
                    list[index++] = (current);
                }

            }
            else if (lefts[current] == prev)
            {
                if (rights[current] != 0)
                    S[++top] = (rights[current]);
                else
                {
                    top--;
                    list[index++] = (current);
                }

            }
            else if (rights[current]  == prev)
            {
                top--;
                list[index++] = (current);
            }

            prev = current;
        }
        return list;
    }

    public static void main(String args[])  throws FileNotFoundException{
//        File file = new File("C:\\Users\\Hassan Ismaeel\\IdeaProjects\\Algorithms\\let_it_flow_sample_input.txt");
//        try {
//            Scanner sc = new Scanner(file);
//            int cases = sc.nextInt();
//            PrintWriter writer = new PrintWriter("output2.txt");
//
////                StringBuilder str = new StringBuilder(0);
////                if (possible) {
////                    writer.format(str.toString() + "\n");
////                } else {
////                    writer.format(" Impossible" + "\n");
////                }
//            //writer.flush();
//        } catch (FileNotFoundException e){
//            System.out.println(e);
//        }
    }
}
