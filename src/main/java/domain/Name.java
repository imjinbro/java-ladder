package domain;

import java.util.Objects;

public class Name {
    private static final int MAX_NAME_LENGTH = 5;
    private String name;

    public Name(String name) throws IllegalArgumentException {
        if (isInvalidLength(name)) {
            throw new IllegalArgumentException(MAX_NAME_LENGTH + "자 이하 입력해야합니다");
        }
        this.name = name;
    }

    static boolean isInvalidLength(String name) {
        return name.length() > MAX_NAME_LENGTH;
    }

    public String getName() {
        return name;
    }

    public int getMaxNameLength() {
        return MAX_NAME_LENGTH;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Name comparisonName = (Name) obj;
        return Objects.equals(name, comparisonName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
