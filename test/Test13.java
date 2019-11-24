import org.junit.Test;

public class Test13 {

    private RobotMove_13 robotMove13 = new RobotMove_13();

    @Test
    public void test1(){
        assert robotMove13.movingCount(5, 10, 10) == 21;
    }

    @Test
    public void test2(){
        assert robotMove13.movingCount(15, 20, 20) == 359;
    }

    @Test
    public void test3(){
        assert robotMove13.movingCount(10, 1, 100) == 29;
    }

    @Test
    public void test4(){
        assert robotMove13.movingCount(10, 1, 10) == 10;
    }

    @Test
    public void test5(){
        assert robotMove13.movingCount(15, 100, 1) == 79;
    }

    @Test
    public void test6(){
        assert robotMove13.movingCount(15, 10, 1) == 10;
    }

    @Test
    public void test7(){
        assert robotMove13.movingCount(15, 1, 1) == 1;
    }

    @Test
    public void test8(){
        assert robotMove13.movingCount(0, 1, 1) == 1;
    }

    @Test
    public void test9(){
        assert robotMove13.movingCount(-10, 10, 10) == 0;
    }
}
