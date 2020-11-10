import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

        // list of students, this is where we store
        // the students that we add
        List<Student> listOfStudents = new ArrayList<>();

        // this is a do while loop to keep the console app open
        do {
            // we call the menu and create a userchoice
            // we'll obviously use the userchoice int
            // to keep track of the user choices
            int userChoice;
            userChoice = menu();

            // a switch statement is like a if with a lot of choices
            // the switch basically says if userchoice = 1 do case 1
            // if userchoice = 2 do case 2. The breaks at the end of the case statements
            // are there to stop the program from looking at the other case statements.
            // meaning if we press 1, we know the case is 1, thus we don't have to go look
            // at 2,3,4 etc
            // https://www.w3schools.com/java/java_switch.asp
            switch (userChoice) {
                case 1:
                    // Add student
                    // if userchoice = 1 run the add student method
                    // the method returns a student, thus we add it
                    // into the list of students. TLDR create a student
                    // add it to the list of students
                    listOfStudents.add(addStudent());
                    break;
                case 2:
                    // Remove student
                    // removes a student using the ID
                    // go look at the method
                    removeStudentById(listOfStudents);
                    break;
                case 3:
                    // View students
                    // displays all the students currently in the list of students
                    // if the list size isn't greater than 0, it means that we haven't added
                    // students, thus we'll stop the user immediately for being a doofus
                    if (listOfStudents.size() > 0) {
                        viewStudents(listOfStudents);
                    } else {
                        System.out.println("There are no students in the list!");
                    }
                    break;
                case 4:
                    // quit
                    // this is legit just to close the app
                    System.exit(0);
                    break;
            }
            // the second part of the do at the top,
            // we're essentially just saying, do run the menu
            // while true meaning forever, because we'll manually
            // stop it with case 4
        } while (true);

    }

    // this is where we add a student
    // you'll notice there is no void,
    // as the method will return a student object
    // https://www.w3schools.com/java/java_methods.asp
    public static Student addStudent() {

        // look at the student class,
        // we create a student object, then
        // we add values to the object
        // then we return the student object
        Student studentToAdd = new Student();
        System.out.println("Enter Student name and surname");
        Scanner scanner = new Scanner(System.in);
        studentToAdd.setNameAndSurname(scanner.nextLine());
        System.out.println("Enter Student id");
        studentToAdd.setId(Long.parseLong(scanner.nextLine()));
        System.out.println("Enter Student gpa");
        studentToAdd.setGpa(Double.parseDouble(scanner.nextLine()));
        System.out.println(studentToAdd.getId());


        // after we've built the student object
        // we'll return it to the case and add it to a list
        return studentToAdd;
    }

    // so this method is a bit of a fuck up because normally
    // you would store the info in a db and just remove using a sql query
    // you'll see that it takes a list of students, but doesn't return a list of students
    // we're going to update the original list of students, but we don't need
    // to return it since it persists
    public static void removeStudentById(List<Student> listOfStudents) {

        // since we're removing by id, we need the user to tell us who to remove
        // we identify them using their id
        System.out.println("Enter the id of the student to remove:");
        Scanner scanner = new Scanner(System.in);
        long removeId = Long.parseLong(scanner.nextLine());


        // this is just a check to make sure that the user isn't a litchi
        // we need the user to type a proper id, and a proper id is going
        // to have a value of more than one
        if (removeId > 1) {

            // we use a loop with an iterator. The reason for this is
            // we are going to remove a student based on an index
            // thus we need to know the position of the student in the list
            // position 0 = johan
            // position 1 = hendrik
            // position 2 = ruth
            // to remove hendrik we'll go list.remove(1)
            // how do we know hendrik is at position 1,
            // well we use the iterator (i in this case)
            // in short the loop says we're going to keep count by using i
            // please start at 0 and loop all the way through to the list's size
            // this prevents us from crashing because we're looping too far
            // or because we're not getting all the users in the list ie we're not
            // checking everyone
            for (int i = 0; i < listOfStudents.size(); i++) {

                // this is a potato way of doing a search
                // we're saying if the id that user gave us
                // matches the id of the student in the loop
                // remove the student at the index(i)
                // also break the loop as we don't give a shit
                // about the rest of the students, our job is essentially done
                // in short if hendrik has an id of 555 and the user entered 555 to remove
                // we will loop through the entire list until we find a student with an id of 555
                // this can be at position 1 or 100, it doesn't matter.
                // the i of the loop is going to tell is where the user is,
                // then we'll use the i as an index to remove the user
                if (listOfStudents.get(i).getId() == removeId) {
                    System.out.println("Removing student where id = " + listOfStudents.get(i).getId());
                    listOfStudents.remove(i);
                    break;
                }
                System.out.println("No such student.");
            }
        }
    }


    // view students method that we use in case 3, static = do not need to instantiate the method
    // void = no return
    // it takes in a list of students
    // https://www.w3schools.com/java/java_methods.asp
    public static void viewStudents(List<Student> listOfStudents) {

        // heading
        System.out.println("Name/ID/GPA");

        // this is a loop that doesn't use a iterator
        // because we're going to loop through everything
        // https://www.baeldung.com/java-iterate-list
        for (Student studentToDisplay : listOfStudents) {
            System.out.println(studentToDisplay.getNameAndSurname() + "/" + studentToDisplay.getId() + "/" + studentToDisplay.getGpa());

        }

    }

    // this is where we create the menu
    public static int menu() {

        int selection;
        Scanner input = new Scanner(System.in);

        System.out.println("-------------------------");
        System.out.println("Menu");
        System.out.println("-------------------------\n");
        System.out.println("1 - Add student");
        System.out.println("2 - Remove student by ID");
        System.out.println("3 - View students");
        System.out.println("4 - Quit");

        selection = input.nextInt();
        return selection;
    }

}
