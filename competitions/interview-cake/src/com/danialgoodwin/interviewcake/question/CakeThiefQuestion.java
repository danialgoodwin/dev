/**
 * Created by Danial on 1/26/2015.
 */
package com.danialgoodwin.interviewcake.question;

import java.util.ArrayList;
import java.util.Collections;

/**
 * "You are a renowned thief who has recently switched from stealing precious metals to stealing cakes because of
 * the insane profit margins. You end up hitting the jackpot, breaking into the world's largest privately owned
 * stock of cakes—the vault of the Queen of England. While Queen Elizabeth has a limited number of types of cake,
 * she has an unlimited supply of each type. Write a function that takes an array of cake tuples and a weight
 * capacity, and returns the maximum monetary value the duffel bag can hold. Weights and values may be any
 * non-negative integer."
 */
public class CakeThiefQuestion extends Question {

    @Override
    protected String getQuestionName() {
        return "CakeThief";
    }

    @Override
    public void solve() {
        solve_test1();
        solve_test2();
        solve_test3();
    }

    private void solve_test1() {
        ArrayList<Cake> allCakes = new ArrayList<Cake>();
        allCakes.add(new Cake(7, 160));
        allCakes.add(new Cake(3, 90));
        allCakes.add(new Cake(2, 15));
        int maxCapacity = 20;

        // Expect: returns 555 (6 of the middle type of cake and 1 of the last type of cake)
//        int maxWorth_greedy = getMaxWorthForWeight_greedyHeuristic(allCakes, maxCapacity);
//        System.out.println("CakeThiefQuestion. getMaxWorthForWeight_greedyHeuristic(), maxWorth: " + maxWorth_greedy);

        int maxWorth_dp_bottomUp = getMaxWorthForWeight_dp_bottomUp(allCakes, maxCapacity);
        System.out.println("CakeThiefQuestion. getMaxWorthForWeight_dp_bottomUp(), maxWorth: " + maxWorth_dp_bottomUp);

        int maxWorth_dp_topDown = getMaxWorthForWeight_dp_topDown(allCakes, maxCapacity);
        System.out.println("CakeThiefQuestion. getMaxWorthForWeight_dp_topDown(), maxWorth: " + maxWorth_dp_topDown);
    }

    private void solve_test2() {
        ArrayList<Cake> allCakes = new ArrayList<Cake>();
        allCakes.add(new Cake(7, 160));
        allCakes.add(new Cake(3, 90));
        allCakes.add(new Cake(2, 15));
        System.out.println("CakeThiefQuestion. getMaxWorthForWeight_dp_bottomUp(null, 100), maxWorth: " + getMaxWorthForWeight_dp_bottomUp(null, 100));
        System.out.println("CakeThiefQuestion. getMaxWorthForWeight_dp_topDown(null, 100), maxWorth: " + getMaxWorthForWeight_dp_topDown(null, 100));
        System.out.println("CakeThiefQuestion. getMaxWorthForWeight_dp_bottomUp(allCakes, 0), maxWorth: " + getMaxWorthForWeight_dp_bottomUp(allCakes, 0));
        System.out.println("CakeThiefQuestion. getMaxWorthForWeight_dp_topDown(allCakes, 0), maxWorth: " + getMaxWorthForWeight_dp_topDown(allCakes, 0));
    }

    private void solve_test3() {
        ArrayList<Cake> allCakes = new ArrayList<Cake>();
        allCakes.add(new Cake(7, 160));
        allCakes.add(new Cake(3, 90));
        allCakes.add(new Cake(2, 15));
        allCakes.add(new Cake(0, 0));
        int maxCapacity = 20;
        System.out.println("CakeThiefQuestion. getMaxWorthForWeight_dp_bottomUp(cake(0,0)), maxWorth: " + getMaxWorthForWeight_dp_bottomUp(allCakes, maxCapacity));
        System.out.println("CakeThiefQuestion. getMaxWorthForWeight_dp_topDown(cake(0,0)), maxWorth: " + getMaxWorthForWeight_dp_topDown(allCakes, maxCapacity));
    }

    // This algorithm starts at the final weight and uses recursion to find the optimal worths of lower weights.
    // 1. Sort. Space: O(n/2), Time: O(lg*n)
    // 2. Logic. Space: O(k), Time: O(k + k*n)
    private ArrayList<ArrayList<Cake>> mMaxWorths;
    public int getMaxWorthForWeight_dp_topDown(ArrayList<Cake> cakes, final int weightCapacity) {
        if (cakes == null || cakes.isEmpty() || weightCapacity == 0) { return 0; }
        // Sort by worthToWeightRatio.
        Collections.sort(cakes);

        mMaxWorths = new ArrayList<ArrayList<Cake>>(weightCapacity + 1);
        mMaxWorths.add(0, new ArrayList<Cake>(0));
        for (int i = 1; i <= weightCapacity; i++) {
            mMaxWorths.add(null);
        }
        ArrayList<Cake> maxWorthCakes = getMaxWorthCakesForWeight_dp_topDown(cakes, new ArrayList<Cake>(), weightCapacity);
        return calculateWorthOfCakes(maxWorthCakes);
    }

