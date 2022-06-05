package org.suai.lab6;

import java.util.ArrayList;
import java.util.Scanner;

public class FormattedInput {
    private static int scanWasCalled = 0;

    public static Object[] reTry(String format){
        if(scanWasCalled == 0){
            throw new IllegalArgumentException("invalid string in");
        }

        return scanf(format);
    }

    public static Object[] scanf(String format) {
        System.out.println("enter data: ");

        Scanner sc = new Scanner(System.in);
        var s = sc.nextLine();

        scanWasCalled = 1;
        return sscanf(format, s);
    }

    public static Object[] sscanf(String format, String in) {
        var formatTrim = format.trim();

        if (!formatTrim.startsWith("%"))
            throw new IllegalArgumentException("Format starts without qualifier");

        formatTrim = formatTrim.replaceAll("%", "");

        var formatTokens = formatTrim.split(" ");
        var inputTokens = in.trim().split(" ");

        if (formatTokens.length != inputTokens.length) {
            System.out.println("The number of qualifiers should be equal to the number of objects");
            return reTry(format);
        }

        return getObjects(format, formatTokens, inputTokens);
    }

    @FunctionalInterface
    interface Converter<T> {
        T convert(String from) throws Exception;
    }

    private static Object[] getObjects(String format, String[] formatTokens, String[] inTokens) {
        var res = new ArrayList<>();
        Converter converter;

        for (int i = 0; i < formatTokens.length; ++i) {
            converter = switch (formatTokens[i]) {
                case "d" -> Integer::valueOf;
                case "f" -> Double::valueOf;
                case "c" -> from -> from.charAt(0);
                case "s" -> s -> s;
                default -> throw new IllegalArgumentException("Acceptable qualifiers are %d, %f, %c, %s");
            };

            try{
                res.add(converter.convert(inTokens[i]));
            }
            catch (Exception e){
                System.out.println("invalid input, try again");
                return reTry(format);
            }
        }
        return res.toArray();
    }
}