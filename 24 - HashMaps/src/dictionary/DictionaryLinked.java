package dictionary;

public class DictionaryLinked implements Dictionary {
    private Node start;
    private int size;

    private class Node {
        Node next;
        Object key;
        Object value;
    }

    public DictionaryLinked() {
        // Sentinel (tomt listehoved, der ikke indeholder data)
        start = new Node();
        size = 0;
    }

    @Override
    public Object get(Object key) {
        // TODO
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Object put(Object key, Object value) {
        // TODO
        return false;
    }

    @Override
    public Object remove(Object key) {
        // TODO
        return false;
    }

    @Override
    public int size() {
        return size;
    }

}
