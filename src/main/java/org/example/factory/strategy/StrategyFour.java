package org.example.factory.strategy;

public class StrategyFour implements AbstractStrategy{
    @Override
    public void exec() {
        System.out.println("孔明妙计安天下，赔了夫人又折兵");
    }

    @Override
    public StrategyEnum strategyType() {
        return StrategyEnum.PLAN_D;
    }
}
