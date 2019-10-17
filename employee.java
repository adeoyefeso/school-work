public class employee extends person{

    private int year_hired;
    private int id;
    private static int counter = 0;

    public employee(String name, int age, int year_hired){
        super(name, age);

        if(year_hired >= 1900 && year_hired <= 2999){

            this.year_hired = year_hired;
        }
        else{
            this.year_hired = 2019;
        }

        this.id = counter;
        counter++;
    }

    public int getYearHired(){

        return this.year_hired;
    }
    public String toString(){
        //Jim was hired in 2017 and is 19 years old
        return getName()+" was hired in "+getYearHired()+" and is "+getAge()+" years old";
    }


}

