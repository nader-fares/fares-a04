package baseline;

public class Word {
    String name;
    int occurrenceCounter;

    public int getOccurrenceCounter() {
        return occurrenceCounter;
    }


    public Word(String name, int occurrenceCounter) {
        this.name = name;
        this.occurrenceCounter = occurrenceCounter;
    }

}
