package edu.penzgtu.oop;

public class NumberTypesSize {
    public static void main(String[] args) {
        // Тип Byte хранит целое число от -2^7 до 2^7 - 1 и занимает 1 байт памяти
        System.out.printf("Min Byte: %d | Max Byte: %d \n", Byte.MIN_VALUE, Byte.MAX_VALUE);

        // Тип Short хранит целое число от -2^15 до 2^15 - 1 и занимает 2 байта памяти
        System.out.printf("Min Short: %d | Max Short: %d \n", Short.MIN_VALUE, Short.MAX_VALUE);

        // Тип Integer хранит целое число от -2^31 до 2^31 - 1 и занимает 4 байта памяти
        System.out.printf("Min Integer: %d | Max Integer: %d \n", Integer.MIN_VALUE, Integer.MAX_VALUE);

        // Тип Long хранит целое число от –2^63 до 2^63 - 1 и занимает 8 байт памяти
        System.out.printf("Min Long: %d | Max Long: %d \n", Long.MIN_VALUE, Long.MAX_VALUE);

        // Тип Float хранит число с плавающей точкой от -3.4 * 10^38 до 3.4 * 10^38 и занимает 4 байта памяти
        System.out.printf("Min Float: %e | Max Float: %e", Float.MIN_VALUE, Float.MAX_VALUE);

        // Тип Double хранит число с плавающей точкой
        // от ±4.9 * 10^324 до ±1.7976931348623157*10^308 и занимает 8 байт памяти
        System.out.printf("Min Double: %e | Max Double: %e \n", Double.MIN_VALUE, Double.MAX_VALUE);
    }
}
