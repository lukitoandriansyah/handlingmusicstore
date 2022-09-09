package lukitoandriansyah.com.handlingmusicstore.controller.products;

import lukitoandriansyah.com.handlingmusicstore.model.dto.ProductsDto;
import lukitoandriansyah.com.handlingmusicstore.model.entity.ProductsEntity;

public class ConvertProduct {

    public ProductsDto convertEntityToDto(ProductsEntity entity){
        ProductsDto productsDto = new ProductsDto();
        productsDto.setProductId(entity.getProductId());
        productsDto.setProductName(entity.getProductName());
        productsDto.setProductCategory(entity.getProductCategory());
        return productsDto;

    }


    //Buat data yang ingin dikirim
    public ProductsEntity convertDtoToEntity(ProductsDto productsDto){
        ProductsEntity productsEntity = new ProductsEntity();
        productsEntity.setProductId(productsDto.getProductId());
        productsEntity.setProductName(productsDto.getProductName());
        productsEntity.setProductCategory(productsDto.getProductCategory());
        return productsEntity;
    }
}
