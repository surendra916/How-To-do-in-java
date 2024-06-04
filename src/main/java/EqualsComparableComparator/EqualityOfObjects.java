package EqualsComparableComparator;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

/*
* "==" is for (referential/address) equality. "equals" method checks for content Equality.
* For existing object instances like "String" and "wrapper classes" and
* "Date-Time" classes ".equals" compares the content equality.
* "equals" method is defined in the Object class so that every Java object inherits it. By default,
* its implementation compares object memory addresses, so it works the same as the == operator.
* However, we can override this method in order to define what equality means for our objects.
* String, Wrapper classes and Date - Time classes implemented/overridden their own "equals" method to check for content equality.
* Same way we can also override the "equals" method in whatever way we want.
*
* */
public class EqualityOfObjects {
    public static void main(String[] args) {
        Integer a = new Integer(1);
        Integer b = new Integer(1);

        Integer c = Integer.valueOf(10);
        Integer d = Integer.valueOf(10);


        System.out.println(c == d);// true
        System.out.println(c.equals(d)); //true

//        if (a.equals(b)){ // True
//            System.out.println("Equal");
//        }
//
//        if(a == b){ // false
//            System.out.println("Equal");
//        }else {
//            System.out.println("Not Equal");
//        }

//        Objects.nonNull(a); // checks for return "a != null", Returns True of False
//        Objects.requireNonNull(a); // returns passed object if not null, Throws NullPointerException if NULL

        // Instead of using a == b, we can use below as well
        // Even if in case 1 variable is null then we don't have to check the nullability.
        // String a =  null;
        // String b =  "Hello"; Objects.equals(a,b) => Very handy to use.
        if(Objects.equals(a,b)){  // (a == b) || (a != null && a.equals(b));
            System.out.println("Equals");
        }

//        String s1 = "Hai";
//        String s2 = "Hai";
//
//        System.out.println(s1 == s2); // True
//        System.out.println(s1.equals(s2)); // True

        // Above statements are true only in String but not in other DATE-TIME (or) WRAPPER classes
        // Because it has a concept of String pool
//        String s3 = new String("sss");
//        String s4 = new String("sss");
//        System.out.println(s3 == s4);//false
//        System.out.println(s3.equals(s4));// True

       // ************************************************************************************************************************************************
       // Alternative to Integer num1 = new Integer(1) => deprecated because it is overhead for java to create multiple wrappers thus degrades memory & performance
       // Recommended is Integer.valueOf(2); => maintains values in cache, Thus by improving performance
//        Integer val1 = Integer.valueOf(1);
//        Integer val2 = Integer.valueOf(1);

//        Integer i1 = 1;
//        Integer i2 = 1;
//        System.out.println(i1 == i2); // true
//        System.out.println(i1.equals(i2));// true

//        if(val1 == val2){
//            System.out.println("val1 == val2: "+(val1 == val2));// True( Because it uses same copy from cache which is used, somewhat similar to String constant pool
//        }
//        if(val1.equals(val2)){
//            System.out.println("val1.equals(val2): "+val1.equals(val2));// True
//        }
        // **********Thus above functionality will be available for all String & WRAPPER classes.**************
        //***********************************************************************************************************************************

        // Same cache concept as above
//        String s1 = new String("sss");
//        String s2 = new String("sss");
//        // s1 == s2 // False because referential equality(Addresses are different)
//        // s1.equals(s2) // True => Content equality because equals and hashcode is being overridden
//        // Instead of above we can go with String.valueOf()

//        String s3 = String.valueOf("ss");
//        String s4 = String.valueOf("ss");
//        System.out.println("s3 == s4 : "+(s3 == s4));
//        System.out.println("s3.equals(s4) : "+s3.equals(s4));
    }
}


