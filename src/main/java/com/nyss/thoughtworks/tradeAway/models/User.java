package com.nyss.thoughtworks.tradeAway.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Base64;
import java.util.Date;

@Table(name = "users")
@XmlRootElement
@Entity
@Data
@Builder(builderMethodName = "hiddenBuilder")
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String emailId;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String address;

    @Column
    private String mobile;

    @Column
    private String gender;

    @Column
    private String userType;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @Column
    private Date dob;

    @Column
    private int experience;

    @Column
    private String panNumber;

    public void encryptPassword() {
        byte[] encodedPassword = Base64.getEncoder().encode(password.getBytes());
        setPassword(new String(encodedPassword));
    }

}
