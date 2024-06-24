class Student {
    private int id;
    private String name;
    private String zipcode;

    public Student() {
        id = 8;
        name = "John";
        zipcode= "19090";
    }
    public String getZipcode(){return zipcode;}

    public int getid() {
        return id;
    }

    public String getname() {
        return name;
    }

    public void setid(int newid) {
        id = newid;
    }

    public void setname(String newname) {
        name = newname;
    }

    public void setZipcode(String newzipcode) {zipcode = newzipcode;}

    public String toString() {
        String result = Integer.toString(id) + " " + name;
        return result;
    }
}

class TestStudent1 {
    public static void main(String args[]) {
        Student s0 = new Student();
        System.out.println(s0);
        Student s1 = new Student();
        s1.setid(312);
        s1.setname("Patrick");
        s1.setZipcode("19090");
        System.out.println("ID is " + s1.getid());
        System.out.println("The student name is " + s1.getname());
        System.out.println("Student zipcode "+ s1.getZipcode());
    }
}