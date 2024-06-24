public class Outputoverloading
{
    private String function(String temp, int data)
    {
        return ("GFG");
    }
    private String function(int data, String temp)
    {
        return ("GeeksforGeeks");
    }
    public static void main(String[] args)
    {
        Outputoverloading obj = new Outputoverloading();
        System.out.println(obj.function(4, "GFG"));
    }
}
