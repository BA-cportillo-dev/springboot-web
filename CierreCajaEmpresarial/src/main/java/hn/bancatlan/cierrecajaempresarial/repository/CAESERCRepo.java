/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package hn.bancatlan.cierrecajaempresarial.repository;

import hn.bancatlan.cierrecajaempresarial.entity.CAESERC;
import hn.bancatlan.cierrecajaempresarial.entity.indexes.ICAESEC1;
import java.math.BigDecimal;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface CAESERCRepo extends JpaRepository<CAESERC, ICAESEC1>{
    @Query(value = "SELECT c FROM CAESERC c WHERE c.EMPNUM = :empresa AND c.SERNUM = :servicio")
    public ArrayList<CAESERC> getServicios(@Param("empresa") BigDecimal empresa, 
                                           @Param("servicio") BigDecimal servicio);
}
