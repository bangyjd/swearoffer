import org.junit.Test;

public class Test15 {

    public int testMode(int n){
        NumberOf1InBinary_15 numberOf1InBinary15 = new NumberOf1InBinary_15();
        int i = numberOf1InBinary15.NumberOf1(n);
        return i;
    }

    @Test
    public void test1(){
        assert testMode(0) == 0;
    }

    @Test
    public void test2(){
        assert testMode(1) == 1;
    }

    @Test
    public void test3(){
        assert testMode(10) == 2;
    }

    @Test
    public void test4(){
        assert testMode(0x7FFFFFFF) == 31;
    }

    @Test
    public void test5(){
        assert testMode(0xFFFFFFFF) == 32;
    }

    @Test
    public void test6(){
        assert testMode(0x80000000) == 1;
    }
}
