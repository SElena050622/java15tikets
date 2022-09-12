import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TicketManagerTest {

    TicketRepository repository = new TicketRepository();
    TicketManager manager = new TicketManager(repository);

    Ticket product1 = new Ticket(1, 1420, "MOW", "LED", 360);
    Ticket product2 = new Ticket(2, 2500, "MOW", "LED", 80);
    Ticket product3 = new Ticket(3, 1150, "MOW", "LED", 160);
    Ticket product4 = new Ticket(4, 5020, "MOW", "RVH", 60);
    Ticket product5 = new Ticket(5, 1070, "MOW", "LED", 1800);

    @Test
    public void ticketHave4() {

        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);
        manager.add(product5);

        Ticket[] expected = { product5, product3, product1, product2, };//+сортировка по цене
        Ticket[] actual = manager.searchBy("MOW", "LED");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ticketHave1() {

        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);
        manager.add(product5);

        Ticket[] expected = { product4 };
        Ticket[] actual = manager.searchBy("MOW", "RVH");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ticketHaveNothing() {

        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);
        manager.add(product5);

        Ticket[] expected = { };
        Ticket[] actual = manager.searchBy("MOW", "DME");

        Assertions.assertArrayEquals(expected, actual);
    }
}
