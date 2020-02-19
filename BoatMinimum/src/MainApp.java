import java.util.Arrays;

/*
* An imminent hurricane threatens the coastal town of Codeville. If at most two people can fit in a rescue boat,
*  and the maximum weight limit for a given boat is k, determine how many boats will be needed to save everyone.
For example, given a population with weights [100, 200, 150, 80] and a boat limit of 200, the smallest number
* of boats required will be three.*/
public class MainApp {
    public static void main(String[] Args) {
        int[] peopleWeights = {100, 200, 150, 80, 200};
        int totalWeight = 200;
        System.out.println(calculateWeight(peopleWeights, totalWeight));
    }

    private static int calculateWeight(int[] weights, int totalWeight) {
        //loop though the integers while adding their weight and ensure it less than total weight
        Arrays.sort(weights);
        int preTotal = 0;
        int peopleCount = 0;
        for (int i : weights) {
            preTotal = preTotal + i;
            System.out.println("preTotal " + preTotal);
            if (preTotal > totalWeight) {
                peopleCount = peopleCount + 1;
                preTotal = i;

            }
            if (preTotal == totalWeight) {
                peopleCount = peopleCount + 1;
                preTotal = 0;
            }
            System.out.println("peopleCount " + peopleCount);
        }
        return peopleCount;
    }
}
