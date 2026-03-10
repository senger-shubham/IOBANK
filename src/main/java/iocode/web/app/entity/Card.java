package iocode.web.app.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String cardId;
    @Column(nullable = false,unique = true)
    private long cardNumber;
    private String cardHolder;
    private double balance;
    @CreationTimestamp
    private LocalDate iss;
    @UpdateTimestamp
    private LocalDate updatedAt;
    private LocalDate exp;
    private LocalDate cvv;
    private String pin;
    private String billingAddress;

    @OneToOne
    @JoinColumn(name = "owner_id")
   private User owner;

    @OneToMany(mappedBy = "card" ,cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Transection> transections;

}
