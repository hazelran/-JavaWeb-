package com.shetuan.dao;

public class QuestionDao extends BaseDao{

    public static String question1(String q1){
        int sum = 0;
        //System.out.println(q1);
        if(q1.equals("科技创新类")){
            sum+=1;
        }else if (q1.equals("理论研究类")){
            sum+=2;
        }else if(q1.equals("社会服务类")){
            sum+=3;
        }else if(q1.equals("体育竞技类")){
            sum+=4;
        }
        //System.out.println(sum);
        return Integer.toString(sum);
    }

    public static String question2(String q2){
        int sum = 0;
        //System.out.println(q2);
        if(q2.equals("授课型")){
            sum+=1;
        }else if (q2.equals("实践型")){
            sum+=2;
        }else if(q2.equals("歌舞型")){
            sum+=3;
        }else if(q2.equals("比赛型")){
            sum+=4;
        }
        //System.out.println(sum);
        return Integer.toString(sum);
    }

    public static String question3(String q3){
        int sum = 0;
        //System.out.println(q2);
        if(q3.equals("20以内")){
            sum+=1;
        }else if (q3.equals("20-15")){
            sum+=2;
        }else if(q3.equals("51-100")){
            sum+=3;
        }else if(q3.equals("100以上")){
            sum+=4;
        }
        //System.out.println(sum);
        return Integer.toString(sum);
    }

    public static String question4(String q4){
        int sum = 0;
        //System.out.println(q2);
        if(q4.equals("独自进行")){
            sum+=1;
        }else if (q4.equals("团体进行")){
            sum+=2;
        }else if(q4.equals("均可")){
            sum+=3;
        }
        //System.out.println(sum);
        return Integer.toString(sum);
    }

    public static String question5(String q5){
        int sum = 0;
        //System.out.println(q2);
        if(q5.equals("兴趣")){
            sum+=1;
        }else if (q5.equals("能力")){
            sum+=2;
        }else if(q5.equals("社会")){
            sum+=3;
        }else if(q5.equals("学校")){
            sum+=4;
        }
        //System.out.println(sum);
        return Integer.toString(sum);
    }

    public static String question6(String q6){
        int sum = 0;
        //System.out.println(q2);
        if(q6.equals("实践")){
            sum+=1;
        }else if (q6.equals("创新")){
            sum+=2;
        }else if(q6.equals("娱乐")){
            sum+=3;
        }
        //System.out.println(sum);
        return Integer.toString(sum);
    }

    public static String output(String sum){
        int count = Integer.parseInt(sum);
        String back = null;
        System.out.println(count);
        if(count == 10){
            back = new String("计算机协会");
        }else if(count == 11){
            back = new String("天文地理协会、English.net协会");
        }else if(count == 12){
            back = new String("心理学社、阳光公益社、社会调查服务中心协会");
        }else if(count == 13){
            back = new String("阳光教育协会");
        }else if(count == 14){
            back = new String("健身协会");
        }else if(count == 16){
            back = new String("魔术协会、排球协会、兵乓球协会");
        }
        System.out.println(back);
        return back;
    }

}
