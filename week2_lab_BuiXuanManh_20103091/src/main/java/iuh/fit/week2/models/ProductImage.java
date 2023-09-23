package iuh.fit.week2.models;

import jakarta.persistence.*;

@Entity
@Table(name = "product_image")
@NamedQueries(
        @NamedQuery(name = "ProductImage.findAll",query = "SELECT e FROM ProductImage e")
)
public class ProductImage {
    @Id
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @Id
    @Column(name = "image_id")
    private String imageId;
    private String path;
    private String alternative;

    public ProductImage(Product product, String imageId, String path, String alternative) {
        this.product = product;
        this.imageId = imageId;
        this.path = path;
        this.alternative = alternative;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getAlternative() {
        return alternative;
    }

    public void setAlternative(String alternative) {
        this.alternative = alternative;
    }

    public ProductImage() {
    }
}
