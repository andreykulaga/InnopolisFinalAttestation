public class NumbersUtil {
    public int gcd (int a, int b){
        if (a<=0 || b<=0) {
            throw new IllegalArgumentException();
        }
        if (b>a) {
            int temp = b;
            b = a;
            a = temp;
        }
        if (a%b==0) {
            return b;
        }
        while (a%b !=0) {
            int c = a%b;
            a = b;
            b = c;
        } return b;
    }
}
