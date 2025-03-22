package ceaser;

public class CaesarCipher {
    private int shiftLength;
    private final char CAPITAL_LETTER_A  = 'A';

    public CaesarCipher(int shiftLength) {
        this.shiftLength = shiftLength;
    }

    public int getShiftLength() {
        return shiftLength;
    }

    public void setShiftLength(int shiftLength) {
        this.shiftLength = shiftLength > 0 ? shiftLength % 26 : 3;
    }

    public String encrypt(String plainText) {
        char[] symbols = plainText.toCharArray();
        for(int i = 0; i < symbols.length; i++){
            symbols[i] = (char)((symbols[i] + shiftLength - CAPITAL_LETTER_A) % 26 + CAPITAL_LETTER_A);
        }
        return new String(symbols);
    }

    public String decrypt(String cipherText) {
        char[] symbols = cipherText.toCharArray();

        for(int i = 0; i < symbols.length; i++){
            symbols[i] = (char)((symbols[i] - shiftLength + 26 - CAPITAL_LETTER_A) % 26 + CAPITAL_LETTER_A);
        }
        return new String(symbols);
    }
}