    public ArrayList<Cake> getMaxWorthCakesForWeight_dp_topDown(final ArrayList<Cake> allCakes, ArrayList<Cake> currentCakes, final int capacityLeft) {
        // Base cases. Return the max worth cakes if it has already been calculated for this weight capacity.
        if (mMaxWorths.size() > capacityLeft && mMaxWorths.get(capacityLeft) != null) { return mMaxWorths.get(capacityLeft); }

        ArrayList<Cake> maxWorthCakes = null;
        int maxWorth = 0;
        for (Cake cake : allCakes) {
            if (cake.worthToWeightRatio == 0) { continue; }
//            else if (cake.worthToWeightRatio == Double.MAX_VALUE) { throw new ANSWER_IS_INFINITY_EXCEPTION; }
            if (cake.weight == capacityLeft) {
                mMaxWorths.add(capacityLeft, currentCakes);
                mMaxWorths.get(capacityLeft).add(cake);
            } else if (cake.weight < capacityLeft) {
                ArrayList<Cake> newCurrentCakes = new ArrayList<Cake>(currentCakes);
                newCurrentCakes.add(cake);
                ArrayList<Cake> tempCakes = getMaxWorthCakesForWeight_dp_topDown(allCakes, newCurrentCakes, capacityLeft - cake.weight);
                int tempWorth = calculateWorthOfCakes(tempCakes);
                if (tempWorth > maxWorth) {
                    maxWorth = tempWorth;
                    maxWorthCakes = new ArrayList<Cake>(tempCakes);
                }
            }
        }
        if (maxWorthCakes == null) {
            maxWorthCakes = new ArrayList<Cake>(0);
        }
        return maxWorthCakes;
    }

    // This algorithm starts at weight zero and works up by one until the final weight is reached.
    // Inefficient because some values may be calculated which aren't needed.
    // 1. Sort. Space: O(n/2), Time: O(lg*n)
    // 2. Logic. Space: O(k), Time: O(k*n)
    public int getMaxWorthForWeight_dp_bottomUp(ArrayList<Cake> cakes, final int weightCapacity) {
        if (cakes == null || cakes.isEmpty() || weightCapacity == 0) { return 0; }
        // Sort by worthToWeightRatio.
        Collections.sort(cakes);

        ArrayList<ArrayList<Cake>> maxWorths = new ArrayList<ArrayList<Cake>>(weightCapacity + 1);
        int capacityLeft = weightCapacity;
        for (int weightIndex = 0; weightIndex <= weightCapacity; weightIndex++) {
            maxWorths.add(new ArrayList<Cake>());
            capacityLeft = weightIndex;

            // Find best collection of cakes for this weight.
            for (Cake cake : cakes) {
                if (cake.worthToWeightRatio == 0) { continue; }
//              else if (cake.worthToWeightRatio == Double.MAX_VALUE) { return ANSWER_IS_INFINITY; }
                if (cake.weight <= weightIndex) {
                    maxWorths.get(weightIndex).add(cake);
                    capacityLeft -= cake.weight;
                    // Add cakes from previous solves.
                    if (capacityLeft > 0) {
                        maxWorths.get(weightIndex).addAll(maxWorths.get(capacityLeft));
                    }
                    break;
                }
            }
        }

        return calculateWorthOfCakes(maxWorths.get(weightCapacity));
    }

    // Inefficient because this is just a heuristic, not guaranteed to be most accurate.
    // 1. Sort. Space: O(n/2), Time: O(lg*n)
    // 2. Logic. Space: O(1), Time: O(n)
    public int getMaxWorthForWeight_greedyHeuristic(ArrayList<Cake> cakes, int weightCapacity) {
        // Sort by worthToWeightRatio.
        Collections.sort(cakes);

        int maxWorth = 0;
        int currentCapacity = 0;
        int cakesIndex = 0;
        while (currentCapacity < weightCapacity) {
            if (cakes.get(cakesIndex).weight < (weightCapacity - currentCapacity)) {
                // Add cake to bag.
                maxWorth += cakes.get(cakesIndex).worth;
                currentCapacity += cakes.get(cakesIndex).weight;
            } else {
                cakesIndex++;
                if (cakesIndex > cakes.size() - 1) {
                    break;
                }
            }
        }
        return maxWorth;
    }

    private static int calculateWorthOfCakes(ArrayList<Cake> cakes) {
        int worth = 0;
        for (Cake cake : cakes) {
            worth += cake.worth;
        }
        return worth;
    }

    private static final class Cake implements Comparable {
        int weight;
        int worth;
        double worthToWeightRatio;
        public Cake(int weight, int worth) {
            this.weight = weight;
            this.worth = worth;
            if (weight == 0) {
                if (worth == 0) {
                    worthToWeightRatio = 0;
                } else {
                    worthToWeightRatio = Double.MAX_VALUE;
                }
            } else {
                worthToWeightRatio = (double) worth / weight;
            }
        }

        @Override
        public int compareTo(Object o) {
            if (this == o) { return 0; }
            if (o == null || !(o instanceof Cake)) { throw new IllegalArgumentException("Object cannot be null"); }

            double diff = this.worthToWeightRatio - ((Cake) o).worthToWeightRatio;
            if (diff == 0) { return 0; }
            else if (diff > 0) { return -1; }
            else { return 1; }
        }
    }
}
