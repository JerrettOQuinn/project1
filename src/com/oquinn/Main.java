package com.oquinn;

import java.util.Scanner;

public class Main
{
    static String[] add(String[] toDo, String newTask)
    {
        String[] newTodo = new String[toDo.length + 1];
        for (int i = 0; i < toDo.length; i++) {
            newTodo[i] = toDo[i];
        }
        newTodo[(newTodo.length - 1)] = newTask;
        return newTodo;
    }

    static String[] remove(String[] toDo, int index)
    {
        if ((index < 0) || (index >= toDo.length)) {
            return toDo;
        }
        String[] newTodo = new String[toDo.length - 1];
        for (int i = 0; i < toDo.length; i++) {
            if (i < index) {
                newTodo[i] = toDo[i];
            } else if (i != index) {
                newTodo[(i - 1)] = toDo[i];
            }
        }
        return newTodo;
    }

    static void update(String[] toDo, int index, String newTask)
    {
        if ((index < 0) || (index >= toDo.length)) {
            return;
        }
        toDo[index] = newTask;
    }

    static void list(String[] toDo)
    {
        for (int i = 0; i < toDo.length; i++) {
            System.out.println(i + ". " + toDo[i]);
        }
    }

    public static void main(String[] args)
    {
        String[] toDo = new String[0];
        Boolean continueLoop = Boolean.valueOf(true);
        Scanner scanner = new Scanner(System.in);
        while (continueLoop.booleanValue())
        {
            System.out.println("Please choose an option:");
            System.out.println("(1) Add a task.");
            System.out.println("(2) Remove a task.");
            System.out.println("(3) Update a task.");
            System.out.println("(4) List all tasks.");
            System.out.println("(0) Exit.");

            String input = scanner.nextLine();
            switch (input)
            {
                case "1":
                    System.out.println("Enter a description of the new task.");
                    String newTask = scanner.nextLine();
                    toDo = add(toDo, newTask);
                    break;
                case "2":
                    System.out.println("Enter the index of the task to remove.");
                    int index = Integer.parseInt(scanner.nextLine());
                    toDo = remove(toDo, index);
                    break;
                case "3":
                    System.out.println("Enter the index of the task to update.");
                    int index2 = Integer.parseInt(scanner.nextLine());
                    System.out.println("Enter the new description of the task.");
                    String newTask2 = scanner.nextLine();
                    update(toDo, index2, newTask2);
                    break;
                case "4":
                    list(toDo);
                    break;
                case "0":
                    continueLoop = Boolean.valueOf(false);
            }
        }
    }
}

