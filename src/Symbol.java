/**
 * @author Alejandro Doberenz
 * @version 2/15/2019
 *
 * A symbol represents the main Roman numerals. The shorthand notations are given their own symbols for simplicity
 * and code cleanliness.
 */
public enum Symbol {

    // <editor-fold defaultstate="collapsed" desc="Roman Numerals">
    M   (1000),
    CM  (900),
    D   (500),
    CD  (400),
    C   (100),
    XC  (90),
    L   (50),
    XL  (40),
    X   (10),
    IX  (9),
    V   (5),
    IV  (4),
    I   (1);
    // </editor-fold>

    public final int value;

    // Method to combine two numerals together.
    public Symbol add(Symbol s) {
        return convertToSymbol(name() + s.name());
    }
    // Converts a given string into a Roman numeral. Returns I if there is no match.
    public static Symbol convertToSymbol(String rom) {
        if(rom.length() > 2)
            throw new IllegalArgumentException("No single symbol is longer than 2 letters");
        switch(rom.toUpperCase()) {
            case "M":
                return Symbol.M;
            case "CM":
                return Symbol.CM;
            case "D":
                return Symbol.D;
            case "CD":
                return Symbol.CD;
            case "C":
                return Symbol.C;
            case "XC":
                return Symbol.XC;
            case "L":
                return Symbol.L;
            case "XL":
                return Symbol.XL;
            case "X":
                return Symbol.X;
            case "IX":
                return Symbol.IX;
            case "V":
                return Symbol.V;
            case "IV":
                return Symbol.IV;
            case "I":
                return Symbol.I;
            default:
                return Symbol.I;
        }
    }

    Symbol(int v) {
        value = v;
    }

}