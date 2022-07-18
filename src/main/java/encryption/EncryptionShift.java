package encryption;

public class EncryptionShift implements Encryption {

    @Override
    public String encryption(char[] charArray, int key) {
        return encryptionShift(charArray, key);
    }

    private String encryptionShift(char[] charArray, int key) {

        StringBuilder words = new StringBuilder();
        int count = key;

        for (char c : charArray) {
            key = count;
            int length = c >= 65 && c <= 91 ? 91 : 123;
            if (c >= 'A') {
                for (int i = c; i <= length; i++) {
                    if (i == length) {
                        i = c - 25;
                    }
                    c = (char) i;
                    if (key == 0) {
                        break;
                    }
                    key--;
                }
            }
            words.append(c);
        }
        return words.toString();
    }
}
