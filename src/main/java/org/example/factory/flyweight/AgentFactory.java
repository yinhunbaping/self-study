package org.example.factory.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * 特工工厂 - 享元工厂
 * 负责创建和管理享元对象池
 */
public class AgentFactory {
    private final Map<String, Agent> agentPool = new HashMap<>();

    public Agent getAgent(String codeName) {
        Agent agent = agentPool.get(codeName);
        if (agent == null) {
            switch (codeName) {
                case "夜莺":
                    agent = new ConcreteAgent("夜莺", "金发碧眼", "伪装渗透");
                    break;
                case "猎豹":
                    agent = new ConcreteAgent("猎豹", "寸头黑肤", "极速追踪");
                    break;
                case "幽灵":
                    agent = new ConcreteAgent("幽灵", "隐形无踪", "黑客入侵");
                    break;
                default:
                    throw new IllegalArgumentException("未知特工代号: " + codeName);
            }
            agentPool.put(codeName, agent);
        }
        return agent;
    }

    public int getAgentCount() {
        return agentPool.size();
    }
}
