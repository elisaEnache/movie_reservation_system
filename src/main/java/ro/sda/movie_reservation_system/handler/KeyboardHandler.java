package ro.sda.movie_reservation_system.handler;

import java.util.Scanner;

public class KeyboardHandler {
    private Scanner scanner;
    public static final String notNumberMsg="NOT A NUMBER!";

    public KeyboardHandler() {
        this.scanner = new Scanner(System.in);
    }

    public String readString(String input){
        System.out.print(input);
        return scanner.nextLine();
    }


    public int readInt (String input){
        Integer value = -1;
        boolean state = true;
        do {
            System.out.println(input);
            if (isNotInt(scanner)){
                 scanner.next();
            }else {
                value = scanner.nextInt();
                scanner.nextLine();
                state = false;
            }
        }while (state);
        return value;
    }

    public boolean isNotInt(Scanner scanner) {
        if (!scanner.hasNextInt()) {
            System.out.println(notNumberMsg);
            return true;
        }
        return false;
    }
}
