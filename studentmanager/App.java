package final2023.studentmanager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class App {
    private static final String COMMA_DELIMITER = ",";

    public static void readListData(String filePath) {

        BufferedReader dataReader = null;
        try {
            String line;
            dataReader = new BufferedReader(new FileReader(filePath));


            // Read file line by line?
            while ((line = dataReader.readLine()) != null) {
                List<String> dataList = parseDataLineToList(line);

                if (dataList.size() != 7) {
                    continue;
                }

                if (dataList.get(0).equals("id")) {
                    continue;
                }

                /*
                TODO

                Đọc được dữ liệu, tạo ra các đối tượng sinh viên ở đây, và cho vào StudentManager để quản lý.
                */
                Student student = new Student.StudentBuilder(dataList.get(0))
                        .withLastname(dataList.get(1))
                        .withFirstname(dataList.get(2))
                        .withYearOfBirth(Integer.parseInt(dataList.get(3)))
                        .withMathsGrade(Double.parseDouble(dataList.get(4)))
                        .withPhysicsGrade(Double.parseDouble(dataList.get(5)))
                        .withChemistryGrade(Double.parseDouble(dataList.get(6)))
                        .build();
                StudentManager.getInstance().append(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (dataReader != null)
                    dataReader.close();
            } catch (IOException crunchifyException) {
                crunchifyException.printStackTrace();
            }
        }
    }

    public static List<String> parseDataLineToList(String dataLine) {
        List<String> result = new ArrayList<>();
        if (dataLine != null) {
            String[] splitData = dataLine.split(COMMA_DELIMITER);
            for (int i = 0; i < splitData.length; i++) {
                result.add(splitData[i]);
            }
        }
        return result;
    }

    public static String[] parseDataLineToArray(String dataLine) {
        if (dataLine == null) {
            return null;
        }

        return dataLine.split(COMMA_DELIMITER);
    }

    public static void main(String[] args) {
        init();

        System.out.println("Test origin:");
        testOriginalData();
        System.out.println("\n===============================\n");


        System.out.println("Test sort year of birth:");
        testSortYearOfBirthDecreasing();
        System.out.println();
        testSortYearOfBirthIncreasing();
        System.out.println("\n===============================\n");


        System.out.println("Test sort math grade:");
        testSortMathsGradeDecreasing();
        System.out.println();
        testSortMathsGradeIncreasing();
        System.out.println("\n===============================\n");

        System.out.println("Test sort physics grade:");
        testSortPhysicsGradeDecreasing();
        System.out.println();
        testSortPhysicsGradeIncreasing();
        System.out.println("\n===============================\n");

        System.out.println("Test sort chemical grade:");
        testSortChemistryGradeDecreasing();
        System.out.println();
        testSortChemistryGradeIncreasing();
        System.out.println("\n===============================\n");

        System.out.println("Test filter math grade:");
        testFilterStudentsHighestMathsGrade();
        System.out.println();
        testFilterStudentsLowestMathsGrade();
        System.out.println("\n===============================\n");

        System.out.println("Test filter physics grade:");
        testFilterStudentsHighestPhysicsGrade();
        System.out.println();
        testFilterStudentsLowestPhysicsGrade();
        System.out.println("\n===============================\n");

        System.out.println("Test filter chemical grade:");
        testFilterStudentsHighestChemistryGrade();
        System.out.println();
        testFilterStudentsLowestChemistryGrade();
        System.out.println("\n===============================\n");

        System.out.println("Test filter average grade:");
        testFilterStudentsHighestAverageGrade();
        System.out.println();
        testFilterStudentsLowestAverageGrade();
        System.out.println("\n===============================\n");
    }

    public static void init() {
        String filePath = "src/final2023/data/students.csv";
//        String filePath = "data/students.csv";
        readListData(filePath);
    }

    public static void testOriginalData() {
        String studentIds = StudentManager.getInstance().idOfStudentsToString(StudentManager.getInstance().getStudentList());
        System.out.print(studentIds);
    }

    public static void testSortYearOfBirthIncreasing() {
        List<Student> students = StudentManager.getInstance().sortYearOfBirthIncreasing();
        String studentIdsString = StudentManager.getInstance().idOfStudentsToString(students);
        System.out.print(studentIdsString);
    }

    public static void testSortYearOfBirthDecreasing() {
        List<Student> students = StudentManager.getInstance().sortYearOfBirthDecreasing();
        String studentIdsString = StudentManager.getInstance().idOfStudentsToString(students);
        System.out.print(studentIdsString);
    }

    public static void testSortMathsGradeIncreasing() {
        /* TODO */
        List<Student> students = StudentManager.getInstance().sortMathsGradeIncreasing();
        String studentIdsString = StudentManager.getInstance().idOfStudentsToString(students);
        System.out.print(studentIdsString);
    }

    public static void testSortMathsGradeDecreasing() {
        /* TODO */
        List<Student> students = StudentManager.getInstance().sortMathsGradeDecreasing();
        String studentIdsString = StudentManager.getInstance().idOfStudentsToString(students);
        System.out.print(studentIdsString);
    }

    public static void testSortPhysicsGradeIncreasing() {
        /* TODO */
        List<Student> students = StudentManager.getInstance().sortPhysicsGradeIncreasing();
        String studentIdsString = StudentManager.getInstance().idOfStudentsToString(students);
        System.out.print(studentIdsString);
    }

    public static void testSortPhysicsGradeDecreasing() {
        /* TODO */
        List<Student> students = StudentManager.getInstance().sortPhysicsGradeDecreasing();
        String studentIdsString = StudentManager.getInstance().idOfStudentsToString(students);
        System.out.print(studentIdsString);
    }

    public static void testSortChemistryGradeIncreasing() {
        /* TODO */
        List<Student> students = StudentManager.getInstance().sortChemistryGradeIncreasing();
        String studentIdsString = StudentManager.getInstance().idOfStudentsToString(students);
        System.out.print(studentIdsString);
    }

    public static void testSortChemistryGradeDecreasing() {
        /* TODO */
        List<Student> students = StudentManager.getInstance().sortChemistryGradeDecreasing();
        String studentIdsString = StudentManager.getInstance().idOfStudentsToString(students);
        System.out.print(studentIdsString);
    }

    public static void testFilterStudentsHighestMathsGrade() {
        List<Student> students = StudentManager.getInstance().sortMathsGradeDecreasing();
        List<Student> nHighestMathsGradeStudents = new LinkedList<>();
        for (int i = 0; i < Math.min(5, students.size()); i++) {
            nHighestMathsGradeStudents.add(students.get(i));
        }
        String studentIdsString = StudentManager.getInstance().idOfStudentsToString(nHighestMathsGradeStudents);
        System.out.print(studentIdsString);
    }

    public static void testFilterStudentsLowestMathsGrade() {
        List<Student> students = StudentManager.getInstance().sortMathsGradeIncreasing();
        List<Student> nLowestMathsGradeStudents = new LinkedList<>();
        for (int i = 0; i < Math.min(5, students.size()); i++) {
            nLowestMathsGradeStudents.add(students.get(i));
        }

        String codeString = StudentManager.getInstance().idOfStudentsToString(nLowestMathsGradeStudents);
        System.out.print(codeString);
    }

    public static void testFilterStudentsHighestPhysicsGrade() {
        /* TODO */
        List<Student> students = StudentManager.getInstance().filterStudentsHighestPhysicsGrade(5);
        String studentIdsString = StudentManager.getInstance().idOfStudentsToString(students);
        System.out.print(studentIdsString);
    }

    public static void testFilterStudentsLowestPhysicsGrade() {
        /* TODO */
        List<Student> students = StudentManager.getInstance().filterStudentsLowestPhysicsGrade(5);
        String studentIdsString = StudentManager.getInstance().idOfStudentsToString(students);
        System.out.print(studentIdsString);
    }

    public static void testFilterStudentsHighestChemistryGrade() {
        /* TODO */
        List<Student> students = StudentManager.getInstance().filterStudentsHighestChemistryGrade(5);
        String studentIdsString = StudentManager.getInstance().idOfStudentsToString(students);
        System.out.print(studentIdsString);
    }

    public static void testFilterStudentsLowestChemistryGrade() {
        /* TODO */
        List<Student> students = StudentManager.getInstance().filterStudentsLowestChemistryGrade(5);
        String studentIdsString = StudentManager.getInstance().idOfStudentsToString(students);
        System.out.print(studentIdsString);
    }

    public static void testFilterStudentsHighestAverageGrade() {
        /* TODO */
        List<Student> students = StudentManager.getInstance().sortAverageGradeDecreasing();
        List<Student> nHighestMathsGradeStudents = new LinkedList<>();
        for (int i = 0; i < Math.min(5, students.size()); i++) {
            nHighestMathsGradeStudents.add(students.get(i));
        }
        String studentIdsString = StudentManager.getInstance().idOfStudentsToString(nHighestMathsGradeStudents);
        System.out.print(studentIdsString);
    }

    public static void testFilterStudentsLowestAverageGrade() {
        /* TODO */
        List<Student> students = StudentManager.getInstance().sortAverageGradeIncreasing();
        List<Student> nHighestMathsGradeStudents = new LinkedList<>();
        for (int i = 0; i < Math.min(5, students.size()); i++) {
            nHighestMathsGradeStudents.add(students.get(i));
        }
        String studentIdsString = StudentManager.getInstance().idOfStudentsToString(nHighestMathsGradeStudents);
        System.out.print(studentIdsString);
    }
}
