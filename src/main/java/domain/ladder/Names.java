package domain.ladder;

public class Names {
    private String[] names;

    Names(String[] names) {
        this.names = names;
    }

    public String getPlayerName(int position) {
        return names[position];
    }

    public int getPlayerNumber() {
        return names.length;
    }
}
