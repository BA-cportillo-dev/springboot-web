package hn.bancatlan.cierrecajaempresarial.repository;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import hn.bancatlan.cierrecajaempresarial.entity.CAETRDF;
import hn.bancatlan.cierrecajaempresarial.entity.indexes.ICAETDF1;

@Repository
public interface CAETRDFRepo extends JpaRepository<CAETRDF, ICAETDF1> {
    @Query("SELECT c FROM CAETRDF c WHERE c.TRDNUM IN :numerosDiarios")
    List<CAETRDF> getDiarioF(@Param("numerosDiarios") List<BigDecimal> numerosDiarios);
}
