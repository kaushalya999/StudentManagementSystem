import java.util.Scanner;

class studentManagement {

    static Scanner kb = new Scanner(System.in);
    static String[] sdtId = new String[0];
    static int[] pmarks = new int[0];
    static int[] dmarks = new int[0];
    static String[] name = new String[0];

    public static void main(String[] args) {
        homePage();
    }

    public final static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            e.printStackTrace();
            // Handle any exceptions.
        }
    }

    public static void line() {
        System.out.println("-------------------------------------------------------------------------------------------------------------------------");
    }

    //Home page
    public static void homePage() {

        clearConsole();
        line();
        System.out.println("|\t\t\t\tWELCOME TO GDSE MARKS MANAGEMENT SYSTEM\t\t\t\t\t\t\t|");
        line();
        System.out.println("[1] Add New Student                  \t\t\t\t\t [2] Add New Student With Marks");
        System.out.println("[3] Add Marks                        \t\t\t\t\t [4] Update Student");
        System.out.println("[5] Update Marks                     \t\t\t\t\t [6] Delete Student");
        System.out.println("[7] Prints Student Details           \t\t\t\t\t [8] Print Student Ranks");
        System.out.println("[9] Best in Programming Fundimentals \t\t\t\t\t [10] Best in Database Management system");

        System.err.println();
        System.out.print("Enter an option to continue > ");
        int a = kb.nextInt();

        switch (a) {
            case 1:
                addNewStudent();
                break;
            case 2:
                addStdWithMarks();
                break;
            case 3:
                addMarks();
                break;
            case 4:
                updateStudent();
                break;
            case 5:
                updateMarks();
                break;
            case 6 : deleteStudent();
                break;

            case 7 : printStdDetails();
                break;

            case 8 : printStdRanks();
                break;
            case 9 : bestPrgFdm();
                break;
            case 10 : bestDbms();
                break;
            default:
                System.out.println("Invalid Option");

        }
    }

    // Add New Student
    public static void addNewStudent() {

        clearConsole();
        line();
        System.out.println("|\t\t\t\t\t\t\t  ADD NEW STUDENT\t\t\t\t\t\t\t|");
        line();

        while (true) {
            String[] tempSId = new String[sdtId.length + 1];
            String[] tempsname = new String[sdtId.length + 1];
            int[] temppmarks = new int[sdtId.length + 1];
            int[] tempdmarks = new int[sdtId.length + 1];

            System.out.print("Enter the student ID :");
            String sId = kb.next();

            boolean existId = false;
            for (int i = 0; i < sdtId.length; i++) {
                if (eqaualString(sdtId[i], sId)) {
                    existId = true;
                    break;
                }
            }
            if (existId) {
                System.out.println("Student id already exist please enter different id:");
                continue;
            }

            for (int i = 0; i < sdtId.length; i++) {
                tempSId[i] = sdtId[i];
                tempsname[i] = name[i];
                temppmarks[i] = pmarks[i];
                tempdmarks[i] = dmarks[i];
            }
            System.out.print("Enter the student Name :");
            String nama = kb.next();

            tempSId[tempSId.length - 1] = sId;
            sdtId = tempSId;

            tempsname[tempsname.length - 1] = nama;
            name = tempsname;

            tempdmarks[tempdmarks.length - 1] = -1;
            pmarks = temppmarks;

            temppmarks[temppmarks.length - 1] = -1;
            dmarks = tempdmarks;

            System.out.print("\nStudent has been Added Successfully! Do you want add new student(Y/N) : ");
            String repeat = kb.next();

            if (!eqaualString(repeat, "y") && !eqaualString(repeat, "Y")) {
                break;
            }

        }
        homePage();
    }

    public static boolean eqaualString(String a, String b) {

        if (a == null || b == null) {
            return false;

        }
        if (a.length() != b.length()) {
            return false;

        }
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                return false;
            }

        }

        return true;

    }

    //Add New Student with Marks
    public static void addStdWithMarks() {

        clearConsole();
        line();
        System.out.println("|\t\t\t\t\t\t ADD NEW STUDENT WITH MARKS\t\t\t\t\t\t|");
        line();

        while (true) {
            String[] tempSId = new String[sdtId.length + 1];
            String[] tempsname = new String[sdtId.length + 1];
            int[] temppmarks = new int[sdtId.length + 1];
            int[] tempdmarks = new int[sdtId.length + 1];

            System.out.print("Enter the student ID :");
            String sId = kb.next();

            boolean existId = false;
            for (int i = 0; i < sdtId.length; i++) {
                if (eqaualString(sdtId[i], sId)) {
                    existId = true;
                    break;
                }
            }
            if (existId) {
                System.out.println("Student id already exist please enter different id:");
                continue;
            }
            for (int i = 0; i < sdtId.length; i++) {
                tempSId[i] = sdtId[i];
                tempsname[i] = name[i];
                temppmarks[i] = pmarks[i];
                tempdmarks[i] = dmarks[i];

            }
            System.out.print("Enter the student Name :");
            String nama = kb.next();

            tempSId[tempSId.length - 1] = sId;
            sdtId = tempSId;

            tempsname[tempsname.length - 1] = nama;
            name = tempsname;

            System.out.print("Enter Programming Fundimental Marks :");
            int pmark = kb.nextInt();

            while (pmark < 0 || pmark > 100) {
                System.out.println("Invalid marks, please enter correct marks.");
                System.out.println();
                System.out.print("Enter Programming Fundimental Marks :");
                pmark = kb.nextInt();
            }

            temppmarks[temppmarks.length - 1] = pmark;
            pmarks = temppmarks;

            System.out.print("Enter DBMS marks :");
            int dmark = kb.nextInt();

            while (dmark < 0 || dmark > 100) {
                System.out.println("Invalid marks, please enter correct marks.");
                System.out.println();
                System.out.print("Enter DBMS marks :");
                dmark = kb.nextInt();

            }

            tempdmarks[tempdmarks.length - 1] = dmark;
            dmarks = tempdmarks;

            System.out.print("\nStudent has been Added Successfully! Do you want add new student(Y/N) : ");
            String repeat = kb.next();

            if (!eqaualString(repeat, "y") && !eqaualString(repeat, "Y")) {
                break;
            }

        }
        homePage();

    }

    //Add Marks
    public static void addMarks() {

        clearConsole();
        line();
        System.out.println("|\t\t\t\t\t\t\tADD MARKS\t\t\t\t\t\t\t|");
        line();

        while (true) {

            System.out.print("Enter the student ID :");
            String sId = kb.next();

            int pos = -1;

            for (int i = 0; i < sdtId.length; i++) {
                if (eqaualString(sdtId[i], sId)) {
                    pos = i;
                    break;
                }
            }

            if (pos == -1) {
                System.out.println("Invalid Student Id, Do yo want to search again(y/n) :");
                
                String repeat = kb.next();

                if (!eqaualString(repeat, "y") && !eqaualString(repeat, "Y")) {
                    break;
                } else
                    continue;

            }
            if (pmarks[pos] != -1) {
                System.out.println("Student name : " + name[pos]);
                System.out.println("This student's marks has been Already added:\n If you want to update marks please use [4] update option\nDo you want to add another student(Y/N)");

                String repeat = kb.next();

                if (!eqaualString(repeat, "y") && !eqaualString(repeat, "Y")) {
                    break;
                } else
                    continue;
            }

            System.out.println("Student name : " + name[pos]);
            System.out.println();
            System.out.print("Enter Programming Fundimental Marks :");
            int pmark = kb.nextInt();

            while (pmark < 0 || pmark > 100) {
                System.out.println("Invalid marks, please enter correct marks.");
                System.out.println();
                System.out.print("Enter Programming Fundimental Marks :");
                pmark = kb.nextInt();
            }

            pmarks[pos] = pmark;

            System.out.print("Enter DBMS Marks :");
            int dmark = kb.nextInt();

            while (dmark < 0 || dmark > 100) {
                System.out.println("Invalid marks, please enter correct marks.");
                System.out.println();
                System.out.print("Enter DBMS marks :");
                dmark = kb.nextInt();

            }

            dmarks[pos] = dmark;

            System.out.print("\nStudent has been Added Successfully! Do you want add new student(Y/N) : ");
            String repeat = kb.next();

            if (!eqaualString(repeat, "y") && !eqaualString(repeat, "Y")) {
                break;
            }

        }
        homePage();

    }

    //Update Student Details        
    public static void updateStudent() {

        clearConsole();
        line();
        System.out.println("|\t\t\t\t\t\tUPDATE STUDENT DETAILS\t\t\t\t\t\t\t|");
        line();

        while (true) {

            System.out.print("Enter the student ID :");
            String sId = kb.next();

            int pos = -1;

            for (int i = 0; i < sdtId.length; i++) {
                if (eqaualString(sdtId[i], sId)) {
                    pos = i;
                    break;
                }
            }

            if (pos == -1) {
                System.out.print("Invalid Student Id, Do yo want to search again(y/n) :");
                String repeat = kb.next();

                if (!eqaualString(repeat, "y") && !eqaualString(repeat, "Y")) {
                    break;
                } else
                    continue;

            } else {
                System.out.print("Student name : " + name[pos]);
                System.out.println();
                System.out.print("Enter new student name : ");
                String x = kb.next();
                name[pos] = x;
            }

            System.out.print("\nStudent Details has been updated Successfully! Do you want to update another student details(Y/N) : ");
            String repeat = kb.next();

            if (!eqaualString(repeat, "y") && !eqaualString(repeat, "Y")) {
                break;
            }

        }
        homePage();

    }

    //Update Marks
    public static void updateMarks() {

        clearConsole();
        line();
        System.out.println("|\t\t\t\t\t\t\tUPDATE MARKS\t\t\t\t\t\t\t|");
        line();

        while (true) {

            System.out.print("Enter the student ID :");
            String sId = kb.next();

            int pos = -1;

            for (int i = 0; i < sdtId.length; i++) {
                if (eqaualString(sdtId[i], sId)) {
                    pos = i;
                    break;
                }
            }

            if (pos == -1) {
                System.out.print("Invalid Student Id, Do yo want to search again(y/n) :");
                String repeat = kb.next();

                if (!eqaualString(repeat, "y") && !eqaualString(repeat, "Y")) {
                    break;
                } else
                    continue;

            }
            
            if(pmarks[pos] == -1 ) {
                System.out.print("This student marks yet to be added. Do you want to search another student (Y/N)");
                String repeat = kb.next();

                if (!eqaualString(repeat, "y") && !eqaualString(repeat, "Y")) {
                    break;
                } else
                    continue;

            }
            else{

                System.out.print("Student name : " + name[pos]);
                System.out.println();

                System.out.println("Programming fundimental marks : " + pmarks[pos]);
                System.out.println("DBMS marks : " + dmarks[pos]);

                System.out.print("Enter new programme fundimental Marks :");
                int pm = kb.nextInt();

                while (pm < 0 || pm > 100) {
                    System.out.print("Invalid marks, please enter correct marks.");
                    System.out.println();
                    System.out.print("Enter DBMS marks :");
                    pm = kb.nextInt();

                }

                pmarks[pos] = pm;

                System.out.print("Enter new DBMS Marks :");
                int dm = kb.nextInt();

                while (dm < 0 || dm > 100) {
                    System.out.print("Invalid marks, please enter correct marks.");
                    System.out.println();
                    System.out.print("Enter DBMS marks :");
                    dm = kb.nextInt();

                }

                dmarks[pos] = dm;

                System.out.print(
                        "\nMarks have been updated Successfully! Do you want to update another student details(Y/N) : ");
                String repeat = kb.next();
                if (!eqaualString(repeat, "y") && !eqaualString(repeat, "Y")) {
                    break;
                }else{
                    continue;
                }

            }

        }
        homePage();
    }

    // Delete Student
    public static void deleteStudent(){

        clearConsole();
        line();
        System.out.println("|\t\t\t\t\t\t\tDELETE STUDENT \t\t\t\t\t\t\t|");
        line();

            String[] tempSId = new String[sdtId.length - 1];
            String[] tempsname = new String[sdtId.length - 1];
            int[] temppmarks = new int[sdtId.length - 1];
            int[] tempdmarks = new int[sdtId.length - 1];

        while (true) {

            System.out.print("Enter the student ID :");
            String sId = kb.next();

            int pos = -1;

            for (int i = 0; i < sdtId.length; i++) {
                if (eqaualString(sdtId[i], sId)) {
                    pos = i;
                    break;
                }
            }

            if (pos == -1) {
                System.out.print("Invalid Student Id, Do yo want to search again(y/n) :");
                String repeat = kb.next();

                if (!eqaualString(repeat, "y") && !eqaualString(repeat, "Y")) {
                    break;
                } else
                    continue;

            }
            
            else{
            
                int j=pos;

                for(int i=0, k=0;i<sdtId.length;i++){
                    if(i!=j){
                        tempSId[k] = sdtId[i];
                        tempsname[k] = name[i]; 
                        temppmarks[k] = pmarks[i];
                        tempdmarks[k] = dmarks[i];
                        k++;
                    }
                }
                sdtId = tempSId;
                name = tempsname;
                pmarks = temppmarks;
                dmarks = tempdmarks;

                System.out.println("Student has been deleted successfully!");

                System.out.print("Do you want to enter another student (y/n) :");
                String repeat = kb.next();

                if (!eqaualString(repeat, "y") && !eqaualString(repeat, "Y")) {
                    break;
                } else
                    continue;
            }
        }
        homePage();
    }

    // Print Student Details
    public static void printStdDetails(){

        clearConsole();
        line();
        System.out.println("|\t\t\t\t\t\t  PRINT STUDENT DETAILS\t\t\t\t\t\t\t|");
        line();

        while (true) {

            System.out.print("Enter the student ID :");
            String sId = kb.next();

            int pos = -1;
            double Total;
            double Average;
            String Rank;

            for (int i = 0; i < sdtId.length; i++) {
                if (eqaualString(sdtId[i], sId)) {
                    pos = i;
                    break;
                }
            }

            if (pos == -1) {
                System.out.print("Invalid Student Id, Do yo want to search again(y/n) :");
                String repeat = kb.next();

                if (!eqaualString(repeat, "y") && !eqaualString(repeat, "Y")) {
                    break;
                } else
                    continue;

            }

            if(pmarks[pos] == -1 ) {

                System.out.println("Student name     :" + name[pos]);
                System.out.println();
                System.out.print("This student marks yet to be added. \n\nDo you want to search another student (Y/N)");
                String repeat = kb.next();

                if (!eqaualString(repeat, "y") && !eqaualString(repeat, "Y")) {
                    break;
                } else
                    continue;

            }

            else{
                Total = total(pmarks[pos], dmarks[pos]);
                Average = average(Total, 2);
                Rank = rank(Average);

                System.out.println("Student name     :" + name[pos]);
                line();
                System.out.println("programming Fundimental Marks      |" + pmarks[pos] + "|");
                System.out.println("Database Management system Marks   |" + dmarks[pos] + "|");
                System.out.println("Total Marks                        |" + Total +       "|");
                System.out.println("Avg. Marks                         |" + Average +     "|");
                System.out.println("Rank                               |" + Rank +        "|");
                line();

                System.out.print("Do you want to enter another student (y/n) :");
                String repeat = kb.next();

                if (!eqaualString(repeat, "y") && !eqaualString(repeat, "Y")) {
                    break;
                } else
                    continue;
            }
                    
        }
        homePage();
    }

    public static double[] sort(double[] array) {
        for (int j = array.length - 1; j >= 0; j--) {
            for (int i = 0; i < j; i++) {
                if (array[i] < array[i + 1]) {
                    double t = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = t;
                }
            }
        }
        return array;
    }


    public static String rank(double rnk){

        double avgarr[] = new double[dmarks.length];
        
        double total = 0;
        double avg = 0;
        int rank = 0;
        String s = " ";

        for (int i = 0; i < dmarks.length; i++) {
            total = pmarks[i] + dmarks[i];
            avg = total / 2;

            avgarr[i] = avg;
        }

        avgarr = removeDuplicate(avgarr);
        avgarr = sort(avgarr);

        for (int i = 0; i < avgarr.length; i++) {
            if (avgarr[i] == rnk) {
                rank = i + 1;
                if (rank == 1) {
                    s = "1 (First)";
                } else if (rank == 2) {
                    s = "2 (Second)";
                } else if (rank == 3) {
                    s = "3 (Third)";
                } else if (rank == avgarr.length) {
                    s = "Last";
                } else {
                    s = "" + rank;
                }
                break;
            }

        }
        return s;
    }

    public static boolean checkDuplicate(double[] array, double value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return true;
            }
        }
        return false;
    } 
    
    public static double[] removeDuplicate(double[] array) {
        double br[] = new double[0];
        for (int i = 0; i < array.length; i++) {
            if (!checkDuplicate(br, array[i])) {
                double temp[] = new double[br.length + 1];
                for (int j = 0; j < br.length; j++) {
                    temp[j] = br[j];
                }
                temp[temp.length - 1] = array[i];
                br = temp;
            }
        }
        return br;
    }

    public static double total(double PFmarks, double DBMSmarks) {
        return PFmarks + DBMSmarks;
    }

    public static double average(double tot, int count) {
        return tot / count;
    }

    //Print student Ranks
    public static void printStdRanks(){

        clearConsole();
        line();
        System.out.println("|\t\t\t\t\t\t  PRINT STUDENT'S RANKS\t\t\t\t\t\t\t|");
        line();

        int index = 0;

        for(int i = 0; i < sdtId.length; i++){
            if(pmarks[i] != -1 && dmarks[i] != -1){
                index++;
            }
        }

        double[] totarray = new double[index];
        double[] avgarr = new double[index];
        String[] namearr = new String[index];
        String[] sidarr = new String[index];

        int count = 0;

        for (int i = 0; i < sdtId.length; i++) {
            if (dmarks[i] != -1 && pmarks[i] != -1) {

                totarray[count] = pmarks[i] + dmarks[i];
                avgarr[count] = totarray[count]/2.0;  
                namearr[count] = name[i];
                sidarr[count] = sdtId[i]; 
                count++;       
            }
        }

        for (int j = index - 1; j >= 0; j--) {
            for (int i = 0; i < j; i++) {
                if (avgarr[i] < avgarr[i + 1]) {

                    double a = avgarr[i];
                    avgarr[i] = avgarr[i + 1];
                    avgarr[i + 1] = a;

                    double t = totarray[i];
                    totarray[i] = totarray[i + 1];
                    totarray[i + 1] = t;

                    String id = sidarr[i];
                    sidarr[i] = sidarr[i + 1];
                    sidarr[i + 1] = id;

                    String name = namearr[i];
                    namearr[i] = namearr[i + 1];
                    namearr[i + 1] = name;
                }
            }
        }

        System.out.println("\n");
        while (true) {
            System.out.println("+--------+-----------+-----------------------+-------------------+-------------------+");
            System.out.println("|Rank    |ID         |Name                   |Total Marks        |Avg.Marks          |");
            System.out.println("+--------+-----------+-----------------------+-------------------+-------------------+");
        

        for(int i = 0; i < index; i++) {
            int rnk = i + 1;
            System.out.println(  + rnk + "\t\t" + sidarr[i] + "\t\t" + namearr[i] + "\t\t\t" + totarray[i] + "\t\t\t" + avgarr[i] + "\t\t" );
        }

        System.out.println("+--------+-----------+-----------------------+-------------------+-------------------+");
        System.out.println();
        System.out.print("Do you want to go back to the Main menu (y/n) :");
        String repeat = kb.next();

            if (!eqaualString(repeat, "y") && !eqaualString(repeat, "Y")) {
                continue;
            } else
                break;
        }
        homePage();
    }

    //Best Marks For Programing Fundimentals
    public static void bestPrgFdm(){

        clearConsole();
        line();
        System.out.println("|\t\t\t\t\t  BEST IN PROGRAMMING FUNDIMENTALS\t\t\t\t\t\t|");
        line();

        int index = 0;

        for(int i = 0; i < sdtId.length; i++){
            if(pmarks[i] != -1 && dmarks[i] != -1){
                index++;
            }
        }

        double[] pmarr = new double[index];
        double[] dmarr = new double[index];
        String[] namearr = new String[index];
        String[] sidarr = new String[index];

        int count = 0;

        for (int i = 0; i < sdtId.length; i++) {
            if (pmarks[i] != -1) {

                pmarr[count] = pmarks[i];
                dmarr[count] = dmarks[i];  
                namearr[count] = name[i];
                sidarr[count] = sdtId[i]; 
                count++;       
            }
        }

        for (int j = index - 1; j >= 0; j--) {
            for (int i = 0; i < j; i++) {
                if (pmarr[i] < pmarr[i + 1]) {

                    double pm = pmarr[i];
                    pmarr[i] = pmarr[i + 1];
                    pmarr[i + 1] = pm;

                    double dm = dmarr[i];
                    dmarr[i] = dmarr[i + 1];
                    dmarr[i + 1] = dm;

                    String id = sidarr[i];
                    sidarr[i] = sidarr[i + 1];
                    sidarr[i + 1] = id;

                    String name = namearr[i];
                    namearr[i] = namearr[i + 1];
                    namearr[i + 1] = name;
                }
            }
        }

        System.out.println("\n");
        while (true) {
            System.out.println("+-----------+-----------------------+-------------------+-------------------+");
            System.out.println("|ID         |Name                   |PF Marks           |DBMS Marks         |");
            System.out.println("+-----------+-----------------------+-------------------+-------------------+");

            for(int i = 0; i < index; i++){
                System.out.println( sidarr[i] + "\t\t" + namearr[i] + "\t\t\t" + pmarr[i] + "\t\t\t" + dmarr[i] + "\t\t" );
            }

            System.out.println("+-----------+-----------------------+-------------------+-------------------+");
        System.out.println();
        System.out.print("Do you want to go back to the Main menu (y/n) :");
        String repeat = kb.next();

            if (!eqaualString(repeat, "y") && !eqaualString(repeat, "Y")) {
                continue;
            } else
                break;
        }
        homePage();
    }

    //Best Marks For DBMS
    public static void bestDbms(){

        clearConsole();
        line();
        System.out.println("|\t\t\t\t\t  BEST IN DATABASE MANAGEMENT SYSTEM\t\t\t\t\t\t|");
        line();

        int index = 0;

        for(int i = 0; i < sdtId.length; i++){
            if(pmarks[i] != -1 && dmarks[i] != -1){
                index++;
            }
        }

        double[] pmarr = new double[index];
        double[] dmarr = new double[index];
        String[] namearr = new String[index];
        String[] sidarr = new String[index];

        int count = 0;

        for (int i = 0; i < sdtId.length; i++) {
            if (pmarks[i] != -1) {

                pmarr[count] = pmarks[i];
                dmarr[count] = dmarks[i];  
                namearr[count] = name[i];
                sidarr[count] = sdtId[i]; 
                count++;       
            }
        }

        for (int j = index - 1; j >= 0; j--) {
            for (int i = 0; i < j; i++) {
                if (dmarr[i] < dmarr[i + 1]) {

                    double pm = pmarr[i];
                    pmarr[i] = pmarr[i + 1];
                    pmarr[i + 1] = pm;

                    double dm = dmarr[i];
                    dmarr[i] = dmarr[i + 1];
                    dmarr[i + 1] = dm;

                    String id = sidarr[i];
                    sidarr[i] = sidarr[i + 1];
                    sidarr[i + 1] = id;

                    String name = namearr[i];
                    namearr[i] = namearr[i + 1];
                    namearr[i + 1] = name;
                }
            }
        }

        System.out.println("\n");
        while (true) {
            System.out.println("+-----------+-----------------------+-------------------+-------------------+");
            System.out.println("|ID         |Name                   |DBMS Marks         |PF Marks           |");
            System.out.println("+-----------+-----------------------+-------------------+-------------------+");

            for(int i = 0; i < index; i++){
                System.out.println( sidarr[i] + "\t\t" + namearr[i] + "\t\t\t" + dmarr[i] + "\t\t\t" + pmarr[i] + "\t\t" );
            }

            System.out.println("+-----------+-----------------------+-------------------+-------------------+");

            System.out.println();
        System.out.print("Do you want to go back to the Main menu (y/n) :");
        String repeat = kb.next();

            if (!eqaualString(repeat, "y") && !eqaualString(repeat, "Y")) {
                continue;
            } else
                break;
        }
        homePage();
    }
        
}


                
      




