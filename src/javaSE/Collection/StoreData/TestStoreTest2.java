package javaSE.Collection.StoreData;




import java.util.*;

/**
 * 测试表格数据的存储
 * 体会ORM思想
 * 每一行数据使用javabean对象存储，多行使用放到map或list中
 */
public class TestStoreTest2 {
    public static void main(String[] args) {
        User user1 = new User(1001,"张三",20000,"2019.10.10");
        User user2 = new User(1002,"李四",30000,"2016.10.10");
        User user3 = new User(1003,"王五",40000,"2013.10.10");

        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        for (User temp:list){
            System.out.println(temp);
        }

        //使用map
        Map<Integer,User> map = new HashMap<>();
        map.put(1001,user1);
        map.put(1002,user2);
        map.put(1003,user3);
        Set<Integer> keySet = map.keySet();
        for (Integer key:keySet){
            System.out.println(key+"::"+map.get(key));
        }


    }
}


class User{
    private int id;
    private String name;
    private double salary;
    private String hiredata;

    //一个完整的javabean 要有set和get方法 和一个无参构造器
    public User() {
    }

    public User(int id, String name, double salary, String hiredata) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.hiredata = hiredata;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getHiredata() {
        return hiredata;
    }

    public void setHiredata(String hiredata) {
        this.hiredata = hiredata;
    }

    @Override
    public String toString() {
        return "id:"+id+"name:"+name+"salary:"+salary+"hiredate:"+hiredata;
    }
}