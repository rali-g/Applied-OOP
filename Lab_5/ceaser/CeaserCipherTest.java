package ceaser;

public class CeaserCipherTest {
    public static void main(String[] args) {

        CaesarCipher ceaser = new CaesarCipher(3);

        System.out.printf("Encrypted text: %s%n", ceaser.encrypt("TOY"));
        System.out.printf("Decrypted text: %s%n", ceaser.decrypt("WRB"));
    }
}
