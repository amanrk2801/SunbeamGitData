package com.sunbeam.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="students")
@NoArgsConstructor
@Getter
@Setter
public class Student {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotBlank(message = "Name is mandatory")
    @Column(length = 20)
    private String name;
    
    @NotBlank(message = "Email is mandatory")
    @Column(length = 40,unique =true)
    private String email;
    @Column(length = 15,unique = true)
    private String phoneNo;
    public Student(String name, String email) {
        this.name = name;
        this.email = email;
    }   
 	
}