package lukitoandriansyah.com.handlingmusicstore.controller.products;


import lukitoandriansyah.com.handlingmusicstore.model.dto.DefaultResponse;
import lukitoandriansyah.com.handlingmusicstore.model.dto.ProductsDto;
import lukitoandriansyah.com.handlingmusicstore.model.entity.ProductsEntity;
import lukitoandriansyah.com.handlingmusicstore.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class Products {

    ConvertProduct convert = new ConvertProduct();
    private final ProductsRepository productsRepository;
    public Products(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    };

    @GetMapping("/list")
    public List<ProductsDto> viewListProduct(){
        List<ProductsDto> list = new ArrayList<>();
        for (ProductsEntity i : productsRepository.findAll()){
            list.add(convert.convertEntityToDto(i));
        }
        return list;
    }


    @PostMapping("/saveproduct")
    public DefaultResponse<ProductsDto> saveProduct(@RequestBody ProductsDto productsDto){
        ProductsEntity products =convert.convertDtoToEntity(productsDto);
        DefaultResponse<ProductsDto> dr= new DefaultResponse<>();
        Optional<ProductsEntity> optionalProducts = productsRepository.findById(productsDto.getProductId());
        if(optionalProducts.isPresent()){
            dr.setStatus(Boolean.FALSE);
            dr.setPesan("Product gagal disimpan");
        }else {
            productsRepository.save(products);
            dr.setStatus(Boolean.TRUE);
            dr.setData(productsDto);
            dr.setPesan("Product Berhasil disimpan");
        }
        return dr;
    }

    @DeleteMapping("/delete/{productId}")
    public DefaultResponse deleteProduct(@PathVariable Integer productId ){
        DefaultResponse<ProductsDto> dr= new DefaultResponse<>();
        Optional<ProductsEntity> optionalProducts = productsRepository.findById(productId);
        if(optionalProducts.isEmpty()){
            dr.setStatus(Boolean.FALSE);
            dr.setPesan("Product gagal dihapus");
        } else{
            productsRepository.delete(optionalProducts.get());
            dr.setStatus(Boolean.TRUE);
            dr.setPesan("Product Berhasil dihapus");
        }
        return dr;
    }

    @PutMapping("/update/{productId}")
    public DefaultResponse updateProduct(@PathVariable Integer productId, @RequestBody ProductsDto productsDto ){
        DefaultResponse dr = new DefaultResponse();
        try{
            Optional<ProductsEntity> optionalProducts = productsRepository.findById(productId);
            ProductsEntity product = optionalProducts.get();
            if(optionalProducts.isPresent()){
                product.setProductId(productId);
                product.setProductName(productsDto.getProductName());
                product.setProductCategory(productsDto.getProductCategory());
                productsRepository.save(product);
                dr.setStatus(Boolean.TRUE);
                dr.setData(productsDto);
                dr.setPesan("Data berhasil diperbaharui");

            }
        }catch (Exception e){
            dr.setStatus(Boolean.FALSE);
            dr.setPesan("Id tidak ditemukan");
        }
        return dr;
    }

}
