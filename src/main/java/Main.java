import domain.Hospital;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        String targetFile = "C:\\Users\\wjdtk\\Downloads\\서울시 병의원 위치 정보.csv";
        FileController<Hospital> hospitalFileController = new FileController<Hospital>(new HospitalParser(), true);   // LineReader뒤의 제네릭타입에 Hospital 넣었더니 에러 사라졌어요
        List<Hospital> hospitals = hospitalFileController.readLine(targetFile);

        /*for(Hospital hospital : hospitals){
            System.out.printf("%s,%s,%s,%s,%d,%s,%s\n", hospital.getId(),hospital.getAddress(),hospital.getDistrict(),hospital.getCategory(),
                    hospital.getEmergency_room(),hospital.getName(), hospital.getSubDivision());
        }*/

        // 파일에 넣을 내용 작성
        List<String> sqlStatements = new ArrayList<>();
        for(Hospital hospital : hospitals){
            sqlStatements.add(hospital.getSqlInsertQuery2());
        }
        // 파일 생성 , 파일 쓰기
        String sqlFilename = "seoul_hospital_insert.sql";
        hospitalFileController.createANewFile(sqlFilename);
        hospitalFileController.writeLines(sqlStatements, sqlFilename);

    }
}
