package org.example.corejava;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;


// Which is better for storing password ? char[] or String
// ans: char[]
// Explanation: If we store in STRING then it will be stored in STRING CONSTANT POOL(SCP). So, GARBAGE COLLECTOR(GC) will not go to SCP so frequently.
// For GC to perform cleanup activity, JVM needs to be restarted. So There's a high chance that STRING LITERAL stays longer in SCP
// resulting in SECURITY THREAT and can also access by people who have MEMORY DUMP ACCESS

/*
* Do not provide setter methods So other way to set your instance variables data is through parameterized constructor
* Make all instance variables  private and final so that they cannot be modified.
* Do not allow subclasses to override methods.The easiest way is to declare the class as final. Final classes in Java can not be inherited.
* If we have MUTABLE fields in the class prefer sending a clone as we did for List<String> token in the below class.
* */
final class ImmutableRecord {
    private final long id;
    private final String name;
    private final List<String> tokens;

    // Suppose if we have a custom class lets say Address
    //private final Address address;


    private final Date dob;
    public ImmutableRecord(long id, String name, List<String> tokens, Date dobb) {// Address address
        this.id = id;
        this.name = name;
        this.tokens = tokens;
        this.dob = dobb;
        //this.address = address;
    }

    //Send a new Object like below
//    public Address getAddress(){
//        return new Address(address.getZip(), address.getPinCode());
//    }

    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public Date getDob(){
        return (Date) new Date().clone(); // Clone it like this
    }

    public List<String> getTokens() {
        // We can also send it as
        //return Collections.unmodifiableList(tokens);// So if someone tries to modify It gives error
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

