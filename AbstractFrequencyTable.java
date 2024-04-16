package aufgabe2;
import java.util.Arrays;

/**
 *
 * @author oliverbittel
 */
public abstract class AbstractFrequencyTable implements aufgabe2.FrequencyTable {
    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public void add(String w) {
        add(w, 1);
    }

    @Override
    public void addAll(aufgabe2.FrequencyTable fq) {
        // Ihr Code:
        for (int i = 0; i < fq.size(); i++) {
            Word word = fq.get(i);
            //if (word != null) {
            add(word.getWord(), word.getFrequency());
            //}
        }
    }
    @Override
    public void collectNMostFrequent(int n, FrequencyTable fq) {
        // Ihr Code:
        fq.clear();
        for(int i = 0; i < n; i++){
            
            if(i == size()){
                return;
            }

            Word a = get(i);
            fq.add(a.getWord(), a.getFrequency());
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("{");
        // Ihr Code:
        for (int i = 0; i < size(); i++) {
            s.append(get(i));
            s.append(", ");
            
        }
        s.append(String.format("} size = %d", size()));
        return s.toString();
    }
}