package fit.se.week7.backend.dto;

import lombok.Data;

import java.util.List;

@Data
public class CheckoutForm {
    private List<CheckoutDto> products;

    // Thêm các phương thức getter và setter nếu cần
}
