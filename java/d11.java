class d10{
    // 盛水的容器
    // 1：暴力方法
    // 2：dp：S=max{(j-i)*min(a[j],a[i])}
	// 设定头尾指针，分别指向头和尾，每次另a[i]值大的移动。
	// 
    public int maxarea(int[] height){
		int left=0,right=height.length-1,maxarea=0;
		while(left<right){
			if((right-left)*Math.min(height[left],height[right])>maxarea){
				maxarea=(right-left)*Math.min(height[left],height[right]);
			}
			int a = (height[left]<height[right])?++left:--right;
		}
		return maxarea;
	}
	public static void main(String[] args) {
		
	}

}

