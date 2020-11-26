package Not_Sys;

public class Template implements Blueprint{
    private String header;
    private String content;
    private int id;
    private static int idCounetr = 0;

    Template(){}
    Template(String header, String content){
        this.id = generateId();
        this.header = header;
        this.content = content;
    }


    public int generateId(){
        return idCounetr++;
    }

    public int getId() {
        return id;
    }

    public void setId() {
        this.id = generateId();
    }


    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String helpFormat(){
        return "Format Of Template Should Be:\nDear $ , " +
                "your booking of the $ is confirmed. thanks for using our store.\n" +
                "$ -> Refer To Parameter";
    }

    @Override
    public String toString() {
        return "Template " + id  + "\n" + header + "\n" + content + "\n";
    }
}
