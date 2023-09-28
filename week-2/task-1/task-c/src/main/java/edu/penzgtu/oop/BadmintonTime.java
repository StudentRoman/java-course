package edu.penzgtu.oop;

import java.util.Scanner;

public class BadmintonTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Is it Sunday today? Yes, no");
        boolean isSunday = getBoolean(scanner.nextLine());

        System.out.println("Is there a wind? Yes, no");
        boolean isWindy = getBoolean(scanner.nextLine());

        System.out.println("What is the humidity? Low, high");
        boolean isHumidity = getBoolean(scanner.nextLine());

        System.out.println("What is the temperature? Hot, warm, cold");
        String temperature = scanner.nextLine();

        System.out.println("What's the weather like? Clear, cloudy, rain, snow, hail");
        String weather = scanner.nextLine();

        System.out.println(isGoodTime(isSunday, isWindy, isHumidity, temperature, weather));

        scanner.close();
    }

    public static String isGoodTime(boolean isSunday, boolean isWindy, boolean isHumidity, String temperature, String weather) {
        if (isSunday && !isWindy && !isHumidity) {
            if (temperature.matches("(?i)hot|warm") && weather.matches("(?i)clear|cloudy")) {
                return "Yes";
            }
        }

        return "No";
    }

    private static boolean getBoolean(String value) {
        return value.matches("(?i)hight|yes");
    }
}
