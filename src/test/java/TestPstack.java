import com.perfma.xlab.xpocket.plugin.pstack.PStackAdapter;

/**
 * @author ck
 */
public class TestPstack {

    public static void main(String[] args) {

        String result = PStackAdapter.execCommand("pstack 833");
        System.out.println(result);
    }
}
