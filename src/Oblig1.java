import javax.crypto.spec.PSource;
import java.util.Arrays;
import java.util.NoSuchElementException;

/// Denne obligen er levert av: Andreas Rud Zimmer, S344051.

public class Oblig1 {

    public static void main(String[] args) {

        System.out.println("Høyeste tallet i listen er: " + maks(new int[]{1, 2, 3, 333, 100002, 4, 5, 65, 7, 8, 9, 10, 9999}));

        System.out.println("Antall ombyttinger er: " + ombyttinger(new int[]{1, 2, 3, 333, 100002, 4, 5, 65, 7, 8, 9, 10, 9999}));

        System.out.println("Antall forskjellige tall i listen er: " + antallUlikeSotert(new int[]{1,2,2,3,4,5,5,6,}));

        int a[] = {1, -1, -2, 2, 6, 2, 8, 13};
        System.out.print("Listen med partall på venstre side og oddetall på høyre: ");
        delsortering(a);
        System.out.println();
        System.out.print("Listen flyttet alle elementer en posisjon: ");

        char b[] = {'a','b','c','d','e','f','g','h','i','j'};
        rotasjon(b);

        System.out.println();
        System.out.print("Antall forskjellige siffer i listen: ");
        int c[] = {1,2,2,2,3,2,1,4};
        System.out.println(antallUlikeUsotert(c));

        String k[] = {"Halla"};
        String l[] = {"Halla"};
        
        System.out.print("Listene sammenflettet gir: ");
        System.out.println(flett("HAlla", "Halla"));
    }


    ///Oppgave 1, del 1


    public static int maks(int[] a) {

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


    public static int antallUlikeSotert(int[] a){

        int teller = 0;
if (a.length>0){
        for(int i = 0; i < a.length-1; i++) {
            if (a[i] < a[i + 1]) {
                teller++;
            }
        }

        }
else {
    throw new NoSuchElementException("Listen er tom");
}
        if (teller > 0){
            teller++;
        }

        return teller;
    }

    /// Oppgave 3
    public static int antallUlikeUsotert(int[] a){

        int antallSiffer = 1;

        for (int i = 1; i < a.length; i++)
        {
            int j = 0;
            for (j = 0; j < i; j++)
                if (a[i] == a[j])
                    break;

            if (i == j)
                antallSiffer++;
        }
        return antallSiffer;
    }


    /// Oppgave 4
    public static void delsortering(int[] a){

        int venstre = 0, høyre = a.length - 1;
        while (venstre < høyre)
        {
            while (a[venstre]%2 == 0 && venstre < høyre)
                venstre++;

            while (a[høyre]%2 == 1 && venstre < høyre)
                høyre--;


            if (venstre < høyre)
            {
                int temp = a[venstre];
                a[venstre] = a[høyre];
                a[høyre] = temp;
                venstre++;
                høyre--;
            }
        }
        for (int i = 0; i < a.length; i++) {

        }
        System.out.print(Arrays.toString(a));
    }

    ///Oppgave 5

    public static void rotasjon(char[] a){
        char huske = a[a.length-1];
        for(int i = a.length-1; i > 0; i--) {
            a[i]=a[i-1];
        }
        a[0] = huske;
        System.out.print(Arrays.toString(a));
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

}


    ///Oppgave 7, a


            /// Dessverre ikke rukket å gjøre

