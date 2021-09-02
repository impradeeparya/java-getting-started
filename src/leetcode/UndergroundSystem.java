package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Pradeep Arya
 */
public class UndergroundSystem {

    class Customer {

        private String startStation;
        private int startTime;

        public Customer(String startStation, int startTime) {
            this.startStation = startStation;
            this.startTime = startTime;
        }

        public void setStartStation(String stationName) {
            this.startStation = stationName;
        }

        public void setStartTime(int startTime) {
            this.startTime = startTime;
        }


    }

    private Map<String, List<Integer>> travelTime;
    private Map<Integer, Customer> customerInfo;

    public UndergroundSystem() {
        this.travelTime = new HashMap<>();
        this.customerInfo = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        Customer customer = customerInfo.get(id);
        if (customer == null) {
            customerInfo.put(id, new Customer(stationName, t));
        } else {
            customer.setStartStation(stationName);
            customer.setStartTime(t);
        }

    }

    public void checkOut(int id, String stationName, int t) {
        Customer customer = customerInfo.get(id);
        if (customer != null) {

            String travelTimeKey = customer.startStation + "-" + stationName;

            List<Integer> time = travelTime.get(travelTimeKey);
            if (time == null) {
                time = new ArrayList<>();
            }
            time.add(t - customer.startTime);
            travelTime.put(travelTimeKey, time);
        }
    }

    public double getAverageTime(String startStation, String endStation) {
        return travelTime.getOrDefault(startStation + "-" + endStation, Collections.emptyList()).stream().collect(Collectors.averagingDouble(num -> num));
    }
}


class UndergroundSystemV2 {

    class Customer {

        private String startStation;
        private int startTime;

        public Customer(String startStation, int startTime) {
            this.startStation = startStation;
            this.startTime = startTime;
        }

        public void setStartStation(String stationName) {
            this.startStation = stationName;
        }

        public void setStartTime(int startTime) {
            this.startTime = startTime;
        }


    }

    class Travel {
        private int totalTime;
        private int travellers;

        public int getTotalTime() {
            return totalTime;
        }

        public void setTotalTime(int totalTime) {
            this.totalTime = totalTime;
        }

        public int getTravellers() {
            return travellers;
        }

        public void setTravellers(int travellers) {
            this.travellers = travellers;
        }
    }

    private Map<String, Travel> travelTime;
    private Map<Integer, Customer> customerInfo;

    public UndergroundSystemV2() {
        this.travelTime = new HashMap<>();
        this.customerInfo = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        Customer customer = customerInfo.get(id);
        if (customer == null) {
            customerInfo.put(id, new Customer(stationName, t));
        } else {
            customer.setStartStation(stationName);
            customer.setStartTime(t);
        }

    }

    public void checkOut(int id, String stationName, int t) {
        Customer customer = customerInfo.get(id);
        if (customer != null) {

            String travelTimeKey = customer.startStation + "-" + stationName;

            Travel travel = travelTime.get(travelTimeKey);
            if (travel == null) {
                travel = new Travel();
            }
            travel.setTotalTime(travel.totalTime + (t - customer.startTime));
            travel.setTravellers(travel.travellers + 1);
            travelTime.put(travelTimeKey, travel);
        }
    }

    public double getAverageTime(String startStation, String endStation) {
        double avgTime = 0;
        Travel travel = travelTime.get(startStation + "-" + endStation);
        if (travel != null) {
            avgTime = (double)travel.totalTime / travel.travellers;
        }
        return avgTime;
    }
}
