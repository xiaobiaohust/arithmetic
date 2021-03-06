package InterviewGuildCode.StackAndQueue;

import java.util.Stack;


/**
 * 求最大子矩阵的大小
 * 给定一个矩阵，只有0和1，求其中全是1的所有矩形区域中，最大的矩形区域为1的数量
 *要求：矩阵大小为O(NxM),时间复杂度为O(NxM)
 * 思路：
 * 1：矩阵的行数为N，以每一行做切割，统计以当前行作为底的情况下，每个位置往上的1的数量，使用数字height表示
 * 2：对于每一次切割，利用height数组，求出以每一行为底的情况下，最大的矩形是什么，多次切割选择最大的矩形
 *
 *问题的重点转换为如何快速实现步骤二，height数组可以理解为一个直方图，也就是将问题转换为
 * 在直方图中求最大矩形的面积，求最大面积，可以理解为求每一根柱子扩展出去的最大矩形，
 * 求扩展出去的面积的关键在于求出该柱子向左向右第一个比它小的柱子，这个可以用栈来求出
 */

public class Problem_09_MaximalRectangle {
	public static int maxRecSize(int [][]map){
		if(map==null||map.length==0||map[0].length==0){
			return 0;
		}
		int maxArea= 0;
		int[] height = new int [map[0].length];
		for(int i=0;i<map.length;++i){
			for(int j=0;j<map[0].length;++j){
				height[j]= map[i][j]==0?0:height[j]+1;
			}
			maxArea = Math.max(maxRecFrombottom(height),maxArea);
		}
		return maxArea;
	}

	//求每个height直方图对应的最大矩形面积
	public static int maxRecFrombottom(int[]height){
		if(height==null||height.length==0){
			return 0;
		}
		int maxArea = 0;
		Stack<Integer>stack = new Stack<>();
		for(int i=0;i<height.length;++i){
			while(!stack.isEmpty()&&height[i]<=height[stack.peek()]){
				//stack pop节点的前一个节点为左边第一个比它小的节点，该节点之所以会pop出去，
				//是因为i对应的节点比它小所以右边第一个比它小的元素就是i
				int j=stack.pop();
				int k = stack.isEmpty()?-1:stack.peek();//j节点对应的前面第一个比它小的节点
				int  curArea = (i-k-1)*height[j];
				maxArea = Math.max(curArea,maxArea);
			}
			stack.push(i);
		}
		//对于栈中剩下的元素，右边没有比它小的元素所以可以拓展到最右边
		while(!stack.isEmpty()){
			int j= stack.pop();
			int k = stack.isEmpty()?-1:stack.peek();
			int curArea = (height.length-k-1)*height[j];
			maxArea = Math.max(curArea,maxArea);
		}
		return maxArea;
	}

	public static void main(String[] args){
		int [][]map = {{1,0,1,1},{1,1,1,1},{1,1,1,0}};
		System.out.println(maxRecSize(map));
	}

}
