import java.util.HashMap;
import java.util.Map;

public class Translator {
    private final Map<Integer, String> numericAlpha;

    public Translator(String[] alphabetic, Integer[] numeric) {
        this.numericAlpha = new HashMap<>();

        for (int i = 0; i < numeric.length; i++) {
            numericAlpha.put(numeric[i], alphabetic[i]);
        }
    }

    public String translate(Integer number) {
        return numericAlpha.get(number);
    }
}

