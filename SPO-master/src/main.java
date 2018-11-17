
import java.util.LinkedList; // создает список
import java.util.regex.Pattern; // создает рег выражения
import java.util.regex.Matcher; // записывает pattern



public class main {

    public static void main(String args[]) {

        Lexems lex = new Lexems();
        LinkedList<Token> tokens = new LinkedList<Token>(); // запись в виде спика

        String sample = "M = 3 - 1 * value + 50 / 2";  // регулярное выражение

        String str1 = "";


        for (int i = 0; i < sample.length(); i++) {   //алгоритм прохода по выражению

            if (sample.toCharArray()[i] == ' ') {
                continue;
            }

            str1 += sample.toCharArray()[i];
            String str2 = " ";
            if (i < sample.length() - 1) {
                str2 = str1 + sample.toCharArray()[i + 1];
            }

            for (String key : lex.lexems.keySet()) {

                Pattern p = Pattern.compile(lex.lexems.get(key)); //получение операторов из Lexems

                Matcher m_1 = p.matcher(str1); // проверка правильности строки 1
                Matcher m_2 = p.matcher(str2); // проверка правильности строки 2


                if (m_1.find() && !m_2.find()) {
                    tokens.add(new Token(key.toString(), str1));
                    str1 = "";
                }
            }
        }

        for (Token t : tokens) {
            System.out.println(t.type + " " + t.token);
        }



    }
}
