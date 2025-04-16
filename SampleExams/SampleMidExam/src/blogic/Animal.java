package blogic;

public class Animal {
    String name;
    AnimalType animalType;
    boolean predator;
    String region;
    boolean endangered;

    public Animal(String name, AnimalType animalType, boolean predator, String region, boolean endangered) {
        setName(name);
        setAnimalType(animalType);
        setPredator(predator);
        setRegion(region);
        setEndangered(endangered);
    }

    public static final String[] REGIONS = {"Africa", "Asia", "Australia", "Europe", "America"};

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || name.isEmpty()) {
            this.name = "Unknown";
        }
        else {
            this.name = name;
        }
    }

    public AnimalType getAnimalType() {
        return animalType;
    }

    public void setAnimalType(AnimalType animalType) {
        if(animalType == null) {
            animalType = AnimalType.BIRD;
        }
        else{
            this.animalType = animalType;
        }
    }

    public boolean isPredator() {
        return predator;
    }

    public void setPredator(boolean predator) {
        this.predator = predator;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        if(region != null || !region.isEmpty()) {
            for (int i = 0; i < REGIONS.length; i++) {
                if(REGIONS[i].equals(region)) {
                    this.region = REGIONS[i];
                    return;
                }
            }
        }
        this.region = "Unknown";
    }

    public boolean isEndangered() {
        return endangered;
    }

    public void setEndangered(boolean endangered) {
        this.endangered = endangered;
    }

    @Override
    public String toString(){
        //Животно{ Фламинго, тип= Птица, хищник= Не, район= Africa, застрашен= Не}
        return String.format("Животно{%s, тип= %s, хищник= %s, " +
                "район= %s, застрашен= %s", name, animalType.getTypeName(),
                (predator)? "Да" : "Не", region, (endangered)? "Да" : "Не");
    }
}
