import java.util.Arrays;

public class LeetCode_Sort_1086 {
    public static int[][] highFive(int[][] items) {
        //如果不相等，安装id排序，小的在前；如果相等，安装成绩大小排序，大的在前
        Arrays.sort(items,( (a,b)->((a[0] == b[0])?b[1]-a[1]:a[0] - b[0])));

        int studentNum = items[items.length - 1][0];//length代表的是有多少学生
        int[][] ans = new int[studentNum][2];

        for(int i = 0; i < items.length; i++ ){        //这里是对items里面每个元素遍历
            //如果是第一个人，或者与前面一个不同
            if(i == 0 || items[i][0] !=items[i -1][0] ){
                int ansIndex = items[i][0] -1;
                ans[ansIndex][0] = items[i][0];

                //对每个学生前五个，累加
                for(int j = i; j < i+5;j++){
                    //代表输出结果的下标，比如第一个学生，他的下标就是0,其实与上面的items[i][0]-1相等
                    int index = items[j][0]-1;
                    ans[index][1] += items[j][1];
                }
                ans[ansIndex][1] /= 5;
                //出外圈后，还会加一，然后找到下一个学生，跳过所有已经找到前五成绩的学生
                i +=4;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] S= {{1,91},{1,92},{2,93},{2,97},{1,60},{2,77},{1,65},{1,87},{1,100},{2,100},{2,76}};
        int[][] T = highFive(S);
        for (int[] v : T){
            System.out.println(v[0] + "--->"+v[1]);
        }
    }
}
