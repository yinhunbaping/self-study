## 1. 基础结构搭建

- [x] 1.1 创建 `src/main/java/org/example/factory/flyweight/` 包目录
- [x] 1.2 创建 `MissionContext` 类，定义外部状态字段（location, target, equipment）

## 2. 享元核心实现

- [x] 2.1 创建 `Agent` 接口，定义 `executeMission(MissionContext)` 方法
- [x] 2.2 创建 `ConcreteAgent` 类，实现 `Agent` 接口，封装内部状态（codeName, appearance, skill）
- [x] 2.3 创建 `AgentFactory` 类，使用 `HashMap` 管理享元池，按 codeName 复用特工对象

## 3. 客户端与入口

- [x] 3.1 创建 `MissionControl` 类，支持批量派发任务，输出任务执行日志
- [x] 3.2 创建 `Main.java` 入口类，执行 100 个任务演示，输出内存复用总结

## 4. 验证

- [x] 4.1 运行 `Main.java`，确认控制台输出包含任务日志和内存总结
- [x] 4.2 确认实际创建的 `ConcreteAgent` 实例数为 3，与任务总数 100 形成对比
