import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * risk level : 
 *      1(Slightly risky)
 *      2(General risk)
 *      3(Significant risk)
 *      4(High risk)
 *      5(Extremely dangerous)
 * risk factory : 
 *      1: time (work time)
 *      2: worker
 *      3: budget
 *      4: Engineering Amount 
 * 
*/

public class LevelRisk {

    static Map<Integer, Integer> level;

    static {
        level = new HashMap<>();
        level.put(1, 4);
        level.put(2, 8);
        level.put(3, 12);
        level.put(4, 16);
        level.put(5, 20);
    }

    public static int getRiskLevel(RiskFactory riskFactory, int riskLevel) {
        return riskFactory.calculateRisk() + level.get(riskLevel);
    }

    public static int getRiskLevel(int time, int workerNum, int budget, int immediateTeam, int riskLevel) {
        return getRiskLevel(new RiskFactory(time, workerNum, budget, immediateTeam), riskLevel);
    }

    public static int getRiskLevel(int[] data) {
        if (data.length < 5)
            return 0;
        return getRiskLevel(data[1], data[2], data[3], data[4], data[0]);
    }

    public static boolean writeFile(String url, String[] data, String title) throws Exception {
        File file = new File(url);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
            bw.write("Title : " + title + "\n");
            for (String str : data)
                bw.write(str + "\n");
            bw.write("\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String[] dataToFile = new String[12];
        String title;
        int[] data = new int[5];
        System.out.println("please input the title");
        title = scanner.nextLine().trim();
        dataToFile[0] = "please input the :" + "\n0: risk level";
        System.out.println(dataToFile[0]);
        data[0] = Integer.valueOf(scanner.nextLine().trim());
        if (data[0] < 1 || data[1] > 5) {
            System.out.println("input error");
            return;
        }
        dataToFile[1] = String.valueOf(data[0]);

        dataToFile[2] = "1: time ( hour)";
        System.out.println(dataToFile[2]);
        data[1] = Integer.valueOf(scanner.nextLine().trim());
        if (data[1] < 0 || data[1] > 8726) {
            System.out.println("input error");
            return;
        }
        dataToFile[3] = String.valueOf(data[1]);

        dataToFile[4] = "2: programmer num";
        System.out.println(dataToFile[4]);
        data[2] = Integer.valueOf(scanner.nextLine().trim());
        if (data[2] < 0 || data[2] > 100) {
            System.out.println("input error");
            return;
        }
        dataToFile[5] = String.valueOf(data[2]);

        dataToFile[6] = "3: budget";
        System.out.println(dataToFile[6]);
        data[3] = Integer.valueOf(scanner.nextLine().trim());
        if (data[3] < 0 || data[3] > 500000) {
            System.out.println("input error");
            return;
        }
        dataToFile[7] = String.valueOf(data[3]);

        dataToFile[8] = "4: immediateTeam Amount";
        System.out.println(dataToFile[8]);
        data[4] = Integer.valueOf(scanner.nextLine().trim());
        if (data[4] < 0 || data[4] > 200) {
            System.out.println("input error");
            return;
        }
        dataToFile[9] = String.valueOf(data[4]);

        dataToFile[10] = " the total grade is :";
        System.out.println(dataToFile[10] + getRiskLevel(data));
        dataToFile[11] = String.valueOf(getRiskLevel(data));
        writeFile("./data.txt", dataToFile, title);
        scanner.close();
    }

}