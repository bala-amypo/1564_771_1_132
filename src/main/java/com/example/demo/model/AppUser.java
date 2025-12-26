// // package com.example.demo.model;

// // import jakarta.persistence.Entity;
// // import jakarta.persistence.Id;
// // import jakarta.persistence.GeneratedValue;
// // import jakarta.persistence.GenerationType;
// // import java.time.LocalDateTime;

// // @Entity
// // public class AppUser {

// //     @Id
// //     @GeneratedValue(strategy = GenerationType.IDENTITY)
// //     private Long id;

// //     private String email;
// //     private String password;
// //     private String role;
// //     private LocalDateTime createdAt;

// //     // getters & setters
// //     public Long getId() { return id; }
// //     public void setId(Long id) { this.id = id; }

// //     public String getEmail() { return email; }
// //     public void setEmail(String email) { this.email = email; }

// //     public String getPassword() { return password; }
// //     public void setPassword(String password) { this.password = password; }

// //     public String getRole() { return role; }
// //     public void setRole(String role) { this.role = role; }

// //     public LocalDateTime getCreatedAt() { return createdAt; }
// //     public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
// // }


// package com.example.demo.model;

// import jakarta.persistence.*;
// import java.time.LocalDateTime;

// @Entity
// @Table(name = "app_users")
// public class AppUser {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column(unique = true)
//     private String email;

//     private String password;

//     private String role;

//     private LocalDateTime createdAt;

//     // ===== getters & setters =====

//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }

//     public String getEmail() { return email; }
//     public void setEmail(String email) { this.email = email; }

//     public String getPassword() { return password; }
//     public void setPassword(String password) { this.password = password; }

//     public String getRole() { return role; }
//     public void setRole(String role) { this.role = role; }

//     public LocalDateTime getCreatedAt() { return createdAt; }
//     public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
// }


package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "app_users")
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String role = "USER"; // default role

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    // Constructors
    public AppUser() {}

    public AppUser(String email, String password, String name, String role) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.role = role;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
