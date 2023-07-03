package com.example.basicauthentication.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Employee {
    private String empNo;
    private String empName;
    private String empPosition;
}
