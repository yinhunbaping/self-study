# 规格说明：添加策略四

## 新增需求

### 需求: 支持第四种类型的策略

系统**必须**支持第四种类型的策略，该策略遵循与现有三种策略相同的接口和工厂注入机制。

#### 场景: 通过 StrategyContext 执行策略四

- **当** 调用方创建 `StrategyContext` 并传入 `StrategyFour` 实例
- **那么** `StrategyContext` **必须**能成功执行该策略的 `operate()` 方法
- **并且** 控制台**必须**输出策略四特有的执行信息

#### 场景: 通过 StrategyFactory 获取策略四

- **当** 调用方通过 `StrategyFactory.getStrategy(StrategyEnum.PLAN_D)` 获取策略
- **那么** 工厂**必须**返回 `StrategyFour` 的实例
- **并且** 调用其 `exec()` 方法**必须**输出策略四的执行信息

#### 场景: 枚举包含策略四

- **当** 查看 `StrategyEnum` 枚举定义
- **那么** **必须**包含 `PLAN_D(4, "妙计四")` 枚举值
- **并且** 其 `id` **必须**为 4，`desc` **必须**为 "妙计四"
