class Passenger {
    private String name;
    private Passenger next;
    public Passenger(String name) {
        this.name = name;
        this.next = null;
    }

    public String getName() {
        return name;
    }

    public Passenger getNext() {
        return next;
    }
    public void setNext(Passenger next) {
        this.next = next;
    }
}
class Flight {
    private Passenger lukman;
    public Flight() {
        this.lukman = null;
    }
    public void addPassenger(String name) {
        Passenger newPassenger = new Passenger(name);
        if (lukman == null) {
            lukman = newPassenger;
        } else {
            Passenger current = lukman;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newPassenger);
        }
    }
    public void removePassenger(String name) {
        if (lukman == null) {
            System.out.println("Daftar penumpang kosong.");
            return;
        }
        if (lukman.getName().equals(name)) {
            lukman = lukman.getNext();
            System.out.println(name + " telah dihapus dari daftar penumpang.");
            return;
        }
        Passenger current = lukman;
        while (current.getNext() != null) {
            if (current.getNext().getName().equals(name)) {
                current.setNext(current.getNext().getNext());
                System.out.println(name + " telah dihapus dari daftar penumpang.");
                return;
            }
            current = current.getNext();
        }

        System.out.println(name + " tidak ditemukan dalam daftar penumpang.");
    }
    public void displayPassengers() {
        Passenger current = lukman;
        if (current == null) {
            System.out.println("Daftar penumpang kosong.");
            return;
        }
        System.out.println("Daftar Penumpang:");
        while (current != null) {
            System.out.println("- " + current.getName());
            current = current.getNext();
        }
    }
}
 class Main {
    public static void main(String[] args) {
        Flight myFlight = new Flight();
        myFlight.addPassenger("bhery waldain");
        myFlight.addPassenger("john warm");
        myFlight.addPassenger("Alice parmadita");

        myFlight.displayPassengers();

        myFlight.removePassenger("bhery waldain");
        myFlight.displayPassengers();

        myFlight.removePassenger("roby syahputra");
    }
}
