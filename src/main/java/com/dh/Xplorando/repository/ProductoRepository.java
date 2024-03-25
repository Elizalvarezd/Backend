package com.dh.Xplorando.repository;

import com.dh.Xplorando.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    Optional<List<Producto>> findAllByUbicacionId(Long id);

}
