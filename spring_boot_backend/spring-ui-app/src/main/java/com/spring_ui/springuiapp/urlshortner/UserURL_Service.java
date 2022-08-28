// package com.spring_ui.springuiapp.urlshortner;

// import java.util.List;
// import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// @Service
// public class UserURL_Service {
//     public String userInput(){
//         return "userInput";
//     }

//     @Autowired
//     UserUrl_Repo usrRepo;
//     public String urlShortening(String inputUrl, String prefferedUrl, Short usrUrl){
//         usrUrl.setMainUrl(inputUrl);
//         Optional<Short> userurl = usrRepo.findUserUrlByShortUrl(prefferedUrl);
//         if(userurl.isPresent()){
//             throw new IllegalStateException("Short URL Taken");
//         }
//         usrUrl.setShortUrl(prefferedUrl);
//         usrRepo.save(usrUrl);
//         System.out.println(inputUrl);
//         System.out.println(prefferedUrl);
//         return "userInput";
//         // return List.of("Hello", "World");
//     }

//     public List<Short> getURLS(){
//         return usrRepo.findAll();
//     }

// }
