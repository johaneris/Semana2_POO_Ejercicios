package run;

public class Cadena
{
    private String texto;

    public Cadena(String texto)
    {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String aMayus()
    {
        return texto.toUpperCase();
    }

    public String aMinus()
    {
        return texto.toLowerCase();
    }

    public String invertir()
    {
        StringBuilder invertida =  new StringBuilder(texto);
        return invertida.reverse().toString();
    }

    public boolean esPalindromo()
    {
        String limpio = texto.replaceAll("\\s+", "").toLowerCase();
        String invertido = new StringBuilder(limpio).reverse().toString();
        return limpio.equals(invertido);
    }

    public int[] contarVocalesConsonantes()
    {
        int vocales = 0;
        int consonantes = 0;
        String textoLimpio = texto.toLowerCase();

        for (int i = 0; i < textoLimpio.length(); i++)
        {
            char c = textoLimpio.charAt(i);
            if (c >= 'a' && c <= 'z')
            {
                if ("aeiou".indexOf(c) != -1)
                {
                    vocales++;
                }
                else
                {
                    consonantes++;
                }
            }
        }
        return new int[]{vocales, consonantes};
    }
}
