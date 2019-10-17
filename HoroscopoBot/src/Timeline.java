import java.util.List;

import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.api.TimelinesResources;
import twitter4j.conf.ConfigurationBuilder;
import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.api.TweetsResources;
import twitter4j.conf.ConfigurationBuilder;

public class Timeline {

	public void linhaDoTempo () throws TwitterException {
		
		ConfigurationBuilder cb = new ConfigurationBuilder(); //cria builder p/ validação de acesso na API
		cb.setDebugEnabled(false)
		.setOAuthConsumerKey("azSycpiawKP0e9URIaj5dE8Ib") 
		.setOAuthConsumerSecret("geduA3MkMoDgXTFrFHIbBWYkmfbi08dpgkoaosupgee8zH82MR") 
		.setOAuthAccessToken("1184616482380099585-LSILcey3QjQf5tvMAynvU1HEXlp6t8") 
		.setOAuthAccessTokenSecret("g0QfiI69kj31m0DgeFqMTfrf3Xpdw1PCkfzmBDdJ6rBAm");
		
		TwitterFactory tf = new TwitterFactory (cb.build());//Cria um objeto Twitter
		twitter4j.Twitter twitter = tf.getInstance();
		
		List<Status> status = twitter.getHomeTimeline();//Recebe as informações do JSON e transforma em lista para ser exibida
		
		for (Status stat : status) {
			System.out.println("usuário: @"+ stat.getUser().getScreenName() + "-" + stat.getText());
		}
	}
}
