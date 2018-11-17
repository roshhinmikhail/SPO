import java.util.HashMap;
import java.util.Map;


public class Lexems {

    static Map<String, String> lexems = new HashMap<String,String>(); // объявление хеш-таблицы для put и get

    public Lexems(){
        lexems.put("VAR", "^[a-z|A-Z]+$"); // переменная
        lexems.put("DIGIT", "^0|[1-9][0-9]*$"); // цифра
        lexems.put("OPERATOR", "^[-|+|/|*]$"); //оператор
        lexems.put("ASSIGNMENT OPERATOR", "^=$"); //оператор присваивания
    }

}
