public class Gamestates {

    private static boolean START = true;
    private static boolean MENU = false;
    private static boolean PAUSE = false;
    private static boolean PLAY = false;

    public static boolean isSTART() {
        return START;
    }

    public static void setSTART(boolean START) {
        Gamestates.START = START;
    }

    public static boolean isMENU() {
        return MENU;
    }

    public static void setMENU(boolean MENU) {
        Gamestates.MENU = MENU;
    }

    public static boolean isPAUSE() {
        return PAUSE;
    }

    public static void setPAUSE(boolean PAUSE) {
        Gamestates.PAUSE = PAUSE;
    }

    public static boolean isPLAY() {
        return PLAY;
    }

    public static void setPLAY(boolean PLAY) {
        Gamestates.PLAY = PLAY;
    }
}
