package pl.sda.structures;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.InputMismatchException;
import java.util.Scanner;

public class WydawanieReszty {

    public static void main(String[] args) {

        final BigDecimal[] NOMINALY = {
                new BigDecimal(200.0),
                new BigDecimal(100.0),
                new BigDecimal(50.0),
                new BigDecimal(20.0),
                new BigDecimal(10.0),
                new BigDecimal(5.0),
                new BigDecimal(2.0),
                new BigDecimal(1.0),
                new BigDecimal("0.5"),
                new BigDecimal("0.2"),
                new BigDecimal("0.1"),
                new BigDecimal("0.05"),
                new BigDecimal("0.02"),
                new BigDecimal("0.01")
        };
        BigDecimal reszta = BigDecimal.ZERO;

        Scanner sc = new Scanner(System.in);
        System.out.print("Podaj reszte: ");

        try {
            reszta = new BigDecimal(sc.nextLine());
        }catch (NumberFormatException | InputMismatchException ex) {
            System.out.println("Nieprawidlowa wartosc");
            return;
        }

        String wynik = "Reszta:\n";

        for (int i = 0; ((i < NOMINALY.length) && (reszta.compareTo(BigDecimal.ZERO)==1)); i++) {
            if (reszta.compareTo(NOMINALY[i]) >=0) {
                BigDecimal temp = reszta.divide(NOMINALY[i], 0,RoundingMode.FLOOR);
                wynik += NOMINALY[i] + " PLN x " + temp + "\n";
                reszta = new BigDecimal(100).multiply(reszta.subtract(temp.multiply(NOMINALY[i]))).divide(new BigDecimal(100));
            }
        }

        System.out.println(wynik);
    }
}