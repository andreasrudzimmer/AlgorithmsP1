import java.util.NoSuchElementException;
import java.util.Arrays;

public class Oblig1 {



/// Denne obligen er levert av: Andreas Rud Zimmer, S344051.


    ///Oppgave 1, del 1


    public static int maks(int[] a) {
        if (a.length == 0) {
            throw new NoSuchElementException("Listen er tom");
        } else {
            int minus = 1;
            int holder = 0;
            for (int i = 0; i < a.length - minus; i++) {
                if (a[i] > a[i + 1]) {
                    holder = a[i + 1];
                    a[i + 1] = a[i];
                    a[i] = holder;

                }
            }
            return a[a.length - minus];
        }
    }


    ///Oppgave 1, del 2
    /*
      - Det er flest ombyttinger når det største tallet er i posisjon 0.
      - Det er færrest ombyttinger når tallet a[i+1] alltid er større enn a[i].
      - I gjennomsnitt vil det bli a.length / 2 antall ombyttinger i en tilfeldig permutasjon.
    */

    public static int ombyttinger(int[] a) {
        int minus = 1;
        int holder = 0;
        int tellerOmbyttinger = 0;
        for (int i = 0; i < a.length - minus; i++) {
            if (a[i] > a[i + 1]) {
                holder = a[i + 1];
                a[i + 1] = a[i];
                a[i] = holder;
                tellerOmbyttinger++;
            }

        }
        return tellerOmbyttinger;

    }


    ///Oppgave 2
    public static int antallUlikeSortert(int[] a) {

        int teller = 1;
        if (a.length > 0) {
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] <= a[i + 1]) {
                    if (a[i] != a[i + 1]) {
                        teller++;
                    }
                } else {
                    throw new IllegalStateException("Listen er usortert!");
                }
            }

        } else {
            teller = 0;
        }
        return teller;
    }

    /// Oppgave 3
    public static int antallUlikeUsortert(int[] a) {
        if (a.length != 0) {
            int tall = 1;
            int j = 0;
            for (int i = 1; i < a.length; i++) {
                for (j = 0; j < i; j++) {
                    if (a[i] == a[j])
                        break;
                }
                if (i == j)
                    tall++;
            }
            return tall;
        } else {
            return 0;
        }
    }


    /// Oppgave 4
    public static void delsortering(int[] a){
        int venstre = 0;
        int høyre = a.length - 1;
        int odd = 0;

        try {
            while (venstre < høyre) {
                while (a[venstre] % 2 != 0) {
                    venstre++;
                    odd++;
                }

                while (venstre < høyre && a[høyre] % 2 == 0) {
                    høyre--;
                }

                int holder = a[venstre];
                if (venstre < høyre) {
                    holder = a[venstre];
                    a[venstre] = a[høyre];
                    a[høyre] = holder;
                }
            }
        } catch (Exception e) {
            // Ignorerer, og sorter under
        }
        Arrays.sort(a, 0, odd);
        Arrays.sort(a, odd, a.length);
    }


    ///Oppgave 5
    public static void rotasjon(char[] a){
        if(a.length == 0) {

        } else {
            char huske = a[a.length - 1];
            for (int i = a.length - 1; i > 0; i--) {
                a[i] = a[i - 1];
            }
            a[0] = huske;
        }
    }



    ///Oppgave 7, a

    public static String flett(String s, String t){
        int n;
        StringBuilder sammensattArr = new StringBuilder("");
        if (s.length()>t.length()) {
            n = s.length();
        } else {
            n = t.length();
        }
        for (int i = 0; i < n;i++) {
            if (i<s.length())  {
                sammensattArr.append(s.substring(i,i+1));
            }
            if (i<t.length()) {
                sammensattArr.append(t.substring(i,i+1));
            }
        }
        return sammensattArr.toString();
    }
    ///Oppgave 7, b

    public static String flett(String... s) {
        String[] arrayet= s;
        String message = "";
        int number = 0;
        int a = 0;
        int b = 1;
        int antallOrd = 0;
        for(int i = 0; i<arrayet.length;i++) {
            antallOrd+=arrayet[i].length();
        }
        while(number<antallOrd) {
            for (int i = 0; i < arrayet.length; i++) {
                try {
                    String bokstav = arrayet[i].substring(a, b);
                    message += bokstav;
                } catch (Exception e) {

                }
            }
            a++;
            b++;
            number++;
        }
        return message;
    }



}



