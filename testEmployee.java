class testEmployee {

    public static void main(String[] args) {
            //test class for employee
            employee e1 = new employee("Jim", 19, 2017);//name, age, date hired
            employee e2 = new employee("Jenny Smith", 23, 2014);//name, age, date hired
            employee e3 = new employee("", 185, 2777);//name, age, date hired

            System.out.println(e1);
            System.out.println(e2);
            System.out.println(e3);
    }
}
