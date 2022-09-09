package lukitoandriansyah.com.handlingmusicstore.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lukitoandriansyah.com.handlingmusicstore.model.entity.ProductsEntity;

import java.time.LocalDate;

public class SubProductsDto {
    private Integer subProductId;
    private Integer productId;
    private String subProductBrand;
    private String subProductSeries;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy")
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
