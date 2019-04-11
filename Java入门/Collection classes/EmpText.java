package azs;

import java.util.Map;
import java.util.TreeMap;

public class EmpText {
    public static void main(String [] args){
        Map<String,String> map = new TreeMap<>();
        Emp emp = new Emp("001","wang");
        Emp emp2 = new Emp("002","wang02");
        Emp emp3 = new Emp("004", "120");
        Emp emp4 = new Emp("010", "chen");
        Emp emp5 = new Emp("015", "121");
        map.put(emp.getE_id(), emp.getE_name());//向map集合中添加指定的key与value的反射
        map.put(emp2.getE_id(), emp2.getE_name());
        map.put(emp3.getE_id(), emp3.getE_name());
        map.put(emp4.getE_id(), emp4.getE_name());
        map.put(emp5.getE_id(), emp5.getE_name());
        map.remove("015");
        for (String string : map.keySet()) {
            System.out.println(map.get(string));
        }
    }
}

