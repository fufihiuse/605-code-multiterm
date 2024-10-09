package abstract_classes.interfaces_vs_abstract_classes;

public interface Pilotable {
    default boolean doesItFly() {
        return true;
    }
}
