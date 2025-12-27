// // package com.example.demo.controller;

// // import com.example.demo.dto.LoginRequest;
// // import org.springframework.http.ResponseEntity;
// // import org.springframework.security.authentication.AuthenticationManager;
// // import org.springframework.web.bind.annotation.*;

// // @RestController
// // @RequestMapping("/api/auth")
// // public class AuthController {

// //     private final AuthenticationManager authenticationManager;

// //     public AuthController(AuthenticationManager authenticationManager) {
// //         this.authenticationManager = authenticationManager;
// //     }

// //     @PostMapping("/login")
// //     public ResponseEntity<String> login(@RequestBody LoginRequest request) {
// //         authenticationManager.authenticate(null);
// //         return ResponseEntity.ok("dummy-token");
// //     }
// // }

// package com.example.demo.controller;

// import com.example.demo.dto.LoginRequest;
// import com.example.demo.dto.LoginResponse;
// import com.example.demo.dto.RegisterRequest;
// import com.example.demo.model.AppUser;
// import com.example.demo.security.JwtUtil;
// import com.example.demo.service.UserService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.Authentication;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/auth")
// public class AuthController {

//     @Autowired
//     private AuthenticationManager authenticationManager;

//     @Autowired
//     private JwtUtil jwtUtil;

//     @Autowired
//     private UserService userService;

//     // ================= LOGIN =================
//     @PostMapping("/login")
//     public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {

//         Authentication auth = authenticationManager.authenticate(
//                 new UsernamePasswordAuthenticationToken(
//                         request.getEmail(),
//                         request.getPassword()
//                 )
//         );

//         AppUser user = userService.findByEmail(request.getEmail());

//         String token = jwtUtil.generateToken(
//                 user.getEmail(),
//                 user.getRole(),
//                 user.getId()
//         );

//         return ResponseEntity.ok(new LoginResponse(token));
//     }

//     // ================= REGISTER =================
//     @PostMapping("/register")
//     public ResponseEntity<AppUser> register(@RequestBody RegisterRequest request) {
//         AppUser savedUser = userService.register(request);
//         return ResponseEntity.ok(savedUser);
//     }
// }


package com.example.demo.controller;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.LoginResponse;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.AppUser;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserService userService;

    
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {

        
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        
        AppUser user = userService.findByEmail(request.getEmail());

        
        String token = jwtUtil.generateToken(
                user.getEmail(),
                user.getRole(),
                user.getId()
        );

        return ResponseEntity.ok(new LoginResponse(token));
    }

   
    @PostMapping("/register")
    public ResponseEntity<AppUser> register(@RequestBody RegisterRequest request) {

        
        AppUser user = new AppUser();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setName(request.getName());
        user.setRole(request.getRole() != null ? request.getRole() : "USER"); 

        
        AppUser savedUser = userService.register(user);

        return ResponseEntity.ok(savedUser);
    }
}

