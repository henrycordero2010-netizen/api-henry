package api.rest.common.enums;

public enum Type {
    MIENTRAS("M"),
    PORQUE("P"),
    TODAVIA("T"),
    OTROS("O"),
    TODOS("X");

    private String type;

    private Type(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
