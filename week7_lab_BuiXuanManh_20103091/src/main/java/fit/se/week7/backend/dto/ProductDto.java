package fit.se.week7.backend.dto;

import fit.se.week7.backend.models.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private String name;
    private double price;
    private String pathImage;
}
