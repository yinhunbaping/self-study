# 提案：为策略模式添加新的策略类型

## 为什么

当前策略模式仅实现了3种策略（PLAN_A、PLAN_B、PLAN_C）。为了演示策略模式的可扩展性，需要添加第4种策略类型，使其能够更好地展示工厂自动注入新策略的能力。

## 变更内容

- 在 `StrategyEnum` 中添加 `PLAN_D(4, "妙计四")` 枚举值
- 新建 `StrategyFour` 类实现 `AbstractStrategy` 接口
- 在 `Main.java` 的测试方法中添加对新策略的调用

## 能力

### 新能力
- `StrategyFour`: 执行第4种策略逻辑

## 影响

- `src/main/java/org/example/factory/strategy/StrategyEnum.java`: 新增枚举值
- `src/main/java/org/example/factory/strategy/StrategyFour.java`: 新建策略实现类
- `src/main/java/org/example/factory/strategy/Main.java`: 新增测试调用
