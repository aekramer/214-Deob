package osrs;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.Future;

public interface RefreshAccessTokenRequester {
   Future request(String var1, URL var2, Map var3, String var4);
}
