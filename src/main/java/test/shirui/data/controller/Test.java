package test.shirui.data.controller;


public class Test {

    public static void main(String[] args) {
//        a();
//        c(10);
        d("1 + 2 + (1 + 3) +4");
    }

    public static void a() {
        String str = "{aaaa}22222222{fsf}";
        String str1 = " " + str + " ";
        System.out.println(str1);
        String[] arr = {"石","锐"};
        String s2 = "111122222222";
        String p = "\\{.*?\\}";
        String[] ss = str1.split(p);
//        try {
//            System.out.println(arr[2]);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        int end = ss.length - 1;
        String s = "";
        for (int i = 0;i < end;i++) {
            s += ss[i] + arr[i];
        }
        s += ss[end];

        System.out.print(s.trim());
    }

    public static int b(int n) { // O(2^n)
        if (n < 3) {
            return 1;
        }
        return b(n-1) + b(n - 2);
	}

    static void c(int n) {
        for (int i = 1;i <= n; i++) {
            System.out.println(b(i));
        }
    }

    static void d(String s) {
        s = s.replace(" ", "");
        String[] s1 = s.split("\\(");
        String[] s2 = s1[1].split("\\)");
        d1(s2[0]);
        System.out.print(d1(s2[0]));
    }

    static int d1(String s) {
        String c = "";
        if (s.indexOf('+') > 0){
            c = "+";
        } else if (s.indexOf('-') > 0) {
            c = "-";
        } else {
            c = "*";
        }
        String nums[];
        if (c.equals("+")) {
            nums = s.split("\\+");
            return Integer.parseInt(nums[0]) + Integer.parseInt(nums[1]);
        } else if (c.equals("-")) {
            nums = s.split("\\-");
            return Integer.parseInt(nums[0]) - Integer.parseInt(nums[1]);
        } else {
            nums = s.split("\\*");
            return Integer.parseInt(nums[0]) * Integer.parseInt(nums[1]);
        }
    }



}
