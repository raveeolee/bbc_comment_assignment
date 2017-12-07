package env;

import java.security.SecureRandom;

/**
 * Created by oleh on 07/12/17.
 */
public class RandomSentenceGenerator {
    private String article[] = { "the", "a", "one", "some", "any" };
    private String noun[] = { "boy", "girl", "dog", "town", "car" };
    private String verb[] = { "drove", "jumped", "ran", "walked", "skipped" };
    private String preposition[] = { "to", "from", "over", "under", "on" };

    public String generateSentence(int numOfSentences) {

        String sentence = "";
        for (int i = 0; i < numOfSentences; i++){
            sentence = article[rand(5)];
            char c = sentence.charAt(0);
            sentence = sentence.replace( c, Character.toUpperCase(c) );
            sentence += " " + noun[rand(5)] + " ";
            sentence += (verb[rand(5)] + " " + preposition[rand(5)]);
            sentence += (" " + article[rand(5)] + " " + noun[rand(5)]);
            sentence += ".";
        }
        return sentence;
    }

    private int rand(int numOfWords) {
        int ri = new SecureRandom().nextInt() % numOfWords;
        if ( ri < 0 )
            ri += numOfWords;
        return ri;
    }
}
