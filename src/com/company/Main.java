package com.company;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Stack using LinkedList\n");
        Stack<Integer> stack1 = new Stack<Integer>(100);
        try {
            for(int i=0;i<10;i++){
                stack1.addVal(2*i);
            }
        }catch (Exception error){
            System.out.println(error.getMessage());
            System.exit(0);
        }
        stack1.showSize();
        stack1.showUsingIterator();

        try {
            while(stack1.getSize()>4)
                stack1.getVal();
        }catch (Exception error){
            System.out.println(error.getMessage());
            System.exit(0);
        }
        stack1.showSize();
        stack1.showUsingIterator();

        try {
            for(int i=1;i<8;i++){
                stack1.addVal(5*i);
            }
        }catch (Exception error){
            System.out.println(error.getMessage());
            System.exit(0);
        }
        stack1.showSize();
        stack1.showUsingIterator();

        try {
            stack1.deleteAll();
        }catch (Exception error){
            System.out.println(error.getMessage());
            System.exit(0);
        }
        stack1.showSize();
        stack1.showUsingIterator();
    }
}

class Stack<T>{
    private LinkedList<T> stack;
    private int capacity;
    private int size = 0;

    public Stack(int capacity) {
        stack = new LinkedList<T>();
        this.capacity=capacity;
    }

    public void changeCapacity(int capacity){
        this.capacity=capacity;
    }

    public void showCapacity(){
        System.out.println(capacity);
    }

    public void showSize(){
        System.out.println("Size of stack: " + size);
    }

    public void addVal(T val) throws Exception{
        if(size<capacity){
            stack.add(val);
            size++;
        }
        else
            throw new Exception("Stack is full!");
    }

    public T getVal() throws EmptyStackException {
        if(stack.isEmpty())
            throw new EmptyStackException();
        else
            size--;
        return stack.pollLast();
    }

    public int getSize() {
        return stack.size();
    }

    public void deleteAll(){
        while (size>0){
            getVal();
        }
    }

    public void showUsingIterator() {
        Iterator it=stack.iterator();
        System.out.print("Stack (from down to top): ");
        while(it.hasNext()) {
            Object element = it.next();
            System.out.print(element + " ");
        }
        System.out.print("\n");
    }

    public String toString() {
        String temp="Stack: ";
        for(T val: stack) {
            temp+=val+" ";
        }
        return temp;
    }
}