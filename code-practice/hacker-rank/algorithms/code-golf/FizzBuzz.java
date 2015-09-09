//Source: https://www.hackerrank.com/challenges/fizzbuzz
//public class Solution{public static void main(String[]args){for(int i=1;i<101;i++){if(i%3==0)l("Fizz");if(i%5==0)l("Buzz");else if(i%3!=0)l(""+i);l("\n");}}static void l(String s){System.out.print(s);}}

// public class Solution{public static void main(String[]a){for(int i=1;i<101;i++){l(i%3==0?"Fizz":"");l(i%5==0?"Buzz":i%3!=0?""+i:"");l("\n");}}static void l(String s){System.out.print(s);}}
public class Solution{
    public static void main(String[]a){for(int i=1;i<101;i++){
        l(i%3==0?"Fizz":"");
        l(i%5==0?"Buzz":i%3!=0?""+i:"");
        l("\n");
    }}
    static void l(String s){System.out.print(s);}
}

public class Solution{
    public static void main(String[]a){for(int i=1;i<101;i++){
        l(i%3==0?"Fizz":"");
        l(i%5==0?"Buzz\n":i%3!=0?i+"\n":"\n");
    }}
    static void l(String s){System.out.print(s);}
}

public class Solution{
    public static void main(String[]a){for(int i=0;++i<101;){
        l(i%3==0?"Fizz":"");
        l(i%5==0?"Buzz\n":i%3!=0?i+"\n":"\n");
    }}
    static void l(String s){System.out.print(s);}
}

public class Solution{
  public static void main(String[]a){for(int i=0;++i<101;){
    System.out.println( (i%3>0?"":"Fizz") + (a%5<1?a%3>0?i:"":"Buzz") );
  }}
}





// In Anonlang-ish
print 1..100.map(i%3?:'Fizz',i%5?:'Buzz').join('\n')
