import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Problem269 p = new Problem269();
        String[] words = {"abcdefgh","bdefghij","cghij","dfghij","efghij","fghij","ghij","hij","ij","j","abcdefghi","bdefghijk","cghijk","dfghijk","efghijk","fghijk","ghijk","hijk","ijk","jk","k"};
        System.out.println(p.foreignDictionary(words));
    }
}