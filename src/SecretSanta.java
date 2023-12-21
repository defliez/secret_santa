import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class SecretSanta {

    Scanner scanner;

    ArrayList<String> participants;
    HashMap<String, String> pairs;



    public static void main(String[] args) {

        SecretSanta secretSanta = new SecretSanta();

        System.out.println("--x--x--x--x--x--x--x--x--x--x--x--x--");
        System.out.println("|\t\t\t\t\t\t\t\t\t |");
        System.out.println("x\t\t\t\t\t\t\t\t\t x");
        System.out.println("|\t\tWelcome to Secret Santa!\t |");
        System.out.println("x\t\t\t\t\t\t\t\t\t x");
        System.out.println("|\t\t\t\t\t\t\t\t\t |");
        System.out.println("x\t\t\t\t\t\t\t\t\t x");

        secretSanta.hoHoHo();


    }

    public void hoHoHo() {

        scanner = new Scanner(System.in);
        participants = new ArrayList<>();
        pairs = new HashMap<>();

        showMenu();

        int choice = scanner.nextInt();
        while (choice != 4) {
            switch (choice) {
                case 1 -> { addParticipant(); }
                case 2 -> { removeParticipant(); }
                case 3 -> { listParticipants(); }
                default -> { System.out.println("Invalid input!"); }
            }
            System.out.println("Press any key to continue...");
            scanner.nextLine();
            System.out.println("\n--x--x--x--x--x--x--x--x--x--x--x--x--");
            showMenu();
            choice = scanner.nextInt();
        }

        generatePairs();
        reveal();
    }

    public void showMenu() {
        System.out.println("|\t\t\t\t MENU\t\t\t\t |");
        System.out.println("x\t1. Add a new participant\t\t x");
        System.out.println("|\t2. Remove a participant\t\t\t |");
        System.out.println("x\t3. List all participants\t\t x");
        System.out.println("|\t4. REVEAL!! \t\t\t\t\t |");
        System.out.println("x\t\t\t\t\t\t\t\t\t x");
        System.out.println("|\t\t\t\t\t\t\t\t\t |");
        System.out.println("--x--x--x--x--x--x--x--x--x--x--x--x--");
        System.out.println("\nEnter your choice: ");
        System.out.print(">> ");
    }

    private void addParticipant() {
        System.out.println("\nEnter participant name: ");
        System.out.print(">> ");
        scanner.nextLine();
        String name = scanner.nextLine();
        participants.add(name);
    }

    private void removeParticipant() {

        listParticipants();

        System.out.println("\nEnter number of participant to delete: ");
        System.out.print(">> ");

        if (scanner.hasNextInt()) {
            int index = scanner.nextInt();
            participants.remove(index);
        } else {
            System.out.println("Invalid input!");
        }
    }

    private void listParticipants() {
        System.out.println("\nParticipants: ");
        for (int i = 0; i < participants.size(); i++) {
            System.out.println(i + ". " + participants.get(i));
        }
    }

    private void reveal() {

        System.out.println("\nHo Ho Ho! Here are the pairs: ");
        for (String giver : pairs.keySet()) {
            System.out.println(giver + " ---> " + pairs.get(giver));
        }
    }

    private void generatePairs() {

        for (String giver : participants) {
            String receiver = pickRandomParticipant(giver);
            pairs.put(giver, receiver);
        }
    }

    private String pickRandomParticipant(String giver) {
        String receiver = participants.get((int) (Math.random() * participants.size()));
        while (receiver.equals(giver) || pairs.containsValue(receiver)) {
            receiver = participants.get((int) (Math.random() * participants.size()));
        }
        return receiver;
    }


}
