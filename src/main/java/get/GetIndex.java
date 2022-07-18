package get;

public class GetIndex {

    public int getIndex(String[] args, String s) {
        return getIdx(args, s);
    }

    private int getIdx(String[] args, String s) {
        int index = 0;

        for (int i = 0; i < args.length; i++) {
            if (args[i].matches(s)) {
                index = i + 1;
                break;
            }
        }
        return index;
    }
}
