import java.util.*;

public class MahJong {

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
        list.add(new Pai(1, "一万"));
        list.add(new Pai(2, "二万"));
        list.add(new Pai(3, "三万"));
        list.add(new Pai(4, "四万"));
        list.add(new Pai(5, "五万"));
        list.add(new Pai(6, "六万"));
        list.add(new Pai(7, "七万"));
        list.add(new Pai(8, "八万"));
        list.add(new Pai(9, "九万"));


        list.add(new Pai(11, "一条"));
        list.add(new Pai(12, "二条"));
        list.add(new Pai(13, "三条"));
        list.add(new Pai(14, "四饼"));
        list.add(new Pai(15, "五条"));
        list.add(new Pai(16, "六条"));
        list.add(new Pai(17, "七条"));
        list.add(new Pai(18, "八条"));
        list.add(new Pai(19, "九条"));

        list.add(new Pai(21, "一饼"));
        list.add(new Pai(22, "二饼"));
        list.add(new Pai(23, "三饼"));
        list.add(new Pai(24, "四饼"));
        list.add(new Pai(25, "五饼"));
        list.add(new Pai(26, "六饼"));
        list.add(new Pai(27, "七饼"));
        list.add(new Pai(28, "八饼"));
        list.add(new Pai(29, "九饼"));

        list.add(new Pai(50, "红中"));

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
        playser_2[i] = new Pai(100," -");
        playser_3[i] = new Pai(100," -");
        playser_4[i] = new Pai(100," -");

        Arrays.sort(playser_1);
        Arrays.sort(playser_2);
        Arrays.sort(playser_3);
        Arrays.sort(playser_4);
    }

    private void printPlayer() {
        int i = 0;
        System.out.print(" 玩家1 --> ");
        for (i = 0; i < playser_1.length; i++) {
            System.out.print(playser_1[i].getName());
        }
        System.out.println();
        System.out.print(" 玩家2 --> ");
        for (i = 0; i < playser_2.length; i++) {
            System.out.print(playser_2[i].getName());
        }
        System.out.println();
        System.out.print(" 玩家3 --> ");
        for (i = 0; i < playser_3.length; i++) {
            System.out.print(playser_3[i].getName());
        }
        System.out.println();
        System.out.print(" 玩家4 --> ");
        for (i = 0; i < playser_4.length; i++) {
            System.out.print(playser_4[i].getName());
        }
    }

    public static void main(String[] args) {

        MahJong mahJong = new MahJong();
        for (int i = 0; i < 4; i++) {
            mahJong.init();
        }
        mahJong.start();
        mahJong.printPlayer();
    }
}
