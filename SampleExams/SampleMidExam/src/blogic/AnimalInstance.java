package blogic;

public class AnimalInstance {
    int animalKey;
    String animalName;
    int animalAge;

    private final String INSTANCE_ID;
    private static int counter = 1;
    public AnimalInstance(int animalKey, String animalName, int animalAge) {
        setAnimalKey(animalKey);
        setAnimalName(animalName);
        setAnimalAge(animalAge);
        INSTANCE_ID = String.format("%s, %03d", animalName, counter++);
    }

    public int getAnimalKey() {
        return animalKey;
    }

    public void setAnimalKey(int animalKey) {
        if(animalKey < 0){
            this.animalKey = 1;
        }else{
            this.animalKey = animalKey;
        }
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        if(animalName == null || animalName.isEmpty()){
            animalName = "Unknown";
        }else{
            this.animalName = animalName;
        }
    }

    public int getAnimalAge() {
        return animalAge;
    }

    public void setAnimalAge(int animalAge) {
        this.animalAge = animalAge;
    }

    @Override
    public String toString() {
        return String.format("%s, Възраст: %3d", INSTANCE_ID, animalAge);
    }
}
