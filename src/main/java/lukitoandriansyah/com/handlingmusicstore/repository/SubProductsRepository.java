package lukitoandriansyah.com.handlingmusicstore.repository;

import lukitoandriansyah.com.handlingmusicstore.model.entity.SubProductsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface SubProductsRepository extends JpaRepository<SubProductsEntity, Integer> {
}
