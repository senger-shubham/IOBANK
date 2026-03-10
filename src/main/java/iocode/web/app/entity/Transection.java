package iocode.web.app.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.PrimitiveIterator;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long txId;
     private Double amount;
     private Double txFee;
      private String owner;
       private String sender;
        private String receiver;

        @UpdateTimestamp
         private LocalDateTime updatedAt;
        @CreationTimestamp
         private LocalDateTime createdAt;
         private Status status;
         private Type type;

         @ManyToOne
         @JoinColumn(name = "card_id")
         private Card card;

        @ManyToOne
       @JoinColumn(name = "account_id")
       private Account account;

}
