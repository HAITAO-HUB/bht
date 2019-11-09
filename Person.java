public class Person {
        private String name;
        private String sex;
        private int age;
        private String address;
        public Person(String name){
            this.name=name;
        }
        public Person(String name,String sex){
            this.name=name;
            this.sex=sex;
        }
        public Person(String name,String sex,int age,String addrss){
            this.name=name;
            this.sex=sex;
            this.age=age;
            this.address=address;
        }
        public static void main(String[] args) {
            Person p1=new Person("张三");
            Person p2=new Person("李四","男");
            Person p3=new Person("王五","男",34,"陕西");
            System.out.println(p1.sex);
            System.out.println(p2.name);
            System.out.println(p3.age);
        }
}
