package userInterface;

import org.apache.tomcat.jni.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
  
  @GetMapping("/")
  public String showForm(Model model){
    User user = new User();
    model.addAttribute("user", user);
    return "register";
  }
  @PostMapping("/register")
  public String submitForm(@ModelAttribute("user") User user) {
    System.out.println("user");
    return "login";
  }
}
