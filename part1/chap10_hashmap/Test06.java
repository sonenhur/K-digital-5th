package part1.chap10_hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Test06 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String word[] = {"BUMBLEBEE", "HEAVEN", "ALTHOUGH", "WONDER"};
        String meaning[] = {"꿀벌과에 속하는 호박벌", "천국", "그럼에도 불구하고", "호기심이 들다"};
        // 키밸류는 heap 영역에, dic은 참조만
        // dic:스택에 저장되는 참조변수
        Map<String, String> dic = new HashMap();

        for (int i = 0; i < word.length; i++) {
            dic.put(word[i], meaning[i]);
        }
        System.out.println(dic);
        System.out.println(dic.size());

        System.out.println(dic.keySet());// [HEAVEN, BUMBLEBEE, WONDER, ALTHOUGH]
        //순서가 "없다"는 아니고, "정해져있지 않다" 인듯?
        //다른 PC, 다른 환경에서는 다른 순서로 나온다고 함
        // =====================================
        System.out.println("-".repeat(30));
        Set<String> keys = dic.keySet();
        for (String key : keys) {
            System.out.println("\t" + key + ":" + dic.get(key));
        }
        System.out.println("-".repeat(30));
        // =====================================
        System.out.println(dic.values());

        System.out.println("HEAVEN :" + dic.get("HEAVEN"));
        dic.replace("HEAVEN", "아주 행복한 감정");
        System.out.println("HEAVEN :" + dic.get("HEAVEN"));
        dic.put("HEAVEN", "이상적인 세상");
        System.out.println("HEAVEN :" + dic.get("HEAVEN"));

        System.out.println(dic.containsKey("BUMBLEBEE"));
        System.out.println(dic.containsValue("자장가"));

        dic.remove("HAVEN");
        System.out.println(dic.containsKey("HAVEN"));

        dic.clear();
        System.out.println(dic.isEmpty());
        System.out.println(dic.size());
    }

}
