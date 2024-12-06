package hn.bancatlan.cierrecajaempresarial.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import hn.bancatlan.cierrecajaempresarial.entity.CAEBMN;
import hn.bancatlan.cierrecajaempresarial.entity.indexes.ICAEBMN;

@Repository
public interface CAEBMNRepo extends JpaRepository<CAEBMN, ICAEBMN> {

    @Query("SELECT c FROM CAEBMN c WHERE c.CIENUM = :numCierre AND c.EMPNUM = :numEmpresa "
            + "AND c.SERNUM = :numServicio")
    public ArrayList<CAEBMN> getRegistrosEmpresaCierre(@Param("numCierre") BigDecimal numCierre,
            @Param("numEmpresa") BigDecimal numEmpresa,
            @Param("numServicio") BigDecimal numServicio);
    
    @Query("SELECT c FROM CAEBMN c WHERE c.CIENUM = :numCierre AND c.EMPNUM = :numEmpresa "
            + "AND c.SERNUM = :numServicio AND c.BMNCOR = :correlativo")
    public ArrayList<CAEBMN> getExisteRegistroCierre(@Param("numCierre") BigDecimal numCierre,
            @Param("numEmpresa") BigDecimal numEmpresa,
            @Param("numServicio") BigDecimal numServicio,
            @Param("correlativo") BigDecimal correlativo);
}
