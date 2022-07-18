package get;

public class GetChar {
    public char[] getChar(String[] args, String s) {
        return getCharacter(args, s);
    }

    private char[] getCharacter(String[] args, String s) {
        GetIndex getIndex = new GetIndex();
        int index = getIndex.getIndex(args, s);
        char[] charArray = new char[args.length - index];
        for (int i = index; i < args.length; i++) {
            charArray = args[i].toCharArray();
            break;
        }
        return charArray;
    }
}
