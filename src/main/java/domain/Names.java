package domain;

import java.util.ArrayList;

public class Names {
    private ArrayList<Name> names = new ArrayList<>();

    public Names(String[] names) {
        initNames(names);
    }

    private void initNames(String[] splitNames) {
        for (String name : splitNames) {
            names.add(new Name(name));
        }
    }

    public String getPlayerName(int position) {
        Name searchName = names.get(position);
        return searchName.getName();
    }

    public int getPlayerNumber() {
        return names.size();
    }

    public boolean isExistName(String name) {
        return names.contains(new Name(name));
    }
}
