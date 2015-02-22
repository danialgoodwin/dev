/**
 * Created by Danial on 2/7/2015.
 */
package com.danialgoodwin.interviewcake.question;

import java.util.Arrays;
import java.util.Random;

/** Write a function to tell us if a full deck of cards shuffled_deck is a single riffle of two other halves half1
 * and half2. */
public class SingleRifleShuffleQuestion extends Question {

    private static Random mRandom;

    static {
        mRandom = new Random();
    }

    public SingleRifleShuffleQuestion() {}

    @Override
    protected String getQuestionName() {
        return "SingleRifleShuffle";
    }

    @Override
    public void solve() {
        int length = 52;

        // Create new standard deck.
        int[] sortedDeck = new int[length];
        for (int i = 0; i < length; i++) {
            sortedDeck[i] = i + 1;
        }

        solve_testShuffle(sortedDeck, 0);
        solve_testShuffle(sortedDeck, 1);
        solve_testShuffle(sortedDeck, 1);
        solve_testShuffle(sortedDeck, 1);
        solve_testShuffle(sortedDeck, 1);
        solve_testShuffle(sortedDeck, 1);
        solve_testShuffle(sortedDeck, 2);
        solve_testShuffle(sortedDeck, 3);
    }

    private void solve_testShuffle(int[] sortedDeck, int numShuffles) {
        int[] shuffledDeck = sortedDeck;
        for (int i = 0; i < numShuffles; i++) {
            // Currently creates a new array each shuffle, this could be improved in the future.
            shuffledDeck = shuffle(shuffledDeck);
        }
        boolean isSingleRifleShuffle = isSingleRifleShuffle(shuffledDeck);
        log("solve_testShuffle(deck, numShuffles=" + numShuffles + "): " + Arrays.toString(shuffledDeck));
        log("isSingleRifleShuffle: " + isSingleRifleShuffle);
    }

    /** Returns a new deck with a single-rifle shuffle applied.
     * Space: O(n), Time: O(n).
     * @param deck the deck to shuffle
     * @return a new shuffled deck or an empty deck if input was null
     */
    private static int[] shuffle(int[] deck) {
        final int length = (deck == null) ? 0 : deck.length;
        int[] shuffledDeck = new int[length];

        // No shuffling to do for small deck.
        if (length <= 1) { return shuffledDeck; }

        // A shuffle must include at least one card in each half.
        final int split = mRandom.nextInt(length - 1) + 1;
        int deckAIndex = 0;
        int deckBIndex = split;

        for (int i = 0; i < length; i++) {
            // Choose from either first half or last half.
            boolean isFirstHalf = mRandom.nextBoolean();
            shuffledDeck[i] = isFirstHalf ? deck[deckAIndex++] : deck[deckBIndex++];

            // Check to see if an entire half was used up. If so, just copy the rest.
            if (deckAIndex >= split) {
                // Copy the rest of deckB into shuffledDeck.
                i++; // Prevents re-writing a value.
                for (; i < length; i++) {
                    shuffledDeck[i] = deck[deckBIndex++];
                }
                break;
            } else if (deckBIndex >= length) {
                // Copy the rest of deckA into shuffledDeck.
                i++; // Prevents re-writing a value.
                for (; i < length; i++) {
                    shuffledDeck[i] = deck[deckAIndex++];
                }
                break;
            }
        }
        return shuffledDeck;
    }

    /** Returns true if input deck is a single rifle shuffle, otherwise false. Deck sizes of 3 or less will
     * always return true because regardless of the number of times shuffled, it will still look like a single rifle
     * shuffle.
     *
     * Note: This doesn't check for repeat cards, so that's a possible future improvement, depending on input source.
     *
     * Space: O(1), Time: O(n). */
    public static boolean isSingleRifleShuffle(int[] shuffledDeck) {
        if (shuffledDeck == null) { throw new IllegalArgumentException("Input must not be null."); }

        int length = shuffledDeck.length;
        if (length <= 3) { return true; }

        int cardLastSeenDeckA = shuffledDeck[0]; // First card will be arbitrary deck A.
        final int UNKNOWN_CARD = -1;
        int cardLastSeenDeckB = UNKNOWN_CARD; // Unknown.

        for (int i = 1; i < length; i++) {
            int currentCard = shuffledDeck[i];
            if (currentCard == cardLastSeenDeckA + 1) {
                cardLastSeenDeckA = currentCard;
            } else if (cardLastSeenDeckB == UNKNOWN_CARD || currentCard == cardLastSeenDeckB + 1) {
                cardLastSeenDeckB = currentCard;
            } else {
                return false;
            }
        }
        return true;
    }

    /** Returns true if the given array has no repeating elements, otherwise false. This will also return true for
     * null and empty arrays. */
    public static boolean isUniqueElements(int[] array) {
        if (array == null || array.length <= 1) { return true; }

        Arrays.sort(array);
        // Check if no repeating elements.
        int length = array.length;
        int previousValue = array[0];
        for (int i = 1; i < length; i++) {
            if (previousValue == array[i]) {
                return false;
            }
            previousValue = array[i];
        }
        return true;
    }

}
