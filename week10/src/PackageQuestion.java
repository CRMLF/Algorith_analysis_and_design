import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @Description
 * @Author ZhengLing
 * @Date 2021/05/17 16:18
 */
public class PackageQuestion {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int n = Integer.parseInt(sc.nextLine());// n=2

        while (n-- > 0) {

            int num = Integer.parseInt(sc.nextLine());// num表示有几个活动2
            //一个基于优先级堆的无界优先级队列。
            PriorityQueue<MeetingTime> queue = new PriorityQueue<MeetingTime>();

            for (int i = 0; i < num; i++) {
                String[] activitys = sc.nextLine().split(" ");
                MeetingTime activity = new MeetingTime(
                        Integer.parseInt(activitys[0]), Integer
                        .parseInt(activitys[1]));

                queue.add(activity);
            }

            int count = 1;//最少是一个活动
            // 取出第一个活动
            int endTime = queue.poll().endTime;
            for (int i = 1; i < num; i++) {
                if (endTime < queue.peek().beginTime) {
                    //说明存在
                    count++;
                    endTime = queue.peek().endTime;
                }
                queue.poll();//获取并移除此队列的头，
            }

            queue.clear();

            System.out.println(count);
        }
    }
}

class MeetingTime implements Comparable<MeetingTime> {

    int beginTime;
    int endTime;

    public MeetingTime(int beginTime, int endTime) {
        this.beginTime = beginTime;
        this.endTime = endTime;
    }

    @Override
    public int compareTo(MeetingTime o) {
        if (this.endTime > o.endTime) {
            return 1;
        } else {
            return -1;
        }
    }


}

