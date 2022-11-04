package backendIntegartion;

import com.EntitiesAPP.mainuser;
import com.EntitiesAPP.meter;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class userBackend {
    String url= "http://localhost:8080/saveUser";
    String url3= "http://localhost:8080/addMeter";
    static String url2= "http://localhost:8080/hi/";

    static RestTemplate template= new RestTemplate();
    public void saveUser(mainuser obj){

        template.postForEntity(url, obj, mainuser.class);
    }

    public static Boolean loginUser(String password, String UserName) {

        return template.getForObject(url2 +password+"/"+UserName, Boolean.class);

    }
    public ResponseEntity<String> addMeter(meter obj){

        return template.postForEntity(url3, obj, String.class);
    }



}
