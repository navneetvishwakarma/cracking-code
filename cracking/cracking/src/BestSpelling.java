import java.io.*;
import java.util.*;

/**
 * Write a program that reads a large list of English words (e.g. from /usr/share/dict/words on a unix system) into
 * memory, and then reads words from stdin, and prints either the best spelling suggestion, or "NO SUGGESTION" if no
 * suggestion can be found. The program should print ">" as a prompt before reading each word, and should loop until killed.
 * <p/>
 * <p/>
 * Your solution should be faster than O(n) per word checked, where n is the length of the dictionary. In particular, you
 * can't scan the dictionary every time you want to spellcheck a word.
 * <p/>
 * <p/>
 * For example:
 * <p/>
 * > sheeep
 * sheep
 * > peeple
 * people
 * <p/>
 * > sheeple
 * NO SUGGESTION
 * <p/>
 * The class of spelling mistakes to be corrected is as follows:
 * <p/>
 * <p/>
 * - Changing one letter: "freend" => "friend"
 * - Removing one letter: "enem" => "enemy"
 * - Adding one letter: "fuun" => "fun"
 * <p/>
 * <p/>
 * For the purposes of this problem, ignore differences between uppercase and lowercase.
 * <p/>
 * If there are many possible corrections of an input word, your program can choose one in any way you like. It just
 * has to be an English word that is a spelling correction of the input by the above rules.
 * <p/>
 * Please provide directions for running the program and or tests. You may use any language, but Scala (followed by
 * Java) would be best. If you don’t know Scala, we would love to see you try it out!
 *
 */
public class BestSpelling {
    // static set of alphabets in English language
    private static final char[] alphabetSet = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private Set<String> dict;
    private Random random;

    /**
     * Get a random number generator on demand.
     *
     * @return <code>Random</code> object
     */
    public Random getRandom() {
        if(random == null) {
            random = new Random();
        }
        return random;
    }

    /**
     * Constructor for <code>BestSpelling</code>
     *
     * @param in input stream pointing to dictionary resource
     * @throws IOException in case of any IO errors
     */
    public BestSpelling(InputStream in) throws IOException {
        loadDict(in);
    }

    /**
     * Main method asking input words from the command line and feeding them to the algorithm
     */
    public void run() {
        Scanner s = new Scanner(System.in);
        while(true) {
            System.out.print("> ");
            String input = s.nextLine();
            String res = suggest(input.toLowerCase());
            if(res != null) {
                System.out.println(res);
            } else {
                // nothing close enough
                System.out.println("NO SUGGESTION");
            }
        }
    }

    // load dictionary into memory from resource pointed to by input stream
    private void loadDict(InputStream in) throws IOException {
        String line;
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        Set<String> words = new HashSet<String>();
        while((line = reader.readLine()) != null) {
            words.add(line.toLowerCase().trim());
        }
        // once loaded, this set cannot be modified
        dict = Collections.unmodifiableSet(words);
    }

    // suggest the best spelling for given input word
    private String suggest(String input) {
        if(dict.contains(input)) {
            // case 1: word already exists in the database
            return input;
        } else {
            Set<String> candidates = new HashSet<String>();
            // case 2: changing one letter
            singleLetterChange(input, candidates);
            // case 3: removing one letter
            singleLetterRemoval(input, candidates);
            // case 4: adding one letter
            singleLetterAddition(input, candidates);

            if(candidates.size() == 0) {
                // no candidates
                return null;
            } else {
                // one or more candidates
                List<String> candList = new ArrayList<String>(candidates);
                if(candidates.size() == 1) {
                    return candList.get(0);
                } else {
                    // more then 1 candidate so choose one randomly
                    return candList.get(getRandom().nextInt(candidates.size()));
                }
            }
        }
    }

    // generates candidates for the case when one letter in the word is mistyped
    private void singleLetterChange(String input, Set<String> candidates) {
        char[] chars = input.toCharArray();
        for(char alphabet : alphabetSet) {
            for(int i = 0; i < chars.length; i++) {
                char hold = chars[i];
                chars[i] = alphabet;
                String candidate = new String(chars);
                if(dict.contains(candidate)) {
                    candidates.add(candidate);
                }
                chars[i] = hold;
            }
        }
    }

    // generates candidates for the case when a letter is removed
    private void singleLetterRemoval(String input, Set<String> candidates) {
        char[] chars = input.toCharArray();
        for(int i = 0; i < chars.length; i++) {
            String candidate = "";
            for(int j = 0; j < chars.length; j++) {
                if(i != j) {
                    candidate += chars[j];
                }
            }
            if(dict.contains(candidate)) {
                candidates.add(candidate);
            }
        }
    }

    // generates candidates for the case when an additional character is typed
    private void singleLetterAddition(String input, Set<String> candidates) {
        char[] chars = input.toCharArray();
        for(char alphabet : alphabetSet) {
            for(int i = 0; i < chars.length + 1; i++) {
                char[] extended = new char[chars.length + 1];
                extended[i] = alphabet;
                boolean addOne = false;
                for(int j = 0; j < chars.length; j++) {
                    if(i == j) {
                        extended[j+1] = chars[j];
                        addOne = true;
                    } else {
                        if(!addOne) {
                            extended[j] = chars[j];
                        } else {
                            extended[j+1] = chars[j];
                        }
                    }
                }
                String candidate = new String(extended);
                if(dict.contains(candidate)) {
                    candidates.add(candidate);
                }
            }
        }


    }

    public static void main(String[] args) throws IOException {
        if(args.length == 0) {
            System.out.println("Please provide a file path. Quiting.");
            return;
        }
        String dict_fn = args[0];
        new BestSpelling(new FileInputStream(new File(dict_fn))).run();
    }

}
