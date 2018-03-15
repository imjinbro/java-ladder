package domain;

import java.util.Objects;

public class Name {
    private String name;

    public Name(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
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
