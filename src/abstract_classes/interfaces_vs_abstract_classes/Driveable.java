package abstract_classes.interfaces_vs_abstract_classes;

public interface Driveable {
    default boolean doesItMove() {
        return true;
    }

}
