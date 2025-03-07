public class PhoneCoder {
    private int key;

    public PhoneCoder() {
    }

    public PhoneCoder(int key) {
        this.key = key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    private static String swap(String phoneNumber) {
        StringBuilder sb = new StringBuilder(phoneNumber);
        char temp = sb.charAt(0);
        sb.setCharAt(0, sb.charAt(2));
        sb.setCharAt(2, temp);

        temp = sb.charAt(1);
        sb.setCharAt(1, sb.charAt(3));
        sb.setCharAt(3, temp);
        return sb.toString();
    }

    public String encode(String phoneNumber) {
        String result = "";
        for (int i = 0; i < phoneNumber.length(); i++) {
            int number = phoneNumber.charAt(i) - '0';
            number = (number + key) % 10;
            result += (char) (number + '0');
        }
        return swap(result);
    }

    public String decode(String phoneNumber) {
        String result = "";
        phoneNumber = swap(phoneNumber);
        for (int i = 0; i < phoneNumber.length(); i++) {
            int number = phoneNumber.charAt(i) - '0';
            if (number < key)
                number += 10;
            number -= key;
            result += (char) (number + '0');
        }

        return result;
    }

    public String toString() {
        String result = "";
        result += "PhoneCoder : ";
        result += (char)key;
        return result;
    }
}
