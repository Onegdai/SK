import java.util.*;

public class MM2 {
    public static void main(String[] args) {
        int czastrwania;
        System.out.print("Podaj czas trwania symulacji: ");
        Scanner odczyt = new Scanner(System.in);
        czastrwania = odczyt.nextInt();
        int ilosczgloszen = 0;
        int ilosczgloszenDO1 = 0;
        int ilosczgloszenDO2 = 0;
        int czasdojazdu = 0;
        int kol1 = 0;
        int kol2 = 0;
        int a1 = 0;
        int a2 = 0;
        int a3 = 0;
        int a4 = 0;
        Queue<Integer> przyjazdlista = new LinkedList<>();
        Queue<Integer> obslugalista = new LinkedList<>();
        List<Integer> wielkosckolejki = new LinkedList<>();
        while (kol1 <= czastrwania && kol2 <= czastrwania) {
            Random gen = new Random();
            double a = 1 - gen.nextDouble();
            double b = 1 - gen.nextDouble();
            double aa = -(Math.log(a) * 60);
            double bb = -(Math.log(b) * 120);
            int czasobslugi = (int) Math.round(aa);
            int czasdojazdupomocniczy = (int) Math.round(bb);
            czasdojazdu = czasdojazdu + czasdojazdupomocniczy;
            ilosczgloszen++;
            System.out.println("!!!!!!!!!!!!!!!!!!");
            przyjazdlista.add(czasdojazdu);
            obslugalista.add(czasobslugi);
            System.out.println("!!!");
            for( int i=0;i<przyjazdlista.size();i++){
                if(kol1<przyjazdlista.peek()){
                    a1 = przyjazdlista.poll();
                    a2 = obslugalista.poll();
                    kol1=a1+a2;
                    ilosczgloszenDO1++;
                } else if(kol2<przyjazdlista.peek()) {
                    a3 = przyjazdlista.poll();
                    a4 = obslugalista.poll();
                    kol2 = a3 + a4;
                    ilosczgloszenDO2++;
                }
            }
            wielkosckolejki.add(przyjazdlista.size());
            System.out.println(przyjazdlista.size());
        }
        System.out.println("ilość zgłoszeń: "+ilosczgloszen+" obsłużonych w kanale 1: "+ilosczgloszenDO1+" w kanale 2: "+ilosczgloszenDO2);



    }
}
