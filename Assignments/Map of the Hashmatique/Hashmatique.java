import java.util.HashMap;
import java.util.Set;
public class Hashmatique{
    public static void main(String[] args){
        HashMap<String, String> userMap = new HashMap<String, String>();
        userMap.put("Shape of You", "I'm in love with the shape of you, we push and pull like a magnet do");
        userMap.put("Bohemian Rhapsody", "Is this the real life? Is this just fantasy? Caught in a landslide, no escape from reality");
        userMap.put("Uptown Funk", "This hit, that ice cold Michelle Pfeiffer, that white gold, This one for them hood girls, them good girls straight masterpieces");
        userMap.put("Blinding Lights", "I said, ooh, I'm blinded by the lights, No, I can't sleep until I feel your touch");
        String lyrics = userMap.get("Uptown Funk");
        System.out.println(lyrics);
        Set<String> keys = userMap.keySet();
        for(String key : keys) {
            System.out.println(key);
            System.out.println(userMap.get(key));    
        }
    }

}