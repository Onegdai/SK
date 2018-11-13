import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

public class A {

    public static void main(String[] args) {

        int czas;
        System.out.println("Podaj czas trwania symulacji:"); //Czas trwania symulacji
        Scanner odczytczasu=new Scanner(System.in);
        czas=odczytczasu.nextInt();

        int czasobslugi;
        System.out.println("Podaj dokoładny czas obsługi:");
        czasobslugi=odczytczasu.nextInt();

        int sredniczasprzyjazdu;
        System.out.println("Podaj średni czas przyjazdu następnego samochodu:"); //Sredni czas przyjazdu następnego samochodu
        sredniczasprzyjazdu = odczytczasu.nextInt();

        Queue<Integer> czasyprzyjazdu = new LinkedList<Integer>(); //następne czasy przyjazdu+bufor - FIFO
        //Queue<Integer> czasyobslugi LinkedList<Integer>(); //następne czasy obsługi
        Queue<Integer> idsamochodow = new LinkedList<Integer>();  // kolejka do wyświetlania z ID samochodów w buforze

        int scs=0; //sumaryczny czas symulacji
        int bufor = 0; //wskazyuje czas oczekiwanai na obsluge
        int sumabuforow = 0; //służy do policzenia średniego czasu w kolejce
        int iloscaut = 0; //służy do policzenia średniego czasu w kolejce
        int srednibufor = 0; //ja nawet nie wiem co to jest czysty kod :|

        while(scs+bufor<=czas) {
            Random generator = new Random();
            double a = 1 - generator.nextDouble();
            double xd = -(Math.log(a) * sredniczasprzyjazdu); //generowanie czasu przyjazdu następnego samochodu
            int x = (int) Math.round(xd);
            if (x==0) {
                x = 1;
            }
            for( int i=0;i<=czasyprzyjazdu.size();i++){
                if(czasyprzyjazdu.size()==0 || (x+scs)<czasyprzyjazdu.peek()+czasobslugi){
                    czasyprzyjazdu.add(x+scs);
                    iloscaut++;
                    idsamochodow.add(iloscaut);
                    int A=x+scs;
                    System.out.println("przyjechał: "+iloscaut+" o czasie: "+A+" w buforze jest: "+czasyprzyjazdu.size()+" samochodów.");
                    break;
                } else{
                    int czasodjazdu = czasyprzyjazdu.poll()+czasobslugi;
                    int odjechal = idsamochodow.poll();
                    System.out.println("odjechał: "+odjechal+" o czasie: "+czasodjazdu+" w buforze pozostało: "+czasyprzyjazdu.size()+" samochodów.");
                }
            }
            scs=scs+x;
            // sumabuforow=sumabuforow+bufor;
            // System.out.println("scs:"+scs);

            // System.out.println("x:"+x);
            // System.out.println("bufor:"+bufor);
        }
        // srednibufor=sumabuforow/iloscaut;
        System.out.println("Koniec symulacji");
        // System.out.println("Przyjechało "+iloscaut+" samochodów. W kolejce spędziły średnio "+srednibufor+"sekund");
    }
}
