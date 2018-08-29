
/**
Following are some interesting facts about String and StringBuffer classes :
1. Objects of String are immutable.
2. String class in Java does not have reverse() method, however StringBuilder class has built in reverse() method.
3. StringBuilder class do not have toCharArray() method, while String class does have toCharArray() method.
**/

// Class of ReverseString
class ReverseString
{
    public static void main(String[] args)
    {
        String input = "GeeksForGeeks";
 
        // convert String to character array
        // by using toCharArray
        char[] try1 = input.toCharArray();
 
        for (int i = try1.length-1; i>=0; i--)
            System.out.print(try1[i]);
    }
}

