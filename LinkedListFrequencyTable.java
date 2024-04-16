package aufgabe2;

import aufgabe2.AbstractFrequencyTable;
import aufgabe2.Word;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author oliverbittel
 */
public class LinkedListFrequencyTable extends AbstractFrequencyTable {

        private Node end;
        private Node begin;
        private int size;


    private static class Node {

        private Word data;
        private Node prev;
        private Node next;

        private Node(Word x, Node n, Node p) {
            data = x;
            next = n;
            prev = p;
        }

    }

    public LinkedListFrequencyTable() {
        end = new Node(null, null, null);
        begin = new Node(null, end, null);
        end.prev = begin;
        size = 0;

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public final void clear() {
        size = 0;
        begin.next = end;
        end.prev = begin;
    }

    @Override
    public void add(String w, int f) {
        Word x = new Word(w, f);
        addNode(x);
    }

    public void addNode(Word x) {

        Node zeiger = begin.next;
        while (zeiger != end) {
            if (zeiger.data.getWord().equals(x.getWord())) {
                zeiger.data.addFrequency(x.getFrequency());
                moveToLeft(zeiger);
                return;
            }
            zeiger = zeiger.next;
        }//neue Node hinten
        Node newNode = new Node(x, end, end.prev);
        end.prev.next = newNode;
        end.prev = newNode;
        moveToLeft(newNode);
        size++;
    }

    @Override
    public Word get(int pos) {
        if(pos < 0 || pos >= size) 
            throw new IndexOutOfBoundsException();
        Node n = begin.next;
        for(int i = 0;i < pos; i++) {
            n = n.next;
        }
        return n.data;
    }

        @Override
    public int get(String w) {
        Node zeiger = begin.next;
        while(zeiger != end) {
            if (zeiger.data.getWord().equals(w)) {
                return zeiger.data.getFrequency();
            }
            zeiger = zeiger.next;
        }
        return 0;
    }

    private void moveToLeft(Node n) {
        Node zeiger = n.prev;
        Word w = n.data;

        while (zeiger != begin && zeiger.data.getFrequency() < w.getFrequency()) {
            zeiger.next.data = zeiger.data;
            zeiger = zeiger.prev;
        }
        zeiger.next.data = w;
        

        /* 
        // Entferne n aus seiner aktuellen Position
        n.prev.next = n.next;
        n.next.prev = n.prev;
    
        // Füge n an die richtige Position in der Liste ein
        n.prev = zeiger;
        n.next = zeiger.next;
        zeiger.next.prev = n;
        zeiger.next = n; */
    }
}