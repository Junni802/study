package junni.baek.baekJoon;

import java.util.*;

public class BaekTest1431 {
    public static void main(String[] args) {
        String value = "ffdee";
        System.out.println("값이다 --> " + value.replaceAll("[^0-9]", ""));
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        List<String> list = new ArrayList<String>();

        /**
         * 조건값 비교
         * 1. 길이에 따른 비교
         * 2. 모든자리의 합에 의한 비교(숫자로만 비교)
         * 3. 사전순으로 비교(숫자가 알파벳보다 사전순으로 작다.)
         */

        for (int i=0; i<number; i++) {
            list.add(sc.next());
        }

        // 값 비교에 따른 정렬을 위한 LOOP문
        for (int i=0; i<list.size() - 1; i++) {
            for(int j=i+1; j<list.size(); j++) {
                if (list.get(i).length() > list.get(j).length()) {
                    String temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }else if(list.get(i).length() == list.get(j).length()) {
                    String aplhaI = list.get(i).replaceAll("[^0-9]", "");
                    System.out.println(aplhaI);
                    int numI = 0;
                    String aplhaJ = list.get(j).replaceAll("[^0-9]", "");
                    System.out.println(aplhaJ);
                    int numJ = 0;
                    if (aplhaI != "" && aplhaJ != "") {
                    for (int k=0; k<aplhaI.length(); k++) {
                        numI += Integer.parseInt(aplhaI.indent(k));
                        System.out.println(aplhaI.indent(k));
                    }
                    for (int m=0; m<aplhaJ.length(); m++){
                        numJ += Integer.parseInt(aplhaJ.indent(m));
                        System.out.println(aplhaJ.indent(m));
                    }
                        if (numI < numJ) {
                            String temp = list.get(i);
                            list.set(i, list.get(j));
                            list.set(j, temp);
                        } else if (numI == numJ) {
                            for (int k = 0; k < list.get(j).length(); k++) {
                                if (list.get(i).indexOf(k) < list.get(j).indexOf(k)) {
                                    String temp = list.get(i);
                                    list.set(i, list.get(j));
                                    list.set(j, temp);
                                    return;
                                } else if (list.get(i).indexOf(k) < list.get(j).indexOf(k)) {
                                    return;
                                }
                            }
                        }
                    }else if(aplhaJ == "" && aplhaI != "") {
                        String temp = list.get(i);
                        list.set(i, list.get(j));
                        list.set(j, temp);
                    }
                }
            }
        }


        list.stream().forEach(alpha -> System.out.println(alpha));

    }
}
