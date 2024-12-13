/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package hn.bancatlan.cierrecajaempresarial.repository;

import hn.bancatlan.cierrecajaempresarial.entity.CAESER;
import hn.bancatlan.cierrecajaempresarial.entity.indexes.ICAESER1;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface CAESERRepo extends JpaRepository<CAESER, ICAESER1>{
    @Query(value = "SELECT * FROM CAEDTA.CAESER c ORDER BY c.EMPNUM ASC", nativeQuery = true)
    public ArrayList<CAESER> getServicios();

    @Query(
        value = "SELECT ser.EMPNUM, ser.SERNUM, ser.SERDES, emp.EMPDES, emp.EMPEST, ser.SEREST, ser.SERCFR " +
            "FROM CAEDTA.caeser ser " +
            "INNER JOIN CAEDTA.CAEEMP emp ON emp.EMPNUM = ser.EMPNUM " +
            "INNER JOIN ( " +
            "    SELECT DISTINCT EMPNUM, SERNUM " +
            "    FROM CAEDTA.caetrd " +
            "    WHERE TRDREF = :fechaCierre " +
            ") diario ON diario.EMPNUM = ser.EMPNUM AND diario.SERNUM = ser.SERNUM",
        nativeQuery = true)
    List<Object[]> getServiciosEmpresas(@Param("fechaCierre") String fechaCierre);

    Optional<CAESER> findByEMPNUMAndSERNUM(BigDecimal EMPNUM, BigDecimal SERNUM);

    String findTICCODByEMPNUMAndSERNUM(BigDecimal EMPNUM, BigDecimal SERNUM);
}
