package blogic;

public enum AnimalType {
    BIRD("Птица"),
    MAMMAL("Бозайник"),
    REPTILE ("Влечуго"),
    FISH("Риба");

    private final String typeName;

    AnimalType(String typeName) { this.typeName = typeName; }
    public String getTypeName() { return typeName; }
}

