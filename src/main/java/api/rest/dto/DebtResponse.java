package api.rest.dto;

import java.util.List;

public class DebtResponse {

    private List<DebtResponseDetail> result;

    public List<DebtResponseDetail> getResult() {
        return result;
    }

    public void setResult(List<DebtResponseDetail> result) {
        this.result = result;
    }
}
