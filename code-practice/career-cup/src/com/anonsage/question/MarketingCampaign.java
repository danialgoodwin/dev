/**
 * Created by dan on 10/23/15.
 */
package com.anonsage.question;

import java.util.*;

/**
 * Company will start a new marketing campaign targeting the users according to their purchase profiles.
 *
 * This campaign has 3 kinds of messages each one targeting one group of customers:
 * - Message 1 targets 25% of customers that spend most at the site
 * - Message 2 targets 25% of customers that spend least at the site
 * - Message 3 targets the rest of the customers
 *
 * Given the list of purchases made during the week, write a program that lists what kind of message each customer will receive.
 *
 * Each purchase in this list features the custom id, the purchase amount among other information.
 *
 * More info: http://www.careercup.com/question?id=5641849970622464
 */
public class MarketingCampaign {

    private static void log(String message) {
        System.out.println(message);
    }

    public static void main(String[] args) {
        List<Purchase> purchases = new ArrayList<>();
        purchases.add(new Purchase(new Customer(1), 1.0));
        purchases.add(new Purchase(new Customer(2), 1.0));
        purchases.add(new Purchase(new Customer(3), 1.0));
        purchases.add(new Purchase(new Customer(3), 1.0));
        purchases.add(new Purchase(new Customer(3), 1.0));
        purchases.add(new Purchase(new Customer(4), 1.0));
        purchases.add(new Purchase(new Customer(5), 1.0));
        purchases.add(new Purchase(new Customer(5), 1.0));
        purchases.add(new Purchase(new Customer(5), 1.0));
        purchases.add(new Purchase(new Customer(5), 1.0));
        purchases.add(new Purchase(new Customer(5), 1.0));
        Map<Customer, Message> messages = getMessageForCustomer(purchases);
        log("messages=" + messages);
    }

    // Improvements:
    // - More generics, aka `T extends Customer`
    // - AtomicDouble.putIfAbsent, then it could be parallel.
    // - Use heap (PriorityQueue) instead of HashMap for better space, less performance.
    public static Map<Customer, Message> getMessageForCustomer(List<Purchase> purchases) {
        Map<Customer, Double> customerPurchaseAmounts = new TreeMap<>();
        for (Purchase purchase : purchases) {
            Customer c = purchase.customer;
            if (!customerPurchaseAmounts.containsKey(c)) {
                customerPurchaseAmounts.put(c, 0.0);
            }
            customerPurchaseAmounts.put(c, purchase.purchaseAmount + customerPurchaseAmounts.get(c));
        }

        Map<Customer, Message> customerMessages = new HashMap<>();
        int size = customerPurchaseAmounts.keySet().size();
        int count = 0;
        final int messageLeastLimit = (int) (size * 0.25);
        final int messageCommonLimit = (int) (size * 0.75);
        for (Customer customer : customerPurchaseAmounts.keySet()) {
            Message m;
            if (count < messageLeastLimit) {
                m = Message.LEAST;
            } else if (count < messageCommonLimit) {
                m = Message.COMMON;
            } else {
                m = Message.MOST;
            }
            customerMessages.put(customer, m);
            count++;
        }
        return customerMessages;
    }


    private static class Purchase {
        public Customer customer;
        public double purchaseAmount;

        public Purchase(Customer customer, double purchaseAmount) {
            this.customer = customer;
            this.purchaseAmount = purchaseAmount;
        }
    }

    private static class Customer implements Comparable {
        public int id;

        public Customer(int id) {
            this.id = id;
        }

        @Override
        public int compareTo(Object o) {
            return id - ((Customer) o).id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Customer customer = (Customer) o;
            return Objects.equals(id, customer.id);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }

    private static enum Message {
        LEAST, COMMON, MOST
    }

}
