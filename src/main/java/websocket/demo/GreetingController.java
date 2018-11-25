package websocket.demo;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

@CrossOrigin(origins = "*")
@Controller
public class GreetingController {

   @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new Greeting("문제:   " + HtmlUtils.htmlEscape(message.getName()) );
    }

    @MessageMapping("/chat")
    @SendTo("/topic/answer")
    public Greeting sendAnswer(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new Greeting("" + HtmlUtils.htmlEscape(message.getName()) );
    }


}
