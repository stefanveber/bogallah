package aufgabe2;

import aufgabe2.AbstractFrequencyTable;
import aufgabe2.Word;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author oliverbittel
 */
public class ArrayFrequencyTable extends AbstractFrequencyTable {

    private int size = 0;
    private Word fqTable[];
    private final int DEFAULT_SIZE = 100;

    public ArrayFrequencyTable() {
        clear();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public final void clear() {
        // throw muss auskommentiert werden!
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        // Ihr Code:
        size = 0;
        fqTable = new Word[DEFAULT_SIZE];

    }

    @Override
    public void add(String w, int f) {
        // throw muss auskommentiert werden!
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        // Ihr Code:
        // Prüfe, ob das Wort bereits in der Tabelle existiert
        
        if (size == fqTable.length){
            fqTable = Arrays.copyOf(fqTable, size*2);
        }

        for(int i = 0; i < size(); i++){
            if(get(i).getWord().equals(w)){
                Word a = get(i);
                a.addFrequency(f);
                moveToLeft(i);
                return;
            }
        }
        Word nWord = new Word(w, f);
        fqTable[size] = nWord;
        size ++;
        moveToLeft(size-1);
        }
        /*for (int i = 0; i < size; i++) {
            if (fqTable[i].getWord().equals(w)) {
                // Wort existiert bereits, erhöhe die Häufigkeit
                fqTable[i].addFrequency(f);
                return;
            }
        }

        // Wort existiert nicht, füge es hinzu
        if (size >= fqTable.length) {
            // Vergrößere das Array, wenn notwendig
            Word[] newTable = new Word[size * 2];
            System.arraycopy(fqTable, 0, newTable, 0, size);
            fqTable = newTable;
        }

        fqTable[size] = new Word(w, f);
        size++; */

    @Override
    public Word get(int pos) {
        // throw muss auskommentiert werden!
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        // Ihr Code:
        if (pos >= 0 && pos < size) {
            return fqTable[pos];
        }
        return null;
    }

    @Override
    public int get(String w) {
        // throw muss auskommentiert werden!
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        // Ihr Code:
        for (int i = size()-1; i >= 0; i--) {

            if (w  == fqTable[i].getWord()) {
                return fqTable[i].getFrequency();
            }
        }
        return 0; 
    }


    private void moveToLeft(int pos){
        Word w = fqTable[pos];
        int i = pos-1;
        while(i >= 0 && fqTable[i].getFrequency() < w.getFrequency()) {
            fqTable[i+1] = fqTable[i];
            i--;
        } 
        fqTable[i + 1] = w;
    }
}