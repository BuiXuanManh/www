package fit.se.week7;

import com.github.javafaker.Faker;
import fit.se.week7.backend.enums.ProductStatus;
import fit.se.week7.backend.models.Product;
import fit.se.week7.backend.models.ProductImage;
import fit.se.week7.backend.models.ProductPrice;
import fit.se.week7.backend.services.ProductImageService;
import fit.se.week7.backend.services.ProductPriceService;
import fit.se.week7.backend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.Optional;

@SpringBootApplication
public class Week7Application {
//    @Qualifier("productImplement")
//    @Autowired
//    private ProductService service;
//    @Autowired
//    private ProductPriceService productPriceService;
//    @Autowired
//    private ProductImageService productImageService;
//    @Bean
//    CommandLineRunner init() {
//        return args -> {
//            int j=1;
//            for (int i = 0; i < 1000; i++) {
//                Faker faker = new Faker();
//                Product p = new Product();
//                p.setName(faker.commerce().productName());
//                p.setDescription(faker.lorem().sentence());
//                p.setUnit(faker.commerce().material());
//                p.setManufacturer(faker.company().name());
//                p.setStatus(ProductStatus.ACTIVE);
//                service.save(p);
//                Optional<Product> pf = service.findById(i+1);
//                if(pf.isPresent()){
//                    p = pf.get();
//                    ProductImage image = new ProductImage(j + "", (i + 1) + "", p);
//                    if(j==12){
//                        j=0;
//                    }
//                    j=j+1;
//                    productImageService.save(image);
//                    LocalDateTime currentTime = LocalDateTime.now().plusHours(i);
//                    ProductPrice price = new ProductPrice();
//                    price.setProduct(p);
//                    price.setPriceDatetime(currentTime);
//                    price.setPrice(Double.parseDouble(faker.commerce().price()));
//                    price.setNote("Note no " + (i + 1));
//                    productPriceService.save(price);
//                }
//            }
//        }
//                ;
//    }
    public static void main(String[] args) {
        SpringApplication.run(Week7Application.class, args);
    }

}
