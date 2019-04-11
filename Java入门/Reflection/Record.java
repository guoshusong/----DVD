package azs.Reflection;

public class Record {
    @File_Method_Parameter_Annotation(describe = "编号",type = int.class)
    int id;
    @File_Method_Parameter_Annotation(describe = "姓名",type = String.class)
    String name;
    @Constructor_Annotation
    public Record(){
    }
    @Constructor_Annotation("立即处死话构造方法")
    public Record(@File_Method_Parameter_Annotation(describe = "编号",type = int.class)int id,@File_Method_Parameter_Annotation(describe = "姓名",type = String.class) String name){
        this.id = id;
        this.name = name;
    }
    @File_Method_Parameter_Annotation(describe = "获得编号", type = int.class)
    public int getId(){
        return id;
    }
    @File_Method_Parameter_Annotation(describe = "设置编号")
    public void  setId(@File_Method_Parameter_Annotation(describe = "编号",type = int.class)int id){
        this.id = id;
    }
    @File_Method_Parameter_Annotation(describe = "获得姓名",type = String.class)
    public String getName(){
        return name;
    }
    @File_Method_Parameter_Annotation(describe = "设置编号")
    public void  setName(@File_Method_Parameter_Annotation(describe = "姓名   ",type = String.class)String name){
        this.name = name;
    }
}
