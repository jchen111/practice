package AirBnB.phone;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by z001ktb
 */
public class FileSystem {
    static class MyFileSystem {
        Map<String, Integer> pathMap;
        Map<String, Runnable> callbackMap;
        static final String ROOT = "root";

        public MyFileSystem() {
            this.pathMap = new HashMap<>();
            this.callbackMap = new HashMap<>();
            pathMap.put(ROOT, 0);
        }

        public boolean create(String path, int value) {
            path = ROOT + path;
            if (pathMap.containsKey(path)) {
                return false;
            }

            int lastSlashIndex = path.lastIndexOf("/");
            if (!pathMap.containsKey(path.substring(0, lastSlashIndex))) {
                return false;
            }

            pathMap.put(path, value);
            return true;
        }

        public boolean set(String path, int value) {
            path = ROOT + path;
            if (!pathMap.containsKey(path)) {
                return false;
            }

            pathMap.put(path, value);

            // Trigger callbacks
            String curPath = path;
            while (curPath.length() > 0) {
                if (callbackMap.containsKey(curPath)) {
                    callbackMap.get(curPath).run();
                }
                int lastSlashIndex = curPath.lastIndexOf("/");
                curPath = curPath.substring(0, lastSlashIndex);
            }

            return true;
        }

        public Integer get(String path) {
            path = ROOT + path;
            return pathMap.get(path);
        }

        public boolean watch(String path, Runnable callback) {
            path = ROOT + path;
            if (!pathMap.containsKey(path)) {
                return false;
            }

            callbackMap.put(path, callback);
            return true;
        }
    }

    public static void main(String[] args) {
        MyFileSystem fs = new MyFileSystem();
        System.out.println(fs.get("/a")); // null
        System.out.println(fs.set("/a", 2)); // false
        System.out.println(fs.create("/a", 1)); // true
        System.out.println(fs.get("/a")); // 1
        System.out.println(fs.create("/e/a/f",1)); // false
        System.out.println(fs.create("/a/b", 2)); // true
        System.out.println(fs.create("/b/c", 3)); // false
        System.out.println(fs.watch("/a/b", new Runnable() {
          @Override
          public void run() {
            System.out.println("callback on /a/b");
//            System.exit(0);
          }
        }));
        System.out.println(fs.watch("/a", new Runnable() {
          @Override
          public void run() {
            System.out.println("callback on /a");
            System.exit(0);
          }
        }));
        System.out.println(fs.set("/a/b", 10)); // trigger 2 callbacks and true
  }

}
