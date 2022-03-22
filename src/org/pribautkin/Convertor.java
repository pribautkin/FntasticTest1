package org.pribautkin;

import java.util.Objects;

public class Convertor {

    public static void main(String[] args) {
        Convertor convertor = new Convertor();
        assertEquals(convertor.convert("din"), "(((");
        assertEquals(convertor.convert("recede"), "()()()");
        assertEquals(convertor.convert("Success"), ")())())");
        assertEquals(convertor.convert("(( @"), "))((");
    }

    /**
     * @param source Source string
     * @return Converted string
     */
    private String convert(String source) {
        char[] chars = source.toLowerCase().toCharArray();
        char[] result = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            if (result[i] != 0) {
                continue;
            }
            boolean wasRepeated = false;
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j] && result[j] == 0) {
                    result[j] = ')';
                    wasRepeated = true;
                }
            }
            result[i] = wasRepeated ? ')' : '(';
        }
        return new String(result);
    }

    private static void assertEquals(String result, String expectedResult) {
        if (!Objects.equals(result, expectedResult)) {
            throw new RuntimeException("Assertion error. Result: " + result + " Expected: " + expectedResult);
        }
    }

}
