public class RationalTester {

    public static void test1() {
        Rational r12 = new Rational(1, 2);
        Rational r23 = new Rational(2, 3);
        assert r12.getNumerator() == 1;
        assert r12.getDenominator() == 2;
        assert r23.isGreaterThan(r12);
        assert r12.isLessThan(r23);
        assert !r12.equals(r23);

        Rational r48 = new Rational(4, 8);
        assert r12.equals(r48);

        Rational r50 = new Rational(5);
        assert r50.getNumerator() == 5;

        Rational r56 = new Rational(5, -6);
        assert r56.getNumerator() == -5;
        assert r56.getDenominator() == 6;
    }

    public static void test2() {
        Rational r12 = new Rational(1, 2);
        Rational r23 = new Rational(2, 3);
        Rational result = r12.add(r23);
        assert result.equals("7/6");

        result = r12.subtract(r23);
        assert result.equals("-1/6");

        result = r12.multiply(r23);
        assert result.equals("1/3");

        result = r12.divide(r23);
        assert result.equals("3/4");

    }

    public static void test3() {
        Rational r12 = new Rational(1, 2);
        Rational result = r12.subtract(r12);
        assert result.equals("0");

        Rational r00 = new Rational(0, 10);
        assert r00.equals("0");
        assert r00.getDenominator() == 1;
        try {
            Rational r01 = new Rational(1, 0);
            assert false;
        } catch (IllegalArgumentException e) {
            // constructor threw exception as expected
            assert true;
        }
    }

    public static void checkIfAssertionsEnabled() {
        boolean enabled = false;
        // if assertions are not enabled, the next statement will not be executed
        assert enabled = true;
        if (!enabled) {
            System.err.println("Assertions are not enabled! Use java -ea RationalTester");
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        checkIfAssertionsEnabled();
        test1();
        test2();
        test3();
        System.out.println("All tests passed!");
    }
}
