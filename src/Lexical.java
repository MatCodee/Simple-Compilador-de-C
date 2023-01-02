import java.util.ArrayList;
import java.util.List;
import java.lang.String;
import java.util.Random;

import java.lang.reflect.Method;

public class Lexical {
    /*
        clasificamos los tipos de elementos de token
        Descartamos espacios en blanco y comentarios dentro del lenguaje
    */
    public Lexical() {}
    List<Token> tokens = new ArrayList<Token>();

    public List<Token> getTokens() { return tokens; }

    // input    // Esta es la funcion que va a analizar linea por linea el codigo y detectar lso token iniciales
    public void LexicalAnalysiz(String source_text) {
        for(int i=0; i< source_text.length(); i++) {
            char current_char = source_text.charAt(i);

            // primero vamos a detectar los tabuladoras, espacios en blanco, saltos de linea y comentarios
            // en caso de encontrar uno de estos debemos pasar al siguiente caracter ya que este es un caracter que debemos ignorar
            switch (current_char) {
                case '\n':
                case '\t':
                case '\r':
                case ' ':
                    System.out.println("Caracteres que no son necesarios en esto");
                    continue;
                default:
                    if(current_char == '_' || Character.isLetter(current_char)) {
                        int current_i = getIdentFunction(source_text,i);
                        i = current_i;
                    }else if (Character.isDigit(current_char)) {
                        int current_i = getIdentFunctionConstantNumber(source_text,current_char);
                        i = current_i;
                    } else if(detect_delimiters(current_char)) {
                        //System.out.println("Delimitador detectado");
                    }else if(detect_operator(current_char)) {
                        // informacion clara
                    }else {
                        // Aqui vamos a determinar si es una palabra reservada del lenguaje
                    }
                }

                    //if(detect_operator(current_char)) continue;
            }

            // deteccon si es un espacio o un comentario
            // analizar el string que esta entrando y ver a que corresponde realmente esto


            //detectar udentificadores

            // detectar
    }
        // random code function
    private int random_code() {
        Random r = new Random();
        int random_number = r.nextInt(9000) + 1000;
        return random_number;
    }

    boolean detect_delimiters(char current_char) {
        //deteccion de los Delimitadores:
        switch (current_char) {
            case '(': {
                Token current_token = new Token(TypeToken.TypeTokenCategory.DELIMITERS, current_char, random_code());
                tokens.add(current_token);
                return true;
            }
            case ')': {
                Token current_token = new Token(TypeToken.TypeTokenCategory.DELIMITERS, current_char, random_code());
                tokens.add(current_token);
                return true;
            }
            case '[': {
                Token current_token = new Token(TypeToken.TypeTokenCategory.DELIMITERS, current_char, random_code());
                tokens.add(current_token);
                return true;
            }
            case ']': {
                Token current_token = new Token(TypeToken.TypeTokenCategory.DELIMITERS,current_char,random_code());
                tokens.add(current_token);
                return true;
            }
            case ',': {
                Token current_token = new Token(TypeToken.TypeTokenCategory.DELIMITERS,current_char,random_code());
                tokens.add(current_token);
                return true;
            }
            case ';': {
                Token current_token = new Token(TypeToken.TypeTokenCategory.DELIMITERS,current_char,random_code());
                tokens.add(current_token);
                return true;
            }
            case '{': {
                Token current_token = new Token(TypeToken.TypeTokenCategory.DELIMITERS,current_char,random_code());
                tokens.add(current_token);
                return true;
            }
            case '}': {
                Token current_token = new Token(TypeToken.TypeTokenCategory.DELIMITERS,current_char,random_code());
                tokens.add(current_token);
                return true;
            }
            case ':': {
                Token current_token = new Token(TypeToken.TypeTokenCategory.DELIMITERS,current_char,random_code());
                tokens.add(current_token);
                return true;
            }
            default:
                return false;
        }
    }

