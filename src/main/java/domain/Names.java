package domain;

import java.util.ArrayList;

public class Names {
    private static final int MIN_PLAYER_NUM = 2;
    private ArrayList<Name> names = new ArrayList<>();

    public Names(String[] splitNames) {
        if (isInvalidPlayerNum(splitNames)) {
            throw new IllegalArgumentException(MIN_PLAYER_NUM + "명 이상이어야 합니다.");
        }

        for (String name : splitNames) {
            names.add(new Name(name));
        }
    }

    static boolean isInvalidPlayerNum(String[] names) {
        return MIN_PLAYER_NUM > names.length;
    }

    // TODO : 중복 체크해서 예외 발생시키기

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
