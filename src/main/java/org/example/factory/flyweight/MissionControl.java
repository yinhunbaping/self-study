package org.example.factory.flyweight;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * 任务控制中心 - 客户端
 * 批量派发任务并展示内存复用效果
 */
public class MissionControl {
    private final AgentFactory agentFactory = new AgentFactory();
    private final Random random = new Random();

    private final List<String> agentNames = Arrays.asList("夜莺", "猎豹", "幽灵");
    private final List<String> locations = Arrays.asList("东京", "首尔", "华盛顿", "伦敦", "莫斯科");
    private final List<String> targets = Arrays.asList("获取首相行程", "监听军事会议", "窃取核武密码", "破坏通讯基站", "暗杀高级将领");
    private final List<String> equipments = Arrays.asList("窃听器", "微型相机", "激光切割器", "神经毒剂", "便携式干扰器");

    public void dispatchMissions(int missionCount) {
        System.out.println("情报总部启动「千面行动」");
        System.out.println("==================================");

        for (int i = 1; i <= missionCount; i++) {
            String agentName = agentNames.get(random.nextInt(agentNames.size()));
            String location = locations.get(random.nextInt(locations.size()));
            String target = targets.get(random.nextInt(targets.size()));
            String equipment = equipments.get(random.nextInt(equipments.size()));

            MissionContext context = new MissionContext(location, target, equipment);
            Agent agent = agentFactory.getAgent(agentName);

            // 仅打印前 5 条和最后 1 条，避免刷屏
            if (i <= 5 || i == missionCount) {
                System.out.print(String.format("[任务 #%03d] ", i));
                agent.executeMission(context);
            } else if (i == 6) {
                System.out.println("... (中间任务日志省略) ...");
            }
        }

        System.out.println("==================================");
        System.out.println("行动总结：");
        System.out.println("总任务数：" + missionCount);
        System.out.println("实际创建特工对象数：" + agentFactory.getAgentCount());
        System.out.println("内存节约：" + (missionCount - agentFactory.getAgentCount()) + " 个对象");
    }
}
