package fit.se.week7.backend.dto;

import fit.se.week7.backend.enums.PaymentMethod;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckoutDto {
    private Long id;
    private double price;
    private int quantity;
    private double total;
}
