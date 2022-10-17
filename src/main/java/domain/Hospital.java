package domain;

public class Hospital {
    private String id;
    private String address; // alt + insert
    private String category;
    private String district;
    private String name;
    private Integer emergency_room;  // 참고로 emergencyroom은 숫자라서 Integer입니다
    private String subDivision;



    public Hospital(String id, String address, String category, String emergency_room,
                    String name, String subDivision) {    // 확실히 사용이 안됐는지 회색이네요
        this.id = id;
        this.address = address;
        this.name = name;
        this.emergency_room = Integer.parseInt(emergency_room);   // 여기 에러나는 건 Integer.parseInt로 int형 만들어주면 됩니다
        this.category = category;
        this.subDivision = subDivision;

        setDistrict(address);
    }

    public void setDistrict(String str) {
        String[] splitted = str.split(" ");
        this.district = splitted[0]+" "+splitted[1]; // 서울시 어쩌구~어쩌구 ~ -> "서울시 00구"로 파싱했어여
    }

    public String getSqlInsertQuery2(){
            String sql = String.format("INSERT INTO `like-lion-db`.`Seoul_hospital`\n(`id`,`address`,`district`,`category`,`emergency_room`,`name`,`subdivision`)\n" +
                    "VALUES\n" +
                    "(\"%s\"," +
                    "\"%s\"," +
                    "\"%s\"," +
                    "\"%s\"," +
                    "\"%d\"," +
                    "\"%s\"," +
                    "\"%s\");\n", this.id, this.address, this.district, this.category, this.emergency_room, this.name, this.subDivision);
//        System.out.println(this.subDivision); -> 잘 들어갔는지 확인하는 용도
        return sql;
    }
    public String getId() {
        return id;
    }
    public String getAddress() {
        return address;
    }

    public String getCategory() {
        return category;
    }

    public String getDistrict() {
        return district;
    }

    public String getName() {
        return name;
    }

    public Integer getEmergency_room() {
        return emergency_room;
    }

    public String getSubDivision() {
        return subDivision;
    }

}
