package org.example.factory.strategy;


public enum StrategyEnum {
    PLAN_A(1, "妙计一"),
    PLAN_B(2, "妙计二"),
    PLAN_C(3, "妙计三"),
    PLAN_D(4, "妙计四")
    ;

    private final Integer id;
    private final String desc;

    StrategyEnum(Integer id, String desc) {
        this.id = id;
        this.desc = desc;
    }

    public Integer getId() {
        return id;
    }

    public String getDesc() {
        return desc;
    }
}
