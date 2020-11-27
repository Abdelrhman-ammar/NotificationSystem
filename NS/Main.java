package Not_Sys;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void operation() {
        Scanner input = new Scanner(System.in);
        String choice, choiceOp, x;
        while (true) {
            mainMenu();
            choice = input.nextLine();
            if (!(choice.equals("1") || choice.equals("2") || choice.equals("3"))) {
                System.out.println("Error You Select Not Valid Choice.\nDefault Choice IS Notification.");
                choice = "1";
            } else if (choice.equals("3")) {
                break;
            }
            secMenu();
            choiceOp = input.nextLine();
            if (!(choiceOp.equals("1") || choiceOp.equals("2") || choiceOp.equals("3") || choiceOp.equals("4") || choiceOp.equals("5"))) {
                System.out.println("Error You Select Not Valid Choice.\nDefault Choice IS Store.");
                choiceOp = "1";
            } else if (choiceOp.equals("5")) {
                break;
            }
            operation operation;
            boolean contain = true;
            switch (choiceOp) {
                case "1":
                    if (choice.equals("1")) {
                        System.out.print("Enter Id OF Template You Want To Use:_");
                        ArrayList<ArrayList<String>> arr = new ArrayList<ArrayList<String>>();
                        ArrayList<String> arr1 = new ArrayList<>();
                        ArrayList<String> arr2 = new ArrayList<>();
                        arr1.add(input.nextLine());
                        int tempID = Integer.parseInt(arr1.get(0));
                        Inventory inventory = new MYSQLInventory();
                        Blueprint temp = inventory.get(tempID, "template");
                        int counter = countParameter(temp.getContent());
                        System.out.println(temp.toString());
                        for (int i = 0; i < counter; i++) {
                            System.out.print("Enter Parameter Number " + (i + 1) + ":_");
                            arr2.add(input.nextLine());
                        }
                        arr.add(arr1);
                        arr.add(arr2);
                        operation = new NotificationHandler();
                        operation.create(arr);
                    } else {
                        Template t = new Template();
                        System.out.println("This Is Template Format");
                        System.out.println(t.helpFormat());
                        ArrayList<ArrayList<String>> arr = new ArrayList<ArrayList<String>>();
                        ArrayList<String> arr1 = new ArrayList<>();
                        System.out.println("Enter Header Of Template:");
                        arr1.add(input.nextLine());
                        System.out.println("Enter content Of Template:");
                        arr1.add(input.nextLine());
                        System.out.println("Enter Language Of Template:");
                        arr1.add(input.nextLine());
                        arr.add(arr1);
                        operation = new TemplateOperation();
                        operation.create(arr);
                    }
                    break;
                case "2":
                    if (choice.equals("1")) {
                        System.out.print("Enter Id OF Notification:_");
                        operation = new NotificationHandler();
                        Blueprint income = operation.read(Integer.parseInt(input.nextLine()));
                        if (income != null) {
                            System.out.println(income);
                        }
                    } else {
                        System.out.print("Enter Id OF Template:_");
                        operation = new TemplateOperation();
                        Blueprint income = operation.read(Integer.parseInt(input.nextLine()));
                        if (income != null) {
                            System.out.println(income);
                        }
                    }
                    break;
                case "3":
                    Blueprint old;
                    int id;
                    if (choice.equals("1")) {
                        System.out.print("Enter Id OF Notification:_");
                        operation = new NotificationHandler();
                    } else {
                        System.out.print("Enter Id OF Template:_");
                        operation = new TemplateOperation();
                    }
                    id = Integer.parseInt(input.nextLine());
                    old = operation.read(id);
                    if (old == null)
                        break;
                    editMenu();
                    String editChoice;
                    editChoice = input.nextLine();
                    if (!(editChoice.equals("1") || editChoice.equals("2") || editChoice.equals("3"))) {
                        System.out.println("Error invaild Input.");
                    } else {
                        if (editChoice.equals("1")) {
                            System.out.print("Enter New Header:_");
                            old.setHeader(input.nextLine());
                        } else if (editChoice.equals("2")) {
                            System.out.print("Enter New Content:_");
                            old.setContent(input.nextLine());
                        } else {
                            System.out.print("Enter New Language:_");
                            old.setLanguage(input.nextLine());
                        }
                        operation.update(id, old);
                    }
                    break;
                case "4":
                    if (choice.equals("1")) {
                        System.out.print("Enter Id OF Notification:_");
                        operation = new NotificationHandler();
                        operation.delete(Integer.parseInt(input.nextLine()));
                    } else {
                        System.out.print("Enter Id OF Template:_");
                        operation = new TemplateOperation();
                        operation.delete(Integer.parseInt(input.nextLine()));
                    }
                    break;
                default:
                    contain = false;
                    break;
            }
            if (contain == false) {
                break;
            }
        }
    }

    public static void mainMenu() {
        System.out.println("Enter 1 To Select Notification.");
        System.out.println("Enter 2 To Select Template.");
        System.out.println("Enter 3 To Exit.");
        System.out.print("Your Select Is:");
    }

    public static void secMenu() {
        System.out.println("Enter 1 To Store:");
        System.out.println("Enter 2 To get:");
        System.out.println("Enter 3 To update:");
        System.out.println("Enter 4 To Delete:");
        System.out.println("Enter 5 To Exit.");
        System.out.print("Your Select Is:");
    }

    public static void editMenu() {
        System.out.println("Enter 1 To Edit Header:");
        System.out.println("Enter 2 To Edit Content:");
        System.out.println("Enter 3 To Edit language:");
        System.out.print("Your Select Is:");
    }

    public static int countParameter(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '$') {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("\t\t\t\t Notification System");
        operation();
    }
}