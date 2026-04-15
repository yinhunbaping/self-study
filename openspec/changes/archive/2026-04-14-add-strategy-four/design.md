# 设计：添加策略四

## 上下文

当前策略模式实现包含：
- `StrategyEnum`: 定义策略类型枚举（PLAN_A ~ PLAN_C）
- `AbstractStrategy`: 策略接口
- `StrategyOne` / `StrategyTwo` / `StrategyThree`: 具体策略实现
- `StrategyFactory`: 通过 Spring 自动注入所有 `AbstractStrategy` 实现
- `StrategyContext`: 策略上下文，通过构造函数注入策略
- `Main`: 包含手动上下文调用和工厂调用的测试入口

## 目标/非目标

**目标：**
- 添加第四种策略类型并遵循现有代码结构
- 保持与现有策略一致的代码风格（命名、输出格式）
- 在 `Main.java` 中补充对新策略的调用

**非目标：**
- 修改现有三种策略的实现
- 修改 `StrategyFactory` 或 `StrategyContext` 的核心逻辑
- 引入新的依赖或框架

## 决策

### 决策1: 策略四的命名和风格

**方法:** 策略类命名为 `StrategyFour`，枚举值为 `PLAN_D(4, "妙计四")`，控制台输出格式参考 `StrategyThree` 的风格，但使用明显区分的文本内容。

**理由:** 保持与 `StrategyOne` / `StrategyTwo` / `StrategyThree` 的命名一致性，同时通过中文描述体现代码库现有的语言风格。

### 决策2: 使用 Spring 的自动注入机制

**方法:** 新建的策略类只需实现 `AbstractStrategy` 接口并添加 `@Component` 注解（如果父类或接口不要求，查看现有策略类是否需要 `@Component`）。

**理由:** `StrategyFactory` 已经使用 `@Resource List<AbstractStrategy>` 自动收集所有策略实现，新策略无需修改工厂代码即可被识别。
