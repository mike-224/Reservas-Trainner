package com.gymapp.appReservas.repository;

import com.gymapp.appReservas.entity.Usuario;
import com.gymapp.appReservas.entity.UsuarioSimplificado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    @Query("SELECT c FROM Usuario c")
    List<UsuarioSimplificado> findUsuarioSimplificado();
}
