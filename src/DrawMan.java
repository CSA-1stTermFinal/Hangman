public class DrawMan {

    public static void main(int count) {
        if (count == 0) {
            zeroMiss();
        } else if (count == 1) {
            oneMiss();
        } else if (count == 2) {
            twoMiss();
        } else if (count == 3) {
            threeMiss();
        } else if (count == 4) {
            fourMiss();
        } else if (count == 5) {
            fiveMiss();
        } else if (count == 6) {
            sixMiss();
        } else if (count == 7) {
            sevenMiss();
        }
    }

    public static void zeroMiss() {
        System.out.println(" #######");
        System.out.println(" ##");
        System.out.println(" ##");
        System.out.println(" ##");
        System.out.println(" ##");
        System.out.println(" ##");
        System.out.println("#########");
    }
    public static void oneMiss() {
        System.out.println(" #######");
        System.out.println(" ##   |");
        System.out.println(" ##");
        System.out.println(" ##");
        System.out.println(" ##");
        System.out.println(" ##");
        System.out.println("#########");
    }
    public static void twoMiss() {
        System.out.println(" #######");
        System.out.println(" ##   |");
        System.out.println(" ##   @");
        System.out.println(" ##");
        System.out.println(" ##");
        System.out.println(" ##");
        System.out.println("#########");
    }
    public static void threeMiss() {
        System.out.println(" #######");
        System.out.println(" ##   |");
        System.out.println(" ##   @");
        System.out.println(" ##   |");
        System.out.println(" ##");
        System.out.println(" ##");
        System.out.println("#########");
    }
    public static void fourMiss() {
        System.out.println(" #######");
        System.out.println(" ##   |");
        System.out.println(" ##   @");
        System.out.println(" ##  /|");
        System.out.println(" ##");
        System.out.println(" ##");
        System.out.println("#########");
    }
    public static void fiveMiss() {
        System.out.println(" #######");
        System.out.println(" ##   |");
        System.out.println(" ##   @");
        System.out.println(" ##  /|\\");
        System.out.println(" ##");
        System.out.println(" ##");
        System.out.println("#########");
    }
    public static void sixMiss() {
        System.out.println(" #######");
        System.out.println(" ##   |");
        System.out.println(" ##   @");
        System.out.println(" ##  /|\\");
        System.out.println(" ##  /");
        System.out.println(" ##");
        System.out.println("#########");
    }
    public static void sevenMiss() {
        System.out.println(" #######");
        System.out.println(" ##   |");
        System.out.println(" ##   @");
        System.out.println(" ##  /|\\");
        System.out.println(" ##  / \\");
        System.out.println(" ##");
        System.out.println("#########");
    }
    public static void youLose() {
        System.out.println(" #######");
        System.out.println(" ##   |");
        System.out.println(" ##   X");
        System.out.println(" ##  /|\\");
        System.out.println(" ##  / \\");
        System.out.println(" ##");
        System.out.println("#########");
    }
}
