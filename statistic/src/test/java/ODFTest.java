import com.storyteller_f.eks.statistic.ODFWorkbook;
import org.junit.jupiter.api.Test;

public class ODFTest {
    @Test
    public void test() throws Exception {
        ODFWorkbook odfWorkbook=new ODFWorkbook("e:\\测试\\未命名 1.ods");
        int numberOfSheets = odfWorkbook.getNumberOfSheets();
        System.out.println(numberOfSheets);

    }
}
