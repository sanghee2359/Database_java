import domain.Hospital;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HospitalParserTest {
    HospitalParser hospitalParser = new HospitalParser();
    String line4 = "\"A1118077\",\"서울특별시 중구 한강대로 416 지하1층 (남대문로5가 서울스퀘어빌딩)\",\"N\",\"치과의원\",\"G099\",\"응급의료기관 이외\"," +
            "\"2\",\"법정 공휴일 : 외래 진료 휴진 설날 및 추석 연휴 : 외래 진료 휴진 인공신장실은 정상 진료\",\"발 발목 무릎 어깨 상지  척추 특화 진료\"," +
            "\"수도권 지하철 2호선 서울대입구역 4번 출구 10M\",\"연세건치과의원\",\"02-755-0882\",\"070-4665-9119\",\"1800\",\"1800\",\"1800\",\"1800\"," +
            "\"1800\",\"1400\",\"1300\",\"1300\",\"0900\",\"0900\",\"0900\",\"0900\",\"0900\",\"1000\",\"0900\",\"0900\",\"046\",\"37\",\"126.97375281464887\"," +
            "\"37.5555048939659\",\"2022-09-07 14:55:29.0\"";

    @Test
    @DisplayName("sqlInsertQuery 만드는 method")
    void testMakeSqlInsertQuery2() {
        Hospital hospital = hospitalParser.parse(this.line4);
        String sql ="INSERT INTO `likelion-db`.`seoul_hospital`\n" +
                "(`id`,`address`,`district`,`category`,`emergency_room`,`name`,`subdivision`)\n" +
                "VALUES\n" +
                "(\"A1118077\",\"서울특별시 중구 한강대로 416 지하1층 (남대문로5가 서울스퀘어빌딩)\",\"서울특별시 중구\",\"N\",\"2\",\"연세건치과의원\",\"치과\");";
        Assertions.assertEquals(sql, hospital.getSqlInsertQuery2());
    }
}