import java.util.HashMap;

public class Solution {
    static class UndergroundSystem {
        private String[] checkInInfo;
        private HashMap<Integer, String[]> checkInMap;
        private HashMap<String, Integer[]> timeMap;

        public UndergroundSystem() {
            checkInInfo = new String[2];
            checkInMap = new HashMap<>();
            timeMap = new HashMap<>();
        }

        public void checkIn(int id, String stationName, int t) {
            checkInInfo = new String[]{stationName, String.valueOf(t)};
            checkInMap.put(id, checkInInfo);
        }

        public void checkOut(int id, String stationName, int t) {
            String[] checkIn = checkInMap.get(id);
            int time = t - Integer.parseInt(checkIn[1]);
            String startStation = checkIn[0];
            String staion = startStation + stationName;
            Integer[] timeArray = timeMap.getOrDefault(staion, new Integer[]{0, 0});
            int times = timeArray[0] + 1;
            int increaseTime = timeArray[1] + time;
            timeMap.put(staion, new Integer[]{times, increaseTime});
        }

        public double getAverageTime(String startStation, String endStation) {
            String queryStation = startStation + endStation;
            Integer[] timeArray = timeMap.get(queryStation);
            return timeArray[1] * 1.0 / timeArray[0];
        }
    }

    public static void main(String[] args) {
        UndergroundSystem undergroundSystem = new UndergroundSystem();
        undergroundSystem.checkIn(45, "Leyton", 3);
        undergroundSystem.checkIn(32, "Paradise", 8);
        undergroundSystem.checkIn(27, "Leyton", 10);
        undergroundSystem.checkOut(45, "Waterloo", 15);
        undergroundSystem.checkOut(27, "Waterloo", 20);
        undergroundSystem.checkOut(32, "Cambridge", 22);
        System.out.println(undergroundSystem.getAverageTime("Paradise", "Cambridge"));
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));         // 返回 11.0。总共有 2 躺从 "Leyton" 到 "Waterloo" 的行程，编号为 id=45 的乘客出发于 time=3 到达于 time=15，编号为 id=27 的乘客出发于 time=10 到达于 time=20。所以平均时间为 ( (15-3) + (20-10) ) / 2 = 11.0
        undergroundSystem.checkIn(10, "Leyton", 24);
        undergroundSystem.getAverageTime("Leyton", "Waterloo");          // 返回 11.0
        undergroundSystem.checkOut(10, "Waterloo", 38);
        undergroundSystem.getAverageTime("Leyton", "Waterloo");          // 返回 12.0
    }
}
