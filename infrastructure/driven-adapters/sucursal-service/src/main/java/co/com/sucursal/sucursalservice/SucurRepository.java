package co.com.sucursal.sucursalservice;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SucurRepository extends JpaRepository<SucursalEntity, Integer> {

}

	

