import org.junit.Test;

public class Test14 {
    public int testMode(int length){
        CuttingRope_14 cuttingRope14 = new CuttingRope_14();
        int i = cuttingRope14.maxProductAfterCutting_solution1(length);
        int j = cuttingRope14.maxProductAfterCutting_solution2(length);
        if (i==j){
            return i;
        }
        return -1;
    }
    private CuttingRope_14 cuttingRope14 = new CuttingRope_14();

    @Test
    public void test1(){
        assert testMode(1)==0;
    }

    @Test
    public void test2(){
        assert testMode(2)==1;
    }

    @Test
    public void test3(){
        assert testMode(3)==2;
    }

    @Test
    public void test4(){
        assert testMode(5)==6;
    }

    @Test
    public void test5(){
        assert testMode(50)==86093442;
    }
}
