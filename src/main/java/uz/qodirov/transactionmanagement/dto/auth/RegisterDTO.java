package uz.qodirov.transactionmanagement.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author: Saidjalol Qodirov 2/5/2023 7:16 AM
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDTO {

    @Size(min = 5)
    private String username;
    @Size(min = 3)
    private String password;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastname;
    @NotBlank
    private String phoneNumber;
    @NotNull
    private Long regionId;

}
