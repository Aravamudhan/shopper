package amudhan.site.web.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// TODO: remove this
@Controller
public class WelcomeController {

  private String message = "Hello World";

  @RequestMapping("/welcome")
  public String welcome(Map<String, Object> model) {
    model.put("message", this.message);
    return "welcome";
  }
}
