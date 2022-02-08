import java.util.ArrayList;

public class CustomerCheck {
    /**
     * The check for a customer or group of customers
     * Guaranteed to contain at least one MenuItem and all entries are non-null
     */
    private ArrayList<MenuItem> check;

    /* Constructor */
    public CustomerCheck(ArrayList<MenuItem> check) {
        this.check = check;
    }

    /**
     * Returns the total of all MenuItem prices on the check,
     * as described in part (a)
     */
    public double totalPrices() {
        double total = 0;
        for (MenuItem item : check) {
            total += item.getPrice();
        }

        return total;
    }

    /**
     * Returns true if the restaurant’s coupon offer can be applied to this check and
     * returns false otherwise, as described in part (b)
     */
    public boolean couponApplies() {
        int counter = 0;
        for (MenuItem item : check) {
            if (item.isDailySpecial() == true) {
                counter++;
            }
        }

        if (counter > 0 || totalPrices() < 40) {
            return false;
        }

        return true;
    }

    /**
     * Calculates the final cost of this check, as described in part (c)
     */
    public double calculateCheck() {
        double finalCost = totalPrices();
        double coupon = 0;
        double tip = 0;

        int people = 0;

        for (MenuItem item : check) {
            if (item.isEntree()) {
                people++;
            }
        }

        if (couponApplies()) {
            coupon = finalCost * .25;
        }

        if (people >= 6) {
            tip = finalCost * .2;
        }

        return finalCost-coupon+tip;
    }
}