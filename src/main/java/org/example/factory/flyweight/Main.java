package org.example.factory.flyweight;

public class Main {
    public static void main(String[] args) {
        MissionControl missionControl = new MissionControl();
        // 派发 100 个任务，但只复用 3 个特工对象
        missionControl.dispatchMissions(100);
    }
}
