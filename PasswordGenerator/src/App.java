public class App {
    public static void main(String[] args) throws Exception {
        String[] words = new String[]{"cold", "rock", "metal", "plastic", "bottle", "water", "computer", "Java", "Python", "C"};
        
        char[] letters = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

        int[] num = new int[]{3, 5, 7, 9, 2, 4, 6, 8};

        // System.out.println(generatePass(people, num, 3, 5));
        PasswordGenerator Test = new PasswordGenerator(letters, num);
        System.out.println(Test.GeneratePass(20, 20));

        PasswordGenerator Test2 = new PasswordGenerator(words, num);
        System.out.println(Test2.GeneratePass(5, 15));


    }
}
