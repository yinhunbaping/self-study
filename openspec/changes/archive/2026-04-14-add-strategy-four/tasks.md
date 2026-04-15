# 任务：添加策略四

## 1. 枚举扩展

- [x] 1.1 在 `StrategyEnum` 中添加 `PLAN_D(4, "妙计四")` 枚举值

## 2. 策略实现

- [x] 2.1 创建 `StrategyFour` 类实现 `AbstractStrategy` 接口
- [x] 2.2 实现 `exec()` 方法，输出策略四的执行信息
- [x] 2.3 实现 `strategyType()` 方法，返回 `StrategyEnum.PLAN_D`
- [x] 2.4 为 `StrategyFour` 添加必要的 Spring 组件注解（如果需要）

## 3. 测试入口更新

- [x] 3.1 在 `Main.java` 的手动调用部分添加 `StrategyFour` 的上下文调用
- [x] 3.2 在 `Main.java` 的工厂调用部分添加 `PLAN_D` 的获取和调用

## 4. 验证

- [x] 4.1 确认所有修改编译通过
- [x] 4.2 确认代码风格与现有策略保持一致
