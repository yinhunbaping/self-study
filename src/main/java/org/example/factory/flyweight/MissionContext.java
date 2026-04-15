package org.example.factory.flyweight;

import lombok.Getter;

/**
 * 任务上下文 - 外部状态
 * 每次执行任务时由客户端传入
 */
@Getter
public class MissionContext {
    private final String location;
    private final String target;
    private final String equipment;

    public MissionContext(String location, String target, String equipment) {
        this.location = location;
        this.target = target;
        this.equipment = equipment;
    }

}
