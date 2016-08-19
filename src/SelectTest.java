import java.util.ArrayList;
import java.util.List;

/**
 * Created by xie on 16/8/19.
 */
public class SelectTest {

    public static void main(String[] args) {


        final int count = 13;
        final int total = 30;

        int[] index = new int[total];
        for (int i = 0; i < total; i++) {
            index[i] = i;
        }

        int nCnt = index.length;

        int nBit = (0xFFFFFFFF >>> (32 - nCnt));

        List list=new ArrayList<>(count);
        for (int i = 1; i <= nBit; i++) {
            for (int j = 0; j < nCnt; j++) {
                if ((i << (31 - j)) >> 31 == -1) {
                    list.add(index[j]);
                }
            }

            if (list.size() == count) {
                System.out.println(list.toString());
            }else {
                list.clear();
            }

        }
    }
}
