package section32CDPIntegrationInSelenium;

import org.apache.commons.collections4.Predicate;
import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import java.net.URI;

public class BasicAuthenticationUsinguriPredicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ChromeDriver driver = new ChromeDriver();
		DevTools obj = driver.getDevTools();
	    obj.createSession();
	    
	    java.util.function.Predicate<URI> uriPredicate= uri -> uri.getHost().contains("httpbin.org");
	    //URI is class which have control on URL 
	    
	    ((HasAuthentication)driver).register(uriPredicate, UsernameAndPassword.of("foo", "bar"));
	    //to perform authentication we need to cast driver to HasAuthentication class so that browser support authentication
	    
	    driver.get(" https://httpbin.org/basic-auth/foo/bar");   
	}

}
