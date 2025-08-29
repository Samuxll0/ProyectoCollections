package TallerCollections;
import java.util.LinkedHashMap;
import java.util.Map;

//Ejerecicio 13: Caché LRU mini. 

class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private int capacidad;

    public LRUCache(int capacidad) {
        super(capacidad, 0.75f, true); 
        this.capacidad = capacidad;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacidad;
    }
}

public class CacheLRU {
    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<>(3);

        cache.put(1, "A");
        cache.put(2, "B");
        cache.put(3, "C");
        System.out.println("Cache inicial: " + cache);

        cache.get(1);

        cache.put(4, "D");

        System.out.println("Cache después de acceder 1 y agregar 4: " + cache);

        cache.get(3);

        cache.put(5, "E");

        System.out.println("Cache final: " + cache);
    }
}
