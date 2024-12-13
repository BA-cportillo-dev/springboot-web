package hn.bancatlan.cierrecajaempresarial.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hn.bancatlan.cierrecajaempresarial.entity.CAEPAM;
import hn.bancatlan.cierrecajaempresarial.entity.indexes.ICAEPAM1;

@Repository
public interface CAEPAMRepo extends JpaRepository<CAEPAM, ICAEPAM1>{
    public Optional<CAEPAM> findByPARNUMAndMONCOD(BigDecimal PARNUM, String MONCOD);

    public List<CAEPAM> findAllByPARNUM(BigDecimal PARNUM);
}
