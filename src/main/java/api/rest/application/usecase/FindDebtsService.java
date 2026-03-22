package api.rest.application.usecase;

import api.rest.dto.DebtResponse;
import api.rest.common.enums.Type;
import api.rest.dto.DebtResponseDetail;
import api.rest.infraestructure.data.entity.DebtEntity;
import api.rest.infraestructure.data.repository.DebtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindDebtsService {

    @Autowired
    private DebtRepository debtRepository;

    List<DebtEntity> response;

    public DebtResponse findDebtByCustomerIdAndGestionType(String customerId, Type debtType) {

        if (debtType == null) {
            response = debtRepository.findAllByCustomerId(customerId);
        } else {
            response = debtRepository.findAllByCustomerIdAndGestionType(customerId, debtType.getType());
        }
        var debtResponse = new DebtResponse();

        var productList = response.stream().map(q -> {

            var detail = new DebtResponseDetail();

            detail.setContractId(q.getContractId());
            detail.setBranch(q.getBranch());
            detail.setDebtAmount(q.getDebtAmount());

            return detail;

        }).toList();

        debtResponse.setResult(productList);

        return debtResponse;
    }
}
