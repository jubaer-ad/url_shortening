// package com.spring_ui.springuiapp.urlshortner;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.ResponseBody;

// @Controller
// public class UserURL_Output_Controller {
//     @Autowired
//     private final UserURL_Service userURL_Service;

    
//     public UserURL_Output_Controller(UserURL_Service userURL_Service) {
//         this.userURL_Service = userURL_Service;
//     }
//     @PostMapping
//     public String urlShortening(String inputUrl, String prefferedUrl, Short usrUrl){
//         return userURL_Service.urlShortening(inputUrl, prefferedUrl, usrUrl);
//     }
//     @RequestMapping("/all")
//     @ResponseBody
//     public List<Short> getURLS(){
//         return userURL_Service.getURLS();
//     }
// }
