

public class main {

    public static void main(String args[]) {
        System.out.println("Compilador de C in Java, es una mierda de lenguaje");
        Lexical lexical = new Lexical();

        String code = "{} () _hola";

        lexical.LexicalAnalysiz(code);
        for(Token t : lexical.getTokens()) {
            System.out.println(t.toString());
        }

    }
}
