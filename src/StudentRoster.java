import jdk.nashorn.internal.ir.ContinueNode;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * Created by Travis Brindley on 7/3/2017.
 * Program will pull class member info from xml file.  The program will then validate user input to ensure they are entering correct responses/
 */
public class StudentRoster {
    //student list
    private static void GetList() {
        try {
            File xmlFile = new File("studentlist.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = dbFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(xmlFile);
            NodeList node = doc.getElementsByTagName("student"); // Node list is the sub grouping people belong in

            for (int i = 0; i < node.getLength(); i++) {
                String firstName = doc.getElementsByTagName("firstname").item(i).getTextContent();
                String lastName = doc.getElementsByTagName("lastname").item(i).getTextContent();
                System.out.printf("Student Name:  %s %s \n", firstName, lastName);

                System.out.println("---------------------");
            }

        } catch (Exception e) {
            System.out.println("Data not found");
        }

    }
    private static void GetNickName(){
        try {
            File xmlFile = new File("studentlist.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = dbFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(xmlFile);
            NodeList node = doc.getElementsByTagName("student"); // Node list is the sub grouping people belong in

            for (int i = 0; i < node.getLength(); i++) {
                String firstName = doc.getElementsByTagName("firstname").item(i).getTextContent();
                String nickName = doc.getElementsByTagName("nickname").item(i).getTextContent();
                System.out.println(nickName);
                System.out.printf("%s's nickname is : %s \n", firstName, nickName);
                System.out.println("---------------------");
            }

        } catch (Exception e) {
            System.out.println("Data not found");
        }
    }
    private static void GetFood(){
        try {
            File xmlFile = new File("studentlist.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = dbFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(xmlFile);
            NodeList node = doc.getElementsByTagName("student"); // Node list is the sub grouping people belong in

            for (int i = 0; i < node.getLength(); i++) {
                String firstName = doc.getElementsByTagName("firstname").item(i).getTextContent();
                String favoriteFood = doc.getElementsByTagName("favoriteFood").item(i).getTextContent();
                System.out.printf("%s's favorite food is : %s \n", firstName, favoriteFood);
                System.out.println("---------------------");
            }

        } catch (Exception e) {
            System.out.println("Data not found");
        }
    }
    private static void GetMovie(){
        try {
            File xmlFile = new File("studentlist.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = dbFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(xmlFile);
            NodeList node = doc.getElementsByTagName("student"); // Node list is the sub grouping people belong in

            for (int i = 0; i < node.getLength(); i++) {
                String firstName = doc.getElementsByTagName("firstname").item(i).getTextContent();
                String favoriteMovie = doc.getElementsByTagName("favoriteMovie").item(i).getTextContent();
                System.out.printf("%s's favorite movie is : %s \n", firstName, favoriteMovie);
                System.out.println("---------------------");
            }

        } catch (Exception e) {
            System.out.println("Data not found");
        }
    }
    public static void main(String[] args) {
        System.out.println("Welcome to Java inc.");

        Scanner scan = new Scanner(System.in);
            do {
                try {
                    System.out.println("What would you like to know? \n" +
                            "1 For Student List\n" +
                            "2 For Student's Nickname \n" +
                            "3 For Student's Favorite Food \n" +
                            "4 For Student's Favorite movie");

                    int selection = scan.nextInt();

                    while (selection < 0 || selection > 4) {
                        System.out.println("Invalid selection.  What would you like to know? \n" +
                                "1 For Student List\n" +
                                "2 For Student's Nickname \n" +
                                "3 For Student's Favorite Food \n" +
                                "4 For Student's Favorite movie");

                        selection = scan.nextInt();
                    }
                    switch (selection) {
                        case 1: {
                            GetList();
                        }
                        case 2: {
                            GetNickName();
                        }
                        case 3: {
                            GetFood();
                        }
                        case 4: {
                            GetMovie();
                        }
                    }
                }catch (InputMismatchException e){
                    System.out.println("Invalid input.  Please only enter a whole number between 1 & 4");
                }

                scan.nextLine(); // garbage catcher
                System.out.print("\nDo you wish to run this again? (Y/N)  ");
                String runAgain = scan.nextLine();

                while (!runAgain.equalsIgnoreCase("y") && !runAgain.equalsIgnoreCase("n")) { // ensures only y or n is entered.
                    System.out.print("\nInvalid input, Do you wish to run this again? (Y/N)  ");
                    runAgain = scan.nextLine();
                }
                if (runAgain.equalsIgnoreCase("n")) {
                    break;
                }
            }while (true) ;



            System.out.println("Thanks!");
        }
    }
