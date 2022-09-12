public class Ticket implements Comparable<Ticket> {

    protected int id;
    protected int price;
    protected String from;
    protected String to;
    protected int traveltime;

    public Ticket(int id, int price, String from, String to, int traveltime) {
        this.id = id;
        this.price = price;
        this.from = from;
        this.to = to;
        this.traveltime = traveltime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(int price) {

        this.price = price;
    }

    public void setFrom(String from) {

        this.from = from;
    }

    public void setTo(String to) {

        this.to = to;
    }

    public void setTraveltime(int traveltime) {

        this.traveltime = traveltime;
    }

    public int getPrice() {

        return price;
    }

    public String getFrom() {

        return from;
    }

    public String getTo() {

        return to;
    }

    public int getTraveltime() {

        return traveltime;
    }

    @Override
    public int compareTo(Ticket o) {
        return price - o.price;
    }
}
