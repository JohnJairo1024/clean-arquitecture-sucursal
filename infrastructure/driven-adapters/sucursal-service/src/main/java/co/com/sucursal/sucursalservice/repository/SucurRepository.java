package co.com.sucursal.sucursalservice.repository;


import co.com.sucursal.sucursalservice.entity.SucursalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SucurRepository extends JpaRepository<SucursalEntity, Integer> {

}

	

