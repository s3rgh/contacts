package contacts.utils;

import java.util.Scanner;

public class ScannerUtils {
    private static Scanner INSTANCE;

    private ScannerUtils() {
    }

    public static Scanner getScannerInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Scanner(System.in);
        }
        return INSTANCE;
    }
}
