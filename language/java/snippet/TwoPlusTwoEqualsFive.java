
// Source: http://codegolf.stackexchange.com/a/28818/19043
// "You need to change it even deeper than you can typically access. Note that this is designed for Java 6 with no funky parameters passed in on the JVM that would otherwise change the IntegerCache.
//
//Deep within the Integer class is a Flyweight of Integers. This is an array of Integers from -128 to +127.  cache[132] is the spot where 4 would normally be. //Set it to 5."
public class TwoPlusTwoEqualsFive {

    public static void main(String[] args) throws Exception {
        Class cache = Integer.class.getDeclaredClasses()[0];
        Field c = cache.getDeclaredField("cache");
        c.setAccessible(true);
        Integer[] array = (Integer[]) c.get(cache);
        array[132] = array[133];

        System.out.printf("%d", 2 + 2);
    }

}
