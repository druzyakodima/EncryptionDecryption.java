package decryption;

public class DecryptionUnicode implements Decryption {

    @Override
    public String decryption(char[] charArray, int key) {
        return decryptionUnicode(charArray, key);
    }

    private String decryptionUnicode(char[] charArray, int key) {

        StringBuilder words = new StringBuilder();
        int count = key;

        for (char character : charArray) {
            key = count;

            while (key > 0) {
                character -= 1;
                key--;
            }
            words.append(character);
        }
        return words.toString();
    }
}
