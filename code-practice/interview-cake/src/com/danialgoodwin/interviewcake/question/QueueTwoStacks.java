package com.danialgoodwin.interviewcake.question;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by dan on 10/17/15.
 */
public class QueueTwoStacks extends Question {

    @Override
    protected String getQuestionName() {
        return "QueueTwoStacks";
    }

    @Override
    public void solve() {

    }


    public static class QueueViaStacks<E> {
        private Stack<E> in = new Stack<>();
        private Stack<E> out = new Stack<>();

        public void enqueue(E e) {
            in.push(e);
        }

        public E dequeue() {
            if (out.isEmpty()) {
                for (E e1 : in) {
                    out.push(e1);
                }
            }
            return out.pop();
        }

    }


}
