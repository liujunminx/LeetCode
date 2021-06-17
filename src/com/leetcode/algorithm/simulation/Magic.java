package com.leetcode.algorithm.simulation;

import java.util.Arrays;

public class Magic {
    //洗牌过程
    int[] magicSort(int[] nums,int length)
    {
        int n=length;
        int result[]=new int[n];
        int mid=n/2;
        for(int i=0,even=0,odd=mid;i<n;i++)
        {
            if((i+1)%2==0)
            {
                result[even++]=nums[i];
            }
            else{
                result[odd++]=nums[i];
            }
        }
        return result;
    }

    int getLen(int[] firstSort,int[] target)
    {
        int n=firstSort.length;
        for(int i=0;i<n;i++)
        {
            if(firstSort[i]!=target[i])
            {
                return i;
            }
        }
        //两个数组完全相等，返回n
        return n;
    }

    public boolean isMagic(int[] target) {

        int n=target.length;
        int nums[]=new int[n];

        //构造数组:{1,2,3,4....n}
        Arrays.fill(nums,1);
        for(int i=1;i<n;i++)
        {
            nums[i]+=nums[i-1];
        }

        nums=magicSort(nums,nums.length);
        // System.out.println(Arrays.toString(nums));
        int k=getLen(nums,target);
        // System.out.println(k);

        if(k==0)
        {
            return false;
        }

        int numsLen=n;
        while(numsLen>0)
        {
            //取走前k个数
            for(int i=k;i<numsLen;i++)
            {
                nums[i-k]=nums[i];
                target[i-k]=target[i];
            }
            if(numsLen>k)
            {
                numsLen-=k;
            }
            else{
                numsLen=0;
            }
            if(numsLen==0)
            {
                return true;
            }
            nums=magicSort(nums,numsLen);
            for(int i=0;i<k&&i<numsLen;i++)
            {
                if(nums[i]!=target[i])
                {
                    return false;
                }
            }
        }
        return false;
    }
}
