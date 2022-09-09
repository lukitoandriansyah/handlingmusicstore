package lukitoandriansyah.com.handlingmusicstore.controller.subProducts;

import lukitoandriansyah.com.handlingmusicstore.controller.subProducts.ConvertSubProducts;
import lukitoandriansyah.com.handlingmusicstore.model.dto.DefaultResponse;
import lukitoandriansyah.com.handlingmusicstore.model.dto.ProductsDto;
import lukitoandriansyah.com.handlingmusicstore.model.dto.SubProductsDto;
import lukitoandriansyah.com.handlingmusicstore.model.entity.ProductsEntity;
import lukitoandriansyah.com.handlingmusicstore.model.entity.SubProductsEntity;
import lukitoandriansyah.com.handlingmusicstore.repository.ProductsRepository;
import lukitoandriansyah.com.handlingmusicstore.repository.SubProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/subproducts")
public class SubProducts {

    ConvertSubProducts convert = new ConvertSubProducts();

    @Autowired
    private SubProductsRepository subProductsRepository;

    @GetMapping("/list")
    public ArrayList<SubProductsDto> viewListSubProduct(){
        ArrayList<SubProductsDto> list = new ArrayList<>();
        for (SubProductsEntity i : subProductsRepository.findAll()){
            list.add(convert.convertEntityToDto(i));
        }
        return list;
    }


    @PostMapping("/savesubproduct")
    public DefaultResponse<SubProductsDto> saveSubProduct(@RequestBody SubProductsDto subProductsDto){
        SubProductsEntity subProducts =convert.convertDtoToEntity(subProductsDto);
        DefaultResponse<SubProductsDto> dr= new DefaultResponse<>();
        Optional<SubProductsEntity> optionalSubProducts = subProductsRepository.findById(subProductsDto.getProductId());
        if(optionalSubProducts.isPresent()){
            dr.setStatus(Boolean.FALSE);
            dr.setPesan("Product gagal disimpan");
        } else{
            subProductsRepository.save(subProducts);
            dr.setStatus(Boolean.TRUE);
            dr.setData(subProductsDto);
            dr.setPesan("Product Berhasil disimpan");
        }
        return dr;
    }

    @DeleteMapping("/delete/{subProductId}")
    public DefaultResponse deleteSubProduct(@PathVariable Integer subProductId ){
        DefaultResponse<SubProductsDto> dr= new DefaultResponse<>();
        Optional<SubProductsEntity> optionalSubProducts = subProductsRepository.findById(subProductId);
        if(!(optionalSubProducts.isPresent())){
            dr.setStatus(Boolean.FALSE);
            dr.setPesan("Product gagal dihapus");
        } else{
            subProductsRepository.delete(optionalSubProducts.get());
            dr.setStatus(Boolean.TRUE);
            dr.setPesan("Product Berhasil dihapus");
        }
        return dr;
    }

    @PutMapping("/update/{subProductId}")
    public DefaultResponse updateSubProduct(@PathVariable Integer subProductId, SubProductsDto subProductsDto ){
        DefaultResponse dr = new DefaultResponse();
        Optional<SubProductsEntity> optionalSubProducts = subProductsRepository.findById(subProductId);
        SubProductsEntity subProducts = optionalSubProducts.get();
        if(optionalSubProducts.isPresent()){
            subProducts.setSubProductBrand(subProductsDto.getSubProductBrand());
            subProducts.setSubProductSeries(subProductsDto.getSubProductSeries());
            subProducts.setSubProductYear(subProductsDto.getSubProductYear());

            dr.setStatus(Boolean.TRUE);
            dr.setPesan("Data berhasil diperbaharui");
            dr.setData(subProductsDto);
        }else{
            dr.setStatus(Boolean.FALSE);
            dr.setPesan("Id tidak ditemukan");
        }

        return dr;
    }

}
