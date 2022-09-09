package lukitoandriansyah.com.handlingmusicstore.model.entity;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "t_subproducts")
public class SubProductsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sub_product_generator")
    @SequenceGenerator(name = "sub_product_generator", sequenceName = "seq_sub_product", initialValue = 1, allocationSize = 1)
    @Column(name = "sub_product_id")
    private Integer subProductId;

    @Column(name = "product_code")
    private Integer productId;

    @OneToOne
    @JoinColumn(name = "product_code", insertable = false, updatable = false)
    private ProductsEntity productsEntity;

    @Column(name = "sub_product_brand")
    private String subProductBrand;

    @Column(name = "sub_product_series")
    private String subProductSeries;

    @Column(name = "sub_product_year")
    private LocalDate subProductYear;

    public Integer getSubProductId() {
        return subProductId;
    }

    public void setSubProductId(Integer subProductId) {
        this.subProductId = subProductId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public ProductsEntity getProductsEntity() {
        return productsEntity;
    }

    public void setProductsEntity(ProductsEntity productsEntity) {
        this.productsEntity = productsEntity;
    }

    public String getSubProductBrand() {
        return subProductBrand;
    }

    public void setSubProductBrand(String subProductBrand) {
        this.subProductBrand = subProductBrand;
    }

    public String getSubProductSeries() {
        return subProductSeries;
    }

    public void setSubProductSeries(String subProductSeries) {
        this.subProductSeries = subProductSeries;
    }

    public LocalDate getSubProductYear() {
        return subProductYear;
    }

    public void setSubProductYear(LocalDate subProductYear) {
        this.subProductYear = subProductYear;
    }
}
