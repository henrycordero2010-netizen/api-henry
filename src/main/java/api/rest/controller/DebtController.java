package api.rest.controller;

import api.rest.dto.DebtResponse;
import api.rest.application.usecase.FindDebtsService;
import api.rest.common.enums.Type;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/debts")
@Validated
@Slf4j
public class DebtController {

    @Autowired
    private FindDebtsService findDebtsService;

    public DebtController(FindDebtsService findDebtsService) { this.findDebtsService = findDebtsService; }

    @GetMapping
    public ResponseEntity<DebtResponse> findByCustomerId(
            @Valid
            @NotNull
            @Pattern(regexp = "^[0-9]{1,8}$")
            String customerId,
            @Valid
            Type debtType){
        return ResponseEntity.status(HttpStatus.OK).body(findDebtsService.findDebtByCustomerIdAndGestionType(customerId,debtType));
    }
}
