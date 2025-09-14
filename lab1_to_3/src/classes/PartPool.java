package classes;
import java.util.*;

public class PartPool {
    private List<Part> available = new ArrayList<>();
    private List<Part> inUse = new ArrayList<>();

    public PartPool() {
        available.add(new Part("Filter", 50));
        available.add(new Part("Wheel", 200));
    }

    public Part acquire() {
        if (available.isEmpty()) return null;
        Part part = available.remove(0);
        inUse.add(part);
        return part;
    }

    public void release(Part part) {
        inUse.remove(part);
        available.add(part);
    }
}
