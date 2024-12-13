package hn.bancatlan.cierrecajaempresarial.repository;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hn.bancatlan.cierrecajaempresarial.entity.CAECCC;
import hn.bancatlan.cierrecajaempresarial.entity.indexes.ICAECCC1;

@Repository
public interface CAECCCRepo extends JpaRepository<CAECCC, ICAECCC1>{
    Optional<CAECCC> findByCIENUMAndCMOCOD(BigDecimal CIENUM, String CMOCOD);
}
