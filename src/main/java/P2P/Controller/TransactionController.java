package P2P.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/P2P")
public class TransactionController {
    @GetMapping("/test")
    public String testMethod(){
        return "Controller works";
    }

}
