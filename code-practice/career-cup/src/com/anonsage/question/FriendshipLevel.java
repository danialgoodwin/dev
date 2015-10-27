/**
 * Created by dan on 10/27/15.
 */
package com.anonsage.question;

import java.util.*;

/**
 * Print the level of friendship.
 * <p/>
 * Given a person and list of his friends, print all his friends by level of association.
 * <p/>
 * The text file will be like one below
 * <p/>
 * A: B,C,D
 * D: B,E,F
 * E: C,F,G
 * <p/>
 * If the input is A, the output should be:
 * <p/>
 * Level 1 - B,C,D
 * Level 2 - E,F
 * Level 3 - G
 * <p/>
 * More info: http://www.careercup.com/question?id=5675048708866048
 */
public class FriendshipLevel {

    private static void log(String message) {
        System.out.println(message);
    }

    private static Set<String> visited = new HashSet<>();

    public static void main(String[] args) {
        Map<String, List<String>> friendships = new HashMap<>();
        friendships.put("A", Arrays.asList("B", "C", "D"));
        friendships.put("D", Arrays.asList("B", "E", "F"));
        friendships.put("E", Arrays.asList("C", "F", "G"));
        String friend = "A";
        List<String> friendshipsByLevel = getFriendshipsByLevel(friendships, friend);
        log("friendshipsByLevel=" + friendshipsByLevel);
    }

    public static List<String> getFriendshipsByLevel(Map<String, List<String>> friendships, String friend) {
        if (!friendships.containsKey(friend)) { return Collections.emptyList(); }

        List<String> friendshipByLevel = new ArrayList<>();

        Queue<String> currList = new LinkedList<>();
        Queue<String> nextList = new LinkedList<>();
        Queue<String> tempList;
        currList.add(friend);
//        visited.add(friend);
        while (!currList.isEmpty()) {
            StringBuilder friendsAtLevel = new StringBuilder(currList.size());
            while (!currList.isEmpty()) {
                String f = currList.remove();
                if (!visited.contains(f)) {
                    friendsAtLevel.append(f);;
                    visited.add(f);
                }
                if (friendships.containsKey(f)) {
                    for (String s : friendships.get(f)) {
                        if (!visited.contains(s)) {
                            nextList.add(s);
                        }
                    }
                }
            }
            friendshipByLevel.add(friendsAtLevel.toString());

            // Swap
            tempList = currList;
            currList = nextList;
            nextList = tempList;
        }

        return friendshipByLevel;
    }

//    private static void bfs(Map<String, List<String>> friendships, String friend, List<String> friendshipByLevel) {
//        Queue<String> q = new LinkedList<>();
//        q.add(friend);
//        while (!q.isEmpty()) {
//            String f = q.remove();
//            visit(f);
//
//            // addFriendsOfFriend();
//            if (friendships.containsKey(f)) {
//                for (String s : friendships.get(f)) {
//                    if (!isVisited(s)) {
//                        q.add(s);
//                    }
//                }
//            }
//        }
//    }
//
//    private static void dfsIter(Map<String, List<String>> friendships, String friend, List<String> friendshipByLevel) {
//        Deque<String> stack = new LinkedList<>();
//        stack.push(friend);
//        while (!stack.isEmpty()) {
//            String f = stack.pop();
//            visit(f);
//
//            if (friendships.containsKey(f)) {
//                for (String s : friendships.get(f)) {
//                    if (!isVisited(s)) {
//                        stack.push(s);
//                    }
//                }
//            }
//        }
//    }
//
//    private static void dfsRec(Map<String, List<String>> friendships, String friend, int depth, List<String> friendshipByLevel) {
//        visit(friend);
//
//        if (friendships.containsKey(friend)) {
//            for (String s : friendships.get(friend)) {
//                if (!isVisited(s)) {
//                    dfsRec(friendships, s, depth + 1, friendshipByLevel);
//                }
//            }
//        }
//    }

}
