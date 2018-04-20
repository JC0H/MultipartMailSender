package ua.com.jcoh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;
import ua.com.jcoh.entity.User;
import ua.com.jcoh.service.UserService;

import java.io.File;
import java.io.IOException;
import java.security.Principal;


@Controller
public class MainController {

    @Autowired
    UserService userService;

    @RequestMapping("/")
    public String toMainPage(Principal principal, Model model){
        model.addAttribute("principal", principal);
        return "index";
    }

    @RequestMapping(value = "registration", method = RequestMethod.GET)
    public String registration(){
        return "registration";
    }

    @RequestMapping(value = "registration", method = RequestMethod.POST)
    public String registrationOfUser(@RequestParam("username") String username, @RequestParam("password") String password,
                                     @RequestParam("email") String email, @RequestParam("file")MultipartFile multipartFile) throws IOException {

        String realPath = System.getProperty("user.home") + File.separator+ "images\\";
        multipartFile.transferTo(new File(realPath + multipartFile.getOriginalFilename()));
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setAvatar("\\avatar\\" + multipartFile.getOriginalFilename());
        userService.save(user);
        return "index";
    }

    @RequestMapping(value = "userListPage" , method = RequestMethod.POST)
    public String userListPage(Model model){
        model.addAttribute("userList" , userService.findAll());
        return "userListPage";
    }

    @RequestMapping(value = "user{id}" , method = RequestMethod.GET)
    public String singleUser(@PathVariable("id") int id, Model model){
        User user = userService.findOne(id);
        model.addAttribute("user", user);
        return "singleUser";
    }


}
