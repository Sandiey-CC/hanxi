package com.bcjd.hanxi.commom;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Validate {
    private Validate(){}
    private static class ValidateInner{
        private static final Validate Instance = new Validate();
    }
    public static final Validate getInstance(){
        return ValidateInner.Instance;
    }

    private static Map<String,Long> superCode = new HashMap<>();
    private static Map<String,Long> mediuCode = new HashMap<>();
    private static Map<String,Long> lowerCode = new HashMap<>();

    public String addSuperCode(){
        if(superCode.size()>=10){
            removeCode(superCode);
            return null;
        }
        String newCode = System.currentTimeMillis()+ DataUtils.getRandomCode();
        long inValidTime = System.currentTimeMillis()+360000;
        superCode.put(newCode,inValidTime);
        return newCode;
    }

    public String addMediuCode(String code){
        if(mediuCode.size()>=10){
            removeCode(mediuCode);
            return null;
        }
        String newCode = System.currentTimeMillis()+ DataUtils.getRandomCode()+"-"+code;
        long inValidTime = System.currentTimeMillis()+360000;
        mediuCode.put(newCode,inValidTime);
        return newCode;
    }

    public String addLowerCode(String code){
        if(lowerCode.size()>=10){
            removeCode(lowerCode);
            return null;
        }
        String newCode = DataUtils.getUUID()+"-"+code;
        long inValidTime = System.currentTimeMillis()+360000;
        lowerCode.put(newCode,inValidTime);
        return newCode;
    }
    public boolean isValid(String code,int level){
        long time;
        //level判断是哪个等级的map
        switch (level){
            case 1:
                if(superCode.get(code)==null)
                    return false;
                time = superCode.get(code);
                if(System.currentTimeMillis()<=time){
                    superCode.remove(code);
                    return true;
                }
                superCode.remove(code);
                break;
            case 2:
                if(mediuCode.get(code)==null)
                    return false;
                time = mediuCode.get(code);
                if(System.currentTimeMillis()<=time){
                    mediuCode.remove(code);
                    return true;
                }
                mediuCode.remove(code);
                break;
            case 3:
                if(lowerCode.get(code)==null)
                    return false;
                time = lowerCode.get(code);
                if(System.currentTimeMillis()<=time){
                    lowerCode.remove(code);
                    return true;
                }
                lowerCode.remove(code);
                break;
        }
        return false;
    }

    public int getLevel(String code) {
        int first = code.indexOf("-");
        int second = code.substring(first+1).indexOf("-");
        if(first == -1)
            return 1;
        if(second == -1)
            return 2;
        if(code.substring(first+second+2).indexOf("-")==-1)
            return 3;
        return 0;
    }

    private void removeCode(Map code){
        Iterator<Map.Entry<String, Long>> iterator = code.entrySet().iterator();
        long now = System.currentTimeMillis();
        long value;
        String key;
        while (iterator.hasNext()) {
            Map.Entry<String,Long> cur= iterator.next();
            value = cur.getValue();
            key = cur.getKey();
            System.out.println(key);
            if(now>value)
                code.remove(key);
        }
    }

}
