import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //некая игрушечная необычность
        ToyList toys1 = new ToyList();
        toys1.addToy(new Toy(25,"книга",3));
        toys1.addToyList(List.of(
                new Toy(5,"книжка",1),
                new Toy(10,"книжулька",2),
                new Toy(10,"книжечка",2)
        ));
        System.out.println(toys1);
        //некая именная необычность
        ParticipantQueue pq = new ParticipantQueue(List.of(
                new Participant("Настя"),
                new Participant("Анастасия"),
                new Participant("Настенька"),
                new Participant("Настёна"),
                new Participant("Ася"),
                new Participant("Нистюша"),
                new Participant("Настасья"),
                new Participant("Стасенька"),
                new Participant("Энн"),
                new Participant("Асюша")
        ));
        //сам розыгрыш
        
        Raffle raf = new Raffle(pq,toys1);
        System.out.println(raf.currentToys.toString());
        raf.runRaffle();

        System.out.println("\nРозыгрыш с вероятностью проиграть\n");
        ParticipantQueue pqloss = new ParticipantQueue();
        for (int i = 1; i <= 10 ; i++){
            pqloss.addParticipant(new Participant());
        }
        Raffle raf2 = new Raffle(pqloss,toys1);
        raf2.setLossWeight(30);
        System.out.println(raf2.currentToys.toString());
        raf2.runRaffle();

        //Финальное состояние призов
        toys1.saveToFile();
    }

}
