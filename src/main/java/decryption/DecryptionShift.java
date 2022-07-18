package decryption;

public class DecryptionShift implements Decryption {

    @Override
    public String decryption(char[] charArray, int key) {
        return decryptionShift(charArray, key);
    }

    private String decryptionShift(char[] charArray, int key) {

        StringBuilder words = new StringBuilder();
        int count = key;

        for (char c : charArray) {
            key = count;
            int length = c >= 65 && c <= 91 ? 65 : 97;

            if (c >= 'A') {
                for (int i = c; i >= length; i--) {
                    c = (char) i;
                    if (i == length) {
                        i = length + 26;
                    }
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
