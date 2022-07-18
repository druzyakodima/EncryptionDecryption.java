import decryption.Decryption;
import decryption.DecryptionShift;
import decryption.DecryptionUnicode;
import encryption.Encryption;
import encryption.EncryptionShift;
import encryption.EncryptionUnicode;
import get.GetChar;
import get.GetIndex;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        String[] args1 = {
                "-alg", "unicode",
                "-mode", "enc",
                "-key", "5",
                "-in", "input.txt",
                "-out", "output.txt"};

        GetIndex getIndex = new GetIndex();
        GetChar getChar = new GetChar();
        ArrayList<String> encWords = new ArrayList<>();

        String flag = Arrays.toString(args1).matches("(.*)enc(.*)") ? "enc" : Arrays.toString(args1).matches("(.*)dec(.*)") ? "dec" : "enc";
        String alg = Arrays.toString(args1).matches("(.*)shift(.*)") ? "shift" : Arrays.toString(args1).matches("(.*)unicode(.*)") ? "unicode" : "shift";

        Decryption decryption;
        Encryption encryption;

        if (alg.matches("(.*)unicode(.*)")) {
            encryption = new EncryptionUnicode();
            decryption = new DecryptionUnicode();
        } else {
            encryption = new EncryptionShift();
            decryption = new DecryptionShift();
        }

        int index = getIndex.getIndex(args1, "-key");
        int key = Integer.parseInt(args1[index]);

        if (Arrays.toString(args1).matches("(.*)-in(.*)")) {
            int indexIn = getIndex.getIndex(args1, "-in");
            File fileReader = new File(args1[indexIn]);
            fileReader.createNewFile();
            try (BufferedReader reader = new BufferedReader(new FileReader(fileReader))) {
                encWords.add(reader.readLine());
                char[] arr = encWords.toString().replace("[", "").replace("]", "").toCharArray();
                encWords.clear();

                if (flag.equals("enc")) {
                    encWords.add(encryption.encryption(arr, key));
                } else {
                    encWords.add(decryption.decryption(arr, key));
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }


        if (Arrays.toString(args1).matches("(.*)-data(.*)")) {
            char[] charArray = getChar.getChar(args1, "-data");
            System.out.println(flag.equals("dec") ? decryption.decryption(charArray, key) : encryption.encryption(charArray, key));
        }

        if (Arrays.toString(args1).matches("(.*)-out(.*)")) {
            int indexOut = getIndex.getIndex(args1, "-out");
            File fileWriter = new File(args1[indexOut]);
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileWriter))) {

                writer.write(encWords.toString().replace("[", "").replace("]", ""));
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}