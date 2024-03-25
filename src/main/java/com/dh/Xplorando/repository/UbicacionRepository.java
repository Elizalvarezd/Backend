package com.dh.Xplorando.repository;


import com.dh.Xplorando.entity.Categoria;
import com.dh.Xplorando.entity.Ubicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UbicacionRepository extends JpaRepository<Ubicacion,Long>{
    Ubicacion findByCiudad(String ciudad);
}
