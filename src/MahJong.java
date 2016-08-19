import java.util.*;

public class MahJong {

    static final int[] n_zero;
    static final int E = 27;
    static final int S = 28;
    static final int W = 29;
    static final int N = 30;
    static final int ZHONG = 31;
    static final int FA = 32;
    static final int BAI = 33;

    static {
        n_zero = new int[34];
        Arrays.fill(n_zero, 0);
    }

    private enum PLAYER {
        玩家1("player_1");
        private String name;

        PLAYER(String name) {
            this.name = name;
        }
    }

    private final int TOTAL = 28 * 4;

    private List<Pai> list = new ArrayList<>(TOTAL);
    private Queue<Pai> queue = new ArrayDeque<>(TOTAL);

    private Pai[] playser_1 = new Pai[14];
    private Pai[] playser_2 = new Pai[14];
    private Pai[] playser_3 = new Pai[14];
    private Pai[] playser_4 = new Pai[14];

    private void init() {
        list.add(new Pai(0, "一万"));
        list.add(new Pai(1, "二万"));
        list.add(new Pai(2, "三万"));
        list.add(new Pai(3, "四万"));
        list.add(new Pai(4, "五万"));
        list.add(new Pai(5, "六万"));
        list.add(new Pai(6, "七万"));
        list.add(new Pai(7, "八万"));
        list.add(new Pai(8, "九万"));


        list.add(new Pai(9, "一条"));
        list.add(new Pai(10, "二条"));
        list.add(new Pai(11, "三条"));
        list.add(new Pai(12, "四饼"));
        list.add(new Pai(13, "五条"));
        list.add(new Pai(14, "六条"));
        list.add(new Pai(15, "七条"));
        list.add(new Pai(16, "八条"));
        list.add(new Pai(17, "九条"));

        list.add(new Pai(18, "一饼"));
        list.add(new Pai(19, "二饼"));
        list.add(new Pai(20, "三饼"));
        list.add(new Pai(21, "四饼"));
        list.add(new Pai(22, "五饼"));
        list.add(new Pai(23, "六饼"));
        list.add(new Pai(24, "七饼"));
        list.add(new Pai(25, "八饼"));
        list.add(new Pai(26, "九饼"));

        list.add(new Pai(ZHONG, "红中"));

    }

    private void wash() {
        if (list.size() != TOTAL) {
            return;
        }

        Random rd = new Random();
        for (int i = 0; i < TOTAL; i++) {
            int j = rd.nextInt(TOTAL);
            Pai temp = list.get(j);
            queue.add(temp);
        }
    }

    private void print() {
        int i = 0;
        Iterator<Pai> iterator = queue.iterator();
        while (iterator.hasNext()) {
            i++;
            System.out.println(i + "   -----    " + iterator.next().getName());
        }
    }

    private Pai next() {
        return queue.poll();
    }

    private void start() {
        wash();
        int i = 0;
        while (i < 13) {
            playser_1[i] = next();
            playser_2[i] = next();
            playser_3[i] = next();
            playser_4[i] = next();
            i++;
        }
        playser_1[i] = next();
        playser_2[i] = new Pai(100, " -");
        playser_3[i] = new Pai(100, " -");
        playser_4[i] = new Pai(100, " -");

        Arrays.sort(playser_1);
        Arrays.sort(playser_2);
        Arrays.sort(playser_3);
        Arrays.sort(playser_4);
    }

    private void printPlayer() {
        int i = 0;
        for (i = 0; i < playser_1.length; i++) {
            System.out.print(playser_1[i].getName());
        }
//        System.out.println();
//        System.out.print(" 玩家2 --> ");
//        for (i = 0; i < playser_2.length; i++) {
//            System.out.print(playser_2[i].getName());
//        }
//        System.out.println();
//        System.out.print(" 玩家3 --> ");
//        for (i = 0; i < playser_3.length; i++) {
//            System.out.print(playser_3[i].getName());
//        }
//        System.out.println();
//        System.out.print(" 玩家4 --> ");
//        for (i = 0; i < playser_4.length; i++) {
//            System.out.print(playser_4[i].getName());
//        }
    }

    public String getStyle(int player) {
        String out = null;
        switch (player) {
            case 1:
                out = calStyle(playser_1);
                break;
        }
        return out;
    }

    static int[] analyse(Pai[] hai) {
        int[] n = n_zero.clone();

        for (Pai i : hai) {
            n[i.getCODE()]++;
        }
        return n;
    }

    static int calc_key(int[] n) {
        int p = -1;
        int x = 0;
        int pos_p = 0;
        boolean b = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                if (n[i * 9 + j] == 0) {
                    if (b) {
                        b = false;
                        x |= 0x1 << p;
                        p++;
                    }
                } else {
                    p++;
                    b = true;
                    switch (n[i * 9 + j]) {
                        case 2:
                            x |= 0x3 << p;
                            p += 2;
                            break;
                        case 3:
                            x |= 0xF << p;
                            p += 4;
                            break;
                        case 4:
                            x |= 0x3F << p;
                            p += 6;
                            break;
                    }
                }
            }
            if (b) {
                b = false;
                x |= 0x1 << p;
                p++;
            }
        }
        for (int i = E; i <= BAI; i++) {
            if (n[i] > 0) {
                p++;
                switch (n[i]) {
                    case 2:
                        x |= 0x3 << p;
                        p += 2;
                        break;
                    case 3:
                        x |= 0xF << p;
                        p += 4;
                        break;
                    case 4:
                        x |= 0x3F << p;
                        p += 6;
                        break;
                }
                x |= 0x1 << p;
                p++;
            }
        }
        return x;
    }


    private String calStyle(Pai[] pai) {

        if (pai.length == 1) {
            return pai[0] + "0";
        }
        int result = calc_key(analyse(pai));
        return result + " : " + Integer.toBinaryString(result);
    }


    public static void main(String[] args) {

        MahJong mahJong = new MahJong();
        for (int i = 0; i < 4; i++) {
            mahJong.init();
        }
        mahJong.start();
        mahJong.printPlayer();
        System.out.println();
        System.out.println(mahJong.getStyle(1));
    }
}
