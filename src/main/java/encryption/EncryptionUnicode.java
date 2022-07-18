package encryption;

public class EncryptionUnicode implements Encryption {

    @Override
    public String encryption(char[] charArray, int key) {
        return encryptionUnicode(charArray, key);
    }

    private String encryptionUnicode(char[] charArray, int key) {

        StringBuilder words = new StringBuilder();
        int count = key;

        for (char character : charArray) {
            key = count;
            while (key > 0) {
                character += 1;
                key--;
            }
            words.append(character);
        }
        return words.toString();
    }
}
