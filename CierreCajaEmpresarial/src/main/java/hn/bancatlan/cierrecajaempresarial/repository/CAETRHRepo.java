package hn.bancatlan.cierrecajaempresarial.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import hn.bancatlan.cierrecajaempresarial.entity.CAETRH;
import hn.bancatlan.cierrecajaempresarial.entity.indexes.ICAETRH;

@Repository
public interface CAETRHRepo extends JpaRepository<CAETRH, ICAETRH>{
    List<BigDecimal> findTRHNUMByTRHREF(String fecha);

    @Query("SELECT h FROM CAETRH h " +
           "INNER JOIN CAETRD d ON h.TRHNUM = d.TRDNUM " +
           "WHERE h.TRHREF = :fechaCierre AND d.TRDREF = :fechaCierre")
    List<CAETRH> findRegistrosEnHistoricoPorFecha(@Param("fechaCierre") String fechaCierre);

    @Query("SELECT COUNT(trh) FROM CAETRH trh WHERE trh.TRHREF = :fechaCierre AND trh.TRHNUM IN :numerosDiarios")
    long existeRegistroEnHistorico(@Param("fechaCierre") String fechaCierre, @Param("numerosDiarios") List<BigDecimal> numerosDiarios);

}
