import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/**
 * Created by yjw on 17-5-9.
 */
public class Solution {
    public static void main(String[] args){
        int[] test={2,7,11,15};
        int[] res=twoSum(test,17);
        for(int elem:res){
            System.out.println(elem);
        }
    }
//1
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[1] = i;
                result[0] = map.get(target - nums[i]);
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }

    //2
    public class ListNode {
             int val;
             ListNode next;
             ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ps=null;
        ListNode res=ps;
        ListNode a=l1;
        ListNode b=l2;

        int jin=0;
        while(a!=null||b!=null){
            int numa=0;
            int numb=0;
            if(a!=null){
                numa=a.val;
            }
            if(b!=null){
                numb=b.val;
            }
            int numc=(numa+numb+jin)%10;
            ps=new ListNode(numc);
            ps=ps.next;
            jin=(numa+numb+jin)/10;

        }
        return null;
    }
}
