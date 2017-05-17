package dynamic;

import java.util.Scanner;

/**
 * Created by linh on 17/05/2017.
 * Với S = "sdeqabcbatqw" ta được bảng:
 *
 0 1 1 1 1 1 1 3 5 5 7 7
 0 1 1 1 1 1 1 3 5 5 7 7
 0 0 1 1 1 1 1 3 5 5 7 7
 0 0 0 1 1 1 1 3 5 5 7 7
 0 0 0 0 1 1 1 3 5 5 5 5
 0 0 0 0 0 1 1 3 3 3 3 3
 0 0 0 0 0 0 1 1 1 1 1 1
 0 0 0 0 0 0 0 1 1 1 1 1
 0 0 0 0 0 0 0 0 1 1 1 1
 0 0 0 0 0 0 0 0 0 1 1 1
 0 0 0 0 0 0 0 0 0 0 1 1
 0 0 0 0 0 0 0 0 0 0 0 1

 Dãy con chung dài nhất là qabcbaq = 7

 */
public class Palindrome {
    int L[][];
    String s;
    void input(){
        Scanner scanner = new Scanner(System.in);
        s = scanner.nextLine();
    }
    int CalPalindrome(){
        int size = s.length();
        L = new int[size+1][size+1];

        //Khởi tạo các giá trị ban đầu = 0 với vị trí i = j thì có duy nhất 1 chữ cái nên = 1
        for (int i = 0;i<size;i++) {
            L[i][i] = 1;
            L[i][0] = 0;
            L[i][size] = 0;
        }


        for (int j = 1;j<size;j++)
            for (int i = j-1;i>=0;i--)
                if (s.charAt(i) == s.charAt(j))
                    L[i][j] = 2 + L[i+1][j-1];
                else L[i][j] = Math.max(L[i+1][j],L[i][j-1]);


        return L[0][size-1];
    }

    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();
        palindrome.input();
        System.out.println(palindrome.CalPalindrome());
    }
}
