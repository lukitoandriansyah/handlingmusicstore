package lukitoandriansyah.com.handlingmusicstore.repository;

import lukitoandriansyah.com.handlingmusicstore.model.entity.ProductsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface ProductsRepository extends JpaRepository<ProductsEntity, Integer> {
    Optional<ProductsEntity> findById(Integer productId);
}
