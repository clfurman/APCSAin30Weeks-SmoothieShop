
import java.util.*;

/**
 * @author : Crystal Sheldon Date: 10/9/2026
 *
 * This class represents a smoothie reward card a customer can use to order a
 * smoothie and pay with points.
 *
 */
public class SmoothieCard {

    private String customerName;
    private int points;
    private int fruitCount;
    private int proteinCount;
    private ArrayList<String> toppings;
    private int pointsUsed;

    /**
     * Creates a SmoothieCard object with customerName being name, points being
     * pts.
     *
     * Precondition: pts will be > 0. Postcondition: initial add in counts
     * (fruitCount and proteinCount) are all set to 0, toppings is an ArrayList
     * is used to track the toppings added and is empty at the start, pointsUsed
     * is initialized to 0.
     */
    public SmoothieCard(String name, int pts) {
        customerName = name;
        points = pts;
        fruitCount = 0;
        proteinCount = 0;
        pointsUsed = 0;
        toppings = new ArrayList<>();
    }

    /**
     * A number of scoops of fruit are added to the smoothie. Each scoop of
     * fruit cost 75 points.
     *
     * Precondition: count > 0 Postcondition: fruitCount, pointsUsed and points
     * are updated accordingly.
     */
    public void addFruit(int count) {
        fruitCount += count;
        pointsUsed += count * 75;
        points -= (count * 75);
    }

    /**
     * A scoop of protein is added to the smoothie. Each scoop of protein cost
     * 125 points.
     *
     * Postcondition: proteinCount, pointsUsed and points are updated
     * accordingly.
     */
    public void addProtein() {
        proteinCount++;
        pointsUsed += 125;
        points -= 125;
    }

    /**
     * A topping is added to the smoothie. Each topping cost 50 points.
     *
     * Postcondition: type is added to the list of toppings; pointsUsed and
     * points are updated accordingly.
     */
    public void addTopping(String type) {
        toppings.add(type);
        pointsUsed += 50;
        points -= 50;
    }

    /**
     * A number of points is added to the total number of points on the account.
     * Points can be added by purchasing a smoothie or purchasing points.
     *
     * Precondition: bonusPoints > 0
     */
    public void earnBonusPoints(int bonusPoints) {
        points += bonusPoints;
    }

    /**
     * The smoothie order is sent to the restaurant to be made. The order
     * includes the customers name, amount of fruit and protein to include, and
     * list of toppings. It reports the number of points used and the total
     * remaining points on the account. The customer earns 50 points for
     * ordering a smoothie. The fruit count, protein count, points used for this
     * order and list of toppings are reset.
     *
     * @return A string listing the customer's name, order, points used, and
     * points balance.
     */
    public String sendOrder() {
        earnBonusPoints(50);
        String toppingsList = getToppings();
        String order = customerName
                + ":\nfruit scoops = " + fruitCount
                + "\nprotein scoops = " + proteinCount
                + "\ntoppings list = " + toppingsList
                + "\npoints used = " + pointsUsed
                + "\nYou earned 50 points for this order!"
                + "\nTotal Remaining Points: " + points;
        fruitCount = 0;
        proteinCount = 0;
        toppings = new ArrayList<>();
        pointsUsed = 0;
        return order;
    }

    /**
     * Returns the name of the customer.
     * @return the customer's name.
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * Returns the number of points remaining.
     * @return the point balance.
     */
    public int getPointsBalance() {
        return points;
    }

    /**
     * Returns the number of fruit scoops ordered.
     * @return the number of fruit scoops in the order.
     */
    public int getFruitScoops() {
        return fruitCount;
    }

    /**
     * Returns the number of protein scoops ordered. 
     * @return the number of protein scoops in the order.
     */
    public int getProteinScoops() {
        return proteinCount;
    }

    /**
     * Returns a list of toppings ordered. 
     * @return a list of toppings in the order.
     */
    public String getToppings() {
        String toppingsList = "";
        for (String topping : toppings) {
            toppingsList = toppingsList + topping + " ";
        }
        return toppingsList;
    }

}

