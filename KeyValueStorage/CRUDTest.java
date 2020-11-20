public class CRUDTest {
    String fileName="C://Users//arun_bhati//Desktop//KVStorage//data-layer//TextFile.txt";
   // @Test
   CRUD crud=new CRUD();
    @Test
     void insertTest(){
        crud.insert("PM","Modi");
        Assert.equals("Modi",crud.search("PM"));
    }

    public void searchTest(){
        Assert.equals("Modi",crud.search("PM"));
    }

    public void deleteTest(){
        crud.delete("PM");
        Assert.equals("",crud.search("PM"));
    }

    public void updateTest(){
        crud.insert("PM","Kejriwal");
        Assert.equals("Kejriwal",crud.search("PM"));
    }
}
