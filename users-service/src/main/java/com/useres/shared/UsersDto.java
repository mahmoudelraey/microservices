package com.useres.shared;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data // = ( @ToString + @EqualsAndHashCode + @Getter + @Setter +  @RequiredArgsConstructor)
public class UsersDto {
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String encryptedPassword;
    private String userId;


}
