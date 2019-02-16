import java.util.ArrayList;

/**
 * @author Alejandro Doberenz
 * @version 2/15/2019
 *
 * This class contains methods to convert a string to a Roman numeral, or an integer to a Roman numeral.
 */
public class RomanNumeral {

    // Returns an array list where each element is a separate symbol.
    private static ArrayList<Symbol> symbolSort(String rom) {
        ArrayList<Symbol> symbols = new ArrayList<>();
        for(int i = 0; i < rom.length(); i++) {
            Symbol current = Symbol.convertToSymbol(String.valueOf(rom.charAt(i)));
            try {
                Symbol next = Symbol.convertToSymbol(String.valueOf(rom.charAt(i+1)));
                if(current.value < next.value) {
                    symbols.add(current.add(next));
                    i++;
                } else
                    symbols.add(current);
            } catch(ArrayIndexOutOfBoundsException | StringIndexOutOfBoundsException ex) {
                symbols.add(current);
            }
        }
        System.out.print("ArraL: ");
        for(int i = 0; i < symbols.size(); i++) {
            if(i==0) {
                System.out.print("[" + symbols.get(i) + ": " + symbols.get(i).value + ", ");
                continue;
            }
            if(i == symbols.size()-1) {
                System.out.println(symbols.get(i) + ": " + symbols.get(i).value + "]");
                continue;
            }
            System.out.print(symbols.get(i) + ": " + symbols.get(i).value + ", ");
        }
        return symbols;
    }

    // Converts a given number into Roman numerals.
    public static String convert(int num) {
        if(num >= 4000)
            throw new IllegalArgumentException("4000 is the maximum allowed input");
        StringBuilder roman = new StringBuilder();
        System.out.print(num + " = ");
        while(true) {
            if(num == 0)
                break;
            if(num / 1000 != 0) {
                roman.append("M");
                num -= 1000;
                continue;
            }
            if(num / 900 != 0) {
                roman.append("CM");
                num -= 900;
                continue;
            }
            if(num / 500 != 0) {
                roman.append("D");
                num -= 500;
                continue;
            }
            if(num / 400 != 0) {
                roman.append("CD");
                num -= 400;
                continue;
            }
            if(num / 100 != 0) {
                roman.append("C");
                num -= 100;
                continue;
            }
            if(num / 90 != 0) {
                roman.append("XC");
                num -= 90;
                continue;
            }
            if(num / 50 != 0) {
                roman.append("L");
                num -= 50;
                continue;
            }
            if(num / 40 != 0) {
                roman.append("XL");
                num -= 40;
                continue;
            }
            if(num / 10 != 0) {
                roman.append("X");
                num -= 10;
                continue;
            }
            if(num / 9 != 0) {
                roman.append("IX");
                num -= 9;
                continue;
            }
            if(num / 5 != 0) {
                roman.append("V");
                num -= 5;
                continue;
            }
            if(num / 4 != 0) {
                roman.append("IV");
                num -= 4;
                continue;
            }
            roman.append("I");
            num -= 1;
        }
        return roman.toString();
    }
    // Converts a given Roman numeral into Arabic script.
    public static int convert(String rom) {
        int arabic = 0;
        for(Symbol s : symbolSort(rom)) {
            arabic += s.value;
        }
        return arabic;
    }

    public static void main(String[] args) {
        System.out.println(convert(46));
        System.out.println(convert(99));
        System.out.println(convert(1819));
        System.out.println(convert(649));
        System.out.println(convert(1983));
        System.out.println(convert(2019));
        System.out.println(convert("XLVI"));
        System.out.println(convert("XCIX"));
        System.out.println(convert("MDCCCXIX"));
        System.out.println(convert("DCXLIX"));
        System.out.println(convert("MCMLXXXIII"));
        System.out.println(convert("MMXIX"));
    }

}