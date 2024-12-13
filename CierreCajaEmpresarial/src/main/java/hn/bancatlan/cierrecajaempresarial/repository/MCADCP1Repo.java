/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package hn.bancatlan.cierrecajaempresarial.repository;

import hn.bancatlan.cierrecajaempresarial.entity.indexes.IMCADCPA;
import hn.bancatlan.cierrecajaempresarial.entity.MCADCP1;
import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface MCADCP1Repo extends JpaRepository<MCADCP1, IMCADCPA> {

    @Query("SELECT c FROM MCADCP1 c WHERE c.DCPPLA = :planilla")
    public MCADCP1 getRegistro(@Param("planilla") String planilla);
}
