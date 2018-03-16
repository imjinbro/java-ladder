package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Names {
    private static final int MIN_PLAYER_NUM = 2;
    private ArrayList<Name> names = new ArrayList<>();

    public Names(String[] splitNames) {
        if (searchDuplicateName(splitNames)) {
            throw new IllegalArgumentException("중복된 이름이 있습니다.");
        }

        if (isInvalidPlayerNum(splitNames)) {
            throw new IllegalArgumentException(MIN_PLAYER_NUM + "명 이상이어야 합니다.");
        }
        initNames(splitNames);
    }

    private void initNames(String[] splitNames) {
        for (String name : splitNames) {
            names.add(new Name(name));
        }
    }

    static boolean isInvalidPlayerNum(String[] names) {
        return MIN_PLAYER_NUM > names.length;
    }

    static boolean searchDuplicateName(String[] names) {
        HashSet<String> nameBox = new HashSet<>(Arrays.asList(names));
        return names.length != nameBox.size();
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

    public int getMaxNameLength() {
        Name firstName = names.stream().findFirst().get();
        return firstName.getMaxNameLength();
    }
}
