package xie.com.mj;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xie on 16/8/23.
 */
public enum PAI {
    W1(0), W2(1), W3(2), W4(3), W5(4), W6(5), W7(6), W8(7), W9(8),
    B1(9), B2(10), B3(11), B4(12), B5(13), B6(14), B7(15), B8(16), B9(17),
    T1(18), T2(19), T3(20), T4(21), T5(22), T6(23), T7(24), T8(25), T9(26),
    E(27), S(28), W(29), N(30), ZH(31), FA(32), BA(33);
    private int code;
    private String name;
    private List<String> list = new ArrayList<>(28);

    PAI(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        String result = "";
        switch (code) {
            case 0:
                result = "一万";
                break;
            case 1:
                result = "二万";
                break;
            case 2:
                result = "三万";
                break;
            case 3:
                result = "四万";
                break;
            case 4:
                result = "五万";
                break;
            case 5:
                result = "六万";
                break;
            case 6:
                result = "七万";
                break;
            case 7:
                result = "八万";
                break;
            case 8:
                result = "九万";
                break;
            case 9:
                result = "一饼";
                break;
            case 10:
                result = "二饼";
                break;
            case 11:
                result = "三饼";
                break;
            case 12:
                result = "四饼";
                break;
            case 13:
                result = "五饼";
                break;
            case 14:
                result = "六饼";
                break;
            case 15:
                result = "七饼";
                break;
            case 16:
                result = "八饼";
                break;
            case 17:
                result = "九饼";
                break;
            case 18:
                result = "一条";
                break;
            case 19:
                result = "二条";
                break;
            case 20:
                result = "三条";
                break;
            case 21:
                result = "四条";
                break;
            case 22:
                result = "五条";
                break;
            case 23:
                result = "六条";
                break;
            case 24:
                result = "七条";
                break;
            case 25:
                result = "八条";
                break;
            case 26:
                result = "九条";
                break;
            case 27:
                result = "东风";
                break;
            case 28:
                result = "南风";
                break;
            case 29:
                result = "西风";
                break;
            case 30:
                result = "北风";
                break;
            case 31:
                result = "红中";
                break;
            case 32:
                result = "发财";
                break;
            case 33:
                result = "白板";
                break;
        }
        return result;
    }
}
