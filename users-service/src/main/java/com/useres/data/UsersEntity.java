package com.useres.data;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data // = ( @ToString + @EqualsAndHashCode + @Getter + @Setter +  @RequiredArgsConstructor)
public class UsersEntity {

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false,length = 60)
    private String firstname;
    @Column(nullable = false,length = 60)
    private String lastname;
    @Column(nullable = false,length = 120,unique = true)
    private String email;
    @Column(nullable = false,unique = true)
    private String encryptedPassword;
    @Column(nullable = false,unique = true)
    private String userId;
}
