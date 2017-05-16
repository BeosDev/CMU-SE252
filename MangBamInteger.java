package bangbam;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by Bùi Lê Hoài Linh on 16/05/2017.
 * Mảng băm cho các số nguyên
 * Ý tưởng: - Tạo ra mảng danh sách liên kết với độ dài là tableSize
 *          - Lấy số nguyên gọi là X cần thêm vào mảng băm % ( Lấy dư ) cho tableSize,
 *          ta được 1 phần tử là danh sách liên kết có vị trí là [X % tableSize]
 *          - Kiểm tra danh sách liên kết thứ [ X % tableSize] đã có X hay chưa,
 *          nếu chưa có thì thêm vào
 */
public class MangBamInteger {
    //Kích thước của độ dài mảng băm tùy theo đề bài ra
    int tableSize = 17;

    void bam(){
        //Mảng danh sách liên k
        LinkedList<Integer>[]lists = new LinkedList[tableSize];


        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 0;i<n;i++){
            int x = scanner.nextInt();

            //Chia lấy vị trí của danh sách liên kết thứ hf
            int hf = x % tableSize;

            //Nếu danh sách liên kết hf là null thì phải khởi tạo
            if (lists[hf] == null)
                lists[hf] = new LinkedList<>();

            //Kiểm tra xem đã có x hay chưa, nếu chưa có thì add vào
            if (!lists[hf].contains(x))
                lists[hf].add(x);
        }

    }
    public static void main(String[] args) {
        MangBamInteger s = new MangBamInteger();
        s.bam();
    }
}
