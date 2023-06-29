package P2P;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class Main {
    //TODO: create new project, add functionality for P2P and add it as module. Then make some test to verify interconnection between P2P and Transaction
    public static void main(String[] args) {
      SpringApplication app=new SpringApplication(P2P.Main.class);
      app.setDefaultProperties(Collections.singletonMap("server.port","8081"));
      app.run(args);
    }
}
