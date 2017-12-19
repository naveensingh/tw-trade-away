package com.nyss.thoughtworks.tradeAway.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.*;
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
    @NotNull(groups = Existing.class)
    @Null(groups = New.class)
    private Long id;

    @NotNull(
            message = "First name is required",
            groups = {Existing.class, New.class}
    )
    @Size(min = 1, message = "At least one character is required in name")
    @Pattern(regexp = "[a-zA-Z]+", message = "This format of name is not recognized")
    @Column
    private String name;

    @Email(message = "Email is not valid")
    @Column
    private String emailId;

    @NotNull(
            message = "Username is required",
            groups = {Existing.class, New.class}
    )
    @Size(min = 1, message = "At least one character is required in username")
    @Pattern(regexp = "[a-zA-Z0-9]+", message = "This format of username is not recognized")
    @Column
    private String username;

    @NotNull(
            message = "Password cannot be empty",
            groups = {Existing.class, New.class}
    )
    @Size(min = 1, message = "At least one character is required in password")
    @Column
    private String password;

    @NotNull(
            message = "Address cannot be empty",
            groups = {Existing.class, New.class}
    )
    @Size(min = 1, message = "At least one character is required in address")
    @Column
    private String address;


    @NotNull(
            message = "Mobile number cannot be empty",
            groups = {Existing.class, New.class}
    )
    @Size(min = 1, max = 10, message = "Mobile number should be between 1 to 10 characters of length")
    @Column
    private String mobile;

    @NotNull(
            message = "Gender should be specified",
            groups = {Existing.class, New.class}
    )
    @Column
    private Gender gender;

    @NotNull(
            message = "Date of birth should be specified",
            groups = {Existing.class, New.class}
    )
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column
    private Date dob;

    public interface Existing {
    }

    public interface New {
    }

    public void encryptPassword() {
        byte[] encodedPassword = Base64.getEncoder().encode(password.getBytes());
        setPassword(encodedPassword.toString());
    }
}
