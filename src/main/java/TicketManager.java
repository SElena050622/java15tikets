import java.util.Arrays;

public class TicketManager {

    protected TicketRepository repository;

    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }

    public  void  add(Ticket product) {
        repository.add(product);
    }

    public  Ticket[] searchBy(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket product : repository.findAll()) {
            if (matches (product, from, to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

    public boolean matches (Ticket ticket,String from, String to) {
        if (!ticket.getFrom().equals(from)) {
            return false;
        }
        if (!ticket.getTo().equals(to)) {
            return false;
        }
        return true;
    }
}
