package AirBnB.phone;

import java.util.*;

/**
 * Created by z001ktb
 */
public class BankSystem {
//    static class MyBankSystem {
//        Map<Integer, Integer> accounts;
//        Map<Integer, Map<Long, Integer>> statements;
//
//        MyBankSystem() {
//            accounts = new HashMap<>();
//            statements = new HashMap<>();
//        }
//
//        public boolean deposite(Integer accountId, Integer money, long timestamp) {
//            try {
//                if(accounts.containsKey(accountId)) {
//                    accounts.put(accountId, accounts.get(accountId) + money);
//                    Map<Long, Integer> records;
//                    if (statements.containsKey(accountId)) {
//                        records = statements.get(accountId);
//                    } else {
//                        records = new HashMap<>();
//                    }
//                    records.put(timestamp, accounts.get(accountId));
//                } else { // if account doesn't exist, initialize account
//                    Map<Long, Integer> records = new HashMap<>();
//                    records.put(timestamp, money);
//                    accounts.put(accountId, money);
//                    statements.put(accountId, records);
//                }
//            } catch(Exception exception) {
//                return false;
//            }
//            return true;
//        }
//
//        public boolean withdraw(Integer accountId, Integer money, long timestamp) {
//            if(!accounts.containsKey(accountId) || accounts.get(accountId) < money) {
//                if(!accounts.containsKey(accountId)) { // if account doesn't exist, initialize account
//                    Map<Long, Integer> records = new HashMap<>();
//                    records.put(timestamp, 0);
//                    accounts.put(accountId, 0);
//                    statements.put(accountId, records);
//                }
//                return false;
//            }
//            try {
//                accounts.put(accountId, accounts.get(accountId) - money);
//                Map<Long, Integer> records;
//                if(statements.containsKey(accountId)) {
//                    records = statements.get(accountId);
//                } else {
//                    records = new HashMap<>();
//                }
//                records.put(timestamp, accounts.get(accountId));
//                statements.put(accountId, records);
//            } catch(Exception exception) {
//                return false;
//            }
//            return true;
//        }
//
//        public int[] check(Integer accountId, long start, long end) {
//            if(!statements.containsKey(accountId) || !accounts.containsKey(accountId) || start > end) {
//                return new int[]{};
//            }
//            int[] result = new int[2];
//            Map<Long, Integer> records = statements.get(accountId);
//            List<Long> timeline = new ArrayList<>(records.keySet());
//            Collections.sort(timeline);
//
//            if(records.containsKey(start)) {
//                result[0] = records.get(start);
//            } else {
//                int index = -(Collections.binarySearch(timeline, start) + 1);
//                result[0] = index == 0 ? records.get(timeline.get(0)) : records.get(timeline.get(index - 1));
//            }
//
//            if(records.containsKey(end)) {
//                result[1] = records.get(end);
//            } else {
//                int index = -(Collections.binarySearch(timeline, end) + 1);
//                result[1] = index == 0 ? records.get(timeline.get(0)) : records.get(timeline.get(index - 1));
//            }
//            return result;
//        }
//    }
//
//      public static void main(String[] args) {
//        MyBankSystem bs = new MyBankSystem();
//        System.out.println(bs.withdraw(0, 100, 0));  // false
//        bs.deposite(0, 100, 1);
//        bs.deposite(1, 250, 2);
//        bs.withdraw(0, 30, 3);
//        System.out.println(bs.check(0, 0, 2)[0]);  // 0
//        System.out.println(bs.check(0, 0, 2)[1]);  // 100
//        bs.deposite(1, 5, 7);
//        System.out.println(bs.check(1, 3, 9)[0]);  // 250
//        System.out.println(bs.check(1, 3, 9)[1]);  // 255
//      }

    static class MyBankSystem {
        Map<Integer, Integer> accounts;
        Map<Integer, Map<Integer,Integer>> statements;


        MyBankSystem() {
            accounts = new HashMap<>();
            statements = new HashMap<>();
        }

        public void deposite(int id, int money, int timestamp) {
            if(money < 0) return;
            int balance = accounts.containsKey(id) ? accounts.get(id) : 0;
            accounts.put(id, balance + money);
            Map<Integer, Integer> states = statements.containsKey(id) ? statements.get(id) : new HashMap<>();
            states.put(timestamp, accounts.get(id));
            statements.put(id, states);
        }

        public Integer withdraw(int id, int money, int timestamp) {
            int balance = accounts.containsKey(id) ? accounts.get(id) : 0;
            Map<Integer, Integer> states = statements.containsKey(id) ? statements.get(id) : new HashMap<>();
            if(!accounts.containsKey(id)) {
                accounts.put(id, 0);
                states.put(timestamp,0);
                statements.put(id, states);
                return null;
            }
            if(money < 0 || money > balance) return null;

            accounts.put(id, balance - money);
            states.put(timestamp, accounts.get(id));
            statements.put(id, states);
            return money;
        }

        public int[] check(int id, int start, int end) {
            int[] resp = new int[2];
            if(!accounts.containsKey(id)) return null;
            Map<Integer, Integer> states = statements.get(id);
            List<Integer> timeline = new ArrayList<>(states.keySet());

            Collections.sort(timeline);

            if(states.containsKey(start)) {
                resp[0] = states.get(start);
            } else {
                int ip = -(Collections.binarySearch(timeline, start) + 1);
                resp[0] = ip == 0 ? states.get(timeline.get(0)) : states.get(timeline.get(ip - 1));
            }

            if(states.containsKey(end)) {
                resp[1] = states.get(end);
            } else {
                int ip = -(Collections.binarySearch(timeline, end) + 1);
                resp[1] = ip == 0 ? states.get(timeline.get(0)) : states.get(timeline.get(ip - 1));
            }

            return resp;
        }

    }

    public static void main(String[] args) {
        MyBankSystem bs = new MyBankSystem();
        System.out.println(bs.withdraw(0, 100, 0));  // false
        bs.deposite(0, 100, 1);
        bs.deposite(1, 250, 2);
        bs.withdraw(0, 30, 3);
        System.out.println(bs.check(0, 0, 2)[0]);  // 0
        System.out.println(bs.check(0, 0, 2)[1]);  // 100
        bs.deposite(1, 5, 7);
        System.out.println(bs.check(1, 3, 9)[0]);  // 250
        System.out.println(bs.check(1, 3, 9)[1]);  // 255
    }
}
