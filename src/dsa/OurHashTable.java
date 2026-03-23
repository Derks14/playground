package dsa;

import java.util.Hashtable;

public class OurHashTable {

    // buckets

    // collision is when the key.hashcode() value of a key in an entry<k, v> list have the same location or ( mod 10 valuess)
    // collision - we turn buckets into a linked list to solve a collision

    // Hashtable - A data structure that stores unique keys to values example
//                 Entry- Each key/value pair is known as an Entry
    //             Fast insertion, look up, deletion of key/value pairs
    //             Not ideal for small data sets, great with large data sets


    // hashing - takes a key and computes an integer ( formula will vary based on key & data type )
//                In a Hashtable, we use the hash % capacity to calculate an index number
//
//                key.hashCode() % capacity = index

//    bucket = an indexed storage location for on more entries
//              can store multiple entries in case of a collision ( linked similarly a Linkedlist)


//    collision = hash function generates the same index for more than one key
//                less collisions = more efficiency

//    runtime complexity : Best Case    O(1) - with no collisions
//                         Worst case   O(n) - all our entries in one giant bucket ( a linked list )





    public static void main(String[] args) {

        Hashtable<String, String> table = new Hashtable<>(100);
        table.put("100", "SpongeBob");
        table.put("123", "Patrick");
        table.put("321", "Sandy");
        table.put("555", "Squidward");
//        System.out.println(table);


        for ( String key: table.keySet()) {
            System.out.println(key.hashCode() % 100 + "\t" + key + "\t" + " " + table.get(key));
        }
    }
}
