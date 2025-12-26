// // package com.example.demo.service;

// // public interface UserService {
// // }


// package com.example.demo.service;

// import com.example.demo.dto.RegisterRequest;
// import com.example.demo.model.AppUser;

// public interface UserService {

//     AppUser register(RegisterRequest request);

//     AppUser findByEmail(String email);
// }


package com.example.demo.service;

import com.example.demo.model.AppUser;

public interface UserService {
    AppUser findByEmail(String email);
    AppUser register(AppUser user);
    String login(String email, String password);
}
