package orb.com.backend.modules.customer.models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import orb.com.backend.modules.cup.models.entity.CupEntity;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "tb_orb_customer")
public class CustomerEntity {

    @Id
    @Comment("Primary key of the customer - UUID")
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "cod_customer_cus", nullable = false, updatable = false)
    private UUID id;

    @CreationTimestamp
    @Comment("Creation date and time of the customer")
    @Column(name = "ldt_creation_cus", nullable = false, updatable = false)
    private LocalDateTime creationDateTime;

    @Comment("Name of the customer")
    @Column(name = "str_name_cus", length = 60, nullable = false)
    private String name;

    @Comment("Email of the customer")
    @Column(name = "str_email_cus", length = 60, unique = true)
    private String email;

    @Comment("Password of the customer")
    @Column(name = "str_password_cus", nullable = false)
    private String password;

    @JoinTable(
            name = "tb_orb_customer_cups",
            joinColumns = @JoinColumn(name = "cod_customer_cus"),
            inverseJoinColumns = @JoinColumn(name = "cod_cup_cup")
    )
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CupEntity> cups = new ArrayList<>();

    public CustomerEntity(String name, String email, String encodedPassword) {
        this.name = name;
        this.email = email;
        this.password = encodedPassword;
    }
}