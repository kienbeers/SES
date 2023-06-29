package com.ses.springjpa.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "EMPLOYEE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    private Long id;

    @Column(name = "Emp_No", length = 30, nullable = false)
    private String empNo;

    @Column(name = "Full_Name", length = 128, nullable = false)
    private String fullName;

    @Temporal(TemporalType.DATE)
    @Column(name = "Hire_Date", nullable = false)
    private Date hireDate;

}
