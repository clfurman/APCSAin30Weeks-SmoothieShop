import java.util.*;

public class SmoothieCard {
    private String customerName;
    private int points;
    private int fruitCount; 
    private int proteinCount;
    private ArrayList<String> toppings;
    private int pointsUsed;

    public SmoothieCard(String name, int pts) {
        customerName = name; 
        points = pts;
        fruitCount = 0;
        proteinCount = 0;
        pointsUsed = 0;
        toppings = new ArrayList<>();
    }

    public void addFruit(int count) {
        fruitCount += count;
        pointsUsed += count * 75;
        points -= (count * 75);
    }

    public void addProtein() {
        proteinCount++;
        pointsUsed += 125;
        points -= 125;
    }

    public void addTopping(String type) {
        toppings.add(type);
        pointsUsed += 50;
        points -= 50;
    }

    public void earnBonusPoints(int bonusPoints) {
        points += bonusPoints;
    }

    public String sendOrder() {
        earnBonusPoints(50);
        String toppingsList = getToppings();
        String order = customerName  
                       + ":\nfruit count = " + fruitCount 
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

    public String getCustomerName() { 
        return customerName;
    }

    public int getPointsBalance() {
        return points;
    }

    public int getFruitScoops() {
        return fruitCount;
    }

    public int getProteinScoops() {
        return proteinCount;
    }

    public String getToppings() {
        String toppingsList = "";
        for (String topping : toppings) { 
            toppingsList = toppingsList + topping + " ";
        }
        return toppingsList;
    }

}
