package lukitoandriansyah.com.handlingmusicstore.controller.subProducts;

import lukitoandriansyah.com.handlingmusicstore.controller.products.Products;
import lukitoandriansyah.com.handlingmusicstore.model.dto.ProductsDto;
import lukitoandriansyah.com.handlingmusicstore.model.dto.SubProductsDto;
import lukitoandriansyah.com.handlingmusicstore.model.entity.ProductsEntity;
import lukitoandriansyah.com.handlingmusicstore.model.entity.SubProductsEntity;
import lukitoandriansyah.com.handlingmusicstore.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;



public class ConvertSubProducts {

    @Autowired
    private ProductsRepository productsRepository;

    public SubProductsDto convertEntityToDto(SubProductsEntity entity){
        SubProductsDto subProductsDto = new SubProductsDto();
        subProductsDto.setProductId(entity.getProductId());
        subProductsDto.setSubProductBrand(entity.getSubProductBrand());
        subProductsDto.setSubProductSeries(entity.getSubProductSeries());
        subProductsDto.setSubProductYear(entity.getSubProductYear());

        return subProductsDto;
    }


    //Buat data yang ingin dikirim
    public SubProductsEntity convertDtoToEntity(SubProductsDto subProductsDto){
        SubProductsEntity subProductsEntity = new SubProductsEntity();
        Optional<ProductsEntity> productsEntity = productsRepository.findById(subProductsDto.getProductId());
        ProductsEntity products = productsEntity.get();

        subProductsEntity.setProductId(products.getProductId());
        subProductsEntity.setSubProductBrand(subProductsDto.getSubProductBrand());
        subProductsEntity.setSubProductSeries(subProductsDto.getSubProductSeries());
        subProductsEntity.setSubProductYear(subProductsDto.getSubProductYear());

        return subProductsEntity;
    }
}
