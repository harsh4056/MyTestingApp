package com.example;

import java.io.IOException;

import java.io.*;

/**
 * Created by moon on 20/7/17.
 */

public class Solution {


    public int solution(int N, String S) {
        int families=0;
        String alphabets[]={"A","B","C","D","E","F","G","H","J","K"};

        for(int n=1;n<=N;n++){
            boolean seats[]={false,false,false,false,false,false,false,false,false,false};
            for(int alpha=0;alpha<alphabets.length;alpha++)
            {
                String seat =n+alphabets[alpha];
                if(S.contains(seat)){
                    seats[alpha]=true;
                } }
            for( int seatNo=0;seatNo<=9;){
                if(seatNo+1<=8){
                    if(seatNo!=1 && seatNo!=2 && seatNo!=5 && seatNo!=6 ){
                    if(seats[seatNo]==false && seats[seatNo+1]==false &&seats[seatNo+2]==false ){
                        families++;
                        seatNo+=3;
                    }
                    }else {
                        seatNo++;
                    }
                }

            }




        }

        return families;
    }
    public int solution(int X, int Y, int[] A) {
        int N = A.length;
        int result = -1;
        int nX = 0;
        int nY = 0;
        for (int i = 0; i < N; i++) {
            if (A[i] == X)
                nX += 1;
            else if (A[i] == Y)
                nY += 1;
            if (nX == nY)
                result = i;
        }
        return result;
    }

    public static void main(String args[])throws IOException {
        Solution solution= new Solution();
        int array[]={6,0,11,7,1,42,7,7,7,42,42,7,42};
        System.out.println(solution.solution(7,42,array));
    }
}
