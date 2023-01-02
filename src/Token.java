
/*
    Este es el tipo de token que va  a tener la lectura del programa
    es decir al de buscar palabras dentro del archivo vamos a identidicar
    el tipo de token que va a tener
*/

public class Token {
    private TypeToken.TypeTokenCategory tt;
    private Object value;
    private int code;

    public Token(TypeToken.TypeTokenCategory typeToken,Object value,int code) {
        this.tt = typeToken;
        this.value = value;
        this.code = code;
    }

    public TypeToken.TypeTokenCategory getTt() {
        return tt;
    }

    public Object getValue() {
        return value;
    }

    public int getCode() {
        return code;
    }

    public void setTt(TypeToken.TypeTokenCategory tt) {
        this.tt = tt;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String toString() {
        return this.tt + " " + this.value + " " + this.code;
    }
}
