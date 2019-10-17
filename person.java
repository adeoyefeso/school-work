public class person{

    private String name;
    private int age;


    public person(String name, int age){
        if(name != ""){
            this.name = name;
        }
        else{
            this.name = "Private contractor";
        }
        if(age <= 150){
            this.age = age;
        }
        else{
            this.age = 18;
        }

    }
    public String getName(){

        return this.name;
    }
    public int getAge(){

        return this.age;
    }
}
