package CodePtit.TH2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CongTy {
    private static String nextValidLine(Scanner sc) {
        while (sc.hasNextLine()) {
            String s = sc.nextLine().trim();
            if (!s.isEmpty())
                return s;
        }
        return "";

    }

    private static int heSo(char nhom, int nam) {
        int[][] bang = {
                { 10, 12, 14, 20 },
                { 10, 11, 13, 16 },
                { 9, 10, 12, 14 },
                { 8, 9, 11, 13 }
        };
        int cot = nam <= 3 ? 0 : nam <= 8 ? 1 : nam <= 15 ? 2 : 3;
        return bang[nhom - 'A'][cot];

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int soPB = Integer.parseInt(nextValidLine(sc));
        Map<String, String> mapPB = new HashMap<>();
        for (int i = 0; i < soPB; i++) {
            String[] p = nextValidLine(sc).split("\\s+", 2);
            mapPB.put(p[0], p[1]);

        }
        int n = Integer.parseInt(nextValidLine(sc));
        for (int i = 0; i < n; i++) {
            String ma = nextValidLine(sc);
            String ten = nextValidLine(sc).replaceAll("\\s+", " ");
            long luongCB = Math.round(Double.parseDouble(nextValidLine(sc)));
            long ngayCong = Math.round(Double.parseDouble(nextValidLine(sc)));

            char nhom = ma.charAt(0);
            int nam = Integer.parseInt(ma.substring(1, 3));
            String tenPB = mapPB.get(ma.substring(3, 5));

            long luong = luongCB * ngayCong * heSo(nhom, nam) * 1000;
            System.out.println(ma + " " + ten + " " + tenPB + " " + luong);
        }
        sc.close();

    }
}
