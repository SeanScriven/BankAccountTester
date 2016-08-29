public class ATMTester {
	public static void main(String[] args) {
        // These print statements let you see how far through this main method
        // you get before an error is detected.
        System.out.print("a ");
        // Create an ATM in Ireland (denominations 5, 10, 20, 50)
        int[] euroDenoms = {5, 10, 20, 50};
        ATM atm1 = new ATM("euro", euroDenoms);
        System.out.print("b ");
        // Check the currency is correctly stored
        if (! atm1.getCurrency().equals("euro")) {
            error();
        }
        System.out.print("c ");
        // Let's check it's empty
        if (atm1.getTotal() != 0) {
            error();
        }
        System.out.print("d ");
        // How many of each kind of note does it contain?
        if (atm1.getQty(5) != 0 || atm1.getQty(10) != 0 ||
            atm1.getQty(20) != 0 || atm1.getQty(50) != 0) {
            error();
        }
        System.out.print("e ");
        // Load it with three 5 euro notes.
        atm1.load(3, 5);
        System.out.print("f ");
        // Check these notes were loaded properly
        if (atm1.getQty(5) != 3 || atm1.getQty(10) != 0 ||
            atm1.getQty(20) != 0 || atm1.getQty(50) != 0 ||
            atm1.getTotal() != 15) {
            error();
        }
        System.out.print("g ");
        // Do the same again for 10 and 50 euro notes.
        atm1.load(2, 10);
        atm1.load(1, 50);
        if (atm1.getQty(10) != 2 || atm1.getQty(50) != 1 ||
            atm1.getTotal() != 85) {
            error();
        }
        System.out.print("h ");
        // Dispense 1 of the 10 euro notes.
        atm1.dispense(1, 10);
        System.out.print("i ");
        // Check this note was dispensed properly
        if (atm1.getQty(5) != 3 || atm1.getQty(10) != 1 ||
            atm1.getQty(20) != 0 || atm1.getQty(50) != 1 ||
            atm1.getTotal() != 75) {
            error();
        }
        System.out.print("j ");
        // Do the same for 2 of the 5 euro notes
        atm1.dispense(2, 5);
        if (atm1.getQty(5) != 1 || atm1.getQty(10) != 1 ||
            atm1.getQty(20) != 0 || atm1.getQty(50) != 1 ||
            atm1.getTotal() != 65) {
            error();
        }
        System.out.print("k ");
        // Now try to dispense 1 20 euro note (impossible!)
        atm1.dispense(1, 20);
        System.out.print("l ");
        // Check this left the ATM's contents unchanged
        if (atm1.getQty(5) != 1 || atm1.getQty(10) != 1 ||
            atm1.getQty(20) != 0 || atm1.getQty(50) != 1 ||
            atm1.getTotal() != 65) {
            error();
        }
        System.out.print("m ");
        // Now try to find out how many 7 euro notes there are in this ATM
        if (atm1.getQty(7) != 0) {
            error();
        }
        System.out.print("n ");
        // Similarly for 3 euro notes...
        if (atm1.getQty(3) != 0) {
            error();
        }
        System.out.print("o ");
        // ...and 52 euro notes
        if (atm1.getQty(52) != 0) {
            error();
        }
        System.out.print("p ");
        // Try to load a 3 euro note, a 7 euro note and a 52 euro note;
        // the contents should be unchanged
        atm1.load(1, 3);
        atm1.load(1, 7);
        atm1.load(1, 52);
        if (atm1.getQty(5) != 1 || atm1.getQty(10) != 1 ||
            atm1.getQty(20) != 0 || atm1.getQty(50) != 1 ||
            atm1.getTotal() != 65) {
            error();
        }
        System.out.print("q ");
        // Try to dispense the same; the contents should be unchanged
        atm1.dispense(1, 3);
        atm1.dispense(1, 7);
        atm1.dispense(1, 52);
        if (atm1.getQty(5) != 1 || atm1.getQty(10) != 1 ||
            atm1.getQty(20) != 0 || atm1.getQty(50) != 1 ||
            atm1.getTotal() != 65) {
            error();
        }
        System.out.print("r ");
        // Create an ATM in Chile (denominations 500, 1000, 2000, 5000, 10000)
        int[] chileDenoms = {500, 1000, 2000, 5000, 10000};
        ATM atm2 = new ATM("peso", chileDenoms);
        System.out.print("s ");
        // Check the currency in both ATMs is correctly stored
        if (! atm1.getCurrency().equals("euro") ||
            ! atm2.getCurrency().equals("peso")) {
            error();
        }
        System.out.print("t ");
        // Load this new ATM and check the contents of both ATMs
        atm2.load(5, 1000);
        atm2.load(10, 2000);
        if (atm1.getQty(5) != 1 || atm1.getQty(10) != 1 ||
            atm1.getQty(20) != 0 || atm1.getQty(50) != 1 ||
            atm1.getTotal() != 65 || atm2.getQty(500) != 0 ||
            atm2.getQty(1000) != 5 || atm2.getQty(2000) != 10 ||
            atm2.getQty(5000) != 0 || atm2.getQty(10000) != 0 || 
            atm2.getTotal() != 25000) {
            error();
        }
        System.out.print("u ");
        // Dispense 3 of the 2000 notes
        atm2.dispense(3, 2000);
        if (atm1.getQty(5) != 1 || atm1.getQty(10) != 1 ||
            atm1.getQty(20) != 0 || atm1.getQty(50) != 1 ||
            atm1.getTotal() != 65 || atm2.getQty(500) != 0 ||
            atm2.getQty(1000) != 5 || atm2.getQty(2000) != 7 ||
            atm2.getQty(5000) != 0 || atm2.getQty(10000) != 0 || 
            atm2.getTotal() != 19000) {
            error();
        }
        System.out.print("v ");
        // Now try to dispense 8 of the 1000 notes (impossible!)
        atm2.dispense(8, 1000);
        if (atm1.getQty(5) != 1 || atm1.getQty(10) != 1 ||
            atm1.getQty(20) != 0 || atm1.getQty(50) != 1 ||
            atm1.getTotal() != 65 || atm2.getQty(500) != 0 ||
            atm2.getQty(1000) != 5 || atm2.getQty(2000) != 7 ||
            atm2.getQty(5000) != 0 || atm2.getQty(10000) != 0 || 
            atm2.getTotal() != 19000) {
            error();
        }
        System.out.println("w x y z ");
        System.out.println("\natm1\n==============");
        System.out.println(atm1);
        System.out.println("\natm2\n==============");
        System.out.println(atm2);
    }

    private static void error()
    {   System.out.println("There's an error in your ATM definition.");
        System.exit(1);
    }
	
	
}
