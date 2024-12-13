/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package hn.bancatlan.cierrecajaempresarial.repository;

import hn.bancatlan.cierrecajaempresarial.entity.CAESCO;
import hn.bancatlan.cierrecajaempresarial.entity.indexes.ICAESCO;
import java.math.BigDecimal;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface CAESCORepo extends JpaRepository<CAESCO, ICAESCO> {
    @Query("SELECT c FROM CAESCO c WHERE c.EMPNUM = :numEmpresa AND c.SERNUM = :numServicio")
    public ArrayList<CAESCO> getConceptos(@Param("numEmpresa") BigDecimal numEmpresa,
                                          @Param("numServicio") BigDecimal numServicio);
}
