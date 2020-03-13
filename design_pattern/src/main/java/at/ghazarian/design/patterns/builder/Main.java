package at.ghazarian.design.patterns.builder;

public class Main {

    public static void main(String[] args) {
        CarEngine bmwEngine = new CarEngine("BMW engine", 200, 2015);
        CarEngine fordEngine = new CarEngine("Ford engine", 2014, 200);

        CarEngine.builder()
                .name("VM")
                .horsePower(60)
                .yearOfConstruction(1990)
                .build();
    }
}
