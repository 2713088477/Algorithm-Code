package weeklySchool;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Plane {
    public int earliest;  
    public int latest;    
    public int landingTime; 
    public boolean isUsed = false;
}

public class day10_18QE {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while ((t--) != 0) {
            int num = sc.nextInt();
            List<Plane> list = new ArrayList<>();
            for (int i = 0; i < num; i++) {
                Plane p = new Plane();
                int T = sc.nextInt();
                int D = sc.nextInt();
                int L = sc.nextInt();
                p.earliest = T;
                p.latest = T + D;
                p.landingTime = L;
                list.add(p);
            }
            
            if (dfs(list, 0, 0)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
    
    public static boolean dfs(List<Plane> list, int count, int currentTime) {
        if (count == list.size()) {
            return true;
        }
        
        for (int i = 0; i < list.size(); i++) {
            Plane plane = list.get(i);
            if (!plane.isUsed) {
                int startTime = Math.max(currentTime, plane.earliest);
                
                if (startTime <= plane.latest) {
                    plane.isUsed = true;
                    if (dfs(list, count + 1, startTime + plane.landingTime)) {
                        return true;
                    }
                    plane.isUsed = false;
                }
            }
        }
        
        return false;
    }
}