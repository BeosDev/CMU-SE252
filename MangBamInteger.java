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
    final int tableSize = 113;
    LinkedList<Integer>[]lists = new LinkedList[tableSize];
    
    void defineHashTable(){
        //Mảng danh sách liên k
        for (int i = 0;i<tableSize;i++){
            lists[i] = new LinkedList();
        }
    }
    
    //Chia lấy vị trí của danh sách liên kết thứ hf
    int hf(int x){
        return x % tableSize;
    }
    
    void insert(int x){
         int pos = hf(x);
        
         //Kiểm tra xem đã có x hay chưa, nếu chưa có thì add vào
         if (!lists[pos].contains(x))
               lists[pos].add(x);
    }
    
    public static void main(String[] args) {
        MangBamInteger s = new MangBamInteger();
    }
}
