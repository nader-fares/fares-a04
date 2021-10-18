package baseline;

public class Word {
    private final String name;
    int occurrenceCounter;

    public String getName() {
        return name;
    }

    public int getOccurrenceCounter() {
        return occurrenceCounter;
    }


    public Word(String name, int occurrenceCounter) {
        this.name = name;
        this.occurrenceCounter = occurrenceCounter;
    }

}
