package ro.sda.movie_reservation_system.handler;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KeyboardHandlerTest {
    private KeyboardHandler keyboardHandler;

    @BeforeEach
    public void setUp() throws Exception {
        keyboardHandler = new KeyboardHandler();
    }

    @Test
    @DisplayName("String input should work")
    public void readStringTest(){
        String input = "Elisa";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals("Elisa", keyboardHandler.readString("Name:"));
    }

    @Test
    @DisplayName("Should test if input isNOT an int")
    public void isNotIntTest(){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }
}
