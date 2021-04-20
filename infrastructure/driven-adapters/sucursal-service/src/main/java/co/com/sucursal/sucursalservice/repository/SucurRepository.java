package co.com.sucursal.sucursalservice.repository;


import co.com.sucursal.sucursalservice.entity.SucursalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface SucurRepository extends JpaRepository<SucursalEntity, Integer> {

    SucursalEntity getSucursalEntityByLatitudAndLongitud(String latitude, String longitud);

    @Transactional
    @Modifying
    @Query(value = "insert into sucursal_entity (id, direccion, horario_atencion, latitud, longitud)" +
            " values(:id, :direccion, :horario_atencion, :latitud, :longitud)", nativeQuery = true)
    void addSucursalData(
            @Param("id") int id,
            @Param("direccion") String direccion,
            @Param("horario_atencion") String horario_atencion,
            @Param("latitud") String latitud,
            @Param("longitud") String longitud
    );

//    @Transactional
//    @Modifying
//    @Query(value = "delete from sucursal_entity where (:id)", nativeQuery = true)
//    void deleteSucursal(@Param("id") int id);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM sucursal_entity WHERE id = ?1", nativeQuery = true)
    void deleteSucursal(int id);


    @Modifying
    @Query("delete from SucursalEntity u where u.id = ?1")
    void deleteUsersById(int id);

}

	

