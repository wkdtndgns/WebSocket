package websocket.demo;

import org.springframework.stereotype.Controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.util.HtmlUtils;

import javax.websocket.OnMessage;
import javax.websocket.Session;
import java.io.IOException;

@Controller
public class GreetingController {


   @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new Greeting("문제:   " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }

    @MessageMapping("/answer")
    public Greeting sendAnswer(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        System.out.println("답  " + message.getName());
        return new Greeting("답, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }


}