    // deteccion de los operadores
    boolean detect_operator(char current_char) {
        switch (current_char) {
            case '+': {
                Token current_token = new Token(TypeToken.TypeTokenCategory.OPERATOR, current_char, random_code());
                tokens.add(current_token);
                return true;
            }
            case '-': {
                Token current_token = new Token(TypeToken.TypeTokenCategory.OPERATOR, current_char, random_code());
                tokens.add(current_token);
                return true;
            }
            case '*': {
                Token current_token = new Token(TypeToken.TypeTokenCategory.OPERATOR, current_char, random_code());
                tokens.add(current_token);
                return true;
            }
            case '/': {
                Token current_token = new Token(TypeToken.TypeTokenCategory.OPERATOR,current_char,random_code());
                tokens.add(current_token);
                return true;
            }
            default:
                return false;
        }
    }

    // Necesito detectar algunas cosas como si es un comentario o es un espacio en blanco
    void ignoreCharacterst(char c) {}
    // los metodos de los automatas:



    int getIdentFunctionConstantNumber(String text,int start_indice) {
        int state = 0,simbol;
        int current_indice = start_indice;
        char current_caracter;
        String current_word = "";
        int [][] table = {
                {1, 2,-1,-1, 7, 7},
                {1, 2, 4, 4,-1,-1},
                {3,-1,-1,-1,-1,-1},
                {3,-1, 4, 4,-1,-1},
                {5,-1,-1,-1, 6, 6},
                {5,-1,-1,-1,-1,-1},
                {6,-1,-1,-1,-1,-1},
                {1,-1,-1,-1,-1,-1},
        };
        for(int i=start_indice;i<text.length();i++) {
            current_caracter = text.charAt(i);
            simbol = getIdentComprobationSimbol(current_caracter);
            if(simbol == -1) break;

            current_word = current_word + current_caracter;
            // le pasamos el tipo de simbolo que es, es decir,es un numeor, un caracter o lo que sea
            // el otro parametro es el estado partimos con el estado inicial que es 0
            state = table[state][simbol]; // actualizamos el estado
            current_indice = i;
        }
        if(state == 1 || state == 3 || state == 5) {
            Token current_token = new Token(TypeToken.TypeTokenCategory.CONSTANT,current_word,random_code());
            tokens.add(current_token);
        }
        return state;
    }
    private int getSimbolNumber(char c) {
        if (Character.isDigit(c)) return 0;
        else if (c == '.') return 1;
        else if (c == 'E') return 2;
        else if (c == 'e') return 3;
        else if (c == '+') return 4;
        else if (c == '-') return 5;
        return -1;
    }

    // Esta es la funcion que em base a un texto que se le va a pasar nosotros aplicamos la funcion de la matriz que tengamos disponible
    // en la tabla de transicion.

    // nota: el -1 es un estado mueto

    int getIdentFunction(String text,int start_indice) {
        int state = 0,simbol;
        int current_indice = start_indice;
        char current_caracter;
        String current_word = "";
        int [][] table =  {
                {1,-1,1},
                {1,1,1},
        };
        for(int i=start_indice;i<text.length();i++) {
            current_caracter = text.charAt(i);
            simbol = getIdentComprobationSimbol(current_caracter);
            if(simbol == -1) break;

            current_word = current_word + current_caracter;
            // le pasamos el tipo de simbolo que es, es decir,es un numeor, un caracter o lo que sea
            // el otro parametro es el estado partimos con el estado inicial que es 0
            state = table[state][simbol]; // actualizamos el estado
            current_indice = i;
        }
        if(state == 1) {
            Token current_token = new Token(TypeToken.TypeTokenCategory.IDENTIFIER,current_word,random_code());
            tokens.add(current_token);
        }
        return current_indice;
    }
    int getIdentComprobationSimbol(char c) {
        if (Character.isLetter(c)) return 0;
        else if(Character.isDigit(c)) return 1;
        else if (c == '_') return 2;
        return -1;
    }


    // incorporar el automata de lectura de comentarios
    // incorporar el automata  de deteccion de string
    // iconrporar el automata de lectura de deteccion de numeros
}