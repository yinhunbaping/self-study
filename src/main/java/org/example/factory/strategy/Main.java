package org.example.factory.strategy;

import javax.annotation.Resource;

public class Main {
    @Resource
    private StrategyFactory strategyFactory;
    public static void main(String[] args) {
        // 执行策略一
        StrategyContext strategyOne = new StrategyContext(new StrategyOne());
        strategyOne.operate();

        // 执行策略二
        StrategyContext strategyTwo = new StrategyContext(new StrategyTwo());
        strategyTwo.operate();

        // 执行策略三
        StrategyContext strategyThree = new StrategyContext(new StrategyThree());
        strategyThree.operate();

        // 执行策略四
        StrategyContext strategyFour = new StrategyContext(new StrategyFour());
        strategyFour.operate();

        System.out.println("====================");

    }

    public void testStrategyFactory() {
        // 获取策略1
        AbstractStrategy strategy1 = strategyFactory.getStrategy(StrategyEnum.PLAN_A);
        strategy1.exec();

        // 获取策略2
        AbstractStrategy strategy2 = strategyFactory.getStrategy(StrategyEnum.PLAN_B);
        strategy2.exec();

        // 获取策略3
        AbstractStrategy strategy3 = strategyFactory.getStrategy(StrategyEnum.PLAN_C);
        strategy3.exec();

        // 获取策略4
        AbstractStrategy strategy4 = strategyFactory.getStrategy(StrategyEnum.PLAN_D);
        strategy4.exec();
    }

}
