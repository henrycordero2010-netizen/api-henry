package api.rest.common.enums;

public enum DebtType {
    MORA("M"),
    PREVENTIVA("P"),
    TARDIA("T"),
    OTRO("O"),
    TODOS("X");

    private String type;

    private DebtType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
