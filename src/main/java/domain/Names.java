package domain;

import java.util.ArrayList;
import java.util.Arrays;

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


    // TODO : 리팩토링
    static boolean searchDuplicateName(String[] names) {
        Arrays.sort(names);
        int startIdx = 0;
        for (int i = startIdx; i < names.length; i++) {
            if (isDiffHeader(names[startIdx], names[startIdx + i])) {
                startIdx++;
                continue;
            }

            if (names[startIdx].equals(names[startIdx + 1])) {
                return true;
            }
        }
        return false;
    }

    private static boolean isDiffHeader(String targetName, String comparisonName) {
        int headerIdx = 0;
        return targetName.charAt(headerIdx) != comparisonName.charAt(headerIdx);
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
