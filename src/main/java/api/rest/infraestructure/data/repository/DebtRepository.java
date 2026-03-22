package api.rest.infraestructure.data.repository;

import api.rest.infraestructure.data.entity.DebtEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface DebtRepository extends JpaRepository<DebtEntity, Long> {
    @Transactional(readOnly = true)
    List<DebtEntity> findAllByCustomerId(String customerId);
    @Transactional(readOnly = true)
    List<DebtEntity> findAllByCustomerIdAndGestionType(String customerId,String gestionType);

    @Transactional(readOnly = true)
    Optional<DebtEntity> findByBranchAndContractId(String branch, String contractId);
}
