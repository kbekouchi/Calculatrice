public class Chiffre {
    static String res="";
    static Long cab = Long.valueOf(0);
    public static String ConvertToTitleCase(int input) {
        if (res.length()>=10) {


            System.out.println("Max dépassé");
        }
        else{
            res += input;
            cab = Long.parseLong(res);
            res = String.valueOf(cab);
            System.out.println(cab);
        }
                return res;
}}

