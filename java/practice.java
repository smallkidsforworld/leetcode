import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class practice {

    public static void main(String[] args) {
        mean();
        Scanner scanner = new Scanner(System.in);
        int choose = scanner.nextInt();
    }




    public static void systemCall(String command){
        try {
            new ProcessBuilder(command).inheritIO().start();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void mean() {
        systemCall("clear");
        String[] list_fun = { "search", "add", "delete", "update" ,"system call"};
        for(int i=0;i<list_fun.length;++i)
            System.out.println(i+" : "+list_fun[i]);
        System.out.println(practice.currentTime());
    }

    public static String currentTime(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(System.currentTimeMillis());
    }

}

class Teacher extends User {
    int manageClass;

    public Teacher() {
    };

    public Teacher(String name, int age, char sex, String phone) {
        super(name, age, sex, phone);
    }

    public Teacher(String name, int age, char sex, String phone, int manageClass) {
        this(name, age, sex, phone);
        this.setManageClass(manageClass);
    }

    public int getManageClass() {
        return manageClass;
    }

    public void setManageClass(int manageClass) {
        this.manageClass = manageClass;
    }
}

class Student extends User {
    int chineseGrade;
    int mathGrade;

    public Student() {
        super();
    }

    public Student(String name, int age, char sex, String phone) {
        super(name, age, sex, phone);
    }

    public int getChineseGrade() {
        return chineseGrade;
    }

    public void setChineseGrade(int chineseGrade) {
        this.chineseGrade = chineseGrade;
    }

    public int getMathGrade() {
        return mathGrade;
    }

    public void setMathGrade(int mathGrade) {
        this.mathGrade = mathGrade;
    }

}

class User {

    public User(String name, int age, char sex, String phone) {
        this.username = name;
        this.age = age;
        this.sex = sex;
        this.phone = phone;
    }

    public User() {

    }

    private int age = 0;
    private String username = "xiaohong";
    private char sex = 'm';
    private String phone = "12345678910";

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    };
}
