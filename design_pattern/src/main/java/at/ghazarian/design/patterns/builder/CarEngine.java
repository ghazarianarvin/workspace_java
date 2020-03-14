package at.ghazarian.design.patterns.builder;

import lombok.Getter;

@Getter
public final class CarEngine {

    private final String name;
    private final int horsePower;
    private final int yearOfConstruction;

    public CarEngine(String name, int horsePower, int yearOfConstruction) {
        this.name = name;
        this.horsePower = horsePower;
        this.yearOfConstruction = yearOfConstruction;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String name;
        private int horsePower;
        private int yearOfConstruction;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder horsePower(int horsePower) {
            this.horsePower = horsePower;
            return this;
        }

        public Builder yearOfConstruction(int yearOfConstruction) {
            this.yearOfConstruction = yearOfConstruction;
            return this;
        }

        public CarEngine build() {
            return new CarEngine(name, horsePower, yearOfConstruction);
        }
    }
}
