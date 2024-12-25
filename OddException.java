public class OddException {
    public void checkOdd(int num) throws Exception {
        if (num % 2 != 0) {
            throw new Exception("The number " + num + " is odd.");
        }
    }

    public static void main(String[] args) {
        OddException obj = new OddException();
        try {
            obj.checkOdd(5);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
