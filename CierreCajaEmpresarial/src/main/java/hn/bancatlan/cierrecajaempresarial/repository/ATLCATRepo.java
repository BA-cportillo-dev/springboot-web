package hn.bancatlan.cierrecajaempresarial.repository;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

import org.springframework.stereotype.Repository;

import hn.bancatlan.cierrecajaempresarial.entity.ATLCAT;
import hn.bancatlan.cierrecajaempresarial.entity.indexes.IATLCAT;

@Repository
public interface ATLCATRepo extends JpaRepository<ATLCAT, IATLCAT> {

}
