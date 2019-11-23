import org.junit.Test;

public class Test12 {

    private StringPathInMatrix_12 matrix12 = new StringPathInMatrix_12();

    @Test
    public void test1(){
        char[] matrix = "ABTGCFCSJDEH".toCharArray();
        char[] str = "BFCE".toCharArray();
        assert matrix12.hasPath(matrix, 3, 4, str) == true;
    }

    @Test
    public void test2(){
        char[] matrix = "ABCESFCSADEE".toCharArray();
        char[] str = "SEE".toCharArray();
        assert matrix12.hasPath(matrix, 3, 4, str) == true;
    }

    @Test
    public void test3(){
        char[] matrix = "ABTGCFCSJDEH".toCharArray();
        char[] str = "ABFB".toCharArray();
        assert matrix12.hasPath(matrix, 3, 4, str) == false;
    }

    @Test
    public void test4(){
        char[] matrix = "ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS".toCharArray();
        char[] str = "SLHECCEIDEJFGGFIE".toCharArray();
        assert matrix12.hasPath(matrix, 5, 8, str) == true;
    }

    @Test
    public void test5(){
        char[] matrix = "ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS".toCharArray();
        char[] str = "SGGFIECVAASABCEHJIGQEM".toCharArray();
        assert matrix12.hasPath(matrix, 5, 8, str) == true;
    }

    @Test
    public void test6(){
        char[] matrix = "ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS".toCharArray();
        char[] str = "SGGFIECVAASABCEEJIGOEM".toCharArray();
        assert matrix12.hasPath(matrix, 5, 8, str) == false;
    }

    @Test
    public void test7(){
        char[] matrix = "ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS".toCharArray();
        char[] str = "SGGFIECVAASABCEHJIGQEMS".toCharArray();
        assert matrix12.hasPath(matrix, 5, 8, str) == false;
    }

    @Test
    public void test8(){
        char[] matrix = "AAAAAAAAAAAA".toCharArray();
        char[] str = "AAAAAAAAAAAAA".toCharArray();
        assert matrix12.hasPath(matrix, 3, 4, str) == false;
    }

    @Test
    public void test9(){
        char[] matrix = "AAAAAAAAAAAA".toCharArray();
        char[] str = "AAAAAAAAAAAA".toCharArray();
        assert matrix12.hasPath(matrix, 3, 4, str) == true;
    }

    @Test
    public void test10(){
        char[] matrix = "A".toCharArray();
        char[] str = "A".toCharArray();
        assert matrix12.hasPath(matrix, 1, 1, str) == true;
    }

    @Test
    public void test11(){
        char[] matrix = "A".toCharArray();
        char[] str = "B".toCharArray();
        assert matrix12.hasPath(matrix, 1, 1, str) == false;
    }
}
