package com.shetuan.dao;

public class QuestionDao extends BaseDao{

    public static String question1(String q1){
        int sum = 0;
        //System.out.println(q1);
        if(q1.equals("�Ƽ�������")){
            sum+=1;
        }else if (q1.equals("�����о���")){
            sum+=2;
        }else if(q1.equals("��������")){
            sum+=3;
        }else if(q1.equals("����������")){
            sum+=4;
        }
        //System.out.println(sum);
        return Integer.toString(sum);
    }

    public static String question2(String q2){
        int sum = 0;
        //System.out.println(q2);
        if(q2.equals("�ڿ���")){
            sum+=1;
        }else if (q2.equals("ʵ����")){
            sum+=2;
        }else if(q2.equals("������")){
            sum+=3;
        }else if(q2.equals("������")){
            sum+=4;
        }
        //System.out.println(sum);
        return Integer.toString(sum);
    }

    public static String question3(String q3){
        int sum = 0;
        //System.out.println(q2);
        if(q3.equals("20����")){
            sum+=1;
        }else if (q3.equals("20-15")){
            sum+=2;
        }else if(q3.equals("51-100")){
            sum+=3;
        }else if(q3.equals("100����")){
            sum+=4;
        }
        //System.out.println(sum);
        return Integer.toString(sum);
    }

    public static String question4(String q4){
        int sum = 0;
        //System.out.println(q2);
        if(q4.equals("���Խ���")){
            sum+=1;
        }else if (q4.equals("�������")){
            sum+=2;
        }else if(q4.equals("����")){
            sum+=3;
        }
        //System.out.println(sum);
        return Integer.toString(sum);
    }

    public static String question5(String q5){
        int sum = 0;
        //System.out.println(q2);
        if(q5.equals("��Ȥ")){
            sum+=1;
        }else if (q5.equals("����")){
            sum+=2;
        }else if(q5.equals("���")){
            sum+=3;
        }else if(q5.equals("ѧУ")){
            sum+=4;
        }
        //System.out.println(sum);
        return Integer.toString(sum);
    }

    public static String question6(String q6){
        int sum = 0;
        //System.out.println(q2);
        if(q6.equals("ʵ��")){
            sum+=1;
        }else if (q6.equals("����")){
            sum+=2;
        }else if(q6.equals("����")){
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
            back = new String("�����Э��");
        }else if(count == 11){
            back = new String("���ĵ���Э�ᡢEnglish.netЭ��");
        }else if(count == 12){
            back = new String("����ѧ�硢���⹫���硢�������������Э��");
        }else if(count == 13){
            back = new String("�������Э��");
        }else if(count == 14){
            back = new String("����Э��");
        }else if(count == 16){
            back = new String("ħ��Э�ᡢ����Э�ᡢ������Э��");
        }
        System.out.println(back);
        return back;
    }

}
