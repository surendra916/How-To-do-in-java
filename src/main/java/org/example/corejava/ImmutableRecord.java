package org.example.corejava;


import java.util.ArrayList;
import java.util.List;


/*
* Do not provide setter methods
* Make all fields final and private
* Do not allow subclasses to override methods.
* The easiest way is to declare the class as final. Final classes in Java can not be extended.
*
* */
final class ImmutableRecord {
    private final long id;
    private final String name;
    private final List<String> tokens;
    public ImmutableRecord(long id, String name, List<String> tokens) {
        this.id = id;
        this.name = name;
        this.tokens = tokens;
    }
    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public List<String> getTokens() {
        return new ArrayList<>(tokens);
    }
    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tokens=" + tokens +
                '}';
    }
}
