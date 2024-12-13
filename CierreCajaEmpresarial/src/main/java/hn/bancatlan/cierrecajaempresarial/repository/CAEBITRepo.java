package hn.bancatlan.cierrecajaempresarial.repository;

import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import hn.bancatlan.cierrecajaempresarial.entity.CAEBIT;
import hn.bancatlan.cierrecajaempresarial.entity.indexes.ICAEBIT;

@Repository
public interface CAEBITRepo extends JpaRepository<CAEBIT, ICAEBIT> {
    @Query(value = "SELECT MAX(c.BITNUM) FROM CAEDTA.CAEBIT c", 
            nativeQuery = true)
    public BigDecimal getUltimoRegistro();
}
