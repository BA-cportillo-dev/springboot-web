/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package hn.bancatlan.cierrecajaempresarial.repository;

import hn.bancatlan.cierrecajaempresarial.entity.CAETRD;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface CAETRDRepo extends JpaRepository<CAETRD, BigDecimal>{
    @Query("SELECT MAX(c.TRDNUM) FROM CAETRD c")
    public Optional<BigDecimal> getUltimaTransaccion();
    
    @Query("SELECT SUM(c.TRDRET) FROM CAETRD c WHERE c.TRDREM = :moneda "
            + "AND c.TRDREF = :fecha AND c.TRDNUM <= :ultimo")
    public BigDecimal getSumaMoneda(@Param("moneda") String moneda,
                                    @Param("fecha") String fecha,
                                    @Param("ultimo") BigDecimal ultimo);
    
    @Query("SELECT SUM(c.TRDRET) FROM CAETRD c WHERE c.EMPNUM = :numEmpresa AND c.SERNUM = :numServicio"
            + " AND c.TRDREM = :moneda AND c.TRDREF = :fecha AND c.TRDNUM <= :ultimo")
    public BigDecimal getSumaServicio1(@Param("numEmpresa") BigDecimal numEmpresa,
                                    @Param("numServicio") BigDecimal numServicio,
                                    @Param("moneda") String moneda,
                                    @Param("fecha") String fecha,
                                    @Param("ultimo") BigDecimal ultimo);
    
    @Query("SELECT COUNT(c) FROM CAETRD c WHERE c.EMPNUM = :numEmpresa AND c.SERNUM = :numServicio"
            + " AND c.TRDREM = :moneda AND c.TRDREF = :fecha AND c.TRDNUM <= :ultimo")
    public BigDecimal getCantidadEmpresaServicio(@Param("numEmpresa") BigDecimal numEmpresa,
                                    @Param("numServicio") BigDecimal numServicio,
                                    @Param("moneda") String moneda,
                                    @Param("fecha") String fecha,
                                    @Param("ultimo") BigDecimal ultimo);
    
    @Query("SELECT SUM(c.TRDRET) FROM CAETRD c WHERE c.EMPNUM = :numEmpresa AND c.SERNUM = :numServicio"
            + " AND c.TRDREM = :moneda AND c.TRDREF = :fecha AND c.TRDCAJ = :canal AND c.TRDNUM <= :ultimo")
    public BigDecimal getSumaServicio2(@Param("numEmpresa") BigDecimal numEmpresa,
                                    @Param("numServicio") BigDecimal numServicio,
                                    @Param("moneda") String moneda,
                                    @Param("fecha") String fecha,
                                    @Param("canal") String canal,
                                    @Param("ultimo") BigDecimal ultimo);
    
    @Query("SELECT c.TRDNUM FROM CAETRD c WHERE c.EMPNUM = :numEmpresa AND c.SERNUM = :numServicio"
            + " AND c.TRDREM = :moneda AND c.TRDREF = :fecha AND c.TRDNUM <= :ultimo")
    public ArrayList<BigDecimal> getSumaServicio3(@Param("numEmpresa") BigDecimal numEmpresa,
                                    @Param("numServicio") BigDecimal numServicio,
                                    @Param("moneda") String moneda,
                                    @Param("fecha") String fecha,
                                    @Param("ultimo") BigDecimal ultimo);
    
    @Query("SELECT c.TRDNUM FROM CAETRD c WHERE c.EMPNUM = :numEmpresa AND c.SERNUM = :numServicio"
            + " AND c.TRDREM = :moneda AND c.TRDREF = :fecha AND c.TRDNUM <= :ultimo AND c.TRDCAJ = :canal")
    public ArrayList<BigDecimal> getSumaServicio4(@Param("numEmpresa") BigDecimal numEmpresa,
                                    @Param("numServicio") BigDecimal numServicio,
                                    @Param("moneda") String moneda,
                                    @Param("fecha") String fecha,
                                    @Param("ultimo") BigDecimal ultimo,
                                    @Param("canal") String canal);
    
    @Query("SELECT SUM(c.TRDMOC) FROM CAETRD c WHERE c.EMPNUM = :numEmpresa AND c.SERNUM = :numServicio"
            + " AND c.TRDREM = :moneda AND c.TRDREF = :fecha AND c.TRDNUM <= :ultimo")
    public BigDecimal getSumaServicio3Mora(@Param("numEmpresa") BigDecimal numEmpresa,
                                    @Param("numServicio") BigDecimal numServicio,
                                    @Param("moneda") String moneda,
                                    @Param("fecha") String fecha,
                                    @Param("ultimo") BigDecimal ultimo);
    
    @Query("SELECT SUM(c.TRDMOC) FROM CAETRD c WHERE c.EMPNUM = :numEmpresa AND c.SERNUM = :numServicio"
            + " AND c.TRDREM = :moneda AND c.TRDREF = :fecha AND c.TRDNUM <= :ultimo AND c.TRDCAJ = :canal")
    public BigDecimal getSumaServicio4Mora(@Param("numEmpresa") BigDecimal numEmpresa,
                                    @Param("numServicio") BigDecimal numServicio,
                                    @Param("moneda") String moneda,
                                    @Param("fecha") String fecha,
                                    @Param("ultimo") BigDecimal ultimo,
                                    @Param("canal") String canal);
    
    @Query("SELECT c FROM CAETRD c WHERE c.EMPNUM = :numEmpresa AND c.SERNUM = :numServicio"
            + " AND c.TRDREM = :moneda AND c.TRDREF = :fecha AND c.TRDNUM <= :ultimo")
    public ArrayList<CAETRD> getTransaccionesComision(@Param("numEmpresa") BigDecimal numEmpresa,
                                    @Param("numServicio") BigDecimal numServicio,
                                    @Param("moneda") String moneda,
                                    @Param("fecha") String fecha,
                                    @Param("ultimo") BigDecimal ultimo);
    
    @Query("SELECT c FROM CAETRD c WHERE c.EMPNUM = :numEmpresa AND c.SERNUM = :numServicio"
            + " AND c.TRDREM = :moneda AND c.TRDREF = :fecha AND c.AGECOD = :agencia AND c.TRDNUM <= :ultimo")
    public ArrayList<CAETRD> getTransaccionesComisionAgencia(@Param("numEmpresa") BigDecimal numEmpresa,
                                    @Param("numServicio") BigDecimal numServicio,
                                    @Param("moneda") String moneda,
                                    @Param("fecha") String fecha,
                                    @Param("agencia") BigDecimal agencia,
                                    @Param("ultimo") BigDecimal ultimo);
    
    @Query("SELECT c FROM CAETRD c WHERE c.TRDREF = :fecha and c.TRDNUM <= :regMax")
    public List<CAETRD> getDiario(@Param("fecha") String fecha, @Param("regMax") BigDecimal regMax);
}
