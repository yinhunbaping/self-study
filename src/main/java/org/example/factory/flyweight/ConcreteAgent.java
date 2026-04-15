package org.example.factory.flyweight;

import lombok.Data;

/**
 * 具体特工 - 具体享元
 * 封装内部状态（代号、外貌、技能）
 */
@Data
public class ConcreteAgent implements Agent {
    private final String codeName;
    private final String appearance;
    private final String skill;

    public ConcreteAgent(String codeName, String appearance, String skill) {
        this.codeName = codeName;
        this.appearance = appearance;
        this.skill = skill;
    }

    @Override
    public void executeMission(MissionContext context) {
        System.out.printf("[特工 %s | %s | 擅长%s] 正在 %s 执行任务：%s，携带装备：%s%n", codeName, appearance, skill, context.getLocation(), context.getTarget(), context.getEquipment());
    }
}
